package dto.player;

public class PlayerResponseDto {
    private int id;
    private String nickname;
    private int age;

    public PlayerResponseDto(int id, String nickname, int age) {
        this.id = id;
        this.nickname = nickname;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public int getAge() {
        return age;
    }
}
