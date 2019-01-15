package tasks.task27;

public class Person {
    private String name ;
    public  String getName()            {	return name;	}
    public  void   setName(String name) {	this.name = name;	}

    public void rename(String new_name) {
        if (!new_name.equals(name))		this.name = new_name;
    }
}
