package logging;
import java.io.IOException;
import java.util.logging.*;

public class MyLogger {
    public static void severeLog(Logger logger, String mes) throws Exception {
       LogManager.getLogManager().readConfiguration();
       logger.setUseParentHandlers(true);
       logger.severe("You entered a wrong key.");
       JavaMail.sendMail(mes);
   }

    public static void infoLog(Logger logger) throws IOException {
        LogManager.getLogManager().readConfiguration();
        logger.setUseParentHandlers(false);
        Handler console = new ConsoleHandler();
        logger.addHandler(console);
        FileHandler fh = new FileHandler();
        logger.addHandler(fh);
    }
}
