package sample;
import CRUD.*;
import DataBase.*;
import javafx.application.Platform;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.jdbc.Expectation;
import org.hibernate.query.Query;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
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

import javax.transaction.Transactional;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class AdminController implements Initializable {

    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();

        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public TableView<OrdersArchiveEntity> HistoryTable1;
    public TableColumn<OrdersArchiveEntity, Integer> HistoryCarScore1;
    public TableColumn<OrdersArchiveEntity, Integer> HistoryOrderScore1;
    public TableColumn<OrdersArchiveEntity, Date> HistoryRentalDate1;
    public TableColumn<OrdersArchiveEntity, Date> HistoryReturnDate1;

    public Button ClientOperationsCreateButton;
    public Button ClientOperationsUpdateButton;
    public Button ClientOperationsDeleteButton;
    public TextField UpdateBaseNameTextField;
    public TextField UpdateBaseTelephoneTextField;
    public TextField UpdateBaseStreetTextField;
    public TextField UpdateBaseHouseTextField;
    public TextField UpdateBaseCityTextField;
    public TextField UpdateBasePostCodeTextField;
    public Label DeleteSellerLoginError;
    public Label DeleteSellerAdressError;
    public Pane DeleteCarPanel;
    public Label CarDeleteError;
    public Pane BaseDeletePanel;
    public Label DeleteBaseAdressError;
    public Label DeleteBaseError;
    public Pane RepairmentOperations;
    public Pane CreateRepairmentsPanel;
    public TextField EngineTextField;
    public TextField TireTextField;
    public TextField FrontWindowsTextField;
    public TextField DoorsTextField;
    public TextField BodyTextField;
    public Pane DeleteRepairmentPanel;
    public TableView<CarEntity> RentTable;
    public TableColumn<CarEntity, String> RentBrand;
    public TableColumn<CarEntity, String> RentColor;
    public TableColumn<CarEntity, Date> RentDate;
    public TableColumn<CarEntity,String> RentCategory;
    public TableColumn<CarEntity,Double> RentPrice;
    public TableView<CarEntity> RentTable1;
    public TableColumn<CarEntity, String> RentBrand1;
    public TableColumn<CarEntity, String> RentColor1;
    public TableColumn<CarEntity, Date> RentDate1;
    public TableColumn<CarEntity,String> RentCategory1;
    public TableColumn<CarEntity,Double> RentPrice1;
    public Label DateError;
    public Label ChooseDate;
    public Button RentCarButton;
    public Pane OrderOperationsPanel;
    public Pane CreateOrderPanel;
    public Pane OrderUpdatePanel;
    public Label NoCarError1;
    public Label CarScoreError1;
    public Button ReturnCar1;
    public TextField CarScore1;
    public TextField OrderScore1;
    public Pane CreateOrdersArchivePanel;
    public Pane OrdersArchiveOperationsPanel;
    public Pane DeleteOrdersArchivePanel;
    public Label CreateSellerError;
    public Label UpdateSellerError;
    public Label CreateClientError;
    public Label UpdateClientError;
    public Label CarCreateError;
    public Button BaseCreateError;
    public Label BaseCreateError1;
    public Label CarUpdateError;
    public Label BaseUpdateError;
    public Label UpdateRepairmentsError;
    public Label OrderUpdateError;
    public Pane DeleteOrderPanel;
    public Label DeleteOrderError;
    public Label DeleteOrdersArchiveError;
    public TextField CarScoreUpdate;
    public TextField OrderScoreUpdate;
    public TextField RentalDateUpdate;
    public TextField ReturnDateUpdate;
    public Label UpdateOrderArchiveError;
    public Pane UpdateOrdersArchive;


    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public ClientEntity client;
    SellerEntity seller = new SellerEntity();
    RentalBaseEntity base = new RentalBaseEntity();
    CarEntity car = new CarEntity();
    RentalBaseEntity base2 =  new RentalBaseEntity();
    RepairmentsEntity repairment = new RepairmentsEntity();
    OrdersEntity order = new OrdersEntity();
    OrdersArchiveEntity past = new OrdersArchiveEntity();
    public String WhatToUpdate;
    public Pane SellerUpdatePanel;
    public TableView<SellerEntity> UpdateSellerSeller;
    public TableColumn<SellerEntity,String> UpdateSellerName;
    public TableColumn<SellerEntity,String> UpdateSellerSurname;
    public TableColumn<SellerEntity,String> UpdateSellerTelephone;
    public TableColumn<SellerEntity,Double> UpdateSellerSalary;
    public TableColumn<SellerEntity,Date> UpdateSellerrRecrutationDate1;
    public TableView<Adress> UpdateSellerAdress;
    public TableColumn <Adress,String>UpdateSellerStreet;
    public TableColumn<Adress,String> UpdateSellerHouse;
    public TableColumn <Adress,String>UpdateSellerCity;
    public TableColumn <Adress,String>UpdateSellerPostCode;
    public TableView<LoginEntity> UpdateSellerTable;
    public TableColumn<LoginEntity,String> UpdateSellerLogin;
    public TableColumn<LoginEntity,String> UpdateSellerPassword;
    public TextField NameTextField1;
    public TextField SurnameTextField1;
    public TextField TelephoneTextField1;
    public TextField SalaryTextField1;
    public TextField RecrutationDateTextField1;
    public TextField StreetTextField1;
    public TextField CityTextField1;
    public TextField PasswordTextField1;
    public TextField LoginTextField1;
    public TextField PostCodeTextField1;
    public TextField HouseTextField1;
    public Pane SellerCreationPanel;
    public TextField NameTextField;
    public TextField SurnameTextField;
    public TextField TelephoneTextField;
    public TextField SalaryTextField;
    public TextField RecrutationDateTextField;
    public TextField StreetTextField;
    public TextField HouseTextField;
    public TextField CityTextField;
    public TextField PostCodeTextField;
    public TextField LoginTextField;
    public TextField PasswordTextField;
    public Pane SellerOperationsPanel;
    public TextField CreateClientName;
    public TextField CreateClientSurname;
    public TextField CreateClientTelephone;
    public TextField CreateClientLogin;
    public TextField CreateClientPassword;
    public TextField CreateClientAdressStreet;
    public TextField CreateClientAdressHouse;
    public TextField CreateClientAdressCity;
    public TextField CreateClientPostCode;
    public Pane CreateClientPanel;
    public Pane SelectClientOperationPanel;
    public Pane CurrentOrdersPanel;
    public TableView<ClientEntity> UpdateClientTable;
    public TableColumn<ClientEntity, String> UpdateClientTableName;
    public TableColumn<ClientEntity, String> UpdateClientTableSurname;
    public TableColumn<ClientEntity, String> UpdateClientTableTelephone;
    public TableView<ClientEntity> UpdateClientTable21;
    public TableColumn<ClientEntity, String> UpdateClientTableName21;
    public TableColumn<ClientEntity, String> UpdateClientTableSurname21;
    public TableColumn<ClientEntity, String> UpdateClientTableTelephone21;
    public TableView<ClientEntity> UpdateClientTable211;
    public TableColumn<ClientEntity, String> UpdateClientTableName211;
    public TableColumn<ClientEntity, String> UpdateClientTableSurname211;
    public TableColumn<ClientEntity, String> UpdateClientTableTelephone211;
    public TableColumn <LoginEntity,String>ClientUpdateLoginTablePassword;
    public TableColumn <LoginEntity,String>ClientUpdateLoginTableLogin;
    public TableView<LoginEntity>ClientUpdateLoginTable;
    public ChoiceBox<String> ClientBoxUpdate;
    public TextField ClientTextUpdate;
    public TextField ClientLoginUpdatePasswordText;
    public TextField ClientLoginUpdateLoginText;
    public TableView<Adress> ClientUpdateAdressTable;
    public TableColumn<Adress,String> ClientUpdateAdressTableStreet;
    public TableColumn<Adress,String> ClientUpdateAdressTableHouse;
    public TableColumn<Adress,String> ClientUpdateAdressTableCity;
    public TableColumn<Adress,String> ClientUpdateAdressTablePostcode;
    public TextField ClientUpdateAdressStreetText;
    public TextField ClientUpdateAdressHouseText;
    public TextField ClientUpdateAdressCityText;
    public TextField ClientUpdateAdressPostcodeText;
    public Pane UpdateClientPanel;
    public Pane CarOperationsPanel;
    public Pane CarCreationPanel;
    public TextField CarCreationMarkTextField;
    public TextField CarCreationColorTextField;
    public TextField CarCreationProductionDateTextField;
    public TextField CarCreationPriceTextField;
    public TextField CarCreationCategoryTextField;
    public TableView<RentalBaseEntity> CreateCarSelectBaseTable;
    public TableColumn<RentalBaseEntity,String> CreateCarRentalBaseColumn;
    public TableColumn<RentalBaseEntity,String> CreateCarTelephoneColumn;
    public Pane CarUpdatePanel;
    public TextField CarUpdateMarkTextField;
    public TextField CarUpdateColorTextField;
    public TextField CarUpdateProductionDateTextField;
    public TextField CarUpdatePriceTextField;
    public TextField CarUpdateCategoryTextField;
    public TableView<RentalBaseEntity>  UpdateCarSelectBaseTable;
    public TableColumn<RentalBaseEntity,String>  UpdateCarRentalBaseColumn;
    public TableColumn<RentalBaseEntity,String>  UpdateCarTelephoneColumn;

    public TableView<CarEntity> MyCarTable1;
    public TableColumn<CarEntity, String> MyCarBrand1;
    public TableColumn<CarEntity, String> MyCarColor1;
    public TableColumn<CarEntity, Date> MyCarDate1;
    public TableColumn<CarEntity,String> MyCarCategory1;
    public TableColumn<CarEntity,Double> MyCarPrice1;


    public TableView<CarEntity> MyCarTable2;
    public TableColumn<CarEntity, String> MyCarBrand2;
    public TableColumn<CarEntity, String> MyCarColor2;
    public TableColumn<CarEntity, Date> MyCarDate2;
    public TableColumn<CarEntity,String> MyCarCategory2;
    public TableColumn<CarEntity,Double> MyCarPrice2;
    public TableColumn<CarEntity,String> UpdateCarRentalBase;

    public TableView<CarEntity> MyCarTable11;
    public TableColumn<CarEntity, String> MyCarBrand11;
    public TableColumn<CarEntity, String> MyCarColor11;
    public TableColumn<CarEntity, Date> MyCarDate11;
    public TableColumn<CarEntity,String> MyCarCategory11;
    public TableColumn<CarEntity,Double> MyCarPrice11;

    public TableView<CarEntity> MyCarTable11a;
    public TableColumn<CarEntity, String> MyCarBrand11a;
    public TableColumn<CarEntity, String> MyCarColor11a;
    public TableColumn<CarEntity, Date> MyCarDate11a;
    public TableColumn<CarEntity,String> MyCarCategory11a;
    public TableColumn<CarEntity,Double> MyCarPrice11a;
    public TableColumn<CarEntity,String> UpdateCarRentalBase1;

    public ChoiceBox<RentalBaseEntity> ChoiceBoxBase;
    public TextField BaseNameTextField;
    public TextField BaseTelephoneTextField;
    public TableView<RentalBaseEntity> BaseAdressTable;
    public TableColumn<RentalBaseEntity, String> BaseName;
    public TableColumn <RentalBaseEntity, String> BaseTelephone;
    public TableColumn<RentalBaseEntity, String>  BaseStreet;
    public TableColumn<RentalBaseEntity, String>  BaseHouse;
    public TableColumn <RentalBaseEntity, String> BaseCity;
    public TableColumn<RentalBaseEntity, String>  BaseCode;
    public TableView<RentalBaseEntity> BaseAdressTable1;
    public TableColumn<RentalBaseEntity, String> BaseName1;
    public TableColumn <RentalBaseEntity, String> BaseTelephone1;
    public TableColumn<RentalBaseEntity, String>  BaseStreet1;
    public TableColumn<RentalBaseEntity, String>  BaseHouse1;
    public TableColumn <RentalBaseEntity, String> BaseCity1;
    public TableColumn<RentalBaseEntity, String>  BaseCode1;
    public TextField BaseStreetTextField;
    public TextField BaseHouseTextField;
    public TextField BaseCityTextField;
    public TextField BasePostCodeTextField;
    public Pane BaseOperationsPanel;
    public Pane BaseCreatePanel;
    public Pane BaseUpdatePanel;
    public TableView<ClientEntity> UpdateClientTable1;
    public TableColumn<ClientEntity, String> UpdateClientTableName1;
    public TableColumn<ClientEntity, String> UpdateClientTableSurname1;
    public TableColumn<ClientEntity, String> UpdateClientTableTelephone1;
    public TableView<ClientEntity> UpdateClientTable2;
    public TableColumn<ClientEntity, String> UpdateClientTableName2;
    public TableColumn<ClientEntity, String> UpdateClientTableSurname2;
    public TableColumn<ClientEntity, String> UpdateClientTableTelephone2;
    public TableView<LoginEntity> ClientUpdateLoginTable1;
    public TableColumn<LoginEntity, String> ClientUpdateLoginTableLogin1;
    public TableColumn<LoginEntity, String> ClientUpdateLoginTablePassword1;
    public TableView<Adress> ClientUpdateAdressTable1;
    public TableColumn <Adress,String> ClientUpdateAdressTableStreet1;
    public TableColumn <Adress,String> ClientUpdateAdressTableHouse1;
    public TableColumn<Adress,String>  ClientUpdateAdressTableCity1;
    public TableColumn <Adress,String> ClientUpdateAdressTablePostcode1;
    public Pane ClientDeletePanel;
    public Label ClientLoginDeleteError;
    public Label ClientAdressDeleteError;
    public Pane DeleteSellerPanel;

    public TableView<LoginEntity> DeleteSellerLoginTable;
    public TableColumn<LoginEntity,String>  DeleteSellerLogin;
    public TableColumn<LoginEntity, String>  DeleteSellerPassword;
    public TableView<Adress>  DeleteSellerAdressTable;
    public TableColumn<Adress, String> DeleteSellerAdressStreet;
    public TableColumn<Adress, String> DeleteSellerAdressHouse;
    public TableColumn<Adress, String> DeleteSellerAdressCity;
    public TableColumn<Adress, String> DeleteSellerAdressPostcode;

    public TableView<SellerEntity> DeleteSellerSeller;
    public TableColumn<SellerEntity,String>  DeleteSellerName;
    public TableColumn<SellerEntity,String>  DeleteSellerSurname;
    public TableColumn<SellerEntity,String>  DeleteSellerTelephone;
    public TableColumn<SellerEntity,Double>  DeleteSellerSalary;
    public TableColumn <SellerEntity,Date> DeleteSellerrRecrutationDate1;


    public TableView<SellerEntity> DeleteSellerSeller1;
    public TableColumn<SellerEntity,String>  DeleteSellerName1;
    public TableColumn<SellerEntity,String>  DeleteSellerSurname1;
    public TableColumn<SellerEntity,String>  DeleteSellerTelephone1;
    public TableColumn<SellerEntity,Double>  DeleteSellerSalary1;
    public TableColumn <SellerEntity,Date> DeleteSellerrRecrutationDate11;

    public TableView<RepairmentsEntity> RepairmentsTable;
    public TableColumn<RepairmentsEntity,String>  RepairmentsEngine;
    public TableColumn<RepairmentsEntity,String>  RepairmentsTire;
    public TableColumn<RepairmentsEntity,String>  RepairmentsWindows;
    public TableColumn<RepairmentsEntity,String>  RepairmentsDoors;
    public TableColumn<RepairmentsEntity,String>  RepairmentsBody;
    public TableView<RepairmentsEntity> RepairmentsTable1;
    public TableColumn<RepairmentsEntity,String>  RepairmentsEngine1;
    public TableColumn<RepairmentsEntity,String>  RepairmentsTire1;
    public TableColumn<RepairmentsEntity,String>  RepairmentsWindows1;
    public TableColumn<RepairmentsEntity,String>  RepairmentsDoors1;
    public TableColumn<RepairmentsEntity,String>  RepairmentsBody1;
    public TableView<CarEntity> NoSellerCarTable2;
    public TableColumn<CarEntity,String>  NoSellerCarBrand2;
    public TableColumn<CarEntity,String>  NoSellerCarColor2;
    public TableColumn<CarEntity,Date>  NoSellerCarDate2;
    public TableColumn<CarEntity,String>  NoSellerCarCategory2;
    public TableColumn<CarEntity,Double>  NoSellerCarPrice2;
    public ChoiceBox<RentalBaseEntity> ChoiceBoxBase2;
    public DatePicker RentCarDate;

    public TableView<OrdersEntity> OrdersTable;
    public TableColumn <OrdersEntity,Date> RentalDateOrders;
    public TableColumn <OrdersEntity,Date> ReturnDateOrders;

    public TableView<OrdersEntity> OrdersTable1;
    public TableColumn <OrdersEntity,Date> RentalDateOrders1;
    public TableColumn <OrdersEntity,Date> ReturnDateOrders1;

    public TextField NewRentalDateTextField;
    public TextField NewReturnDateTextField;

    @Override
    @Transactional
    public void initialize(URL location, ResourceBundle resources) {
        final Session session = getSession();
        UpdateSellerName.setCellValueFactory(new PropertyValueFactory<SellerEntity, String>("name"));
        UpdateSellerSurname.setCellValueFactory(new PropertyValueFactory<SellerEntity, String>("surname"));
        UpdateSellerTelephone.setCellValueFactory(new PropertyValueFactory<SellerEntity, String>("telephone"));
        UpdateSellerSalary.setCellValueFactory(new PropertyValueFactory<SellerEntity, Double>("salary"));
        UpdateSellerrRecrutationDate1.setCellValueFactory(new PropertyValueFactory<SellerEntity, Date>("recrutationDate"));

        UpdateSellerLogin.setCellValueFactory(new PropertyValueFactory<LoginEntity,String>("username"));
        UpdateSellerPassword.setCellValueFactory(new PropertyValueFactory<LoginEntity,String>("password"));

        UpdateSellerStreet.setCellValueFactory(new PropertyValueFactory<Adress,String>("street"));
        UpdateSellerHouse.setCellValueFactory(new PropertyValueFactory<Adress,String>("house"));
        UpdateSellerCity.setCellValueFactory(new PropertyValueFactory<Adress,String>("city"));
        UpdateSellerPostCode.setCellValueFactory(new PropertyValueFactory<Adress,String>("postCode"));

        DeleteSellerName.setCellValueFactory(new PropertyValueFactory<SellerEntity, String>("name"));
        DeleteSellerSurname.setCellValueFactory(new PropertyValueFactory<SellerEntity, String>("surname"));
        DeleteSellerTelephone.setCellValueFactory(new PropertyValueFactory<SellerEntity, String>("telephone"));
        DeleteSellerSalary.setCellValueFactory(new PropertyValueFactory<SellerEntity, Double>("salary"));
        DeleteSellerrRecrutationDate1.setCellValueFactory(new PropertyValueFactory<SellerEntity, Date>("recrutationDate"));

        HistoryCarScore1.setCellValueFactory(new PropertyValueFactory<OrdersArchiveEntity,Integer>("carScore"));
        HistoryOrderScore1.setCellValueFactory(new PropertyValueFactory<OrdersArchiveEntity,Integer>("orderScore"));
        HistoryRentalDate1.setCellValueFactory(new PropertyValueFactory<OrdersArchiveEntity,Date>("rentalDate"));
        HistoryReturnDate1.setCellValueFactory(new PropertyValueFactory<OrdersArchiveEntity,Date>("returnDate"));

        DeleteSellerName1.setCellValueFactory(new PropertyValueFactory<SellerEntity, String>("name"));
        DeleteSellerSurname1.setCellValueFactory(new PropertyValueFactory<SellerEntity, String>("surname"));
        DeleteSellerTelephone1.setCellValueFactory(new PropertyValueFactory<SellerEntity, String>("telephone"));
        DeleteSellerSalary1.setCellValueFactory(new PropertyValueFactory<SellerEntity, Double>("salary"));
        DeleteSellerrRecrutationDate11.setCellValueFactory(new PropertyValueFactory<SellerEntity, Date>("recrutationDate"));


        DeleteSellerLogin.setCellValueFactory(new PropertyValueFactory<LoginEntity,String>("username"));
        DeleteSellerPassword.setCellValueFactory(new PropertyValueFactory<LoginEntity,String>("password"));

        DeleteSellerAdressStreet.setCellValueFactory(new PropertyValueFactory<Adress,String>("street"));
        DeleteSellerAdressHouse.setCellValueFactory(new PropertyValueFactory<Adress,String>("house"));
        DeleteSellerAdressCity.setCellValueFactory(new PropertyValueFactory<Adress,String>("city"));
        DeleteSellerAdressPostcode.setCellValueFactory(new PropertyValueFactory<Adress,String>("postCode"));

        UpdateSellerLogin.setCellValueFactory(new PropertyValueFactory<LoginEntity,String>("username"));
        UpdateSellerPassword.setCellValueFactory(new PropertyValueFactory<LoginEntity,String>("password"));
        UpdateSellerStreet.setCellValueFactory(new PropertyValueFactory<Adress,String>("street"));
        UpdateSellerHouse.setCellValueFactory(new PropertyValueFactory<Adress,String>("house"));
        UpdateSellerCity.setCellValueFactory(new PropertyValueFactory<Adress,String>("city"));
        UpdateSellerPostCode.setCellValueFactory(new PropertyValueFactory<Adress,String>("postCode"));


        ClientBoxUpdate.getItems().add("name");
        ClientBoxUpdate.getItems().add("surname");
        ClientBoxUpdate.getItems().add("telephone");
        UpdateClientTableName.setCellValueFactory(new PropertyValueFactory<ClientEntity, String>("name"));
        UpdateClientTableSurname.setCellValueFactory(new PropertyValueFactory<ClientEntity, String>("surname"));
        UpdateClientTableTelephone.setCellValueFactory(new PropertyValueFactory<ClientEntity, String>("telephone"));
        UpdateClientTableName2.setCellValueFactory(new PropertyValueFactory<ClientEntity, String>("name"));
        UpdateClientTableSurname2.setCellValueFactory(new PropertyValueFactory<ClientEntity, String>("surname"));
        UpdateClientTableTelephone2.setCellValueFactory(new PropertyValueFactory<ClientEntity, String>("telephone"));
        UpdateClientTableName21.setCellValueFactory(new PropertyValueFactory<ClientEntity, String>("name"));
        UpdateClientTableSurname21.setCellValueFactory(new PropertyValueFactory<ClientEntity, String>("surname"));
        UpdateClientTableTelephone21.setCellValueFactory(new PropertyValueFactory<ClientEntity, String>("telephone"));
        UpdateClientTableName211.setCellValueFactory(new PropertyValueFactory<ClientEntity, String>("name"));
        UpdateClientTableSurname211.setCellValueFactory(new PropertyValueFactory<ClientEntity, String>("surname"));
        UpdateClientTableTelephone211.setCellValueFactory(new PropertyValueFactory<ClientEntity, String>("telephone"));
        ClientUpdateLoginTableLogin.setCellValueFactory(new PropertyValueFactory<LoginEntity,String>("username"));
        ClientUpdateLoginTablePassword.setCellValueFactory(new PropertyValueFactory<LoginEntity,String>("password"));
        ClientUpdateAdressTableStreet.setCellValueFactory(new PropertyValueFactory<Adress,String>("street"));
        ClientUpdateAdressTableHouse.setCellValueFactory(new PropertyValueFactory<Adress,String>("house"));
        ClientUpdateAdressTableCity.setCellValueFactory(new PropertyValueFactory<Adress,String>("city"));
        ClientUpdateAdressTablePostcode.setCellValueFactory(new PropertyValueFactory<Adress,String>("postCode"));
        CreateCarRentalBaseColumn.setCellValueFactory(new PropertyValueFactory<RentalBaseEntity,String>("name"));
        CreateCarTelephoneColumn.setCellValueFactory(new PropertyValueFactory<RentalBaseEntity,String>("telephone"));
        UpdateCarRentalBaseColumn.setCellValueFactory(new PropertyValueFactory<RentalBaseEntity,String>("name"));
        UpdateCarTelephoneColumn.setCellValueFactory(new PropertyValueFactory<RentalBaseEntity,String>("telephone"));

        MyCarBrand1.setCellValueFactory(new PropertyValueFactory<CarEntity, String>("mark"));
        MyCarColor1.setCellValueFactory(new PropertyValueFactory<CarEntity,String>("color"));
        MyCarDate1.setCellValueFactory(new PropertyValueFactory<CarEntity, Date>("productionDate"));
        MyCarCategory1.setCellValueFactory(new PropertyValueFactory<CarEntity,String>("category"));
        MyCarPrice1.setCellValueFactory(new PropertyValueFactory<CarEntity,Double>("price"));

        MyCarBrand11.setCellValueFactory(new PropertyValueFactory<CarEntity, String>("mark"));
        MyCarColor11.setCellValueFactory(new PropertyValueFactory<CarEntity,String>("color"));
        MyCarDate11.setCellValueFactory(new PropertyValueFactory<CarEntity, Date>("productionDate"));
        MyCarCategory11.setCellValueFactory(new PropertyValueFactory<CarEntity,String>("category"));
        MyCarPrice11.setCellValueFactory(new PropertyValueFactory<CarEntity,Double>("price"));

        MyCarBrand11a.setCellValueFactory(new PropertyValueFactory<CarEntity, String>("mark"));
        MyCarColor11a.setCellValueFactory(new PropertyValueFactory<CarEntity,String>("color"));
        MyCarDate11a.setCellValueFactory(new PropertyValueFactory<CarEntity, Date>("productionDate"));
        MyCarCategory11a.setCellValueFactory(new PropertyValueFactory<CarEntity,String>("category"));
        MyCarPrice11a.setCellValueFactory(new PropertyValueFactory<CarEntity,Double>("price"));


        MyCarBrand2.setCellValueFactory(new PropertyValueFactory<CarEntity, String>("mark"));
        MyCarColor2.setCellValueFactory(new PropertyValueFactory<CarEntity,String>("color"));
        MyCarDate2.setCellValueFactory(new PropertyValueFactory<CarEntity, Date>("productionDate"));
        MyCarCategory2.setCellValueFactory(new PropertyValueFactory<CarEntity,String>("category"));
        MyCarPrice2.setCellValueFactory(new PropertyValueFactory<CarEntity,Double>("price"));


        List Baza = session.createQuery("from RentalBaseEntity").list();
        ObservableList<RentalBaseEntity> Bazy = FXCollections.observableArrayList(Baza);

        BaseName.setCellValueFactory(new PropertyValueFactory<RentalBaseEntity,String>("name"));
        BaseTelephone.setCellValueFactory(new PropertyValueFactory<RentalBaseEntity,String>("telephone"));
        BaseStreet.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAdressByAdressId().getStreet()));
        BaseHouse.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAdressByAdressId().getHouse()));
        BaseCity.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAdressByAdressId().getCity()));
        BaseCode.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAdressByAdressId().getPostCode()));

        BaseName1.setCellValueFactory(new PropertyValueFactory<RentalBaseEntity,String>("name"));
        BaseTelephone1.setCellValueFactory(new PropertyValueFactory<RentalBaseEntity,String>("telephone"));
        BaseStreet1.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAdressByAdressId().getStreet()));
        BaseHouse1.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAdressByAdressId().getHouse()));
        BaseCity1.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAdressByAdressId().getCity()));
        BaseCode1.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAdressByAdressId().getPostCode()));

        UpdateClientTableName1.setCellValueFactory(new PropertyValueFactory<ClientEntity, String>("name"));
        UpdateClientTableSurname1.setCellValueFactory(new PropertyValueFactory<ClientEntity, String>("surname"));
        UpdateClientTableTelephone1.setCellValueFactory(new PropertyValueFactory<ClientEntity, String>("telephone"));
        ClientUpdateLoginTableLogin1.setCellValueFactory(new PropertyValueFactory<LoginEntity,String>("username"));
        ClientUpdateLoginTablePassword1.setCellValueFactory(new PropertyValueFactory<LoginEntity,String>("password"));
        ClientUpdateAdressTableStreet1.setCellValueFactory(new PropertyValueFactory<Adress,String>("street"));
        ClientUpdateAdressTableHouse1.setCellValueFactory(new PropertyValueFactory<Adress,String>("house"));
        ClientUpdateAdressTableCity1.setCellValueFactory(new PropertyValueFactory<Adress,String>("city"));
        ClientUpdateAdressTablePostcode1.setCellValueFactory(new PropertyValueFactory<Adress,String>("postCode"));

        RepairmentsEngine.setCellValueFactory(new PropertyValueFactory<RepairmentsEntity,String>("engine"));
        RepairmentsTire.setCellValueFactory(new PropertyValueFactory<RepairmentsEntity,String>("tire"));
        RepairmentsWindows.setCellValueFactory(new PropertyValueFactory<RepairmentsEntity,String>("frontWindows"));
        RepairmentsDoors.setCellValueFactory(new PropertyValueFactory<RepairmentsEntity,String>("doors"));
        RepairmentsBody.setCellValueFactory(new PropertyValueFactory<RepairmentsEntity,String>("body"));
        RepairmentsEngine1.setCellValueFactory(new PropertyValueFactory<RepairmentsEntity,String>("engine"));
        RepairmentsTire1.setCellValueFactory(new PropertyValueFactory<RepairmentsEntity,String>("tire"));
        RepairmentsWindows1.setCellValueFactory(new PropertyValueFactory<RepairmentsEntity,String>("frontWindows"));
        RepairmentsDoors1.setCellValueFactory(new PropertyValueFactory<RepairmentsEntity,String>("doors"));
        RepairmentsBody1.setCellValueFactory(new PropertyValueFactory<RepairmentsEntity,String>("body"));

        NoSellerCarBrand2.setCellValueFactory(new PropertyValueFactory<CarEntity, String>("mark"));
        NoSellerCarColor2.setCellValueFactory(new PropertyValueFactory<CarEntity,String>("color"));
        NoSellerCarDate2.setCellValueFactory(new PropertyValueFactory<CarEntity, Date>("productionDate"));
        NoSellerCarCategory2.setCellValueFactory(new PropertyValueFactory<CarEntity,String>("category"));
        NoSellerCarPrice2.setCellValueFactory(new PropertyValueFactory<CarEntity,Double>("price"));


        RentBrand.setCellValueFactory(new PropertyValueFactory<CarEntity, String>("mark"));
        RentColor.setCellValueFactory(new PropertyValueFactory<CarEntity,String>("color"));
        RentDate.setCellValueFactory(new PropertyValueFactory<CarEntity, Date>("productionDate"));
        RentCategory.setCellValueFactory(new PropertyValueFactory<CarEntity,String>("category"));
        RentPrice.setCellValueFactory(new PropertyValueFactory<CarEntity,Double>("price"));

        RentBrand1.setCellValueFactory(new PropertyValueFactory<CarEntity, String>("mark"));
        RentColor1.setCellValueFactory(new PropertyValueFactory<CarEntity,String>("color"));
        RentDate1.setCellValueFactory(new PropertyValueFactory<CarEntity, Date>("productionDate"));
        RentCategory1.setCellValueFactory(new PropertyValueFactory<CarEntity,String>("category"));
        RentPrice1.setCellValueFactory(new PropertyValueFactory<CarEntity,Double>("price"));

        RentalDateOrders.setCellValueFactory(new PropertyValueFactory<OrdersEntity,Date>("rentalDate"));
        ReturnDateOrders.setCellValueFactory(new PropertyValueFactory<OrdersEntity,Date>("returnDate"));


        RentalDateOrders1.setCellValueFactory(new PropertyValueFactory<OrdersEntity,Date>("rentalDate"));
        ReturnDateOrders1.setCellValueFactory(new PropertyValueFactory<OrdersEntity,Date>("returnDate"));
        ChoiceBoxBase.setItems(Bazy);
        ChoiceBoxBase2.setItems(Bazy);
        refreshALL();
    }

    public void refreshALL(){
        refreshHistory();
        refreshClient5();
        refreshNoSellerCar2();
        refreshCarsDelete();
        refreshClient2();
        refreshSellers();
        refreshClient();
        refreshBaseSelector();
        refreshBaseSelector2();
        refreshBase();
        refreshBase2();
        refreshDeleteclient();
        refreshRepairments2();
        refreshClient3();
        refreshOrders();
        refreshRentTable();
        refreshClientOrderUpdate();
        refreshClient4();
        refreshOrders2();
        refreshPastCar();
    }


    public void refreshClient4(){
        final Session session = getSession();
        Query query = session.createQuery("from ClientEntity");
        List Helper = query.list();
        ObservableList<ClientEntity> Helper2 = FXCollections.observableArrayList(Helper);
        UpdateClientTable21.setItems(Helper2);
        session.close();
    }


    public void refreshClientOrderUpdate(){
        final Session session = getSession();
        Query query = session.createQuery("from SellerEntity");
        List<SellerEntity> Autka = query.list();
        ObservableList <SellerEntity>   AutkaObs = FXCollections.observableArrayList(Autka);
        DeleteSellerSeller1.setItems(AutkaObs);
        session.close();
    }

    public void refreshOrders(){
        final Session session = getSession();
        Query query = session.createQuery("from OrdersEntity");
        List<OrdersEntity> Autka = query.list();
        ObservableList <OrdersEntity>  AutkaObs = FXCollections.observableArrayList(Autka);
        OrdersTable.setItems(AutkaObs);
        session.close();
    }


    public void refreshOrders2(){
        final Session session = getSession();
        Query query = session.createQuery("from OrdersEntity");
        List<OrdersEntity> Autka = query.list();
        ObservableList <OrdersEntity>  AutkaObs = FXCollections.observableArrayList(Autka);
        OrdersTable1.setItems(AutkaObs);
        session.close();
    }


    public void refreshRentTable(){
        final Session session = getSession();
        Query query = session.createQuery("from CarEntity ");
        List<CarEntity> Autka = query.list();
        ObservableList <CarEntity>  AutkaObs = FXCollections.observableArrayList(Autka);
        RentTable1.setItems(AutkaObs);
        session.close();
    }


    @FXML
    private void RentCarButtonPressed(ActionEvent event) throws IOException
    {
        try {
            final Session session = getSession();
            if (RentCarDate.getValue() == null) {
                ChooseDate.setText("You need to choose return date first!");
            } else {
                LocalDate returndata = RentCarDate.getValue();
                long millis = System.currentTimeMillis();
                java.sql.Date date = new java.sql.Date(millis);
                CarEntity car = RentTable.getSelectionModel().getSelectedItem();
                RentalBaseEntity base = ChoiceBoxBase.getSelectionModel().getSelectedItem();
                System.out.println(car.getId());
                OrdersCRUD maker = new OrdersCRUD();
                Date date2 = Date.valueOf(returndata);
                DateError.setText("RETURN DATE CANNOT OCCUR BEFORE THE DATE OF RENTING");
                if (date2.after(date)) {
                    DateError.setText("");
                    maker.saveOrdersEntity(date, date2, car, null, client);
                    RentTable.getItems().remove(car);
                    DateError.setText("Car Rented!");
                    ChooseDate.setText("");
                    refreshALL();
                }
            }
            session.close();
        }
        catch(ConstraintViolationException cve){
            DateError.setText("You need to select a Client and a Car first!");
        }
    }



    @FXML
    private void BoxSwitch2(ActionEvent event) throws IOException
    {
        final Session session = getSession();
        RentTable.getItems().removeAll();
        RentalBaseEntity base = ChoiceBoxBase2.getSelectionModel().getSelectedItem();
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
    private void SelectDate(ActionEvent event){
        System.out.println(RentCarDate.getValue());
    }




    public void SellerOperationsButtonClicked(ActionEvent actionEvent) {
        SellerOperationsPanel.toFront();    refreshALL();
    }

    @FXML
    private void BoxSwitch(ActionEvent event) throws IOException
    {
       refreshCars();
    }
    @FXML
    public void refreshBase(){
        final Session session = getSession();
        Query query = session.createQuery("from RentalBaseEntity ");
        List<RentalBaseEntity> Autka = query.list();
        ObservableList <RentalBaseEntity>  AutkaObs = FXCollections.observableArrayList(Autka);
        BaseAdressTable.setItems(AutkaObs);
        session.close();
    }    @FXML

    public void refreshBase2(){
        final Session session = getSession();
        Query query = session.createQuery("from RentalBaseEntity ");
        List<RentalBaseEntity> Autka = query.list();
        ObservableList <RentalBaseEntity>  AutkaObs = FXCollections.observableArrayList(Autka);
        BaseAdressTable1.setItems(AutkaObs);
        session.close();
    }

    @FXML
    public void refreshCars(){
        final Session session = getSession();
        MyCarTable1.getItems().removeAll();
        RentalBaseEntity base = ChoiceBoxBase.getSelectionModel().getSelectedItem();
        Query query = session.createQuery("from CarEntity WHERE RentalBaseEntityByRentalBaseId = :wartosc");
        query.setParameter("wartosc", base);
        List Autka = query.list();
        ObservableList<CarEntity> AutkaObs = FXCollections.observableArrayList(Autka);
        MyCarTable1.setItems(AutkaObs);
        session.close();
    }


    public void refreshCarsDelete(){
        final Session session = getSession();
        Query query = session.createQuery("from CarEntity");
        List Autka = query.list();
        ObservableList<CarEntity> AutkaObs = FXCollections.observableArrayList(Autka);
        MyCarTable11a.setItems(AutkaObs);
        session.close();
    }


    public void refreshCarsOrderArchive(){
        final Session session = getSession();
        Query query = session.createQuery("select c from CarEntity c, OrdersEntity o where o.carByCarId.id=c.id and o.clientByClientId.id=:cos");
        query.setParameter("cos", client.getId());
        List Autka = query.list();
        ObservableList<CarEntity> AutkaObs = FXCollections.observableArrayList(Autka);
        MyCarTable2.setItems(AutkaObs);
        session.close();
    }


    public void CreateClientFinalPressed(ActionEvent actionEvent) {
        final Session session = getSession();
        String postcode = CreateClientPostCode.getText();
        String telephone = CreateClientTelephone.getText();
        CreateClientError.setText("You need to fill all the boxes to create a Client!");
        if(!CreateClientLogin.getText().trim().equals("") && !CreateClientPassword.getText().trim().equals("") && !CreateClientAdressStreet.getText().trim().equals("") &&
                !CreateClientPostCode.getText().trim().equals("") && !CreateClientAdressCity.getText().trim().equals("") && !CreateClientAdressHouse.getText().trim().equals("")&&
                !CreateClientName.getText().trim().equals("") && !CreateClientSurname.getText().trim().equals("") && !CreateClientTelephone.getText().trim().equals("") ) {
            CreateClientError.setText("Postcode must be like this: 11-111");
            if(Pattern.matches("[0-9][0-9]-[0-9][0-9][0-9]", postcode)) {
                CreateClientError.setText("Telephone must be like this: 123456789");
                if(Pattern.matches("[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]", telephone)) {
                    CreateClientError.setText("Username already taken!");
                    if(SellerController.LoginCheck(CreateClientLogin.getText())) {
                        CreateClientError.setText("Password must contain: numbers, lowercase, uppercase, special character!");
                        if(SellerController.PaswwordCheck(CreateClientPassword.getText())) {
                            LoginCRUD logincreator = new LoginCRUD();
                            logincreator.saveLogin(CreateClientLogin.getText(), CreateClientPassword.getText(), 1);
                            AdressCRUD adrescreator = new AdressCRUD();
                            adrescreator.saveAdress(CreateClientAdressStreet.getText(), CreateClientPostCode.getText(), CreateClientAdressHouse.getText(), CreateClientAdressCity.getText());
                            ClientCRUD clientcreator = new ClientCRUD();
                            Query query = session.createQuery("from Adress order by id DESC");
                            query.setMaxResults(1);
                            Adress adress = (Adress) query.uniqueResult();
                            Query query2 = session.createQuery("from LoginEntity order by id DESC");
                            query2.setMaxResults(1);
                            LoginEntity login = (LoginEntity) query2.uniqueResult();
                            clientcreator.saveClient(CreateClientName.getText(), CreateClientSurname.getText(), CreateClientTelephone.getText(), adress, login);
                            CreateClientError.setText("Client Added!");
                        }
                    }
                }
            }
        }
    }
    
    

    public void CreateClientProceed(ActionEvent actionEvent) {
        CreateClientPanel.toFront();    refreshALL();
    }

    public void BackFromClientCreator(ActionEvent actionEvent) {
        SelectClientOperationPanel.toFront();    refreshALL();
    }

    public void refreshClient3(){
        final Session session = getSession();
        Query query = session.createQuery("from ClientEntity");
        List Helper = query.list();
        ObservableList<ClientEntity> Helper2 = FXCollections.observableArrayList(Helper);
        UpdateClientTable2.setItems(Helper2);
        session.close();
    }
    public void refreshClient5(){
        final Session session = getSession();
        Query query = session.createQuery("from ClientEntity");
        List Helper = query.list();
        ObservableList<ClientEntity> Helper2 = FXCollections.observableArrayList(Helper);
        UpdateClientTable211.setItems(Helper2);
        session.close();
    }


    public void refreshClient(){
        final Session session = getSession();
        Query query = session.createQuery("from ClientEntity");
        List Helper = query.list();
        ObservableList<ClientEntity> Helper2 = FXCollections.observableArrayList(Helper);
        UpdateClientTable.setItems(Helper2);
        session.close();
    }

    public void refreshLogins(){
        final Session session = getSession();
        Query query2 = session.createQuery("from LoginEntity where id = :wartosc");
        query2.setParameter("wartosc", client.getLoginEntityByID().getId());
        List Logins = query2.list();
        ObservableList<LoginEntity> Logins2 = FXCollections.observableArrayList(Logins);
        ClientUpdateLoginTable.setItems(Logins2);
        session.close();
    }

    public void refreshAdress(){
        final Session session = getSession();
        Query query3 = session.createQuery("from Adress where id = :wartosc");
        query3.setParameter("wartosc", client.getAdressByAdressId().getId());
        List Logins = query3.list();
        ObservableList<Adress> Logins3 = FXCollections.observableArrayList(Logins);
        ClientUpdateAdressTable.setItems(Logins3);
        session.close();
    }

    public void ClientUpdateDataPressed(ActionEvent actionEvent) {
        try {
            String text = ClientTextUpdate.getText();
            client = UpdateClientTable.getSelectionModel().getSelectedItem();
            if (text.equals("")) {
                UpdateClientError.setText("Select section you want to update from the box");
            }
            if (WhatToUpdate.equals("name")) {
                ClientCRUD updator = new ClientCRUD();
                updator.UpdateClientName(client.getId(), text);
                refreshClient();
                UpdateClientError.setText("Updated!");
            }
            if (WhatToUpdate.equals("surname")) {
                ClientCRUD updator = new ClientCRUD();
                updator.UpdateClientSurname(client.getId(), text);
                refreshClient();
                UpdateClientError.setText("Updated!");
            }
            if (WhatToUpdate.equals("telephone")) {
                ClientCRUD updator = new ClientCRUD();
                updator.UpdateClientTelephone(client.getId(), text);
                refreshClient();
                UpdateClientError.setText("Updated!");
            }
        }
        catch(Exception e) {
            UpdateClientError.setText("You need to select a Client first!");
        }
    }



    public void ClientUpdateTableClick(MouseEvent mouseEvent) {
        client = UpdateClientTable.getSelectionModel().getSelectedItem();
        ClientLoginUpdateLoginText.setText(client.getLoginEntityByID().getUsername());
        ClientLoginUpdatePasswordText.setText(client.getLoginEntityByID().getPassword());
        ClientUpdateAdressStreetText.setText(client.getAdressByAdressId().getStreet());
        ClientUpdateAdressHouseText.setText(client.getAdressByAdressId().getHouse());
        ClientUpdateAdressPostcodeText.setText(client.getAdressByAdressId().getPostCode());
        ClientUpdateAdressCityText.setText(client.getAdressByAdressId().getCity());
        refreshLogins();
        refreshAdress();
    }


    public void ClientUpdateTableClick4(MouseEvent mouseEvent) {
        client = UpdateClientTable211.getSelectionModel().getSelectedItem();
        refreshCarsOrderArchive();
    }



    public void ClientOperationsButtonPressed(ActionEvent actionEvent) {
        SelectClientOperationPanel.toFront();    refreshALL();
    }

    @FXML
    private void ClientBoxUpdateSwitch(ActionEvent event) throws IOException {
        WhatToUpdate = ClientBoxUpdate.getSelectionModel().getSelectedItem();
    }

    public void ClientUpdateLoginPressed(ActionEvent actionEvent) {
        try {
            String login = ClientLoginUpdateLoginText.getText();
            String password = ClientLoginUpdatePasswordText.getText();
            UpdateClientError.setText("You need to type in the login and password first!");
            if(!login.equals("")&& !password.equals("")) {
                LoginCRUD updator = new LoginCRUD();
                updator.LoginUsername(client.getLoginEntityByID().getId(), login);
                updator.LoginPassword(client.getLoginEntityByID().getId(), password);
                refreshLogins();
                UpdateClientError.setText("Updated!");
            }
        }
        catch(Exception e) {
            UpdateClientError.setText("You need to select a Client first!");
        }
    }

    public void ClientUpdateAdressPressed(ActionEvent actionEvent) {
        try {
            String street = ClientUpdateAdressStreetText.getText();
            String house = ClientUpdateAdressHouseText.getText();
            String city = ClientUpdateAdressCityText.getText();
            String postcode = ClientUpdateAdressPostcodeText.getText();
            UpdateClientError.setText("You need to fill all the Adress boxes first!");
            if(!street.equals("")&& !house.equals("")&&!city.equals("")&&!postcode.equals("")) {
                UpdateClientError.setText("Postcode must have following pattern: 11-111");
                if (Pattern.matches("[0-9][0-9]-[0-9][0-9][0-9]", postcode)) {
                    AdressCRUD updator = new AdressCRUD();
                    updator.UpdateAdressStreet(client.getAdressByAdressId().getId(), street);
                    updator.UpdateAdressHouse(client.getAdressByAdressId().getId(), house);
                    updator.UpdateAdressCity(client.getAdressByAdressId().getId(), city);
                    updator.UpdateAdressPostCode(client.getAdressByAdressId().getId(), postcode);
                    refreshAdress();
                    UpdateClientError.setText("Updated!");
                }
            }
        }
        catch(Exception e) {
            UpdateClientError.setText("You need to select a Client first!");
        }
    }



    public void UpdateClientProceed(ActionEvent actionEvent) {
        UpdateClientPanel.toFront();    refreshALL();
    }


    public void refreshSellers(){
        final Session session = getSession();
        Query query = session.createQuery("from SellerEntity ");
        List List = query.list();
        ObservableList <SellerEntity> ObsList = FXCollections.observableArrayList(List);
        UpdateSellerSeller.setItems(ObsList);
        session.close();
    }

    public void refreshSellerAdress(){
        final Session session = getSession();
        seller=UpdateSellerSeller.getSelectionModel().getSelectedItem();
        Query query = session.createQuery("from Adress a where a.id = :wartosc");
        query.setParameter("wartosc",seller.getAdressByAdressId().getId());
        List List = query.list();
        ObservableList <Adress> ObsList = FXCollections.observableArrayList(List);
        UpdateSellerAdress.setItems(ObsList);
        System.out.println("Adres Refresh");
        session.close();
    }

    public void refreshSellerLogin(){
        final Session session = getSession();
        seller=UpdateSellerSeller.getSelectionModel().getSelectedItem();
        Query queryHist = session.createQuery("from LoginEntity where id = :wartosc");
        queryHist.setParameter("wartosc",seller.getLoginEntityByID().getId());
        List List = queryHist.list();
        ObservableList <LoginEntity> ObsList = FXCollections.observableArrayList(List);
        UpdateSellerTable.setItems(ObsList);
        session.close();
    }


    public void CreateSellerButtonPressed(ActionEvent actionEvent) throws ParseException {
        final Session session = getSession();
        CreateSellerError.setText("You need to fill all the boxes!");
        if(!LoginTextField.getText().trim().equals("") && !PasswordTextField.getText().trim().equals("") &&!StreetTextField.getText().trim().equals("") &&
                !PostCodeTextField.getText().trim().equals("") && !HouseTextField.getText().trim().equals("") &&!CityTextField.getText().trim().equals("") &&
                !NameTextField.getText().trim().equals("") && !SurnameTextField.getText().trim().equals("") && !TelephoneTextField.getText().trim().equals("") && !SalaryTextField.getText().trim().equals("")) {
            CreateSellerError.setText("Post Code must have a pattern like this: 11-111");
            if(Pattern.matches("[0-9][0-9]-[0-9][0-9][0-9]", PostCodeTextField.getText())) {
                CreateSellerError.setText("Telephone must have a pattern like this: 123456789");
                if(Pattern.matches("[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]", TelephoneTextField.getText())) {
                    CreateSellerError.setText("Salary must be a double type!");
                    if(Pattern.matches("^[0-9]+([,.][0-9]?)?$", SalaryTextField.getText())) {
                        CreateSellerError.setText("Date must be like this : 1999-01-01!");
                        if(Pattern.matches("^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$",RecrutationDateTextField.getText())) {
                            CreateSellerError.setText("Username already taken");
                            if(SellerController.LoginCheck(LoginTextField.getText())) {
                                CreateSellerError.setText("Password must contain: numbers, lowercase, uppercase, special character!");
                                if(SellerController.PaswwordCheck(PasswordTextField.getText())) {
                                    LoginCRUD loginCreator = new LoginCRUD();
                                    AdressCRUD adressCreator = new AdressCRUD();
                                    SellerCRUD sellerCreator = new SellerCRUD();
                                    loginCreator.saveLogin(LoginTextField.getText(), PasswordTextField.getText(), 2);
                                    adressCreator.saveAdress(StreetTextField.getText(), PostCodeTextField.getText(), HouseTextField.getText(), CityTextField.getText());
                                    Query query = session.createQuery("from Adress order by id DESC");
                                    query.setMaxResults(1);
                                    Adress adress = (Adress) query.uniqueResult();
                                    Query query2 = session.createQuery("from LoginEntity order by id DESC");
                                    query2.setMaxResults(1);
                                    LoginEntity login = (LoginEntity) query2.uniqueResult();
                                    System.out.println(RecrutationDateTextField.getText());
                                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
                                    java.util.Date date = sdf.parse(RecrutationDateTextField.getText());
                                    java.sql.Date sqlDate = new Date(date.getTime());
                                    sellerCreator.saveSeller(NameTextField.getText(), SurnameTextField.getText(), TelephoneTextField.getText(), Double.parseDouble(SalaryTextField.getText()), sqlDate, adress, login);
                                    CreateSellerError.setText("Updated!");
                                }
                            }
                        }
                    }
                }
            }
        }

    }

    public void BackFromSellerCreation(ActionEvent actionEvent) {
        SellerOperationsPanel.toFront();    refreshALL();
    }

    public void AddSellerButtonClicked(ActionEvent actionEvent) {
        SellerCreationPanel.toFront();    refreshALL();
    }

    public void UpdateSellerButtonPressed(ActionEvent actionEvent) throws ParseException {
        UpdateSellerError.setText("You need to fill all the boxes first!");
        if(!NameTextField1.getText().trim().equals("") && !SurnameTextField1.getText().trim().equals("") && !TelephoneTextField1.getText().trim().equals("") && !SalaryTextField1.getText().trim().equals("")) {
            UpdateSellerError.setText("Telephone must have a pattern like this: 123456789");
            if(Pattern.matches("[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]", TelephoneTextField1.getText())) {
                UpdateSellerError.setText("Salary must be a double type!");
                if (Pattern.matches("[0-9]*\\.[0-9]*", SalaryTextField1.getText())) {
                    UpdateSellerError.setText("Date must be like this : 1999-01-01!");
                    if(Pattern.matches("^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$",RecrutationDateTextField1.getText()))
                    {
                        SellerCRUD updator = new SellerCRUD();
                        updator.UpdateSellerName(seller.getId(), NameTextField1.getText());
                        updator.UpdateSellerSurname(seller.getId(), SurnameTextField1.getText());
                        updator.UpdateSellerTelephone(seller.getId(), TelephoneTextField1.getText());
                        updator.UpdateSellerSalary(seller.getId(), Double.parseDouble(SalaryTextField1.getText()));
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
                        java.util.Date date = sdf.parse(RecrutationDateTextField1.getText());
                        java.sql.Date sqlDate = new Date(date.getTime());
                        updator.UpdateSellerRecrutationDate(seller.getId(), sqlDate);
                        UpdateSellerSeller.getItems().clear();
                        refreshSellers();
                        UpdateSellerError.setText("Updated!");
                    }
                }
            }
        }
    }

    public void UpdateSellerAdressButtonPressed(ActionEvent actionEvent) {
        UpdateSellerError.setText("You need to fill all the boxes first!");
        if(!StreetTextField1.getText().trim().equals("") && !PostCodeTextField1.getText().trim().equals("") && !HouseTextField1.getText().trim().equals("") &&!CityTextField1.getText().trim().equals("")) {
            UpdateSellerError.setText("PostCode must have pattern like this: 11-111");
            if(Pattern.matches("[0-9][0-9]-[0-9][0-9][0-9]", PostCodeTextField1.getText())) {
                AdressCRUD updator = new AdressCRUD();
                updator.UpdateAdressStreet(seller.getAdressByAdressId().getId(), StreetTextField1.getText());
                updator.UpdateAdressCity(seller.getAdressByAdressId().getId(), CityTextField1.getText());
                updator.UpdateAdressHouse(seller.getAdressByAdressId().getId(), HouseTextField1.getText());
                updator.UpdateAdressPostCode(seller.getAdressByAdressId().getId(), PostCodeTextField1.getText());
                UpdateSellerAdress.getItems().clear();
                UpdateSellerError.setText("Updated!");
            }
        }
    }

    public void UpdateSellerLoginButtonPressed(ActionEvent actionEvent) {
        UpdateSellerError.setText("You need to fill all the boxes first!");
        if(!LoginTextField1.getText().trim().equals("") && !PasswordTextField1.getText().trim().equals("")){
            LoginCRUD updator = new LoginCRUD();
            updator.LoginUsername(seller.getLoginEntityByID().getId(), LoginTextField1.getText());
            updator.LoginPassword(seller.getLoginEntityByID().getId(), PasswordTextField1.getText());
            UpdateSellerTable.getItems().clear();
            refreshSellerLogin();
            UpdateSellerError.setText("Updated!");
        }
    }

    public void GetUpdateSeller(MouseEvent mouseEvent) {
        seller=UpdateSellerSeller.getSelectionModel().getSelectedItem();
        NameTextField1.setText(seller.getName());
        SurnameTextField1.setText(seller.getSurname());
        TelephoneTextField1.setText(seller.getTelephone());
        SalaryTextField1.setText(String.valueOf(seller.getSalary()));
        RecrutationDateTextField1.setText(String.valueOf(seller.getRecrutationDate()));
        StreetTextField1.setText(seller.getAdressByAdressId().getStreet());
        HouseTextField1.setText(seller.getAdressByAdressId().getHouse());
        PostCodeTextField1.setText(seller.getAdressByAdressId().getPostCode());
        CityTextField1.setText(seller.getAdressByAdressId().getCity());
        LoginTextField1.setText(seller.getLoginEntityByID().getUsername());
        PasswordTextField1.setText(seller.getLoginEntityByID().getPassword());
        System.out.println(seller.getName());
        refreshSellerAdress();
        refreshSellerLogin();
    }

    public void BackFromClientUpdator(ActionEvent actionEvent) {
        SelectClientOperationPanel.toFront();    refreshALL();
    }

    public void UpdateSellerPanelButtonPressed(ActionEvent actionEvent) { SellerUpdatePanel.toFront();
        refreshALL();
    }


    public void refreshBaseSelector(){
        final Session session = getSession();
        Query queryHist = session.createQuery("from RentalBaseEntity");
        List List = queryHist.list();
        ObservableList <RentalBaseEntity> ObsList = FXCollections.observableArrayList(List);
        CreateCarSelectBaseTable.setItems(ObsList);
        session.close();
    }

    public void refreshBaseSelector2(){
        final Session session = getSession();
        Query queryHist = session.createQuery("from RentalBaseEntity");
        List List = queryHist.list();
        ObservableList <RentalBaseEntity> ObsList = FXCollections.observableArrayList(List);
        UpdateCarSelectBaseTable.setItems(ObsList);
        session.close();
    }




    public void CreateCarButtonPressed(ActionEvent actionEvent) {
        CarCreationPanel.toFront();    refreshALL();
    }

    public void UpdateCarButtonPressed(ActionEvent actionEvent) {
        CarUpdatePanel.toFront();    refreshALL();
    }



    public void CarCreationButtonPressedFinal(ActionEvent actionEvent) throws ParseException {
        try {
            CarCreateError.setText("You need to fill all the boxes!");
            if (!CarCreationMarkTextField.getText().trim().equals("") && !CarCreationColorTextField.getText().trim().equals("") && !(CarCreationPriceTextField.getText().trim().equals("") && !CarCreationCategoryTextField.getText().trim().equals(""))) {
                CarCreateError.setText("Date must have pattern like : 1999-10-10 !");
                if (Pattern.matches("^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$", CarCreationProductionDateTextField.getText())) {
                    CarCreateError.setText("Price must be a double type!");
                    if (Pattern.matches("[0-9]*\\.[0-9]*", CarCreationPriceTextField.getText())) {
                        CarCRUD creator = new CarCRUD();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
                        java.util.Date date = sdf.parse(CarCreationProductionDateTextField.getText());
                        java.sql.Date sqlDate = new Date(date.getTime());
                        creator.saveCar(base, CarCreationMarkTextField.getText(), CarCreationColorTextField.getText(), sqlDate, Double.parseDouble(CarCreationPriceTextField.getText()), CarCreationCategoryTextField.getText());
                        CarCreateError.setText("Created!");
                    }
                }
            }
        }  catch(Exception e) {
            CarCreateError.setText("You need to choose the Rental Base first!");
        }

    }




    public void CreateCarSelectBase(MouseEvent mouseEvent) {
       base = CreateCarSelectBaseTable.getSelectionModel().getSelectedItem();
    }

    public void CarOperationsButtonPressed(ActionEvent actionEvent) {
        CarOperationsPanel.toFront();    refreshALL();
    }

    public void UpdateCarSelectBase(MouseEvent mouseEvent) {
        base = UpdateCarSelectBaseTable.getSelectionModel().getSelectedItem();
    }

    public void UpdateCarButtonPressedFinal(ActionEvent actionEvent) throws ParseException, JDBCException {
        CarUpdateError.setText("You need to fill in all the boxes!");
        if (!CarUpdateMarkTextField.getText().trim().equals("") && !CarUpdateColorTextField.getText().trim().equals("") &&
                !CarUpdatePriceTextField.getText().trim().equals("") && !CarUpdateCategoryTextField.getText().trim().equals("")&& !CarUpdateProductionDateTextField.getText().trim().equals("")) {
            CarUpdateError.setText("Date must have pattern like : 1999-10-10 !");
            if (Pattern.matches("^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$", CarUpdateProductionDateTextField.getText())) {
                CarUpdateError.setText("Price must be a double type!");
                if (Pattern.matches("^[0-9]+([,.][0-9]?)?$", CarUpdatePriceTextField.getText())) {
                    CarUpdateError.setText("");
                    CarCRUD updator = new CarCRUD();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
                    java.util.Date date = sdf.parse(CarUpdateProductionDateTextField.getText());
                    Date sqlDate = new Date(date.getTime());
                    updator.UpdateCarCategory(car.getId(), CarUpdateCategoryTextField.getText());
                    updator.UpdateCarColor(car.getId(), CarUpdateColorTextField.getText());
                    updator.UpdateCarMark(car.getId(), CarUpdateMarkTextField.getText());
                    updator.UpdateCarPrice(car.getId(), Double.parseDouble(CarUpdatePriceTextField.getText()));
                    updator.UpdateCarProductionDate(car.getId(), sqlDate);
                    updator.UpdateCarBase(car.getId(), base);
                    CarUpdateError.setText("");
                    refreshCars();
                }
            }
        }

    }

    public void UpdateCarSelect(MouseEvent mouseEvent) {
        car = MyCarTable1.getSelectionModel().getSelectedItem();
        CarUpdateMarkTextField.setText(car.getMark());
        CarUpdateColorTextField.setText(car.getColor());
        CarUpdatePriceTextField.setText(String.valueOf(car.getPrice()));
        CarUpdateCategoryTextField.setText(car.getCategory());
        CarUpdateProductionDateTextField.setText(String.valueOf(car.getProductionDate()));
    }

    public void SelectCreateBase(MouseEvent mouseEvent) {
    }

    public void CreateBaseButtonPressed(ActionEvent actionEvent) {
        final Session session = getSession();
        BaseCreateError1.setText("You need to fill all the boxes first!");
        if (!BaseStreetTextField.getText().trim().equals("") && !BasePostCodeTextField.getText().trim().equals("") && !BaseHouseTextField.getText().trim().equals("") && !BaseCityTextField.getText().trim().equals("") &&
        !BaseNameTextField.getText().trim().equals("") && !BaseTelephoneTextField.getText().trim().equals("")) {
            BaseCreateError1.setText("Post code must have a following pattern: 11-111");
            if(Pattern.matches("[0-9][0-9]-[0-9][0-9][0-9]", BasePostCodeTextField.getText())) {
                BaseCreateError1.setText("Telephone must have a following pattern: 123456789");
                if(Pattern.matches("[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]", BaseTelephoneTextField.getText())) {
                    AdressCRUD adressCreator = new AdressCRUD();
                    adressCreator.saveAdress(BaseStreetTextField.getText(), BasePostCodeTextField.getText(), BaseHouseTextField.getText(), BaseCityTextField.getText());
                    Query query = session.createQuery("from Adress order by id DESC");
                    query.setMaxResults(1);
                    Adress adress = (Adress) query.uniqueResult();
                    RentalBaseCRUD baseCreator = new RentalBaseCRUD();
                    baseCreator.saveRentalBase(BaseNameTextField.getText(), BaseTelephoneTextField.getText(), adress);
                    BaseCreateError1.setText("Created!");
                }
            }
        }
    }

    public void BaseCreateProceed(ActionEvent actionEvent) {
        BaseCreatePanel.toFront();    refreshALL();
    }

    public void BaseUpdateProceed(ActionEvent actionEvent) {
        BaseUpdatePanel.toFront();    refreshALL();

    }

    public void BaseOperations(ActionEvent actionEvent) {
        BaseOperationsPanel.toFront();    refreshALL();

    }

    public void UpdateBaseFinal(ActionEvent actionEvent) {
        try {
            BaseUpdateError.setText("You need to fill all the boxes first!");
            if (!UpdateBaseStreetTextField.getText().trim().equals("") && !UpdateBasePostCodeTextField.getText().trim().equals("") && !UpdateBaseHouseTextField.getText().trim().equals("") && !UpdateBaseCityTextField.getText().trim().equals("") &&
                    !UpdateBaseNameTextField.getText().trim().equals("") && !UpdateBaseTelephoneTextField.getText().trim().equals("")) {
                BaseUpdateError.setText("Post code must have a following pattern: 11-111");
                if (Pattern.matches("[0-9][0-9]-[0-9][0-9][0-9]", UpdateBasePostCodeTextField.getText())) {
                    BaseUpdateError.setText("Telephone must have a following pattern: 123456789");
                    if (Pattern.matches("[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]", UpdateBaseTelephoneTextField.getText())) {
                        AdressCRUD adressUpdate = new AdressCRUD();
                        RentalBaseCRUD baseUpdate = new RentalBaseCRUD();
                        adressUpdate.UpdateAdressPostCode(base.getAdressByAdressId().getId(), UpdateBasePostCodeTextField.getText());
                        adressUpdate.UpdateAdressStreet(base.getAdressByAdressId().getId(), UpdateBaseStreetTextField.getText());
                        adressUpdate.UpdateAdressCity(base.getAdressByAdressId().getId(), UpdateBaseCityTextField.getText());
                        adressUpdate.UpdateAdressHouse(base.getAdressByAdressId().getId(), UpdateBaseHouseTextField.getText());
                        baseUpdate.UpdateRentalBaseName(base.getId(), UpdateBaseNameTextField.getText());
                        baseUpdate.UpdateRentalBaseTelephone(base.getId(), UpdateBaseTelephoneTextField.getText());
                        refreshBase();
                        BaseUpdateError.setText("Updated!");
                    }
                }
            }
        }
        catch(Exception e) {
            BaseUpdateError.setText("You need to choose the base first!");
        }
    }

    public void SelectUpdateBase(MouseEvent mouseEvent) {
        base = BaseAdressTable.getSelectionModel().getSelectedItem();
        UpdateBaseNameTextField.setText(base.getName());
        UpdateBaseTelephoneTextField.setText(base.getTelephone());
        UpdateBaseStreetTextField.setText(base.getAdressByAdressId().getStreet());
        UpdateBaseHouseTextField.setText(base.getAdressByAdressId().getHouse());
        UpdateBasePostCodeTextField.setText(base.getAdressByAdressId().getPostCode());
        UpdateBaseCityTextField.setText(base.getAdressByAdressId().getCity());

    }

    public void refreshClient2(){
        final Session session = getSession();
        Query query = session.createQuery("from ClientEntity");
        List Helper = query.list();
        ObservableList<ClientEntity> Helper2 = FXCollections.observableArrayList(Helper);
        UpdateClientTable1.setItems(Helper2);
        session.close();
    }

    public void refreshLogins2(){
        final Session session = getSession();
        Query query2 = session.createQuery("from LoginEntity where id = :wartosc");
        query2.setParameter("wartosc", client.getLoginEntityByID().getId());
        List Logins = query2.list();
        ObservableList<LoginEntity> Logins2 = FXCollections.observableArrayList(Logins);
        ClientUpdateLoginTable1.setItems(Logins2);
        session.close();
    }

    public void refreshAdress2(){
        final Session session = getSession();
        Query query3 = session.createQuery("from Adress where id = :wartosc");
        query3.setParameter("wartosc", client.getAdressByAdressId().getId());
        List Logins = query3.list();
        ObservableList<Adress> Logins3 = FXCollections.observableArrayList(Logins);
        ClientUpdateAdressTable1.setItems(Logins3);
        session.close();
    }

    public void refreshDeleteclient(){
        final Session session = getSession();
        Query query = session.createQuery("from SellerEntity");
        List<SellerEntity> Autka = query.list();
        ObservableList <SellerEntity>   AutkaObs = FXCollections.observableArrayList(Autka);
        DeleteSellerSeller.setItems(AutkaObs);
        session.close();
    }


    public void refreshLogins3(){
        final Session session = getSession();
        Query query2 = session.createQuery("from LoginEntity where id = :wartosc");
        query2.setParameter("wartosc", seller.getLoginEntityByID().getId());
        List Logins = query2.list();
        ObservableList<LoginEntity> Logins2 = FXCollections.observableArrayList(Logins);
        DeleteSellerLoginTable.setItems(Logins2);
        session.close();
    }

    public void refreshAdress3(){
        final Session session = getSession();
        Query query3 = session.createQuery("from Adress where id = :wartosc");
        query3.setParameter("wartosc", seller.getAdressByAdressId().getId());
        List Logins = query3.list();
        ObservableList<Adress> Logins3 = FXCollections.observableArrayList(Logins);
        DeleteSellerAdressTable.setItems(Logins3);
        session.close();
    }


    public void ClientDeleteProceed(ActionEvent actionEvent) {
        ClientDeletePanel.toFront();    refreshALL();
    }

    public void ClientDeleteSelect(MouseEvent mouseEvent) {
        client = UpdateClientTable1.getSelectionModel().getSelectedItem();
        refreshLogins2();
        refreshAdress2();
    }

    public void DeleteClientButtonPressed(ActionEvent actionEvent) {
        ClientCRUD deletor = new ClientCRUD();
        deletor.deleteClient(client.getId());
        refreshALL();
    }

    public void DeleteClientLoginButtonPressed(ActionEvent actionEvent) {
        try {
            LoginCRUD deletor = new LoginCRUD();
            deletor.deleteLogin(client.getLoginEntityByID().getId());
            ClientUpdateLoginTable1.getItems().clear();

        }
        catch(Exception e) {
            ClientLoginDeleteError.setText("Before deleting the login, you need to delete a client");

        }
    }

    public void DeleteClientAdressButtonPressed(ActionEvent actionEvent) {
        try {
            AdressCRUD deletor = new AdressCRUD();
            deletor.deleteAdress(client.getAdressByAdressId().getId());
            ClientUpdateAdressTable1.getItems().clear();
        }
        catch(Exception e) {
            ClientAdressDeleteError.setText("Before deleting the adress, you need to delete a client");
        }
    }

    public void DeleteSellerProceed(ActionEvent actionEvent) {
        DeleteSellerPanel.toFront();    refreshALL();
    }

    public void GetDeleteSeller(MouseEvent mouseEvent) {
        seller = DeleteSellerSeller.getSelectionModel().getSelectedItem();
        refreshAdress3();
        refreshLogins3();
    }


    public void DeleteSellerButton(ActionEvent actionEvent) {
        SellerCRUD deletor = new SellerCRUD();
        deletor.deleteSeller(seller.getId());
        refreshALL();
    }

    public void DeleteSellerLoginButton(ActionEvent actionEvent) { try {
        LoginCRUD deletor = new LoginCRUD();
        deletor.deleteLogin(seller.getLoginEntityByID().getId());
        DeleteSellerLoginTable.getItems().clear();
    }
    catch(Exception e) {
       DeleteSellerLoginError.setText("Before deleting the login, you need to delete an Employee");
    }
    }

    public void DeleteSellerAdressButton(ActionEvent actionEvent) {
        try {
            AdressCRUD deletor = new AdressCRUD();
            deletor.deleteAdress(seller.getAdressByAdressId().getId());
            DeleteSellerAdressTable.getItems().clear();
        }
        catch(Exception e) {
            DeleteSellerAdressError.setText("Before deleting the adress, you need to delete an Employee");
        }
    }

    public void DeleteCarProceed(ActionEvent actionEvent) {
        DeleteCarPanel.toFront();    refreshALL();
    }

    public void DeleteCarButton(ActionEvent actionEvent) {
        try {
            CarCRUD deletor = new CarCRUD();
            deletor.deleteCar(car.getId());
            refreshCarsDelete();
        }
        catch(Exception e) {
            CarDeleteError.setText("Before deleting the car, you need to delete certain Repairments");
        }
    }

    public void DeleteCarSelect(MouseEvent mouseEvent) {
        car = MyCarTable11a.getSelectionModel().getSelectedItem();
    }

    public void SelectDeleteBase(MouseEvent mouseEvent) {
        base = BaseAdressTable1.getSelectionModel().getSelectedItem();
    }

    public void BaseDeleteButton(ActionEvent actionEvent) {
        try {
            RentalBaseCRUD deletor = new RentalBaseCRUD();
            deletor.deleteRentalBase(base.getId());
        }
        catch(Exception e) {
            DeleteBaseAdressError.setText("You need to delete all cars from the Base first!");
        }

    }

    public void BaseDeleteProceed(ActionEvent actionEvent) {
        BaseDeletePanel.toFront();    refreshALL();
    }

    public void BaseDeleteAdressButton(ActionEvent actionEvent) {

        try {
            AdressCRUD deletor = new AdressCRUD();
            deletor.deleteAdress(base.getAdressByAdressId().getId());
            refreshBase2();
        }
        catch(Exception e) {
            DeleteBaseAdressError.setText("Before deleting the adress, you need to delete the base!");
        }

    }
    public void refreshRepairments(){
        final Session session = getSession();
        Query query3 = session.createQuery("from RepairmentsEntity  where carByCarId.id=:wartosc");
        query3.setParameter("wartosc", car.getId());
        List Logins = query3.list();
        ObservableList<RepairmentsEntity> Logins3 = FXCollections.observableArrayList(Logins);
        RepairmentsTable.setItems(Logins3);
        session.close();
    }

    public void refreshRepairments2(){
        final Session session = getSession();
        Query query3 = session.createQuery("from RepairmentsEntity");
        List Logins = query3.list();
        ObservableList<RepairmentsEntity> Logins3 = FXCollections.observableArrayList(Logins);
        RepairmentsTable1.setItems(Logins3);
        session.close();
    }

    public void CreateRepairmentButtonPressed(ActionEvent actionEvent) {
        final Session session = getSession();
        try {
            Query query4 = session.createQuery("from RepairmentsEntity  where carByCarId.id=:wartosc");
            query4.setParameter("wartosc", car.getId());
            List Logins = query4.list();
            ObservableList<RepairmentsEntity> Repairments = FXCollections.observableArrayList(Logins);
            RepairmentsCRUD creator = new RepairmentsCRUD();
            UpdateRepairmentsError.setText("You need to fill all the boxes first!");
            if(!EngineTextField.getText().trim().equals("") &&  !TireTextField.getText().trim().equals("") && !FrontWindowsTextField.getText().trim().equals("") && !DoorsTextField.getText().trim().equals("") && !BodyTextField.getText().trim().equals("")) {
                if (Repairments.size() == 0) {
                    creator.saveRepairments(EngineTextField.getText(), TireTextField.getText(), FrontWindowsTextField.getText(), DoorsTextField.getText(), BodyTextField.getText(), car);
                    UpdateRepairmentsError.setText("Created!");
                } else {
                    creator.UpdateRepairmentsBody(car.getId(), BodyTextField.getText());
                    creator.UpdateRepairmentsDoors(car.getId(), DoorsTextField.getText());
                    creator.UpdateRepairmentsEngine(car.getId(), EngineTextField.getText());
                    creator.UpdateRepairmentsFrontWindow(car.getId(), FrontWindowsTextField.getText());
                    creator.UpdateRepairmentTire(car.getId(), FrontWindowsTextField.getText());
                    UpdateRepairmentsError.setText("Updated!");
                }
                refreshRepairments();
            }
        }
        catch(Exception e) {
            UpdateRepairmentsError.setText("You need to select the car First!");
        }
    }

    
    public void refreshNoSellerCar2(){
        final Session session = getSession();
        Query query2 = session.createQuery("from CarEntity");
        List Logins = query2.list();
        ObservableList<CarEntity> Logins2 = FXCollections.observableArrayList(Logins);
        NoSellerCarTable2.setItems(Logins2);
        session.close();
    }

    public void CarRepairmentsClick(MouseEvent mouseEvent) {
        car = NoSellerCarTable2.getSelectionModel().getSelectedItem();
        refreshRepairments();
    }


    public void CreateUpdateRepairmentProceed(ActionEvent actionEvent) {
        CreateRepairmentsPanel.toFront();    refreshALL();
    }

    public void DeleteRepairmentProceed(ActionEvent actionEvent) {
        DeleteRepairmentPanel.toFront();    refreshALL();
    }

    public void RepairOperationsProceed(ActionEvent actionEvent) {
        RepairmentOperations.toFront();    refreshALL();
    }


    public void DeleteRepairment(ActionEvent actionEvent) {
        RepairmentsCRUD deletor = new RepairmentsCRUD();
        deletor.deleteRepairments(repairment.getId());
        refreshRepairments2();
    }

    public void SelectRepairment(MouseEvent mouseEvent) {
        repairment = RepairmentsTable1.getSelectionModel().getSelectedItem();
    }
    public void ClientUpdateTableClick2(MouseEvent mouseEvent) {
        client = UpdateClientTable2.getSelectionModel().getSelectedItem();
    }


    public void OrderCreateProceed(ActionEvent actionEvent) {
        CreateOrderPanel.toFront();    refreshALL();
    }

    public void OrderUpdateProceed(ActionEvent actionEvent) {
        OrderUpdatePanel.toFront();    refreshALL();
    }

    public void OrderDeleteProceed(ActionEvent actionEvent) {
        DeleteOrderPanel.toFront();    refreshALL();
    }

    public void SelectOrderForUpdate(MouseEvent mouseEvent) {
        order = OrdersTable.getSelectionModel().getSelectedItem();
        NewRentalDateTextField.setText(String.valueOf(order.getRentalDate()));
        NewReturnDateTextField.setText(String.valueOf(order.getReturnDate()));
    }

    public void SelectOrderForUpdate2 (MouseEvent mouseEvent) {
        order = OrdersTable1.getSelectionModel().getSelectedItem();
    }

    public void UpdateOrder(ActionEvent actionEvent) throws ParseException {

            OrderUpdateError.setText("You need to fill in both of the dates!");
            if (!NewRentalDateTextField.getText().trim().equals("") && !NewReturnDateTextField.getText().trim().equals("")) {
                OrderUpdateError.setText("Dates must have following pattern: 1999-01-01");
                if ((Pattern.matches("^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$", NewRentalDateTextField.getText()))
                &&(Pattern.matches("^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$", NewReturnDateTextField.getText()))){
                try {
                    OrdersCRUD updator = new OrdersCRUD();
                    updator.UpdateOrdersEntitySellerID(order.getId(), seller);
                    updator.UpdateOrdersEntityCarID(order.getId(), car);
                    updator.UpdateOrdersEntityClientID(order.getId(), client);
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
                    java.util.Date dateretnal = sdf.parse(NewRentalDateTextField.getText());
                    java.util.Date datereturn = sdf.parse(NewReturnDateTextField.getText());
                    java.sql.Date sqlDate1 = new Date(dateretnal.getTime());
                    java.sql.Date sqlDate2 = new Date(datereturn.getTime());
                    updator.UpdateOrdersEntityRentalDate(order.getId(), sqlDate1);
                    updator.UpdateOrdersEntityReturnDate(order.getId(), sqlDate2);
                    refreshOrders();
                    OrderUpdateError.setText("Updated!");

                } catch (Exception e ) {
                    OrderUpdateError.setText("You need to select the Car, Seller and a Client First!");
                }
            }
            }
    }

    public void ClientUpdateTableClick3(MouseEvent mouseEvent) {
        client = UpdateClientTable21.getSelectionModel().getSelectedItem();
    }

    public void SelectCarForOrder(MouseEvent mouseEvent) {
        car = RentTable1.getSelectionModel().getSelectedItem();
    }

    public void GetDeleteSeller1(MouseEvent mouseEvent) {
        seller = DeleteSellerSeller1.getSelectionModel().getSelectedItem();
    }

    public void OrdersOperationsProceed(ActionEvent actionEvent) {
        OrderOperationsPanel.toFront();
        refreshALL();
    }

    public void DeleteOrder(ActionEvent actionEvent) {
        try {
            OrdersCRUD deletor = new OrdersCRUD();
            deletor.deleteOrdersEntity(order.getId());
            refreshOrders2();
            DeleteOrderError.setText("Deleted!");
        }
        catch(Exception e) {
            DeleteOrderError.setText("You need to select the order First!");
        }

    }
    @FXML
    private void  ReturnCarPressed(ActionEvent event) throws IOException
    {
        final Session session = getSession();
        CarEntity car = MyCarTable2.getSelectionModel().getSelectedItem();
        NoCarError1.setText("You need to choose a car first");
        if(!car.getMark().trim().equals("")) {
            NoCarError1.setText("");
            CarScoreError1.setText("Car Score  and Order Score must be set to number beetwen 1-10");
            if (!CarScore1.getText().trim().equals("") && !OrderScore1.getText().trim().equals("") && Integer.parseInt(CarScore1.getText())>=0
                    && Integer.parseInt(CarScore1.getText())<=10   && Integer.parseInt(OrderScore1.getText())>=0
                    && Integer.parseInt(OrderScore1.getText())<=10) {
                CarScoreError1.setText("");
                int carscore = Integer.parseInt(CarScore1.getText());
                int orderscore = Integer.parseInt(OrderScore1.getText());
                int baseid = car.getRentalBaseEntityByRentalBaseId().getId();
                RentalBaseEntity base = session.byId(RentalBaseEntity.class).getReference(baseid);
                Query query10 = session.createQuery("select c from OrdersEntity c WHERE c.carByCarId = :wartosc");
                query10.setParameter("wartosc", car);
                OrdersEntity order = (OrdersEntity) query10.uniqueResult();
                OrdersArchiveCRUD create = new OrdersArchiveCRUD();
                OrdersCRUD delete = new OrdersCRUD();
                create.saveOrdersArchiveEntity(orderscore, carscore, base.getId(), order.getId(), order.getRentalDate(), order.getReturnDate(), order.getCarByCarId().getId(),0, order.getClientByClientId().getId());
                MyCarTable2.getItems().remove(car);
                delete.deleteOrdersEntity(order.getId());
            }

        }
        session.close();
    }

    public void refreshHistory(){
        final Session session = getSession();
        Query queryHist = session.createQuery("from OrdersArchiveEntity");
        List<OrdersArchiveEntity> HistoryList = queryHist.list();
        ObservableList <OrdersArchiveEntity> Historia = FXCollections.observableArrayList(HistoryList);
        HistoryTable1.setItems(Historia);
        session.close();

    }
    public void CreateOrdersArchiveProceed(ActionEvent actionEvent) {
        CreateOrdersArchivePanel.toFront();
        refreshALL();
    }

    public void UpdateOrdersArchiveProceed(ActionEvent actionEvent) {
        UpdateOrdersArchive.toFront();
    }

    public void DeleteOrdersArchiveProceed(ActionEvent actionEvent) {
        DeleteOrdersArchivePanel.toFront();
        refreshALL();
    }

    public void ProceedOrdersArchive(ActionEvent actionEvent) {
        OrdersArchiveOperationsPanel.toFront();
        refreshALL();
    }

    public void SelectPastOrder(MouseEvent mouseEvent) {
        past = HistoryTable1.getSelectionModel().getSelectedItem();
        CarScoreUpdate.setText(String.valueOf(past.getCarScore()));
        OrderScoreUpdate.setText(String.valueOf(past.getOrderScore()));
        RentalDateUpdate.setText(String.valueOf(past.getRentalDate()));
        ReturnDateUpdate.setText(String.valueOf(past.getReturnDate()));
        refreshPastCar();
    }

    public void refreshPastCar(){
        final Session session = getSession();
        Query query = session.createQuery("from CarEntity WHERE :wartosc = id");
        query.setParameter("wartosc", past.getCarByCarId());
        List Autka = query.list();
        ObservableList<CarEntity> AutkaObs = FXCollections.observableArrayList(Autka);
        MyCarTable11.setItems(AutkaObs);
        session.close();
    }

    public void DeleteOrdersArchive(ActionEvent actionEvent) {
        try {
            OrdersArchiveCRUD deletor = new OrdersArchiveCRUD();
            deletor.deleteOrdersArchiveEntity(past.getId());
            refreshHistory();
            DeleteOrdersArchiveError.setText("Deleted");
        }
        catch(Exception e){
            DeleteOrdersArchiveError.setText("Choose an order first");
        }
    }

    public void UpdateOrdersArchive(ActionEvent actionEvent) throws ParseException {

        UpdateOrderArchiveError.setText("All boxes must be filled!");
        if (!CarScoreUpdate.getText().trim().equals("") && !OrderScoreUpdate.getText().trim().equals("") && !RentalDateUpdate.getText().trim().equals("") && !ReturnDateUpdate.getText().trim().equals("")) {
            UpdateOrderArchiveError.setText("Dates must have following pattern: yyyy-mm-dd!");
            if ((Pattern.matches("^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$", RentalDateUpdate.getText()))
                    && (Pattern.matches("^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$", ReturnDateUpdate.getText()))) {
                UpdateOrderArchiveError.setText("Can and order score must be a number beetwen 1-10!");
                if (Integer.parseInt(CarScoreUpdate.getText()) >= 0 && Integer.parseInt(CarScoreUpdate.getText()) <= 10 && Integer.parseInt(OrderScoreUpdate.getText()) >= 0
                        && Integer.parseInt(OrderScoreUpdate.getText()) <= 10) {
                    UpdateOrderArchiveError.setText("chuj");
                        OrdersArchiveCRUD updator = new OrdersArchiveCRUD();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
                        java.util.Date date = sdf.parse(RentalDateUpdate.getText());
                        java.sql.Date sqlDate = new Date(date.getTime());
                        java.util.Date date2 = sdf.parse(ReturnDateUpdate.getText());
                        java.sql.Date sqlDate2 = new Date(date2.getTime());
                        updator.UpdateOrdersArchiveEntityCarScore(past.getId(), Integer.parseInt(CarScoreUpdate.getText()));
                        updator.UpdateOrdersArchiveEntityOrderScore(past.getId(), Integer.parseInt(OrderScoreUpdate.getText()));
                        updator.UpdateOrdersArchiveEntityReturnDate(past.getId(), sqlDate2);
                        updator.UpdateOrdersArchiveRentalDate(past.getId(), sqlDate);
                        UpdateOrderArchiveError.setText("Updated!");
                        refreshHistory();
                }
            }
        }

        }

    public void Close(ActionEvent actionEvent) {
        Platform.exit();
    }
}

