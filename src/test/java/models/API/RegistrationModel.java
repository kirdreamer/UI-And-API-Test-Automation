package models.API;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RegistrationModel {
    private Integer id;
    private String token;
}
