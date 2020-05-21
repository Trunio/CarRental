package sample;
import CRUD.*;
import DataBase.*;
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

    public Button ClientOperationsCreateButton;
    public Button ClientOperationsUpdateButton;
    public Button ClientOperationsDeleteButton;
    public TextField UpdateBaseNameTextField;
    public TextField UpdateBaseTelephoneTextField;
    public TextField UpdateBaseStreetTextField;
    public TextField UpdateBaseHouseTextField;
    public TextField UpdateBaseCityTextField;
    public TextField UpdateBasePostCodeTextField;


    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public ClientEntity client;
    SellerEntity seller = new SellerEntity();
    RentalBaseEntity base = new RentalBaseEntity();
    CarEntity car = new CarEntity();
    RentalBaseEntity base2 =  new RentalBaseEntity();
    public String WhatToUpdate;
    public Pane SellerUpdatePanel;
    public TableView<SellerEntity> UpdateSellerSeller;
    public TableColumn<SellerEntity,String> UpdateSellerName;
    public TableColumn<SellerEntity,String> UpdateSellerSurname;
    public TableColumn<SellerEntity,String> UpdateSellerTelephone;
    public TableColumn<SellerEntity,String> UpdateSellerSalary;
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
    public TableColumn<CarEntity,String> UpdateCarRentalBase;
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
    public TextField BaseStreetTextField;
    public TextField BaseHouseTextField;
    public TextField BaseCityTextField;
    public TextField BasePostCodeTextField;
    public Pane BaseOperationsPanel;
    public Pane BaseCreatePanel;
    public Pane BaseUpdatePanel;


    @Override
    @Transactional
    public void initialize(URL location, ResourceBundle resources) {
        final Session session = getSession();
        UpdateSellerName.setCellValueFactory(new PropertyValueFactory<SellerEntity, String>("name"));
        UpdateSellerSurname.setCellValueFactory(new PropertyValueFactory<SellerEntity, String>("surname"));
        UpdateSellerTelephone.setCellValueFactory(new PropertyValueFactory<SellerEntity, String>("telephone"));
        UpdateSellerSalary.setCellValueFactory(new PropertyValueFactory<SellerEntity, String>("salary"));
        UpdateSellerrRecrutationDate1.setCellValueFactory(new PropertyValueFactory<SellerEntity, Date>("recrutationDate"));
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
        List Baza = session.createQuery("from RentalBaseEntity").list();
        ObservableList<RentalBaseEntity> Bazy = FXCollections.observableArrayList(Baza);
        BaseName.setCellValueFactory(new PropertyValueFactory<RentalBaseEntity,String>("name"));
        BaseTelephone.setCellValueFactory(new PropertyValueFactory<RentalBaseEntity,String>("telephone"));
        BaseStreet.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAdressByAdressId().getStreet()));
        BaseHouse.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAdressByAdressId().getHouse()));
        BaseCity.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAdressByAdressId().getCity()));
        BaseCode.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAdressByAdressId().getPostCode()));

        ChoiceBoxBase.setItems(Bazy);
       refreshSellers();
        refreshClient();
        refreshBaseSelector();
        refreshBaseSelector2();
        refreshBase();
        session.close();
    }

    public void SellerOperationsButtonClicked(ActionEvent actionEvent) {
        SellerOperationsPanel.toFront();
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
    @FXML
    public void CreateClientFinalPressed(ActionEvent actionEvent) {
        final Session session = getSession();
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
    }

    public void CreateClientProceed(ActionEvent actionEvent) {
        CreateClientPanel.toFront();
    }

    public void BackFromClientCreator(ActionEvent actionEvent) {
        SelectClientOperationPanel.toFront();
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
        String text = ClientTextUpdate.getText();
        client = UpdateClientTable.getSelectionModel().getSelectedItem();
        if (WhatToUpdate.equals("name")) {
            ClientCRUD updator = new ClientCRUD();
            updator.UpdateClientName(client.getId(), text);
            refreshClient();
        }
        if (WhatToUpdate.equals("surname")) {
            ClientCRUD updator = new ClientCRUD();
            updator.UpdateClientSurname(client.getId(), text);
            refreshClient();
        }
        if (WhatToUpdate.equals("telephone")) {
            ClientCRUD updator = new ClientCRUD();
            updator.UpdateClientTelephone(client.getId(), text);
            refreshClient();
        }
    }


    public void ClientUpdateTableClick(MouseEvent mouseEvent) {
        client = UpdateClientTable.getSelectionModel().getSelectedItem();
        refreshLogins();
        refreshAdress();
    }

    public void ClientOperationsButtonPressed(ActionEvent actionEvent) {
        SelectClientOperationPanel.toFront();
    }

    @FXML
    private void ClientBoxUpdateSwitch(ActionEvent event) throws IOException {
        WhatToUpdate = ClientBoxUpdate.getSelectionModel().getSelectedItem();
    }

    public void ClientUpdateLoginPressed(ActionEvent actionEvent) {
        String login = ClientLoginUpdateLoginText.getText();
        String password = ClientLoginUpdatePasswordText.getText();
        LoginCRUD updator = new LoginCRUD();
        updator.LoginUsername(client.getLoginEntityByID().getId(),login);
        updator.LoginPassword(client.getLoginEntityByID().getId(),password);
        refreshLogins();
    }

    public void ClientUpdateAdressPressed(ActionEvent actionEvent) {
        String street = ClientUpdateAdressStreetText.getText();
        String house = ClientUpdateAdressHouseText.getText();
        String city = ClientUpdateAdressCityText.getText();
        String postcode = ClientUpdateAdressPostcodeText.getText();
        AdressCRUD updator = new AdressCRUD();
        updator.UpdateAdressStreet(client.getAdressByAdressId().getId(),street);
        updator.UpdateAdressHouse(client.getAdressByAdressId().getId(),house);
        updator.UpdateAdressCity(client.getAdressByAdressId().getId(),city);
        updator.UpdateAdressPostCode(client.getAdressByAdressId().getId(),postcode);
        refreshAdress();
    }



    public void UpdateClientProceed(ActionEvent actionEvent) {
        UpdateClientPanel.toFront();
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
        queryHist.setParameter("wartosc",seller.getAdressByAdressId().getId());
        List List = queryHist.list();
        ObservableList <LoginEntity> ObsList = FXCollections.observableArrayList(List);
        UpdateSellerTable.setItems(ObsList);
        session.close();
    }


    public void CreateSellerButtonPressed(ActionEvent actionEvent) throws ParseException {
        final Session session = getSession();
        LoginCRUD loginCreator = new LoginCRUD();
        AdressCRUD adressCreator = new AdressCRUD();
        SellerCRUD sellerCreator = new SellerCRUD();
        loginCreator.saveLogin(LoginTextField.getText(),PasswordTextField.getText(),2);
        adressCreator.saveAdress(StreetTextField.getText(),PostCodeTextField.getText(),HouseTextField.getText(),CityTextField.getText());
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
        sellerCreator.saveSeller(NameTextField.getText(),SurnameTextField.getText(),TelephoneTextField.getText(), Double.parseDouble(SalaryTextField.getText()),sqlDate,adress,login);

    }

    public void BackFromSellerCreation(ActionEvent actionEvent) {
        SellerOperationsPanel.toFront();
    }

    public void AddSellerButtonClicked(ActionEvent actionEvent) {
        SellerCreationPanel.toFront();
    }

    public void UpdateSellerButtonPressed(ActionEvent actionEvent) throws ParseException {
        SellerCRUD updator = new SellerCRUD();
        updator.UpdateSellerName(seller.getId(),NameTextField1.getText());
        updator.UpdateSellerSurname(seller.getId(),SurnameTextField1.getText());
        updator.UpdateSellerTelephone(seller.getId(),TelephoneTextField1.getText());
        updator.UpdateSellerSalary(seller.getId(), Double.parseDouble(SalaryTextField1.getText()));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        java.util.Date date = sdf.parse(RecrutationDateTextField1.getText());
        java.sql.Date sqlDate = new Date(date.getTime());
        updator.UpdateSellerRecrutationDate(seller.getId(),sqlDate);
        UpdateSellerSeller.getItems().clear();
        refreshSellers();
    }

    public void UpdateSellerAdressButtonPressed(ActionEvent actionEvent) {
        AdressCRUD updator = new AdressCRUD();
        updator.UpdateAdressStreet(seller.getAdressByAdressId().getId(),StreetTextField1.getText());
        updator.UpdateAdressCity(seller.getAdressByAdressId().getId(),CityTextField1.getText());
        updator.UpdateAdressHouse(seller.getAdressByAdressId().getId(),HouseTextField1.getText());
        updator.UpdateAdressPostCode(seller.getAdressByAdressId().getId(),PostCodeTextField1.getText());
        UpdateSellerAdress.getItems().clear();
    }

    public void UpdateSellerLoginButtonPressed(ActionEvent actionEvent) {
        LoginCRUD updator = new LoginCRUD();
        updator.LoginUsername(seller.getLoginEntityByID().getId(),LoginTextField1.getText());
        updator.LoginPassword(seller.getLoginEntityByID().getId(),PasswordTextField1.getText());
        UpdateSellerTable.getItems().clear();
        refreshSellerLogin();
    }

    public void GetUpdateSeller(MouseEvent mouseEvent) {
        seller=UpdateSellerSeller.getSelectionModel().getSelectedItem();
        System.out.println(seller.getName());
        refreshSellerAdress();
        refreshSellerLogin();
    }

    public void BackFromClientUpdator(ActionEvent actionEvent) {
        SelectClientOperationPanel.toFront();
    }

    public void UpdateSellerPanelButtonPressed(ActionEvent actionEvent) { SellerUpdatePanel.toFront();

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
        CarCreationPanel.toFront();
    }

    public void UpdateCarButtonPressed(ActionEvent actionEvent) {

    }

    public void CarCreationButtonPressedFinal(ActionEvent actionEvent) throws ParseException {
        CarCRUD creator = new CarCRUD();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        java.util.Date date = sdf.parse(CarCreationProductionDateTextField.getText());
        java.sql.Date sqlDate = new Date(date.getTime());
        creator.saveCar(base,CarCreationMarkTextField.getText(),CarCreationColorTextField.getText(),sqlDate,Double.parseDouble(CarCreationPriceTextField.getText()),CarCreationCategoryTextField.getText());
    }

    public void CreateCarSelectBase(MouseEvent mouseEvent) {
       base = CreateCarSelectBaseTable.getSelectionModel().getSelectedItem();
    }

    public void CarOperationsButtonPressed(ActionEvent actionEvent) {
        CarUpdatePanel.toFront();
    }

    public void UpdateCarSelectBase(MouseEvent mouseEvent) {
        base = UpdateCarSelectBaseTable.getSelectionModel().getSelectedItem();
    }

    public void UpdateCarButtonPressedFinal(ActionEvent actionEvent) throws ParseException {
        CarCRUD updator = new CarCRUD();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        java.util.Date date = sdf.parse(CarUpdateProductionDateTextField.getText());
        java.sql.Date sqlDate = new Date(date.getTime());
        updator.UpdateCarCategory(car.getId(),CarUpdateCategoryTextField.getText());
        updator.UpdateCarColor(car.getId(),CarUpdateColorTextField.getText());
        updator.UpdateCarMark(car.getId(),CarUpdateMarkTextField.getText());
        updator.UpdateCarPrice(car.getId(),Double.parseDouble(CarUpdatePriceTextField.getText()));
        updator.UpdateCarProductionDate(car.getId(),sqlDate);
        updator.UpdateCarBase(car.getId(),base);
        refreshCars();
    }

    public void UpdateCarSelect(MouseEvent mouseEvent) {
        car = MyCarTable1.getSelectionModel().getSelectedItem();
    }

    public void SelectCreateBase(MouseEvent mouseEvent) {
    }

    public void CreateBaseButtonPressed(ActionEvent actionEvent) {
        final Session session = getSession();
        AdressCRUD adressCreator = new AdressCRUD();
        adressCreator.saveAdress(BaseStreetTextField.getText(),BasePostCodeTextField.getText(),BaseHouseTextField.getText(),BaseCityTextField.getText());
        Query query = session.createQuery("from Adress order by id DESC");
        query.setMaxResults(1);
        Adress adress = (Adress) query.uniqueResult();
        RentalBaseCRUD baseCreator = new RentalBaseCRUD();
        baseCreator.saveRentalBase(BaseNameTextField.getText(),BaseTelephoneTextField.getText(),adress);
    }

    public void BaseCreateProceed(ActionEvent actionEvent) {
        BaseCreatePanel.toFront();
    }

    public void BaseUpdateProceed(ActionEvent actionEvent) {
        BaseUpdatePanel.toFront();

    }

    public void BaseOperations(ActionEvent actionEvent) {
        BaseOperationsPanel.toFront();

    }

    public void UpdateBaseFinal(ActionEvent actionEvent) {
        AdressCRUD adressUpdate = new AdressCRUD();
        RentalBaseCRUD baseUpdate = new RentalBaseCRUD();
        adressUpdate.UpdateAdressPostCode(base.getAdressByAdressId().getId(),UpdateBasePostCodeTextField.getText());
        adressUpdate.UpdateAdressStreet(base.getAdressByAdressId().getId(),UpdateBaseStreetTextField.getText());
        adressUpdate.UpdateAdressCity(base.getAdressByAdressId().getId(),UpdateBaseCityTextField.getText());
        adressUpdate.UpdateAdressHouse(base.getAdressByAdressId().getId(),UpdateBaseHouseTextField.getText());
        baseUpdate.UpdateRentalBaseName(base.getId(),UpdateBaseNameTextField.getText());
        baseUpdate.UpdateRentalBaseTelephone(base.getId(),UpdateBaseTelephoneTextField.getText());
        refreshBase();
    }

    public void SelectUpdateBase(MouseEvent mouseEvent) {
        base = BaseAdressTable.getSelectionModel().getSelectedItem();
    }
}
