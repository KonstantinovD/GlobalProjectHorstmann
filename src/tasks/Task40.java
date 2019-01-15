package tasks;

//page 397

import javax.xml.stream.XMLStreamException;

public class Task40 implements TasksMainMethod{
    @Override
    public void run() {
        System.out.println("start");

        try{
            //throw new RuntimeException();
            throw new XMLStreamException();
        }catch(Exception ex){
            throwAs(ex);//if throws, JVM stops
            System.out.println("caught");
        }

        System.out.println("end");
    }

    public static <T extends Throwable> void
    throwAs(Throwable e) throws T{
        throw (T) e;
    }
}
