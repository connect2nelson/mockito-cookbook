package fun.abm.com.mockitocookbook.authenticator;

public interface Authenticator {

    boolean authenticateUser(String username, String password);

    void canCredentialsBeAuthenticated(String username, String password) throws CannotAuthenicateUserException;

    boolean checkWhetherCredentialsAreValid(String username, String password);

}
