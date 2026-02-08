package model;
import model.interfaces.IValidatable;

public class Player extends BaseEntity implements IValidatable<Player> {
    private String nickname;
    private int age;
    private int rank;
    private int teamId;

    public Player(int id, String nickname, int age, int rank, int teamId) {
        super(id, nickname);
        this.nickname = nickname;
        this.age = age;
        this.rank = rank;
        this.teamId = teamId;
        validateOrThrow(this);
    }

    @Override
    public boolean isValid(Player player) {
        return player != null &&
                player.getName() != null &&
                !player.getName().trim().isEmpty() &&
                player.age > 0 &&
                player.rank >= 0 &&
                player.teamId > 0;
    }

    public int getId() { return super.id; }
    public String getName() { return nickname; }
    public int getAge() { return age; }
    public int getRank() { return rank; }
    public int getTeamId() { return teamId; }

    public void setId(int id) { this.id = id; }
    public void setNickname(String nickname) { this.nickname = nickname; }
    public void setAge(int age) { this.age = age; }
    public void setRank(int rank) { this.rank = rank; }
    public void setTeamId(int teamId) { this.teamId = teamId; }

    @Override
    public String getEntityType() {
        return "Player";
    }

    @Override
    public String getInfo() {
        return "Player: " + getName() + " | Age: " + age + " | Rank: " + rank + " | Team ID: " + teamId;
    }

    @Override
    public String toString() {
        return getInfo();
    }
}
