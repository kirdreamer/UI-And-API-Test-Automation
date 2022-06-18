package models.API;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserCredentialsModel {

    private Data data;
    private Support support;

    @Getter
    @RequiredArgsConstructor
    public class Data {
        private Integer id;
        private String email;
        private String first_name;
        private String last_name;
        private String avatar;
    }

    @Getter
    @RequiredArgsConstructor
    public class Support {
        private String url;
        private String text;
    }
}
