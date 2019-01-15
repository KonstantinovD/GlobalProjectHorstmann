package tasks;

import java.io.IOException;
import java.util.Date;
import java.util.logging.*;

public class Task32 implements TasksMainMethod {
    @Override
    public void run() {

        class LogFilter implements Filter{
            public boolean isLoggable(LogRecord record){
                if(record.getMessage().startsWith("ENTRY")) return false;
                return true;
            }
        }

        Logger logger = Logger.getLogger("NamelessXML");
        logger.setLevel(Level.FINER);
        logger.setUseParentHandlers(false);

        logger.setFilter(new LogFilter());

        try {
            Handler fh = new FileHandler("logging//XmlLogger.xml", 256, 2, true);

            fh.setFormatter(new SimpleFormatter() {
                private static final String format = "[%1$tF %1$tT] [%2$-7s] %3$s %n";

                @Override
                public synchronized String format(LogRecord lr) {

                    formatMessage(lr);

                    return String.format(format,
                            new Date(lr.getMillis()),
                            lr.getLevel().getLocalizedName(),
                            lr.getMessage()
                    );
                }
            });


            logger.addHandler(fh);

            logger.entering(Task32.class.getName(),
            "run");

            logger.severe("message1");
            logger.log(Level.SEVERE, "msg 2-2");

            logger.exiting(Task32.class.getName(),
                    "run");

        }catch(IOException ex){
            System.err.println(ex.getMessage());
        }

    }
}
