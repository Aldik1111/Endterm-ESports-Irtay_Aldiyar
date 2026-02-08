package model;

public abstract class Game extends BaseEntity {

    protected Game(int id, String name) {
        super(id, name);
    }

    // abstract methods (уже были)
    public abstract int getTeamSize();
    public abstract String getGenre();



    @Override
    public String getEntityType() {
        return "Game";
    }

    @Override
    public String getInfo() {
        return "Game: " + name +
                " | Genre: " + getGenre() +
                " | Team size: " + getTeamSize();
    }
}