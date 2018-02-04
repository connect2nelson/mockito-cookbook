package fun.abm.com.mockitocookbook.authenticator;


import org.springframework.stereotype.Component;

@Component
public class AuthenticatorImpl implements Authenticator {
    @Override
    public boolean authenticateUser(String username, String password) {
        return false;
    }

    @Override
    public void canCredentialsBeAuthenticated(String username, String password) throws CannotAuthenicateUserException {
        throw new CannotAuthenicateUserException();
    }

    public boolean checkWhetherCredentialsAreValid(String username, String password) {

        return false;
    }
}
