package Examples.InterferationWithClasses;

import java.util.HashMap;
import java.util.Map;

public class Person {

    private int id;
    private String name;
    private Map<Integer, String> database;

    public Person() {
        this.database = new HashMap<>();
    }
    public Person(int age, String name) {
        this.id = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Integer, String> getDatabase() {
        return database;
    }

    public void setDatabase(int id, String name) {
        this.id = id;
        this.name = name;

        database.put(id, name);
    }
}
