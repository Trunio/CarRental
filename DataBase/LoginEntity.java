package DataBase;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Login", schema = "dbo", catalog = "master")
public class LoginEntity {
    private int id;
    private String username;
    private String password;
    private int AccessRights;


    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Username", nullable = false, length = 30)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "Password", nullable = false, length = 30)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "AccessRights", nullable = false)
    public int getAccessRights() {
        return AccessRights;
    }

    public void setAccessRights(int AccessRights) {
        this.AccessRights = AccessRights;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginEntity that = (LoginEntity) o;
        return id == that.id &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, AccessRights);
    }
}
