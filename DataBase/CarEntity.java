package DataBase;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "Car", schema = "dbo", catalog = "master")
public class CarEntity {
    private int id;
    public RentalBaseEntity RentalBaseEntityByRentalBaseId;
    public String mark;
    public String color;
    public Date productionDate;
    public double price;
    private String category;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Mark", nullable = false, length = 20)
    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    @Basic
    @Column(name = "Color", nullable = false, length = 20)
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Basic
    @Column(name = "Production_Date", nullable = false)
    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    @Basic
    @Column(name = "Price", nullable = false, precision = 0)
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "Category", nullable = false, length = 20)
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarEntity carEntity = (CarEntity) o;
        return id == carEntity.id &&
                Double.compare(carEntity.price, price) == 0 &&
                Objects.equals(mark, carEntity.mark) &&
                Objects.equals(color, carEntity.color) &&
                Objects.equals(productionDate, carEntity.productionDate) &&
                Objects.equals(category, carEntity.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mark, color, productionDate, price, category);
    }

    @ManyToOne
    @JoinColumn(name = "RentalBase_Id", referencedColumnName = "ID", nullable = false)
    public RentalBaseEntity getRentalBaseEntityByRentalBaseId() {
        return RentalBaseEntityByRentalBaseId;
    }

    public void setRentalBaseEntityByRentalBaseId(RentalBaseEntity RentalBaseEntityByRentalBaseId) {
        this.RentalBaseEntityByRentalBaseId = RentalBaseEntityByRentalBaseId;
    }
}
