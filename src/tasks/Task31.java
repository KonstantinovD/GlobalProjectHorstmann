package tasks;

import java.io.File;
import java.io.IOException;
import java.util.logging.*;

public class Task31 implements TasksMainMethod{

    private final static Logger logger = Logger.getLogger(Task31.class.getName());

    @Override
    public void run() {
        try {

            //File file = new File("by\\konstantinov\\tasks\\task31\\Logfile.log");
            //System.out.println(file.getAbsolutePath());
            //System.exit(0);

            logger.setLevel(Level.ALL);
            //logger.setUseParentHandlers(false);


            LogManager.getLogManager().readConfiguration(
                    Task31.class.getResourceAsStream("/logging.properties"));


            //FileHandler fh = new FileHandler("logging//app_log%u.txt", true);

            int FILE_SIZE = 1024;
            FileHandler fh = new FileHandler("app_lg%u.xml", FILE_SIZE, 3, false);

            fh.setFormatter(new SimpleFormatter());
            fh.setLevel(Level.FINE);
            logger.addHandler(fh);

            for(int i=0; i<25; i++) {
                logger.severe("message" + i);
            }




        } catch (IOException e) {
            System.err.println("Could not setup logger configuration: " + e.toString());
        }
    }


}
