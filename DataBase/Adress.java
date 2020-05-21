package DataBase;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Adress", schema = "dbo", catalog = "master")
public class Adress {
    private int id;
    private String street;
    private String house;
    private String city;
    private String postCode;

    @Id
    @Column(name = "ID")

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Street", nullable = false, length = 20)
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Basic
    @Column(name = "House", nullable = false, length = 20)
    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    @Basic
    @Column(name = "City", nullable = false, length = 20)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "PostCode", nullable = false, length = 20)
    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Adress that = (Adress ) o;
        return id == that.id &&
                Objects.equals(street, that.street) &&
                Objects.equals(house, that.house) &&
                Objects.equals(city, that.city) &&
                Objects.equals(postCode, that.postCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, street, house, city, postCode);
    }
}
