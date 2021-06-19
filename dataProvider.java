package Prueba;

import org.testng.annotations.DataProvider;

public class dataProvider {

    @DataProvider(name = "email")
    public Object[][] crearEmails() {
        return new Object[][]{
                {"test1@test.com"},
                {"test2@test.com"},
                {"test3@test.com"}
        };
    }
}
