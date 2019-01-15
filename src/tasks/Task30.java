package tasks;

import java.io.IOException;
import java.util.logging.*;

public class Task30 implements TasksMainMethod {

    private final static Logger logger = Logger.getLogger(Task30.class.getName());
    @Override
    public void run() {


    }

    public static void test(){
        LogManager.getLogManager().reset();
        logger.setLevel(Level.ALL);
        logger.setUseParentHandlers(false);

        //ConsoleHandler ch = new ConsoleHandler();
        //ch.setLevel(Level.SEVERE);
        //logger.addHandler(ch);
        try {
            FileHandler fh = new FileHandler(Task30.class.getName());
            fh.setFormatter(new SimpleFormatter());
            fh.setLevel(Level.FINE);
            logger.addHandler(fh);
        }catch(IOException ex){
            logger.log(Level.SEVERE, "File logging isn't enable:\n" + ex.getMessage());
        }
        logger.log(Level.INFO, "My first log");

        try{
            throw new java.io.IOException("IO problems");
        }catch(Exception e){
            logger.severe(e.getMessage());
        }
    }
}
