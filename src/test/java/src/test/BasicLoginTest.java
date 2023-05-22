package src.test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import src.POs.LoginFormPO;
import src.POs.LoginSuccessPO;

public class BasicLoginTest extends DriverLifeCycleSetting{
	private LoginFormPO login;
	private LoginSuccessPO loginSuccess;
	
	@Test 
	public void testLoginOK() {
		login = new LoginFormPO(driver);
		loginSuccess = (LoginSuccessPO) login.with("user", "user");
		assertTrue(loginSuccess.successBoxIsPresent());
	}
	
	@Test
	public void testLoginNoOK() {
		login = new LoginFormPO(driver);
		login.with("user", "error");
		// remain in the login-form page
		assertTrue(login.invalidBoxIsPresent());
	}
}
