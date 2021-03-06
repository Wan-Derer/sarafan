package letscode.sarafan.controller;

import letscode.sarafan.domain.User;
import letscode.sarafan.repository.MessageRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@RequiredArgsConstructor
@Controller
@RequestMapping("/")
public class MainController {

  private final MessageRepo messageRepo;

  @GetMapping
  public String main (Model model, @AuthenticationPrincipal User user){

    HashMap<Object, Object> data = new HashMap<>();
    data.put("profile", user);
    data.put("messages", messageRepo.findAll());

    model.addAttribute("frontendData", data);

    return "index";
  }




}
