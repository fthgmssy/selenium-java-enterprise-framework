package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static final Properties props = new Properties();

    static {
        try (InputStream in = ConfigReader.class.getClassLoader()
                .getResourceAsStream("config.properties")) {
            if (in == null) throw new RuntimeException("config.properties not found");
            props.load(in);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public static String get(String key) {
        String value = System.getProperty(key);
        return value != null ? value : props.getProperty(key);
    }

    public static String getBrowser()     { return get("browser"); }
    public static String getBaseUrl()     { return get("base.url"); }
    public static boolean isHeadless()    { return Boolean.parseBoolean(get("headless")); }
    public static int getImplicitWait()   { return Integer.parseInt(get("implicit.wait")); }
    public static int getExplicitWait()   { return Integer.parseInt(get("explicit.wait")); }
    public static boolean screenshotOnFailure() {
        return Boolean.parseBoolean(get("screenshot.on.failure"));
    }
}
