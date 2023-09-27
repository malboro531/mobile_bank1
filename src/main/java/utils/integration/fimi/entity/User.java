package utils.integration.fimi.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String clerk;
    private String password;
    private String session;
    private String NextChallenge;
    private String PAN;

    public User(String clerk, String password, String session) {
        this.clerk = clerk;
        this.password = password;
        this.session = session;
    }
}


