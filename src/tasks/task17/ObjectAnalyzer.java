package tasks.task17;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class ObjectAnalyzer {
    private ArrayList<Object> visited = new ArrayList<>();

    /**
     * Returns string representation of all object fields
     * @param obj object
     * @return Returns string with class name and all the
     * fields of the object with its values
     */
    public String toString(Object obj)
    {
        if(obj == null) return null;
        if(visited.contains(obj)) return "...";
        visited.add(obj);
        Class cl = obj.getClass();

        if(cl == String.class) return (String) obj;

        if(cl.isArray()){
            String r = cl.getComponentType() + "[]{";
            for(int i = 0; i < Array.getLength(obj); i++){
                if(i>0) r += ", ";
                Object val = Array.get(obj, i);
                if(cl.getComponentType().isPrimitive()) r += val;
                else r += toString(val);
            }
            r.concat("}");
            return r;
        }

        String r = cl.getName();
        //check all the fields of current class and all its superclasses
        do{
            r += "[";
            Field[] fields = cl.getDeclaredFields();
            AccessibleObject.setAccessible(fields, true);
            //get names and values of all the fields
            for(Field f : fields)
            {
                if(!Modifier.isStatic(f.getModifiers()))
                {
                    if(!r.endsWith("{")) r += ", ";
                    r += f.getName() + "=";
                    try{
                        Class t = f.getType();
                        Object val = f.get(obj);
                        if(t.isPrimitive()) r+= val;
                        else r += toString(val);
                    }catch (Exception ex){
                        ex.printStackTrace();
                    }
                }
            }
            r += "}";
            cl = cl.getSuperclass();
        } while (cl != null);

        return r;
    }
}
















