package devs.moigorod.RegisterLogin.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
public class LoginDTO {
    private String email;
    private String password;


}
