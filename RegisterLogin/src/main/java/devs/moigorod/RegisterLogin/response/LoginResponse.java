package devs.moigorod.RegisterLogin.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString
public class LoginResponse {
   private String message;
   private Boolean status;
}
