
package DataBase;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.Objects;

@Entity
@Table(name = "RentalBase", schema = "dbo", catalog = "master")
public class RentalBaseEntity {
    private int id;
    private String name;
    private String telephone;
    private Adress adressByAdressId;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Transactional
    @Basic
    @Column(name = "Name", nullable = true, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Telephone", nullable = true, length = 20)
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
        RentalBaseEntity that = (RentalBaseEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(telephone, that.telephone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, telephone);
    }

    @ManyToOne
    @JoinColumn(name = "Adress_ID", referencedColumnName = "ID", nullable = false)
    public Adress getAdressByAdressId() {
        return adressByAdressId;
    }

    public void setAdressByAdressId(Adress adressByAdressId) {
        this.adressByAdressId = adressByAdressId;
    }
    @Override
    public String toString() {
        return name;
    }
}

