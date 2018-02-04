package fun.abm.com.mockitocookbook.authenticator;

public interface Authenticator {

    boolean authenticateUser(String username, String password);

}
