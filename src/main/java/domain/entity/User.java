package domain.entity;

public class User {
    private int id;
    private String name;
    private String email;
    public User() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id2) {
        this.id = id2;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
}
