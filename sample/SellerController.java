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
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.*;

import static java.sql.JDBCType.NULL;

public class SellerController implements Initializable {

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

    public Label CreateClientError;
    public Label UpdateClientError;
    public Label SetSellerError;
    public Label UpdateRepairmentsError;


    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public String WhatToUpdate;
    public ClientEntity client;
    public OrdersEntity order;
    public SellerEntity seller;
    public OrdersEntity order2;
    public CarEntity car;
    OrdersArchiveEntity past = new OrdersArchiveEntity();

    @FXML
    public Label ClientLoginDeleteError;
    public Label ClientAdressDeleteError;
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
    public TableView<OrdersEntity> NoSellerOrderTable;
    public TableColumn<OrdersEntity,Date> NoSellerOrderRentalDate;
    public TableColumn<OrdersEntity, Date> NoSellerOrderReturnDate;
    public TableView<CarEntity> NoSellerCarTable;
    public TableColumn<CarEntity,String>  NoSellerCarBrand;
    public TableColumn<CarEntity,String>  NoSellerCarColor;
    public TableColumn<CarEntity,Date>  NoSellerCarDate;
    public TableColumn<CarEntity,String>  NoSellerCarCategory;
    public TableColumn<CarEntity,Double>  NoSellerCarPrice;
    public TableView<ClientEntity> NoSellerClientTable;
    public TableColumn<ClientEntity,String> NoSellerClientName;
    public TableColumn<ClientEntity,String>  NoSellerClientSuname;
    public TableColumn <ClientEntity,String> NoSellerClientTelephone;
    public TableView<Adress> NoSellerAdress;
    public TableColumn<Adress,String> NoSellerAdressStreet;
    public TableColumn<Adress,String> NoSellerAdressHouse;
    public TableColumn<Adress,String> NoSellerAdressCity;
    public TableColumn<Adress,String> NoSellerAdressPostcode;
    public TableView<OrdersEntity> NoSellerOrderTable1;
    public TableColumn<OrdersEntity,Date> NoSellerOrderRentalDate1;
    public TableColumn<OrdersEntity, Date> NoSellerOrderReturnDate1;
    public TableView<CarEntity> NoSellerCarTable1;
    public TableColumn<CarEntity,String>  NoSellerCarBrand1;
    public TableColumn<CarEntity,String>  NoSellerCarColor1;
    public TableColumn<CarEntity,Date>  NoSellerCarDate1;
    public TableColumn<CarEntity,String>  NoSellerCarCategory1;
    public TableColumn<CarEntity,Double>  NoSellerCarPrice1;
    public TableView<ClientEntity> NoSellerClientTable1;
    public TableColumn<ClientEntity,String> NoSellerClientName1;
    public TableColumn<ClientEntity,String>  NoSellerClientSuname1;
    public TableColumn <ClientEntity,String> NoSellerClientTelephone1;
    public TableView<Adress> NoSellerAdress1;
    public TableColumn<Adress,String> NoSellerAdressStreet1;
    public TableColumn<Adress,String> NoSellerAdressHouse1;
    public TableColumn<Adress,String> NoSellerAdressCity1;
    public TableColumn<Adress,String> NoSellerAdressPostcode1;
    public TableView<CarEntity> NoSellerCarTable2;
    public TableColumn<CarEntity,String>  NoSellerCarBrand2;
    public TableColumn<CarEntity,String>  NoSellerCarColor2;
    public TableColumn<CarEntity,Date>  NoSellerCarDate2;
    public TableColumn<CarEntity,String>  NoSellerCarCategory2;
    public TableColumn<CarEntity,Double>  NoSellerCarPrice2;
    public TableView<RepairmentsEntity> RepairmentsTable;
    public TableColumn<RepairmentsEntity,String>  RepairmentsEngine;
    public TableColumn<RepairmentsEntity,String>  RepairmentsTire;
    public TableColumn<RepairmentsEntity,String>  RepairmentsWindows;
    public TableColumn<RepairmentsEntity,String>  RepairmentsDoors;
    public TableColumn<RepairmentsEntity,String>  RepairmentsBody;
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
    public Pane OrdersArchivePane;
    public Pane RepairmentsPanel;
    public TextField EngineTextField;
    public TextField TireTextField;
    public TextField FrontWindowsTextField;
    public TextField DoorsTextField;
    public TextField BodyTextField;
    public TableView<ClientEntity> UpdateClientTable1;
    public TableColumn<ClientEntity, String> UpdateClientTableName1;
    public TableColumn<ClientEntity, String> UpdateClientTableSurname1;
    public TableColumn<ClientEntity, String> UpdateClientTableTelephone1;
    public TableView<LoginEntity> ClientUpdateLoginTable1;
    public TableColumn<LoginEntity, String> ClientUpdateLoginTableLogin1;
    public TableColumn<LoginEntity, String> ClientUpdateLoginTablePassword1;
    public TableView<Adress> ClientUpdateAdressTable1;
    public TableColumn <Adress,String> ClientUpdateAdressTableStreet1;
    public TableColumn <Adress,String> ClientUpdateAdressTableHouse1;
    public TableColumn<Adress,String>  ClientUpdateAdressTableCity1;
    public TableColumn <Adress,String> ClientUpdateAdressTablePostcode1;
    public Pane DeleteClientPanel;
    public TableView<CarEntity> MyCarTable1;
    public TableColumn<CarEntity, String>  MyCarBrand1;
    public TableColumn<CarEntity, String>  MyCarColor1;
    public TableColumn<CarEntity, Date>  MyCarDate1;
    public TableColumn<CarEntity, String>  MyCarCategory1;
    public TableColumn <CarEntity,Double>MyCarPrice1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        final Session session = getSession();
        LoginEntity login = Controller.user;
        Query query5 = session.createQuery("from SellerEntity WHERE LoginEntityByID = :wartosc");
        query5.setParameter("wartosc",login);
        List Helper = query5.list();
        ObservableList<SellerEntity> Helper2 = FXCollections.observableArrayList(Helper);
        seller = Helper2.get(0);
        ClientBoxUpdate.getItems().add("name");
        ClientBoxUpdate.getItems().add("surname");
        ClientBoxUpdate.getItems().add("telephone");
        UpdateClientTableName.setCellValueFactory(new PropertyValueFactory<ClientEntity, String>("name"));
        UpdateClientTableSurname.setCellValueFactory(new PropertyValueFactory<ClientEntity, String>("surname"));
        UpdateClientTableTelephone.setCellValueFactory(new PropertyValueFactory<ClientEntity, String>("telephone"));
        ClientUpdateLoginTableLogin.setCellValueFactory(new PropertyValueFactory<LoginEntity,String>("username"));
        ClientUpdateLoginTablePassword.setCellValueFactory(new PropertyValueFactory<LoginEntity,String>("password"));
        ClientUpdateAdressTableStreet.setCellValueFactory(new PropertyValueFactory<Adress,String>("street"));
        ClientUpdateAdressTableHouse.setCellValueFactory(new PropertyValueFactory<Adress,String>("house"));
        ClientUpdateAdressTableCity.setCellValueFactory(new PropertyValueFactory<Adress,String>("city"));
        ClientUpdateAdressTablePostcode.setCellValueFactory(new PropertyValueFactory<Adress,String>("postCode"));
        UpdateClientTableName1.setCellValueFactory(new PropertyValueFactory<ClientEntity, String>("name"));
        UpdateClientTableSurname1.setCellValueFactory(new PropertyValueFactory<ClientEntity, String>("surname"));
        UpdateClientTableTelephone1.setCellValueFactory(new PropertyValueFactory<ClientEntity, String>("telephone"));
        ClientUpdateLoginTableLogin1.setCellValueFactory(new PropertyValueFactory<LoginEntity,String>("username"));
        ClientUpdateLoginTablePassword1.setCellValueFactory(new PropertyValueFactory<LoginEntity,String>("password"));
        ClientUpdateAdressTableStreet1.setCellValueFactory(new PropertyValueFactory<Adress,String>("street"));
        ClientUpdateAdressTableHouse1.setCellValueFactory(new PropertyValueFactory<Adress,String>("house"));
        ClientUpdateAdressTableCity1.setCellValueFactory(new PropertyValueFactory<Adress,String>("city"));
        ClientUpdateAdressTablePostcode1.setCellValueFactory(new PropertyValueFactory<Adress,String>("postCode"));
        NoSellerOrderReturnDate.setCellValueFactory(new PropertyValueFactory<OrdersEntity,Date>("returnDate"));
        NoSellerOrderRentalDate.setCellValueFactory(new PropertyValueFactory<OrdersEntity,Date>("rentalDate"));
        NoSellerCarBrand.setCellValueFactory(new PropertyValueFactory<CarEntity, String>("mark"));
        NoSellerCarColor.setCellValueFactory(new PropertyValueFactory<CarEntity,String>("color"));
        NoSellerCarDate.setCellValueFactory(new PropertyValueFactory<CarEntity, Date>("productionDate"));
        NoSellerCarCategory.setCellValueFactory(new PropertyValueFactory<CarEntity,String>("category"));
        NoSellerCarPrice.setCellValueFactory(new PropertyValueFactory<CarEntity,Double>("price"));
        NoSellerClientName.setCellValueFactory(new PropertyValueFactory<ClientEntity,String>("name"));
        NoSellerClientSuname.setCellValueFactory(new PropertyValueFactory<ClientEntity,String>("surname"));
        NoSellerClientTelephone.setCellValueFactory(new PropertyValueFactory<ClientEntity,String>("telephone"));
        NoSellerAdressStreet.setCellValueFactory(new PropertyValueFactory<Adress,String>("street"));
        NoSellerAdressCity.setCellValueFactory(new PropertyValueFactory<Adress,String>("city"));
        NoSellerAdressHouse.setCellValueFactory(new PropertyValueFactory<Adress,String>("house"));
        NoSellerAdressPostcode.setCellValueFactory(new PropertyValueFactory<Adress,String>("postCode"));
        NoSellerOrderReturnDate1.setCellValueFactory(new PropertyValueFactory<OrdersEntity,Date>("returnDate"));
        NoSellerOrderRentalDate1.setCellValueFactory(new PropertyValueFactory<OrdersEntity,Date>("rentalDate"));
        NoSellerCarBrand1.setCellValueFactory(new PropertyValueFactory<CarEntity, String>("mark"));
        NoSellerCarColor1.setCellValueFactory(new PropertyValueFactory<CarEntity,String>("color"));
        NoSellerCarDate1.setCellValueFactory(new PropertyValueFactory<CarEntity, Date>("productionDate"));
        NoSellerCarCategory1.setCellValueFactory(new PropertyValueFactory<CarEntity,String>("category"));
        NoSellerCarPrice1.setCellValueFactory(new PropertyValueFactory<CarEntity,Double>("price"));
        NoSellerClientName1.setCellValueFactory(new PropertyValueFactory<ClientEntity,String>("name"));
        NoSellerClientSuname1.setCellValueFactory(new PropertyValueFactory<ClientEntity,String>("surname"));
        NoSellerClientTelephone1.setCellValueFactory(new PropertyValueFactory<ClientEntity,String>("telephone"));
        NoSellerAdressStreet1.setCellValueFactory(new PropertyValueFactory<Adress,String>("street"));
        NoSellerAdressCity1.setCellValueFactory(new PropertyValueFactory<Adress,String>("city"));
        NoSellerAdressHouse1.setCellValueFactory(new PropertyValueFactory<Adress,String>("house"));
        NoSellerAdressPostcode1.setCellValueFactory(new PropertyValueFactory<Adress,String>("postCode"));
        NoSellerCarBrand2.setCellValueFactory(new PropertyValueFactory<CarEntity, String>("mark"));
        NoSellerCarColor2.setCellValueFactory(new PropertyValueFactory<CarEntity,String>("color"));
        NoSellerCarDate2.setCellValueFactory(new PropertyValueFactory<CarEntity, Date>("productionDate"));
        NoSellerCarCategory2.setCellValueFactory(new PropertyValueFactory<CarEntity,String>("category"));
        NoSellerCarPrice2.setCellValueFactory(new PropertyValueFactory<CarEntity,Double>("price"));
        RepairmentsEngine.setCellValueFactory(new PropertyValueFactory<RepairmentsEntity,String>("engine"));
        RepairmentsTire.setCellValueFactory(new PropertyValueFactory<RepairmentsEntity,String>("tire"));
        RepairmentsWindows.setCellValueFactory(new PropertyValueFactory<RepairmentsEntity,String>("frontWindows"));
        RepairmentsDoors.setCellValueFactory(new PropertyValueFactory<RepairmentsEntity,String>("doors"));
        RepairmentsBody.setCellValueFactory(new PropertyValueFactory<RepairmentsEntity,String>("body"));
        /*
        HistoryBrand.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCarByCarId().getMark()));
        HistoryColor.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCarByCarId().getColor()));
        HistoryDate.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCarByCarId().getProductionDate().toString()));
        HistoryCategory.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCarByCarId().getCategory()));
        HistoryPrice.setCellValueFactory(cellData -> new SimpleObjectProperty<Double>(cellData.getValue().getCarByCarId().getPrice()));
        */
        MyCarBrand1.setCellValueFactory(new PropertyValueFactory<CarEntity, String>("mark"));
        MyCarColor1.setCellValueFactory(new PropertyValueFactory<CarEntity,String>("color"));
        MyCarDate1.setCellValueFactory(new PropertyValueFactory<CarEntity, Date>("productionDate"));
        MyCarCategory1.setCellValueFactory(new PropertyValueFactory<CarEntity,String>("category"));
        MyCarPrice1.setCellValueFactory(new PropertyValueFactory<CarEntity,Double>("price"));

        HistoryCarScore.setCellValueFactory(new PropertyValueFactory<OrdersArchiveEntity,Integer>("carScore"));
        HistoryOrderScore.setCellValueFactory(new PropertyValueFactory<OrdersArchiveEntity,Integer>("orderScore"));
        HistoryRentalDate.setCellValueFactory(new PropertyValueFactory<OrdersArchiveEntity,Date>("rentalDate"));
        HistoryReturnDate.setCellValueFactory(new PropertyValueFactory<OrdersArchiveEntity,Date>("returnDate"));
refreshALL();
        session.close();
    }
    public void refreshALL(){
        refreshClient();
        refreshClient2();
        refreshNoSellerCar2();
        refreshNoSellerOrder();
        refreshNoSellerOrder1();
        refreshHistory();

    }


    public static boolean LoginCheck(String values) {
        final Session session = getSession();
        List employee = session.createQuery("from LoginEntity").list();
        for (Object o : employee) {
            LoginEntity helper = (LoginEntity) o;
            if ((helper.getUsername().equals(values))) {
                return false;
            }
        }
        return true;
    }
    public static boolean PaswwordCheck(String values) {
        return Pattern.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$", values);
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
                    if(LoginCheck(CreateClientLogin.getText())) {
                        CreateClientError.setText("Password must contain: numbers, lowercase, uppercase, special character!");
                        if(PaswwordCheck(CreateClientPassword.getText())) {
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
        CreateClientPanel.toFront();
        refreshALL();
    }

    public void BackFromClientCreator(ActionEvent actionEvent) {
        SelectClientOperationPanel.toFront();        refreshALL();
    }


    public void ClientOperationsButtonPressed(ActionEvent actionEvent) {
        SelectClientOperationPanel.toFront();        refreshALL();
    }

    public void CurrentOrdersButtonPressed(ActionEvent actionEvent) {
        CurrentOrdersPanel.toFront();        refreshALL();
    }


    @FXML
    private void ClientBoxUpdateSwitch(ActionEvent event) throws IOException {
        WhatToUpdate = ClientBoxUpdate.getSelectionModel().getSelectedItem();
    }
    public void refreshHistory(){
        final Session session = getSession();
        Query queryHist = session.createQuery("from OrdersArchiveEntity");
        List<OrdersArchiveEntity> HistoryList = queryHist.list();
        ObservableList <OrdersArchiveEntity> Historia = FXCollections.observableArrayList(HistoryList);
        HistoryTable.setItems(Historia);
    }

    public void refreshNoSellerOrder(){
        final Session session = getSession();
        Query query = session.createQuery("from OrdersEntity o where o.sellerBySellerId is null");
        List Helper = query.list();
        ObservableList<OrdersEntity> Helper2 = FXCollections.observableArrayList(Helper);
        NoSellerOrderTable.setItems(Helper2);
        session.close();
    }

    public void refreshNoSellerOrder1(){
        final Session session = getSession();
        Query query = session.createQuery("from OrdersEntity");
        List Helper = query.list();
        ObservableList<OrdersEntity> Helper2 = FXCollections.observableArrayList(Helper);
        NoSellerOrderTable1.setItems(Helper2);
        session.close();
    }

    public void refreshNoSellerCar(){
        final Session session = getSession();
            Query query2 = session.createQuery("select c from CarEntity c, OrdersEntity  o where o.carByCarId.id=c.id and o.id = :wartosc");
            query2.setParameter("wartosc", order.getId());
            List Logins = query2.list();
            ObservableList<CarEntity> Logins2 = FXCollections.observableArrayList(Logins);
            NoSellerCarTable.setItems(Logins2);
        session.close();
    }

    public void refreshNoSellerCar2(){
        final Session session = getSession();
        Query query2 = session.createQuery("from CarEntity");
        List Logins = query2.list();
        ObservableList<CarEntity> Logins2 = FXCollections.observableArrayList(Logins);
        NoSellerCarTable2.setItems(Logins2);
        session.close();
    }

    public void refreshNoSellerCar1(){
        final Session session = getSession();
        Query query2 = session.createQuery("select c from CarEntity c, OrdersEntity  o where o.carByCarId.id=c.id and o.id = :wartosc2");
        query2.setParameter("wartosc2", order2.getId());
        List Logins = query2.list();
        ObservableList<CarEntity> Logins2 = FXCollections.observableArrayList(Logins);
        NoSellerCarTable1.setItems(Logins2);
        session.close();
    }

    public void refreshNoSellerClient(){
        final Session session = getSession();
        Query query2 = session.createQuery("select c from ClientEntity c, OrdersEntity  o where o.clientByClientId.id=c.id and o.id = :wartosc");
        query2.setParameter("wartosc", order.getId());
        List Logins = query2.list();
        ObservableList<ClientEntity> Logins2 = FXCollections.observableArrayList(Logins);
        NoSellerClientTable.setItems(Logins2);
        session.close();
    }

    public void refreshNoSellerClient1(){
        final Session session = getSession();
        Query query2 = session.createQuery("select c from ClientEntity c, OrdersEntity  o where o.clientByClientId.id=c.id and o.id = :wartosc2");
        query2.setParameter("wartosc2", order2.getId());
        List Logins = query2.list();
        ObservableList<ClientEntity> Logins2 = FXCollections.observableArrayList(Logins);
        NoSellerClientTable1.setItems(Logins2);
        session.close();
    }


    public void refreshNoAdressClient(){
        final Session session = getSession();
        Query query2 = session.createQuery("select a from Adress a, OrdersEntity  o where o.clientByClientId.adressByAdressId.id = a.id and o.id = :wartosc");
        query2.setParameter("wartosc", order.getId());
        List Logins = query2.list();
        ObservableList<Adress> Logins2 = FXCollections.observableArrayList(Logins);
        NoSellerAdress.setItems(Logins2);
        session.close();
    }

    public void refreshNoAdressClient1(){
        final Session session = getSession();
        Query query2 = session.createQuery("select a from Adress a, OrdersEntity  o where o.clientByClientId.adressByAdressId.id = a.id and o.id = :wartosc2");
        query2.setParameter("wartosc2", order2.getId());
        List Logins = query2.list();
        ObservableList<Adress> Logins2 = FXCollections.observableArrayList(Logins);
        NoSellerAdress1.setItems(Logins2);
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


    public void refreshRepairments(){
        final Session session = getSession();
        Query query3 = session.createQuery("from RepairmentsEntity  where carByCarId.id=:wartosc");
        query3.setParameter("wartosc", car.getId());
        List Logins = query3.list();
        ObservableList<RepairmentsEntity> Logins3 = FXCollections.observableArrayList(Logins);
        RepairmentsTable.setItems(Logins3);
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
        ClientUpdateAdressCityText.setText(client.getAdressByAdressId().getCity());
        ClientUpdateAdressPostcodeText.setText(client.getAdressByAdressId().getPostCode());
        refreshLogins();
        refreshAdress();

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

    public void NoSellerTableClick(MouseEvent mouseEvent) {
        order = NoSellerOrderTable.getSelectionModel().getSelectedItem();
        refreshNoSellerCar();
        refreshNoAdressClient();
        refreshNoSellerClient();
    }

    public void NoSellerTableClick1(MouseEvent mouseEvent) {
        order2 = NoSellerOrderTable1.getSelectionModel().getSelectedItem();
        refreshNoSellerCar1();
        refreshNoAdressClient1();
        refreshNoSellerClient1();
    }

    public void CarRepairmentsClick(MouseEvent mouseEvent) {
        car = NoSellerCarTable2.getSelectionModel().getSelectedItem();
        refreshRepairments();
    }

    public void SetSellerButton(ActionEvent actionEvent) {
        try {
            OrdersCRUD updator = new OrdersCRUD();
            updator.UpdateOrdersEntitySellerID(order.getId(), seller);
            refreshNoSellerOrder();
            NoSellerCarTable.getItems().clear();
            NoSellerAdress.getItems().clear();
            NoSellerClientTable.getItems().clear();
            SetSellerError.setText("Sold!");
        }
        catch(Exception e) {
            SetSellerError.setText("You need to select an Order First!");
        }
    }

    public void BackFromClientUpdator(ActionEvent actionEvent) {
        SelectClientOperationPanel.toFront();        refreshALL();
    }

    public void UpdateClientProceed(ActionEvent actionEvent) {
        UpdateClientPanel.toFront();        refreshALL();
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

    public void RepairmentsButtonClick(ActionEvent actionEvent) {
        RepairmentsPanel.toFront();        refreshALL();
    }

    public void HistoryButtonPressed(ActionEvent actionEvent) {
        OrdersArchivePane.toFront();        refreshALL();
    }

    public void ClientDeleteSelect(MouseEvent mouseEvent) {
        client = UpdateClientTable1.getSelectionModel().getSelectedItem();
        refreshLogins2();
        refreshAdress2();
    }

    public void DeleteClientButtonPressed(ActionEvent actionEvent) {
        ClientCRUD deletor = new ClientCRUD();
        deletor.deleteClient(client.getId());        refreshALL();
    }

    public void DeleteClientLoginButtonPressed(ActionEvent actionEvent) {
        try {
        LoginCRUD deletor = new LoginCRUD();
        deletor.deleteLogin(client.getLoginEntityByID().getId());
        }
        catch(Exception e) {
            ClientLoginDeleteError.setText("Before deleting the login, you need to delete a client");
        }
    }

    public void DeleteClientAdressButtonPressed(ActionEvent actionEvent) {
        try {
            AdressCRUD deletor = new AdressCRUD();
            deletor.deleteAdress(client.getAdressByAdressId().getId());
        }
        catch(Exception e) {
            ClientAdressDeleteError.setText("Before deleting the adress, you need to delete a client");
        }
    }


    public void SelectPastOrder(MouseEvent mouseEvent) {
        past = HistoryTable.getSelectionModel().getSelectedItem();
        refreshPastCar();
    }

    public void refreshPastCar(){
        final Session session = getSession();
        Query query = session.createQuery("from CarEntity WHERE :wartosc = id");
        query.setParameter("wartosc", past.getCarByCarId());
        List Autka = query.list();
        ObservableList<CarEntity> AutkaObs = FXCollections.observableArrayList(Autka);
        MyCarTable1.setItems(AutkaObs);
        session.close();
    }

    public void DeleteClientProceed(ActionEvent actionEvent) {
        DeleteClientPanel.toFront();
        refreshALL();
    }

    public void Close(ActionEvent actionEvent) {
        Platform.exit();
    }
}
