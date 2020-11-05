package TestNG;

import org.testng.annotations.Test;

public class TestNG_DependenetInherited {

    @Test
    public void OpenBrowser() {
        System.out.println("BrowserOpened");
    }
}

class InheritedDependencyTest extends TestNG_DependenetInherited {
    @Test(dependsOnMethods = { "OpenBrowser" })
    public void LogIn() {
        System.out.println("Logged In");
    }
}
