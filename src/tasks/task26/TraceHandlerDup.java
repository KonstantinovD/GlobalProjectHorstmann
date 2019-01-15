package tasks.task26;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//служит для переадресации вызовов методов исходного объекта
public class TraceHandlerDup implements InvocationHandler
{
    private Object target;

    public TraceHandlerDup(Object t){
        target = t;
    }

    public Object invoke(Object proxy, Method m, Object[] args)
            throws Throwable{
/*
        if(m.getName() == "writeHello"){
            System.out.println("first method");
        }
        if(m.getName() == "writeBye"){
            System.out.println("second method");
        }
*/
        System.out.println("method invoke");

        return m.invoke(target, args);
    }
}