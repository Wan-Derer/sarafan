package letscode.sarafan.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table
@Getter
@Setter
@ToString(of = {"id", "text"})
//@JsonAutoDetect
public class Message {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @JsonView(Views.Id.class)
  private Long id;

  @JsonView(Views.IdName.class)
  private String text;

  @Column(updatable = false)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd hh:mm:ss")
  @JsonView(Views.FullMessage.class)
  private LocalDateTime creationDate;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Message message = (Message) o;
    return id != null && Objects.equals(id, message.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }


}
