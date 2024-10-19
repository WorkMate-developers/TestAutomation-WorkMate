package utils;

import org.testng.Assert;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils extends LoggerUtils {

    private static final String sPropertiesPath = "common.properties";
    private static final Properties properties = loadPropertiesFile();

    /**
     * Loads the properties file from a custom location.
     *
     * @param sFilePath String file path
     * @return Properties
     */

    public static Properties loadPropertiesFile(String sFilePath) {
        InputStream inputStream = PropertiesUtils.class.getClassLoader().getResourceAsStream(sFilePath);
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (Exception e) {
            Assert.fail("Cannot load " + sFilePath + " properties file! Message: " + e.getMessage());
        }
        return properties;
    }

    /**
     * Loads the properties file `common.properties` from the predefined default location.
     *
     * @return Properties
     */

    public static Properties loadPropertiesFile() {
        return loadPropertiesFile(sPropertiesPath);
    }

    /**
     * Returns the value of a property specified in the parameter.
     *
     * @param sProperty String
     * @return property value
     */

    private static String getProperty(String sProperty) {
        log.trace("getProperty(" + sProperty + ")");
        String property = properties.getProperty(sProperty);
        Assert.assertNotNull(property, "Property: " + sProperty + " not found in properties file!");
        return property;
    }

    public static String getEnvironment() {
        String sEnvironment = System.getProperty("environment");
        if (sEnvironment == null) {
            sEnvironment = getProperty("environment");
        }
        return sEnvironment.toLowerCase();
    }


    /**
     * Returns the value of main application URL based on the `environment` specified in the common.properties file.
     * @return String application URL
     */

    public static String getApplicationUrl() {
        String sEnvironment = getEnvironment();
        switch (sEnvironment) {
            case "local" -> {
                return properties.getProperty("localBaseUrl");
            }
            case "test" -> {
                return properties.getProperty("testBaseUrl");
            }
            case "stage" -> {
                return properties.getProperty("stageBaseUrl");
            }
            case "prod" -> {
                return properties.getProperty("prodBaseUrl");
            }
            default -> Assert.fail("Invalid environment " + sEnvironment + ", cannot get the application URL property!");
        }
        return null;
    }


    /**
     * Returns the value of backend URL based on the `environment` specified in the common.properties file.
     * @return String backend URL
     */

    public static String getBackendUrl() {
        String sEnvironment = getEnvironment();
        switch (sEnvironment) {
            case "local" -> {
                return properties.getProperty("localBackEndUrl");
            }
            case "test" -> {
                return properties.getProperty("testBackEndUrl");
            }
            case "stage" -> {
                return properties.getProperty("stageBackEndUrl");
            }
            case "prod" -> {
                return properties.getProperty("prodBackEndUrl");
            }
            default -> Assert.fail("Invalid environment " + sEnvironment + ", cannot get the backend URL property!");
        }
        return null;
    }

    /**
     * Returns the value of database URL based on the `environment` specified in the common.properties file.
     * @return String database URL
     */

    public static String getDatabaseUrl() {
        String sEnvironment = getEnvironment();
        switch (sEnvironment) {
            case "local" -> {
                return properties.getProperty("localDatabaseUrl");
            }
            case "test" -> {
                return properties.getProperty("testDatabaseUrl");
            }
            case "stage" -> {
                return properties.getProperty("stageDatabaseUrl");
            }
            case "prod" -> {
                return properties.getProperty("prodDatabaseUrl");
            }
            default -> Assert.fail("Invalid environment " + sEnvironment + ", cannot get the database URL property!");
        }
        return null;
    }

    public static String getBrowser() {
        return getProperty("browser").toLowerCase();
    }

    public static String getDriversFolder() {
        return getProperty("driversFolder");
    }

    public static String getScreenshotsFolder() {
        return getProperty("screenshotsFolder");
    }

    /**
     * Returns values of any boolean property from the common.properties file, and converts in to actual Boolean value.
     * @param sProperty the name of the property whose value is returned
     * @return Boolean value of the property
     */

    public static Boolean getBoolProperty(String sProperty) {
        String sPropertyValue = properties.getProperty(sProperty).toLowerCase();
        if (!(sPropertyValue.equals("true") || sPropertyValue.equals("false"))) {
            Assert.fail("Unknown value for '" + sProperty + "' property. Found: " + sPropertyValue);
        }
        return Boolean.parseBoolean(sPropertyValue);
    }
}
