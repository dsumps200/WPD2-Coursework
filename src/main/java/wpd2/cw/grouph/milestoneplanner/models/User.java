package wpd2.cw.grouph.milestoneplanner.models;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="USER")
public class User {

    @Id
    @Column(name="id")
    @GeneratedValue
    private int id;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Transient
    private String passwordConfirm;

    @Column(name="firstname")
    private String firstname;

    @Column(name="surname")
    private String surname;

    public String getUsername() {
        return username;
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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public User() { super(); }
}
