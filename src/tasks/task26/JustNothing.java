package tasks.task26;

public class JustNothing implements MyInterface {
    @Override
    public void writeBye() {
        System.out.println("HELLO!!!");
    }

    @Override
    public void writeHello() {
        System.out.println("BYE^_^");
    }
}
