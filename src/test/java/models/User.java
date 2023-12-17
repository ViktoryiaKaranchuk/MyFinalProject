package models;

public class User {

    private String email;
    private String password;

    private String name;

    public User(String login, String password) {
        this.email = login;
        this.password = password;
    }

    public String getLogin() {

        return email;
    }

    public void setLogin(String login) {

        this.email = login;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

}
