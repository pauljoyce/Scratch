package UEFACL;

public class Team {
    private String name;
    private String nation;
    private int level;

    public Team(String name, String nation, int level) {
        this.name = name;
        this.nation = nation;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }


    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", nation='" + nation + '\'' +
                ", level=" + level +
                '}';
    }
}
