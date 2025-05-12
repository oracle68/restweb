package com.myapp.mocks;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

//runner de mockito que detecta las anotaciones
@RunWith(MockitoJUnitRunner.class)	
public class AuthenticatorApplicationTest {


	@Test
	public void testAuthenticate() {
		AuthenticatorInterface authenticatorMock;
		AuthenticatorApplication authenticator;
		String username = "JavaCodeGeeks";
		String password = "unsafePassword";
		authenticatorMock = Mockito.mock(AuthenticatorInterface.class);
		authenticator = new AuthenticatorApplication(authenticatorMock);
		when(authenticatorMock.authenticateUser(username, password)).thenReturn(false);
		boolean actual = authenticator.authenticate(username, password);
		assertFalse(actual);
		}	
}
