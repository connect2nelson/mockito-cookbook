package fun.abm.com.mockitocookbook.authenticator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class AuthenticatorApplnTest {

    @Mock
    private AuthenticatorImpl authenticator;

    @InjectMocks
    private AuthenticatorAppln authenticatorAppln;

    @Test
    public void shouldReturnTrueWhenAuthenticationStrategyIsSuccessfull() throws CannotAuthenicateUserException {

        when(authenticator.authenticateUser(anyString(), anyString())).thenReturn(true);
        when(authenticator.checkWhetherCredentialsAreValid(anyString(), anyString())).thenReturn(true);


        String username = "abm";
        String password = "unsafePassword";

        assertTrue(authenticatorAppln.authenticate(username, password));

        verify(authenticator, times(1)).authenticateUser(username, password);
        verify(authenticator, atLeast(1)).authenticateUser(username, password);
        verify(authenticator, atLeastOnce()).authenticateUser(username, password);
        verify(authenticator, atMost(1)).authenticateUser(username, password);
    }


    @Test
    public void shouldCheckWhetherUsernameAndPasswordIsValidAndThenDoCheckForAuthenication() throws CannotAuthenicateUserException {

        when(authenticator.authenticateUser(anyString(), anyString())).thenReturn(true);
        when(authenticator.checkWhetherCredentialsAreValid(anyString(), anyString())).thenReturn(true);

        String username = "abm";
        String password = "unsafePassword";
        InOrder inOrder = inOrder(authenticator);


        assertTrue(authenticatorAppln.authenticate(username, password));

        inOrder.verify(authenticator).checkWhetherCredentialsAreValid(username, password);
        inOrder.verify(authenticator).authenticateUser(username, password);

    }


    @Test(expected = EmptyCredentialsException.class)
    public void shouldThrowEmptyCredentialsExceptionWhenAuthenticateIsCalledWithEmptyCredentials() throws CannotAuthenicateUserException {

        String username = "abm";
        String password = "unsafePassword";

        when(authenticator.checkWhetherCredentialsAreValid(anyString(), anyString()))
                .thenThrow(EmptyCredentialsException.class);
        when(authenticator.authenticateUser(anyString(), anyString())).thenReturn(true);

        assertTrue(authenticatorAppln.authenticate(username, password));

    }

    @Test(expected = CannotAuthenicateUserException.class)
    public void shouldThrowEmptyCredentialsWhenCredentialsAreEmpty() throws CannotAuthenicateUserException {

        String username = "abm";
        String password = "unsafePassword";

        doThrow(new CannotAuthenicateUserException()).
                when(authenticator)
                .canCredentialsBeAuthenticated(anyString(), anyString());

        authenticatorAppln.authenticate(username, password);

        verify(authenticator, times(1)).canCredentialsBeAuthenticated(username, password);
        verify(authenticator, never()).authenticateUser(username, password);
    }

}