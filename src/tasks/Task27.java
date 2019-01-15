package tasks;


import tasks.task27.IPerson;
import tasks.task27.NeverSleepingEye;
import tasks.task27.Person;

import java.lang.reflect.Proxy;

public class Task27 implements TasksMainMethod {
    @Override
    public void run() {
        Person person = new Person();

        IPerson personproxy = (IPerson) Proxy.newProxyInstance(Person.class.getClassLoader(),
                Person.class.getInterfaces(),
                new NeverSleepingEye(person));

        personproxy.setName("Гриша");
        String h  = personproxy.getName() ;
        personproxy.rename("Вася");
    }
}
