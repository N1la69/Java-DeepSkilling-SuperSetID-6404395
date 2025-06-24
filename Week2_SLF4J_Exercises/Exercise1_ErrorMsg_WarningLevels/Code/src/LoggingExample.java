package Week2_SLF4J_Exercises.Exercise1_ErrorMsg_WarningLevels.Code.src;

import java.util.logging.Logger;
import java.util.logging.Level;

public class LoggingExample {
    private static final Logger logger = Logger.getLogger(LoggingExample.class.getName());

    public static void main(String[] args) {
        logger.log(Level.SEVERE, "This is an error message");
        logger.log(Level.WARNING, "This is a warning message");
    }
}
