package CRUD;

import DataBase.Adress;
import DataBase.ClientEntity;
import DataBase.LoginEntity;
import DataBase.OrdersArchiveEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;

public class LoginCRUD {
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
    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }


    public void saveLogin(String login, String Password, int access){
        final Session session = getSession();
        try {
            session.beginTransaction();
            LoginEntity helper = new LoginEntity();
            helper.setAccessRights(access);
            helper.setPassword(Password);
            helper.setUsername(login);
            session.save(helper);
            session.getTransaction().commit();
            System.out.println("Inserted Successfully");

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    public  void  LoginUsername(int id1, String name){
        final Session session = getSession();
        try {
            session.beginTransaction();;
            LoginEntity helper = new LoginEntity();
            helper = session.byId(LoginEntity.class).getReference(id1);
            helper.setUsername(name);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    public  void  LoginPassword(int id1, String name){
        final Session session = getSession();
        try {
            session.beginTransaction();;
            LoginEntity helper = new LoginEntity();
            helper = session.byId(LoginEntity.class).getReference(id1);
            helper.setPassword(name);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public  void  deleteLogin(int id1){
        final Session session = getSession();
        try {
            session.beginTransaction();
            LoginEntity helper = new LoginEntity();
            helper = session.byId(LoginEntity.class).getReference(id1);
            session.delete(helper);
            session.getTransaction().commit();
            System.out.println("Deleted Login:");
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    public void retriveLogins() {
        final Session session = getSession();
        try {
            session.beginTransaction();
            List employee = session.createQuery("from LoginEntity ").list();
            for (Iterator iterator = employee.iterator(); iterator.hasNext(); ) {
                LoginEntity helper = ( LoginEntity) iterator.next();
                System.out.println(helper.getUsername()+" " + helper.getPassword() + " " + helper.getAccessRights());
            }
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    public static void main(String[] args)
    {
        final Session session = getSession();

        LoginCRUD deletor =  new LoginCRUD();

        deletor.deleteLogin(1);

        // nowy.saveCar("Benz","Black",new Date(2015-12-06), 20500.5,"Klasa C");
        //nowy.UpdateAdressStreet(3,"Fresh");
        // nowy.UpdateAdressCity(3,"Gdynia");
        // nowy.UpdateAdressPostCode(3,"99-999");
        // nowy.UpdateAdressHouse(3,"Domeczek");
    }
}
