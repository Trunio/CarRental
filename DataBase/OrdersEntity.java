package DataBase;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "Orders", schema = "dbo", catalog = "master")
public class OrdersEntity {
    private int id;
    private Date rentalDate;
    private Date returnDate;
    private CarEntity carByCarId;
    private SellerEntity sellerBySellerId;
    private ClientEntity clientByClientId;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Rental_Date", nullable = false)
    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    @Basic
    @Column(name = "Return_Date", nullable = false)
    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdersEntity that = (OrdersEntity) o;
        return id == that.id &&
                Objects.equals(rentalDate, that.rentalDate) &&
                Objects.equals(returnDate, that.returnDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rentalDate, returnDate);
    }

    @ManyToOne
    @JoinColumn(name = "Car_Id", referencedColumnName = "ID", nullable = false)
    public CarEntity getCarByCarId() {
        return carByCarId;
    }

    public void setCarByCarId(CarEntity carByCarId) {
        this.carByCarId = carByCarId;
    }

    @ManyToOne
    @JoinColumn(name = "Seller_Id", referencedColumnName = "ID")
    public SellerEntity getSellerBySellerId() {
        return sellerBySellerId;
    }

    public void setSellerBySellerId(SellerEntity sellerBySellerId) {
        this.sellerBySellerId = sellerBySellerId;
    }

    @ManyToOne
    @JoinColumn(name = "Client_Id", referencedColumnName = "ID", nullable = false)
    public ClientEntity getClientByClientId() {
        return clientByClientId;
    }

    public void setClientByClientId(ClientEntity clientByClientId) {
        this.clientByClientId = clientByClientId;
    }
}
