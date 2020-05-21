package DataBase;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Client", schema = "dbo", catalog = "master")
public class ClientEntity {
    private int id;
    private String name;
    private String surname;
    private String telephone;
    private Adress adressByAdressId;
    private LoginEntity LoginEntityByID;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Name", nullable = false, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Surname", nullable = false, length = 20)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "Telephone", nullable = false, length = 20)
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientEntity that = (ClientEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(telephone, that.telephone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, telephone);
    }

    @ManyToOne
    @JoinColumn(name = "Adress_ID", referencedColumnName = "ID", nullable = false)
    public Adress getAdressByAdressId() {
        return adressByAdressId;
    }

    public void setAdressByAdressId(Adress adressByAdressId) {
        this.adressByAdressId = adressByAdressId;
    }

    @ManyToOne
    @JoinColumn(name = "Login_ID", referencedColumnName = "ID", nullable = false)
    public LoginEntity getLoginEntityByID() {
        return LoginEntityByID;
    }

    public void setLoginEntityByID (LoginEntity LoginEntityByID) {
        this.LoginEntityByID = LoginEntityByID;
    }
}

