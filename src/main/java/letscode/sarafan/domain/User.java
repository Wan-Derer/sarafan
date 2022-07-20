package letscode.sarafan.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "usr")
@Getter
@Setter
public class User {

  @Id
  private String id;
  private String name;
  private String userpic;
  private String email;
  private String gender;
  private String locale;
  private LocalDateTime lastVisit;

}
