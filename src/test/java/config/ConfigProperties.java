package config;

import lombok.extern.slf4j.Slf4j;

import java.util.Properties;
import java.util.TimeZone;

import static java.lang.System.getProperty;
import static org.codehaus.groovy.classgen.AsmClassGenerator.getProperty;

@Slf4j
public class ConfigProperties {
    private static final Properties props = new Properties();
    public final static String BASE_URL;
    public static final String env;

    static {
        env = getProperty("env", "int");
        log.info("C O N F I G U R A T I O N");
        log.info("JVM timezone: {}", TimeZone.getDefault().getID());
        log.info("Environment: "+env);

        BASE_URL = getProperty("base.url");
    }



}
