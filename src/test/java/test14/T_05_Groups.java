package test14;

import org.testng.annotations.Test;

public class T_05_Groups {

	@Test(groups = "admin")
	public void RegisterByEmail() {
		System.out.println("RegisterByEmail");
	}

	@Test(groups = "user")
	public void RegisterByFacebook() {
		System.out.println("RegisterByFacebook");
	}

	@Test(groups = { "user", "admin" })
	public void RegisterByGoogle() {
		System.out.println("RegisterByGoogle");
	}

	@Test(groups = "admin")
	public void LoginByEmail() {
		System.out.println("LoginByEmail");
	}

	@Test(groups = "user")
	public void LoginByFacebook() {
		System.out.println("LoginByFacebook");
	}

	@Test(groups = { "user", "admin" })
	public void LoginByGoogle() {
		System.out.println("LoginByGoogle");
	}

}
