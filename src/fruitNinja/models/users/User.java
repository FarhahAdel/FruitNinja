package fruitNinja.models.users;

public class User {

    private String username;
    private String fullName;
    private String password;
    private int level;
    private int experience;

    public User()
    {

    }

    public User(String fullName, String username, String password)
    {
        this.fullName = fullName;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
