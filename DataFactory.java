package ModeloPrueba;

import org.testng.annotations.Factory;

public class DataFactory {

    @Factory
    public Object[] fabricaModelo() {
        return new Object[] {
                new prueba_mailchimp(),
                new prueba_mailchimp()
        };
    }
}
