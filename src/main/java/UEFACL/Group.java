package UEFACL;

import java.util.List;

public class Group {
    private String name;
    private List<Team> teams;

    public Group(String name) {
        this.name = name;
    }

    public Group(String name, List<Team> teams) {
        this.name = name;
        this.teams = teams;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", teams=" + teams +
                '}';
    }
}
