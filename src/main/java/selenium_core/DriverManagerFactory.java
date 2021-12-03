package selenium_core;

public class DriverManagerFactory {

    public static DriverManager getDriverManager(String browser) {

        DriverManager driverManager;

        switch (browser) {
            case "Chrome": {
                driverManager = new ChromeDriverManager();
            }
            break;
            case "Firefox": {
                driverManager = new FirefoxDriverManager();
            }
            break;
            default:
                driverManager = new ChromeDriverManager();
        }
        return driverManager;
    }
}
