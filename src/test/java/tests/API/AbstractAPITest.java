package tests.API;

import helper.RandomHelper;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public abstract class AbstractAPITest {
    private final String rootPath = "src/main/resources/";
    private String apiConfigurationPath = rootPath + "api.properties";

    protected RandomHelper randomHelper;
    protected String endpoint;
    protected Properties properties;

    @BeforeClass
    public void prediction() throws IOException {
        properties = getApplicationProperties();
        endpoint = properties.getProperty("service.url");
        randomHelper = new RandomHelper();
    }

    public Properties getApplicationProperties() throws IOException {
        Properties applicationProperties = new Properties();
        applicationProperties.load(new FileInputStream(apiConfigurationPath));
        return applicationProperties;
    }
}
