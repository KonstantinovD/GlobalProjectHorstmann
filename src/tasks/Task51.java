package tasks;

import java.util.*;

public class Task51 implements TasksMainMethod {
    @Override
    public void run() {
        SortedSet<Item> parts = new TreeSet<>();
        parts.add(new Item("Toaster", 1234));
        parts.add(new Item("Widget", 4562));
        parts.add(new Item("Modem", 9912));
        System.out.println(parts);

        NavigableSet<Item> sortByDescription = new TreeSet<>(
                Comparator.comparing(Item::getDescription));

        sortByDescription.addAll(parts);
        System.out.println("-----------------------------------");
        System.out.println(sortByDescription);
    }
}

class Item implements Comparable<Item>
{
    private String description;
    private int partNumber;

    public Item(String aDescription, int aPartNumber) {
        description = aDescription;
        partNumber = aPartNumber;
    }

    public String getDescription(){ return description; }

    public String toString() {
        return "[descr=" + description + ", partNumb="
                + partNumber + "]";
    }

    public boolean equals(Object other){
        if(this == other) return true;
        if(other == null) return false;
        if(getClass() != other.getClass()) return false;
        Item otherItem = (Item)other;
        return Objects.equals(description, otherItem.description) &&
                partNumber == otherItem.partNumber;
    }

    public int hashCode(){
        return Objects.hash(description, partNumber);
    }

    @Override
    public int compareTo(Item other) {
        int diff = Integer.compare(partNumber, other.partNumber);
        return diff != 0 ? diff:
                description.compareTo(other.description);
    }
}
