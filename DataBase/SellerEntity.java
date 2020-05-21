package DataBase;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "Seller", schema = "dbo", catalog = "master")
public class SellerEntity {
    private int id;
    private String name;
    private String surname;
    private String telephone;
    private double salary;
    private Date recrutationDate;
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

    @Basic
    @Column(name = "Salary", nullable = false, precision = 0)
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Basic
    @Column(name = "Recrutation_Date", nullable = false)
    public Date getRecrutationDate() {
        return recrutationDate;
    }

    public void setRecrutationDate(Date recrutationDate) {
        this.recrutationDate = recrutationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SellerEntity that = (SellerEntity) o;
        return id == that.id &&
                telephone == that.telephone &&
                Double.compare(that.salary, salary) == 0 &&
                Objects.equals(recrutationDate, that.recrutationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, telephone, salary, recrutationDate);
    }

    @ManyToOne
    @JoinColumn(name = "Adress_ID", referencedColumnName = "ID", nullable = false)
    public Adress  getAdressByAdressId() {
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

