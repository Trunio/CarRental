package CRUD;

import DataBase.Adress;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;


public class AdressCRUD{
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



    public void saveAdress(String Street,String PostCode,String House,String City){
        final Session session = getSession();
        try {
            session.beginTransaction();
            Adress adres= new Adress ();
            adres.setStreet(Street);
            adres.setPostCode(PostCode);
            adres.setHouse(House);
            adres.setCity(City);
            session.save(adres);
            session.getTransaction().commit();
            System.out.println("Inserted Successfully");

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void retriveAdress()
    {
        final Session session = getSession();
        try {
            session.beginTransaction();
            List employee = session.createQuery("from Adress").list();
            for (Iterator iterator = employee.iterator(); iterator.hasNext();)
            {
                Adress helper = (Adress) iterator.next();
                System.out.println(helper.getCity()+"  "+helper.getHouse()+"  "+helper.getStreet()+"   "+helper.getPostCode());
            }
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void retriveSelectedAdress(int id)
    {
        final Session session = getSession();
        try {
            session.beginTransaction();
            List employee = session.createQuery("from Adress").list();
            for (Iterator iterator = employee.iterator(); iterator.hasNext();)
            {
                Adress helper = (Adress) iterator.next();
                if(helper.getId()==id)
                System.out.println(helper.getCity()+"  "+helper.getHouse()+"  "+helper.getStreet()+"   "+helper.getPostCode());
            }
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public Adress getSelectedAdress(int id)
    {
        Adress adres= new Adress ();
        final Session session = getSession();
        try {
            session.beginTransaction();
            List employee = session.createQuery("from Adress").list();
            for (Iterator iterator = employee.iterator(); iterator.hasNext();)
            {
                Adress helper = (Adress) iterator.next();
                if(helper.getId()==id)
                    adres=helper;
            }
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return adres;
    }


    public  void  deleteAdress(int id1){
        final Session session = getSession();
        try {
            session.beginTransaction();;
            Adress adresik= new Adress ();
            adresik = session.byId(Adress.class).getReference(id1);
            session.delete(adresik);
            session.getTransaction().commit();
            System.out.println("Deleted Postcode: " + adresik.getPostCode() );
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public  void  UpdateAdressStreet(int id1, String ulica){
        final Session session = getSession();
        try {
            session.beginTransaction();;
            Adress adresik= new Adress ();
            adresik = session.byId(Adress.class).getReference(id1);
            adresik.setStreet(ulica);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    public  void  UpdateAdressCity(int id1, String miasto){
        final Session session = getSession();
        try {
            session.beginTransaction();;
            Adress adresik= new Adress ();
            adresik = session.byId(Adress.class).getReference(id1);
            adresik.setCity(miasto);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    public  void  UpdateAdressHouse(int id1, String dom){
        final Session session = getSession();
        try {
            session.beginTransaction();;
            Adress adresik= new Adress ();
            adresik = session.byId(Adress.class).getReference(id1);
            adresik.setHouse(dom);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    public  void  UpdateAdressPostCode(int id1, String kod){
        final Session session = getSession();
        try {
            session.beginTransaction();;
            Adress adresik= new Adress ();
            adresik = session.byId(Adress.class).getReference(id1);
            adresik.setPostCode(kod);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    public static void main(String[] args)
    {
        AdressCRUD nowy = new AdressCRUD();
       // nowy.saveAdress("Poziomkowa","80911","Zielony","Wawka");
       // nowy.retriveAdress();
      //  nowy.retriveSelectedAdress(1);
        nowy.deleteAdress(2);
     //   nowy.UpdateAdressStreet(3,"Fresh");
      //  nowy.UpdateAdressCity(3,"Gdynia");
      //  nowy.UpdateAdressPostCode(3,"99-999");
       // nowy.UpdateAdressHouse(3,"Domeczek");
    }

}