/*
 *  This class is a global logging class which is responsible for all kinds of log operations.
 */


package Logs_config;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {

    static {
        configLog4j();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        System.setProperty("currenttime", dateFormat.format(new Date()));
    }
        private static void configLog4j() {

            String log4jConfigFile = System.getProperty("user.dir") +
                    File.separator + "AutoTest\\src\\main\\resources\\log4j.properties";
            PropertyConfigurator.configure(log4jConfigFile);
        }
        // Initialize Log4j instance
        private static final Logger Log = Logger.getLogger(Log.class.getName());

        //We can use it when starting tests
        public static void startLog (String testClassName){
            Log.info("Test is Starting...");
        }

        //We can use it when ending tests
        public static void endLog (String testClassName){
            Log.info("Test is Ending...");
        }

        //Info Level Logs_config
        public static void info (String message) {
            Log.info(message);
        }

        //Warn Level Logs_config
        public static void warn (String message) {
            Log.warn(message);
        }

        //Error Level Logs_config
        public static void error (String message) {
            Log.error(message);
        }

        //Fatal Level Logs_config
        public static void fatal (String message) {
            Log.fatal(message);
        }

        //Debug Level Logs_config
        public static void debug (String message) {
            Log.debug(message);
        }
    }

