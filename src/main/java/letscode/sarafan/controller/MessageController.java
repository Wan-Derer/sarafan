package letscode.sarafan.controller;

import com.fasterxml.jackson.annotation.JsonView;
import letscode.sarafan.domain.Message;
import letscode.sarafan.domain.Views;
import letscode.sarafan.repository.MessageRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("message")
@RequiredArgsConstructor
public class MessageController {

  private final MessageRepo messageRepo;

  @GetMapping
  @JsonView(Views.IdName.class)
  public List<Message> list() {
    return messageRepo.findAll();
  }

  @GetMapping("{id}")
  @JsonView(Views.FullMessage.class)
  public Message getOne(@PathVariable("id") Message message) {
    return message;
  }

  @PostMapping
  public Message create(@RequestBody Message message) {
    message.setCreationDate(LocalDateTime.now());
    return messageRepo.save(message);
  }

  @PutMapping("{id}")
  public Message update(
    @PathVariable("id") Message messageFromDb,
    @RequestBody Message messageFromUser
  ) {
    BeanUtils.copyProperties(messageFromUser, messageFromDb, "id");

    return messageRepo.save(messageFromDb);
  }

  @DeleteMapping("{id}")
  public void delete(@PathVariable long id) {
    messageRepo.deleteById(id);
  }


}
