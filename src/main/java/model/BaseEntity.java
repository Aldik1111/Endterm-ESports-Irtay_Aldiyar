package model;

public abstract class BaseEntity {

    protected int id;
    protected String name;

    protected BaseEntity(int id, String name) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id must be positive");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.id = id;
        this.name = name;
    }

    public abstract String getEntityType();
    public abstract String getInfo();

    public void printInfo() {
        System.out.println(getInfo());
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }
}
