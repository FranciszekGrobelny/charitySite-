package pl.coderslab.charity.dto.user;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter @Setter @ToString
public class RegisterUserDTO {

    @Email @NotNull
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String password2;

    public RegisterUserDTO(@Email @NotNull String email, @NotNull String password, @NotNull String password2) {
        this.email = email;
        this.password = password;
        this.password2 = password2;
    }
}
