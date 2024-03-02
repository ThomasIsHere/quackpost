package ahiru.quackpost.controller.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest { // Should be move in model?
    private String firstname;
    private String lastname;
    private String email;
    private String password;
}
