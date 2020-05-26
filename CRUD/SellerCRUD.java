package CRUD;

import CRUD.RentalBaseCRUD;
import DataBase.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import DataBase.LoginEntity;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;


public class SellerCRUD{
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



    public void saveSeller(String name, String surname, String telephone, double salary, Date recrutationDate, Adress adressByAdressID, LoginEntity login){
        final Session session = getSession();
        try {
            session.beginTransaction();
            SellerEntity seller = new SellerEntity();
            seller.setName(name);
            seller.setTelephone(telephone);
            seller.setAdressByAdressId(adressByAdressID);
            seller.setSurname(surname);
            seller.setSalary(salary);
            seller.setRecrutationDate(recrutationDate);
            seller.setLoginEntityByID(login);
            session.save(seller);
            session.getTransaction().commit();
            System.out.println("Inserted Successfully");

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void retriveSeller()
    {
        final Session session = getSession();
        try {
            session.beginTransaction();
            List employee = session.createQuery("from SellerEntity").list();
            for (Iterator iterator = employee.iterator(); iterator.hasNext();)
            {
                SellerEntity helper = (SellerEntity) iterator.next();
                System.out.println(helper.getName()+ " " + helper.getSurname()+ " " + helper.getTelephone() + " " + helper.getSalary() + " " + helper.getRecrutationDate() + " " + helper.getAdressByAdressId());
            }
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void retriveSelectedSeller(int id)
    {
        final Session session = getSession();
        try {
            session.beginTransaction();
            List employee = session.createQuery("from SellerEntity").list();
            for (Iterator iterator = employee.iterator(); iterator.hasNext();)
            {
                SellerEntity helper = (SellerEntity) iterator.next();
                if(helper.getId()==id)
                    System.out.println(helper.getName()+ " " + helper.getSurname()+ " " + helper.getTelephone() + " " + helper.getSalary() + " " + helper.getRecrutationDate() + " " + helper.getAdressByAdressId());


            }
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public  void  deleteSeller(int id1){
        final Session session = getSession();
        try {
            session.beginTransaction();
            SellerEntity seller = new SellerEntity();
            seller = session.byId(SellerEntity.class).getReference(id1);
            session.delete(seller);
            session.getTransaction().commit();
            System.out.println("Deleted Seller: " + seller.getName());
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public  void  UpdateSellerName(int id1, String name){
        final Session session = getSession();
        try {
            session.beginTransaction();;
            SellerEntity seller = new SellerEntity();
            seller = session.byId(SellerEntity.class).getReference(id1);
            seller.setName(name);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    public  void  UpdateSellerSurname(int id1, String surname){
        final Session session = getSession();
        try {
            session.beginTransaction();
            SellerEntity seller = new SellerEntity();
            seller = session.byId(SellerEntity.class).getReference(id1);
            seller.setSurname(surname);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    public  void  UpdateSellerTelephone(int id1, String telephone){
        final Session session = getSession();
        try {
            session.beginTransaction();;
            SellerEntity seller = new SellerEntity();
            seller = session.byId(SellerEntity.class).getReference(id1);
            seller.setTelephone(telephone);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    public  void  UpdateSellerAdressId(int id1, Adress AdressByAdressId){
        final Session session = getSession();
        try {
            session.beginTransaction();;
            SellerEntity seller = new SellerEntity();
            seller = session.byId(SellerEntity.class).getReference(id1);
            seller.setAdressByAdressId(AdressByAdressId);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public  void  UpdateSellerRecrutationDate(int id1, Date date){
        final Session session = getSession();
        try {
            session.beginTransaction();;
            SellerEntity seller = new SellerEntity();
            seller = session.byId(SellerEntity.class).getReference(id1);
            seller.setRecrutationDate(date);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public  void  UpdateSellerSalary(int id1, double salary){
        final Session session = getSession();
        try {
            session.beginTransaction();;
            SellerEntity seller = new SellerEntity();
            seller = session.byId(SellerEntity.class).getReference(id1);
            seller.setSalary(salary);
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
        SellerCRUD cos = new SellerCRUD();
       // cos.deleteSeller(1);
        // nowy.saveCar("Benz","Black",new Date(2015-12-06), 20500.5,"Klasa C");
        //nowy.UpdateAdressStreet(3,"Fresh");
        // nowy.UpdateAdressCity(3,"Gdynia");
        // nowy.UpdateAdressPostCode(3,"99-999");
        // nowy.UpdateAdressHouse(3,"Domeczek");
    }

}