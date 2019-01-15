package tasks;

import tasks.task26.JustNothing;
import tasks.task26.MyInterface;
import tasks.task26.TraceHandlerDup;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;





public class Task26 implements TasksMainMethod {
    @Override
    public void run() {

        JustNothing myObj = new JustNothing();
        MyInterface proxy = (MyInterface) Proxy.newProxyInstance(null,
                JustNothing.class.getInterfaces(), new TraceHandlerDup(myObj));

        myObj.writeBye();

        myObj.toString();

    }
}



