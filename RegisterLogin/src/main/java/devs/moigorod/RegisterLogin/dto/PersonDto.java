package devs.moigorod.RegisterLogin.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class PersonDto {

    @NotEmpty(message = "Name should not be empty!")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 character")
    private String username;


    @NotEmpty(message = "Email should not be empty")
    private String email;

    private String phoneNumber;

    @NotEmpty(message = "password must not be empty")
    private String password;

}
