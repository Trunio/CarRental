package DataBase;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Repairments", schema = "dbo", catalog = "master")
public class RepairmentsEntity {
    private int id;
    private String engine;
    private String tire;
    private String frontWindows;
    private String doors;
    private String body;
    private CarEntity carByCarId;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Engine", nullable = false, length = 20)
    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    @Basic
    @Column(name = "Tire", nullable = false, length = 20)
    public String getTire() {
        return tire;
    }

    public void setTire(String tire) {
        this.tire = tire;
    }

    @Basic
    @Column(name = "FrontWindows", nullable = false, length = 20)
    public String getFrontWindows() {
        return frontWindows;
    }

    public void setFrontWindows(String frontWindows) {
        this.frontWindows = frontWindows;
    }

    @Basic
    @Column(name = "Doors", nullable = false, length = 20)
    public String getDoors() {
        return doors;
    }

    public void setDoors(String doors) {
        this.doors = doors;
    }

    @Basic
    @Column(name = "Body", nullable = false, length = 20)
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RepairmentsEntity that = (RepairmentsEntity) o;
        return id == that.id &&
                Objects.equals(engine, that.engine) &&
                Objects.equals(tire, that.tire) &&
                Objects.equals(frontWindows, that.frontWindows) &&
                Objects.equals(doors, that.doors) &&
                Objects.equals(body, that.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, engine, tire, frontWindows, doors, body);
    }

    @ManyToOne
    @JoinColumn(name = "Car_Id", referencedColumnName = "ID", nullable = false)
    public CarEntity getCarByCarId() {
        return carByCarId;
    }

    public void setCarByCarId(CarEntity carByCarId) {
        this.carByCarId = carByCarId;
    }
}
