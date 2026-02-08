package dto.player;

public class PlayerRequestDto {
    public int getRank;
    public int getTeamId;
    private String nickname;
    private int age;

    public String getNickname() {
        return nickname;
    }

    public int getAge() {
        return age;
    }

    public int getTeamId() {
        return getTeamId;
    };

    public int getRank() {
        return getRank;
    };
}
