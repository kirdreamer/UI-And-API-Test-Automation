package models.API;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserRegistrationModel {
    private String email;
    private String password;
}
