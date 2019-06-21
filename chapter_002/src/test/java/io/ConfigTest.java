package io;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {
    Config config = new Config("C:/projects/job4j/app.properties");

    @Test
    public void whenGetKeyAndValue() {
        config.load();
        assertThat(config.value("hibernate.connection.driver_class"), is("org.postgresql.Driver"));
        assertThat(config.value("hibernate.connection.username"), is("postgres"));
    }

}
