package data.models;

public class Diary {
    private  String username;
    private  String password;
    private int id = 0;
    private boolean logStatus;

    public boolean isLogStatus() {
        return logStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean setLogStatus(boolean logStatus) {
        this.logStatus = logStatus;
        return logStatus;
    }

    public Diary() {


    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }
}



