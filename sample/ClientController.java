package sample;


import CRUD.OrdersArchiveCRUD;
import CRUD.OrdersCRUD;
import DataBase.*;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;




public class ClientController implements Initializable {



    private static final SessionFactory ourSessionFactory;
    private  double xOffset = 0;
    private  double yOffset = 0;
    final Session session = getSession();
    LoginEntity login = Controller.user;
    Query query = session.createQuery("from ClientEntity WHERE LoginEntityByID = :wartosc");
    ClientEntity client = new ClientEntity();

    int baseid =1;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();

        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    @FXML
    private Label label;
    public Label ChooseDate;
    public TextField EmailLogin;
    public TextField PasswordLogin;
    public Label DateError;

    public TableView<CarEntity> RentTable;



    public TableColumn<CarEntity, String> RentBrand;
    public TableColumn<CarEntity, String> RentColor;
    public TableColumn<CarEntity, Date> RentDate;
    public TableColumn<CarEntity,String> RentCategory;
    public TableColumn<CarEntity,Double> RentPrice;
    public TableView<CarEntity> MyCarTable;
    public TableColumn<CarEntity, String> MyCarBrand;
    public TableColumn<CarEntity, String> MyCarColor;
    public TableColumn<CarEntity, Date> MyCarDate;
    public TableColumn<CarEntity,String> MyCarCategory;
    public TableColumn<CarEntity,Double> MyCarPrice;

    public TableView<OrdersArchiveEntity> HistoryTable;
    public TableColumn<OrdersArchiveEntity, String> HistoryBrand;
    public TableColumn<OrdersArchiveEntity, String> HistoryColor;
    public TableColumn<OrdersArchiveEntity, String> HistoryDate;
    public TableColumn<OrdersArchiveEntity,String> HistoryCategory;
    public TableColumn<OrdersArchiveEntity, Double> HistoryPrice;
    public TableColumn<OrdersArchiveEntity, Integer> HistoryCarScore;
    public TableColumn<OrdersArchiveEntity, Integer> HistoryOrderScore;
    public TableColumn<OrdersArchiveEntity, Date> HistoryRentalDate;
    public TableColumn<OrdersArchiveEntity, Date> HistoryReturnDate;
    public TableView<RentalBaseEntity> BaseAdressTable;
    public TableColumn<RentalBaseEntity, String> BaseName;
    public TableColumn <RentalBaseEntity, String> BaseTelephone;
    public TableColumn<RentalBaseEntity, String>  BaseStreet;
    public TableColumn<RentalBaseEntity, String>  BaseHouse;
    public TableColumn <RentalBaseEntity, String> BaseCity;
    public TableColumn<RentalBaseEntity, String>  BaseCode;
    public Label CarScoreError;
    public Label OrderScoreError;
    public Pane HistoryPanel;
    public Pane RentCarPanel;
    public Pane MyCarPanel;
    public DatePicker RentCarDate;
    public AnchorPane ClientPanel;
    public ChoiceBox<RentalBaseEntity> ChoiceBoxBase;
    public TextField OrderScore;
    public TextField CarScore;
    public Label NoCarError;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Query query4 = session.createQuery("from ClientEntity WHERE LoginEntityByID = :wartosc");
        query4.setParameter("wartosc",login);
        List Helper = query4.list();
        ObservableList<ClientEntity> Helper2 = FXCollections.observableArrayList(Helper);
        client = Helper2.get(0);

        final Session session = getSession();
    RentBrand.setCellValueFactory(new PropertyValueFactory<CarEntity, String>("mark"));
    RentColor.setCellValueFactory(new PropertyValueFactory<CarEntity,String>("color"));
    RentDate.setCellValueFactory(new PropertyValueFactory<CarEntity, Date>("productionDate"));
    RentCategory.setCellValueFactory(new PropertyValueFactory<CarEntity,String>("category"));
    RentPrice.setCellValueFactory(new PropertyValueFactory<CarEntity,Double>("price"));
    MyCarBrand.setCellValueFactory(new PropertyValueFactory<CarEntity, String>("mark"));
    MyCarColor.setCellValueFactory(new PropertyValueFactory<CarEntity,String>("color"));
    MyCarDate.setCellValueFactory(new PropertyValueFactory<CarEntity, Date>("productionDate"));
    MyCarCategory.setCellValueFactory(new PropertyValueFactory<CarEntity,String>("category"));
    MyCarPrice.setCellValueFactory(new PropertyValueFactory<CarEntity,Double>("price"));


    HistoryBrand.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCarByCarId().getMark()));
    HistoryColor.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCarByCarId().getColor()));
    HistoryDate.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCarByCarId().getProductionDate().toString()));
    HistoryCategory.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCarByCarId().getCategory()));
    HistoryPrice.setCellValueFactory(cellData -> new SimpleObjectProperty<Double>(cellData.getValue().getCarByCarId().getPrice()));
    HistoryCarScore.setCellValueFactory(new PropertyValueFactory<OrdersArchiveEntity,Integer>("carScore"));
    HistoryOrderScore.setCellValueFactory(new PropertyValueFactory<OrdersArchiveEntity,Integer>("orderScore"));
    HistoryRentalDate.setCellValueFactory(new PropertyValueFactory<OrdersArchiveEntity,Date>("rentalDate"));
    HistoryReturnDate.setCellValueFactory(new PropertyValueFactory<OrdersArchiveEntity,Date>("returnDate"));


    List Baza = session.createQuery("from RentalBaseEntity").list();
    ObservableList<RentalBaseEntity> Bazy = FXCollections.observableArrayList(Baza);
    RentalBaseEntity base2 = Bazy.get(1);

    Query query = session.createQuery("from CarEntity WHERE RentalBaseEntityByRentalBaseId = :wartosc");
    query.setParameter("wartosc", base2);
    List Autka = query.list();
    ObservableList<CarEntity> AutkaObs = FXCollections.observableArrayList(Autka);

    Query query2 = session.createQuery("select c from CarEntity c, OrdersEntity o where o.carByCarId.id = c.id");
    List order = query2.list();
    ObservableList<CarEntity> OrderList = FXCollections.observableArrayList(order);


    Query query3 = session.createQuery("select c from CarEntity c, OrdersEntity o where o.carByCarId.id=c.id and o.clientByClientId.id=:cos");
    query3.setParameter("cos", client.getId());
    List usercars = query3.list();
    ObservableList<CarEntity> UserAvaibleCars = FXCollections.observableArrayList(usercars);

    AutkaObs.removeAll(OrderList);
    ChoiceBoxBase.setItems(Bazy);
    RentTable.setItems(AutkaObs);
    MyCarTable.setItems(UserAvaibleCars);
    refreshHistory();

    }

    public void refreshHistory(){
        Query queryHist = session.createQuery("from OrdersArchiveEntity where clientByClientId.id=:cos");
        queryHist.setParameter("cos", client.getId());
        List<OrdersArchiveEntity> HistoryList = queryHist.list();
        ObservableList <OrdersArchiveEntity> Historia = FXCollections.observableArrayList(HistoryList);
        HistoryTable.setItems(Historia);

    }

    @FXML
    private void RentCarClientPressed(ActionEvent event) throws IOException

    {
    RentCarPanel.toFront();
    }
    @FXML
    private void HistoryClientPressed(ActionEvent event) throws IOException

    {
        HistoryPanel.toFront();
    }
    @FXML
    private void MyCarsClientPressed(ActionEvent event) throws IOException

    {
        MyCarPanel.toFront();
    }
    @FXML
    private void RentCarButtonPressed(ActionEvent event) throws IOException
    {
       if (RentCarDate.getValue() == null){
           ChooseDate.setText("You need to choose return date first!");
       }
       else {
           LocalDate returndata = RentCarDate.getValue();
           long millis=System.currentTimeMillis();
           java.sql.Date date=new java.sql.Date(millis);
           CarEntity car = RentTable.getSelectionModel().getSelectedItem();
           RentalBaseEntity base = ChoiceBoxBase.getSelectionModel().getSelectedItem();
           System.out.println(car.getId());
           OrdersCRUD maker = new OrdersCRUD();
           Date date2 = Date.valueOf(returndata);
           DateError.setText("RETURN DATE CANNOT BY EARLIER THAN THE DATE OF RENTING");
            if(date2.after(date)) {
                DateError.setText("");
                Query query2 = session.createQuery("from ClientEntity WHERE LoginEntityByID = :wartosc");
                query2.setParameter("wartosc", login);
                List Helper = query2.list();
                ObservableList<ClientEntity> Helper2 = FXCollections.observableArrayList(Helper);
                System.out.println(Helper2);
                ClientEntity client = Helper2.get(0);
                maker.saveOrdersEntity(date, date2, car, null, client);
                RentTable.getItems().remove(car);
                MyCarTable.getItems().add(car);
            }
       }
    }


    @FXML
    private void BoxSwitch(ActionEvent event) throws IOException
    {
        RentTable.getItems().removeAll();
        RentalBaseEntity base = ChoiceBoxBase.getSelectionModel().getSelectedItem();
        Query query = session.createQuery("from CarEntity WHERE RentalBaseEntityByRentalBaseId = :wartosc");
        query.setParameter("wartosc", base);
        List Autka = query.list();
        ObservableList<CarEntity> AutkaObs = FXCollections.observableArrayList(Autka);
        Query query2 = session.createQuery("select c from CarEntity c, OrdersEntity o where o.carByCarId.id = c.id");
        List order = query2.list();
        ObservableList<CarEntity> OrderList = FXCollections.observableArrayList(order);
        AutkaObs.removeAll(OrderList);
        RentTable.setItems(AutkaObs);
        System.out.println("wow");
    }

    @FXML
    private void  ReturnCarPressed(ActionEvent event) throws IOException
    {
        CarEntity car = MyCarTable.getSelectionModel().getSelectedItem();
        NoCarError.setText("You need to choose a car first");
        if(!car.getMark().equals("")) {
            NoCarError.setText("");
            CarScoreError.setText("Car Score  and Order Score must be set to number beetwen 1-10");
            if (!CarScore.getText().trim().equals("") && !OrderScore.getText().trim().equals("")) {
                CarScoreError.setText("");
                int carscore = Integer.parseInt(CarScore.getText());
                int orderscore = Integer.parseInt(OrderScore.getText());
                int baseid = car.getRentalBaseEntityByRentalBaseId().getId();
                RentalBaseEntity base = session.byId(RentalBaseEntity.class).getReference(baseid);
                Query query10 = session.createQuery("select c from OrdersEntity c WHERE c.carByCarId = :wartosc");
                query10.setParameter("wartosc", car);
                OrdersEntity order = (OrdersEntity) query10.uniqueResult();
                OrdersArchiveCRUD create = new OrdersArchiveCRUD();
                OrdersCRUD delete = new OrdersCRUD();
                create.saveOrdersArchiveEntity(orderscore, carscore, base, order.getId(), order.getRentalDate(), order.getReturnDate(), order.getCarByCarId(), order.getSellerBySellerId(), order.getClientByClientId());
                MyCarTable.getItems().remove(car);
                delete.deleteOrdersEntity(order.getId());
                refreshHistory();
            }
        }
    }


    @FXML
    private void SelectDate(ActionEvent event){
        System.out.println(RentCarDate.getValue());
    }
}


