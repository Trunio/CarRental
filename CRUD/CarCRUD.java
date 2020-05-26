package CRUD;

import DataBase.CarEntity;
import DataBase.RentalBaseEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;


public class CarCRUD{
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



    public void saveCar(RentalBaseEntity RentalBaseEntityByRentalBaseId, String mark, String color, Date productionDate, double price, String category){
        final Session session = getSession();
        try {
            session.beginTransaction();
            CarEntity car = new CarEntity();
            car.setRentalBaseEntityByRentalBaseId(RentalBaseEntityByRentalBaseId);
            car.setCategory(category);
            car.setPrice(price);
            car.setMark(mark);
            car.setColor(color);
            car.setProductionDate(productionDate);
            session.save(car);
            session.getTransaction().commit();
            System.out.println("Inserted Successfully");

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void retriveCar()
    {
        final Session session = getSession();
        try {
            session.beginTransaction();
            List employee = session.createQuery("from CarEntity ").list();
            for (Iterator iterator = employee.iterator(); iterator.hasNext();)
            {
                CarEntity helper = (CarEntity) iterator.next();
                System.out.println(helper.getMark()+ " " + helper.getColor()+ " " + helper.getProductionDate() + " " + helper.getPrice() + " " + helper.getCategory());
            }
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void retriveSelectedCar(int id)
    {
        final Session session = getSession();
        try {
            session.beginTransaction();
            List employee = session.createQuery("from CarEntity ").list();
            for (Iterator iterator = employee.iterator(); iterator.hasNext();)
            {
                CarEntity helper = (CarEntity) iterator.next();
                if(helper.getId()==id)
                    System.out.println(helper.getMark()+ " " + helper.getColor()+ " " + helper.getProductionDate() + " " + helper.getPrice() + " " + helper.getCategory());

            }
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public  void  deleteCar(int id1){
        final Session session = getSession();
        try {
            session.beginTransaction();
            CarEntity car = new CarEntity();
            car = session.byId(CarEntity.class).getReference(id1);
            session.delete(car);
            session.getTransaction().commit();
            System.out.println("Deleted Car: " + car.getCategory());
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public  void  UpdateCarMark(int id1, String mark){
        final Session session = getSession();
        try {
            session.beginTransaction();;
            CarEntity car = new CarEntity();
            car = session.byId(CarEntity.class).getReference(id1);
            car.setMark(mark);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public  void  UpdateCarColor(int id1, String color){
        final Session session = getSession();
        try {
            session.beginTransaction();;
            CarEntity car = new CarEntity();
            car = session.byId(CarEntity.class).getReference(id1);
            car.setColor(color);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public  void  UpdateCarProductionDate(int id1, Date date){
        final Session session = getSession();
        try {
            session.beginTransaction();;
            CarEntity car = new CarEntity();
            car = session.byId(CarEntity.class).getReference(id1);
            car.setProductionDate(date);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public  void  UpdateCarPrice(int id1, double price){
        final Session session = getSession();
        try {
            session.beginTransaction();;
            CarEntity car = new CarEntity();
            car = session.byId(CarEntity.class).getReference(id1);
            car.setPrice(price);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    public  void  UpdateCarBase(int id1, RentalBaseEntity base){
        final Session session = getSession();
        try {
            session.beginTransaction();;
            CarEntity car = new CarEntity();
            car = session.byId(CarEntity.class).getReference(id1);
            car.setRentalBaseEntityByRentalBaseId(base);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    public  void  UpdateCarCategory(int id1, String category){
        final Session session = getSession();
        try {
            session.beginTransaction();;
            CarEntity car = new CarEntity();
            car = session.byId(CarEntity.class).getReference(id1);
            car.setCategory(category);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void main(String[] args)
    {
        CarCRUD nowy = new CarCRUD();
        Date help = new Date(2015-12-06);
    //    nowy.saveCar("Benz","Black",new Date(2015-12-06), 20500.5,"Klasa C");
        //nowy.UpdateAdressStreet(3,"Fresh");
       // nowy.UpdateAdressCity(3,"Gdynia");
       // nowy.UpdateAdressPostCode(3,"99-999");
       // nowy.UpdateAdressHouse(3,"Domeczek");
    }

}