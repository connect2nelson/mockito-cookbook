package fun.abm.com.mockitocookbook.authenticator;

import org.junit.Test;
import org.junit.runner.RunWith;
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
    public void shouldReturnTrueWhenAuthenticationStrategyIsSuccessfull() {

        when(authenticator.authenticateUser(anyString(), anyString())).thenReturn(true);

        String username = "abm";
        String password = "unsafePassword";
        assertTrue(authenticatorAppln.authenticate(username, password));

        verify(authenticator, times(1)).authenticateUser(username, password);
        verify(authenticator, atLeast(1)).authenticateUser(username, password);
        verify(authenticator, atLeastOnce()).authenticateUser(username, password);
        verify(authenticator, atMost(1)).authenticateUser(username, password);
    }
}