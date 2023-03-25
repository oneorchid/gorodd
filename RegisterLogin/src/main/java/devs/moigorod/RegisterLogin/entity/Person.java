package devs.moigorod.RegisterLogin.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "person")
@Data
@NoArgsConstructor
@ToString
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Name must not be empty")
    @Size(min = 3, max = 100, message = "name must be between 2-100 characters")
    @Column(name = "username")
    private String username;

    @Column(name = "email", length = 255)
    private String email;

    @Column(name = "password")
    @NotEmpty(message = "password must not be empty")
    private String password;

    @Column(name = "phone_number")
    private String phoneNumber;

    public Person(String username, String email, String password, String phoneNumber) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }
}
