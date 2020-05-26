package DataBase;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "OrdersArchive", schema = "dbo", catalog = "master")
public class OrdersArchiveEntity {
    private int id;
    private int orderScore;
    private int carScore;
    private Date rentalDate;
    private Date returnDate;
    private int carByCarId;
    private int sellerBySellerId;
    private int clientByClientId;
    private int RentalBaseEntitybyID;
    private int Orders_Id;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Order_Score", nullable = false)
    public int getOrderScore() {
        return orderScore;
    }

    public void setOrderScore(int orderScore) {
        this.orderScore = orderScore;
    }

    @Basic
    @Column(name = "Orders_Id", nullable = false)
    public int getOrders_Id() {
        return Orders_Id;
    }

    public void setOrders_Id(int Orders_Id) {
        this.Orders_Id = Orders_Id;
    }


    @Basic
    @Column(name = "Car_Score", nullable = false)
    public int getCarScore() {
        return carScore;
    }

    public void setCarScore(int carScore) {
        this.carScore = carScore;
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

    @Basic
    @Column(name = "Seller_Id")
    public int getSellerBySellerId() {
        return sellerBySellerId;
    }

    public void setSellerBySellerId(int sellerBySellerId) {
        this.sellerBySellerId = sellerBySellerId;
    }

    @Basic
    @Column(name = "Client_Id", nullable = false)
    public int getClientByClientId() {
        return clientByClientId;
    }

    public void setClientByClientId(int clientByClientId) {
        this.clientByClientId = clientByClientId;
    }


    @Basic
    @Column(name = "id_Base", nullable = false)
    public int getRentalBaseEntitybyID() {
        return RentalBaseEntitybyID;
    }

    public void setRentalBaseEntitybyID(int RentalBaseEntitybyID) {
        this.RentalBaseEntitybyID = RentalBaseEntitybyID;
    }

    @Basic
    @Column(name = "Car_Id",  nullable = false)
    public int getCarByCarId() {
        return carByCarId;
    }

    public void setCarByCarId(int carByCarId) {
        this.carByCarId = carByCarId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdersArchiveEntity that = (OrdersArchiveEntity) o;
        return id == that.id &&
                orderScore == that.orderScore &&
                carScore == that.carScore && Objects.equals(rentalDate, that.rentalDate) &&
                Objects.equals(returnDate, that.returnDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderScore, carScore, rentalDate, returnDate);
    }
}
