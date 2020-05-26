package CRUD;

import DataBase.Adress;
import DataBase.RentalBaseEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;


public class RentalBaseCRUD{
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



    public void saveRentalBase(String name, String telephone, Adress adressByAdressI){
        final Session session = getSession();
        try {
            session.beginTransaction();
            RentalBaseEntity base = new RentalBaseEntity();
            base.setName(name);
            base.setTelephone(telephone);
            base.setAdressByAdressId(adressByAdressI);
            session.save(base);
            session.getTransaction().commit();
            System.out.println("Inserted Successfully");

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void retriveRentalBase()
    {
        final Session session = getSession();
        try {
            session.beginTransaction();
            List employee = session.createQuery("from RentalBaseEntity").list();
            for (Iterator iterator = employee.iterator(); iterator.hasNext();)
            {
                RentalBaseEntity helper = (RentalBaseEntity) iterator.next();
                System.out.println(helper.getName()+ " " + helper.getTelephone()+ " " + helper.getAdressByAdressId());
            }
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void retriveSelectedRentalBase(int id)
    {
        final Session session = getSession();
        try {
            session.beginTransaction();
            List employee = session.createQuery("from RentalBaseEntity").list();
            for (Iterator iterator = employee.iterator(); iterator.hasNext();)
            {
                RentalBaseEntity helper = (RentalBaseEntity) iterator.next();
                if(helper.getId()==id)
                    System.out.println(helper.getName()+ " " + helper.getTelephone()+ " " + helper.getAdressByAdressId());

            }
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public  void  deleteRentalBase(int id1){
        final Session session = getSession();
        try {
            session.beginTransaction();
            RentalBaseEntity base = new RentalBaseEntity();
            base = session.byId(RentalBaseEntity.class).getReference(id1);
            session.delete(base);
            session.getTransaction().commit();
            System.out.println("Deleted Base: " + base.getName());
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public  void  UpdateRentalBaseName(int id1, String name){
        final Session session = getSession();
        try {
            session.beginTransaction();;
            RentalBaseEntity base = new RentalBaseEntity();
            base = session.byId(RentalBaseEntity.class).getReference(id1);
            base.setName(name);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    public  void  UpdateRentalBaseTelephone(int id1, String Telephone){
        final Session session = getSession();
        try {
            session.beginTransaction();;
            RentalBaseEntity base = new RentalBaseEntity();
            base = session.byId(RentalBaseEntity.class).getReference(id1);
            base.setTelephone(Telephone);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public  void  UpdateRentalBaseAdress(int id1, Adress adress){
        final Session session = getSession();
        try {
            session.beginTransaction();;
            RentalBaseEntity base = new RentalBaseEntity();
            base = session.byId(RentalBaseEntity.class).getReference(id1);
            base.setAdressByAdressId(adress);
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
        Adress wartosc = new Adress();
      //  CRUD.AdressCRUD nowy = new CRUD.AdressCRUD();
      //  nowy.saveAdress("Poziomkowa","80911","Zielony","Wawka");
        wartosc = session.byId(Adress.class).getReference(3);
        RentalBaseCRUD baza = new RentalBaseCRUD();
        baza.saveRentalBase("Gdanska","608120476",wartosc);

        // nowy.saveCar("Benz","Black",new Date(2015-12-06), 20500.5,"Klasa C");
        //nowy.UpdateAdressStreet(3,"Fresh");
        // nowy.UpdateAdressCity(3,"Gdynia");
        // nowy.UpdateAdressPostCode(3,"99-999");
        // nowy.UpdateAdressHouse(3,"Domeczek");
    }

}