package model;

public class Admin {
    private int id_admin;
    private String a_username;
    private String a_password;
    private String a_email;

    public Admin() {
    }

    public Admin(int id_admin, String a_username, String a_password, String a_email) {
        this.id_admin = id_admin;
        this.a_username = a_username;
        this.a_password = a_password;
        this.a_email = a_email;
    }

    public int getId_admin() {
        return id_admin;
    }

    public String getA_username() {
        return a_username;
    }

    public String getA_password() {
        return a_password;
    }

    public String getA_email() {
        return a_email;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }

    public void setA_username(String a_username) {
        this.a_username = a_username;
    }

    public void setA_password(String a_password) {
        this.a_password = a_password;
    }

    public void setA_email(String a_email) {
        this.a_email = a_email;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id_admin=" + id_admin +
                ", a_username='" + a_username + '\'' +
                ", a_password='" + a_password + '\'' +
                ", a_email='" + a_email + '\'' +
                '}';
    }
}
