package CRUD;

import CRUD.RentalBaseCRUD;
import DataBase.Adress;
import DataBase.CarEntity;
import DataBase.RepairmentsEntity;
import DataBase.RentalBaseEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.Iterator;
import java.util.List;


public class RepairmentsCRUD{
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



    public void saveRepairments(String engine, String tire, String FrontWindow, String doors, String body, CarEntity carBycarID){
        final Session session = getSession();
        try {
            session.beginTransaction();
            RepairmentsEntity repairment = new RepairmentsEntity();
            repairment.setEngine(engine);
            repairment.setTire(tire);
            repairment.setFrontWindows(FrontWindow);
            repairment.setDoors(doors);
            repairment.setBody(body);
            repairment.setCarByCarId(carBycarID);
            session.save(repairment);
            session.getTransaction().commit();
            System.out.println("Inserted Successfully");

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void retriveRepairments() {
        final Session session = getSession();
        try {
            session.beginTransaction();
            List employee = session.createQuery("from RepairmentsEntity").list();
            for (Iterator iterator = employee.iterator(); iterator.hasNext(); ) {
                RepairmentsEntity helper = (RepairmentsEntity) iterator.next();
                System.out.println(helper.getEngine() + " " + helper.getTire() + " " + helper.getFrontWindows() + " " + helper.getDoors() + " " + helper.getBody() + " " + helper.getCarByCarId());
                session.getTransaction().commit();
            }
        }catch(HibernateException e){
                e.printStackTrace();
            } finally{
                session.close();
            }
        }
    

    public void retriveSelectedRepairments(int id)
    {
        final Session session = getSession();
        try {
            session.beginTransaction();
            List employee = session.createQuery("from RepairmentsEntity").list();
            for (Iterator iterator = employee.iterator(); iterator.hasNext();)
            {
                RepairmentsEntity helper = (RepairmentsEntity) iterator.next();
                if(helper.getId()==id)
                    System.out.println(helper.getEngine() + " " + helper.getTire() + " " + helper.getFrontWindows() + " " + helper.getDoors() + " " + helper.getBody() + " " + helper.getCarByCarId());
            }
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public  void  deleteRepairments(int id1){
        final Session session = getSession();
        try {
            session.beginTransaction();
            RepairmentsEntity repairment = new RepairmentsEntity();
            repairment = session.byId(RepairmentsEntity.class).getReference(id1);
            session.delete(repairment);
            session.getTransaction().commit();
            System.out.println("Deleted Repairments for car: " + repairment.getCarByCarId());
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public  void  UpdateRepairmentsEngine(int id1, String engine){
        final Session session = getSession();
        try {
            session.beginTransaction();;
            RepairmentsEntity repairment = new RepairmentsEntity();
            repairment = session.byId(RepairmentsEntity.class).getReference(id1);
            repairment.setEngine(engine);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    public  void  UpdateRepairmentTire(int id1, String tire){
        final Session session = getSession();
        try {
            session.beginTransaction();;
            RepairmentsEntity repairment = new RepairmentsEntity();
            repairment = session.byId(RepairmentsEntity.class).getReference(id1);
            repairment.setTire(tire);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    public  void  UpdateRepairmentsFrontWindow(int id1, String FrontWindow){
        final Session session = getSession();
        try {
            session.beginTransaction();;
            RepairmentsEntity repairment = new RepairmentsEntity();
            repairment = session.byId(RepairmentsEntity.class).getReference(id1);
            repairment.setFrontWindows(FrontWindow);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    public  void  UpdateRepairmentsDoors(int id1, String doors){
        final Session session = getSession();
        try {
            session.beginTransaction();;
            RepairmentsEntity repairment = new RepairmentsEntity();
            repairment = session.byId(RepairmentsEntity.class).getReference(id1);
            repairment.setDoors(doors);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    public  void  UpdateRepairmentsBody(int id1, String body){
        final Session session = getSession();
        try {
            session.beginTransaction();;
            RepairmentsEntity repairment = new RepairmentsEntity();
            repairment = session.byId(RepairmentsEntity.class).getReference(id1);
            repairment.setBody(body);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    public  void  UpdateRepairmentsCarEntity(int id1, CarEntity car){
        final Session session = getSession();
        try {
            session.beginTransaction();;
            RepairmentsEntity repairment = new RepairmentsEntity();
            repairment = session.byId(RepairmentsEntity.class).getReference(id1);
            repairment.setCarByCarId(car);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void main(String[] args)
    {

        // nowy.saveCar("Benz","Black",new Date(2015-12-06), 20500.5,"Klasa C");
        //nowy.UpdateAdressStreet(3,"Fresh");
        // nowy.UpdateAdressCity(3,"Gdynia");
        // nowy.UpdateAdressPostCode(3,"99-999");
        // nowy.UpdateAdressHouse(3,"Domeczek");
    }

}