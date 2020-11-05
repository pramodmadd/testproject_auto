package TestNG;

import org.testng.annotations.Test;

public class TestNG_Dependent {

    @Test(dependsOnMethods = { "OpenBrowser" })
    public void LogIn() {
        System.out.println("This will execute second (SignIn)");
    }

    @Test
    public void OpenBrowser() {
        System.out.println("This will execute first (Open Browser)");
    }

    /*
        --------------------------------------------------------------------------------
     */
    /*@Test(dependsOnGroups = { "SignIn" })
    public void ViewAcc() {
        System.out.println("SignIn Successful");
    }

    @Test(groups = { "SignIn" })
    public void LogIn() {
        System.out.println("Logging In Success");
    }*/

    /*
        --------------------------------------------------------------------------------
     */

   /* @Test
    public void OpenBrowser() {
        System.out.println("Opening The Browser");
    }

    @Test(dependsOnMethods = { "SignIn", "OpenBrowser" })
    public void LogOut() {
        System.out.println("Logging Out");
    }

    @Test
    public void SignIn() {
        System.out.println("Signing In");
    }*/
}
