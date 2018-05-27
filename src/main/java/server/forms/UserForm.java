package server.forms;

import lombok.Data;

import java.util.Date;

@Data
public class UserForm {
    private String first_name;
    private String last_name;
    private String login;
    private String password;
    private String phoneNumber;
}
