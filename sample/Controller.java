package sample;


import DataBase.CarEntity;
import DataBase.ClientEntity;
import DataBase.LoginEntity;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private static final SessionFactory ourSessionFactory;
    private  double xOffset = 0;
    private  double yOffset = 0;
    public static LoginEntity user;

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
    public TextField EmailLogin;
    public PasswordField PasswordLogin;
    public Label WrongLoginTEXT;
    public AnchorPane LoginPanel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Drag();
    }

    private void Drag(){
        LoginPanel.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });

        //move around here
        LoginPanel.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Main2.stage.setX(event.getScreenX() - xOffset);
                Main2.stage.setY(event.getScreenY() - yOffset);
            }
        });
    }


    @FXML
    private void LoginPress(ActionEvent event) throws IOException {
        final Session session = getSession();
        String login = String.valueOf(EmailLogin.getText());
        String password = String.valueOf(PasswordLogin.getText());
        ArrayList<String> lista = new ArrayList<String>();
        String values = login + password;
        session.beginTransaction();
        List employee = session.createQuery("from LoginEntity").list();
        for (Object o : employee) {
            LoginEntity helper = (LoginEntity) o;
            if((helper.getUsername() + helper.getPassword()).equals(values)) {
                user=helper;
                if(helper.getAccessRights()==1){
                    Parent menu = FXMLLoader.load(getClass().getResource("ClientScene.fxml"));
                    LoginPanel.getChildren().removeAll();
                    LoginPanel.getChildren().setAll(menu);
                    LoginPanel.prefHeight(450);
                    LoginPanel.prefWidth(900);
            }
                if(helper.getAccessRights()==2){
                    user=helper;
                    Parent menu = FXMLLoader.load(getClass().getResource("SellerScene.fxml"));
                    LoginPanel.getChildren().removeAll();
                    LoginPanel.getChildren().setAll(menu);
                    LoginPanel.prefHeight(600);
                    LoginPanel.prefWidth(1000);
                }
                if(helper.getAccessRights()==3){
                    Parent menu = FXMLLoader.load(getClass().getResource("AdminScene.fxml"));
                    LoginPanel.getChildren().removeAll();
                    LoginPanel.getChildren().setAll(menu);
                    LoginPanel.prefHeight(600);
                    LoginPanel.prefWidth(1000);
                }


            } else {
                WrongLoginTEXT.setText("Incorrect email or password!");
            }
        }
    }


}

