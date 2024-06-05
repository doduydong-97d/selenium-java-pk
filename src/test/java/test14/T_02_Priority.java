package test14;

import org.testng.annotations.Test;

public class T_02_Priority {

	@Test(priority = 1)
	public void Open() {
		System.out.println("Open");
	}

	@Test(priority = 2)
	public void Register() {
		System.out.println("Register");
	}

	@Test(priority = 3)
	public void Login() {
		System.out.println("Login");
	}

	@Test(priority = 4)
	public void Logout() {
		System.out.println("Logout");
	}

	@Test(priority = 5)
	public void Close() {
		System.out.println("Close");
	}

}
