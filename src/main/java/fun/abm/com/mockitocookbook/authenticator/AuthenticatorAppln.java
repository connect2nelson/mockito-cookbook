package fun.abm.com.mockitocookbook.authenticator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class AuthenticatorAppln {

    private Authenticator authenticator;

    @Autowired
    public AuthenticatorAppln(Authenticator authenticator) {
        this.authenticator = authenticator;
    }


    boolean authenticate(String username, String password){
        return this.authenticator.authenticateUser(username,password);
    }
}
