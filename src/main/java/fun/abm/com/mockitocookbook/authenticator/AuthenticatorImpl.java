package fun.abm.com.mockitocookbook.authenticator;


import org.springframework.stereotype.Component;

@Component
public class AuthenticatorImpl implements Authenticator {
    @Override
    public boolean authenticateUser(String username, String password) {
        return false;
    }
}
