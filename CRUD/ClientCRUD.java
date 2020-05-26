package CRUD;

import CRUD.RentalBaseCRUD;
import DataBase.Adress;
import DataBase.ClientEntity;
import DataBase.LoginEntity;
import DataBase.RentalBaseEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.Iterator;
import java.util.List;


public class ClientCRUD{
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



    public void saveClient(String name, String surname, String telephone, Adress adressByAdressI, LoginEntity login){
        final Session session = getSession();
        try {
            session.beginTransaction();
            ClientEntity klient = new ClientEntity();
            klient.setName(name);
            klient.setTelephone(telephone);
            klient.setAdressByAdressId(adressByAdressI);
            klient.setSurname(surname);
            klient.setLoginEntityByID(login);
            session.save(klient);
            session.getTransaction().commit();
            System.out.println("Inserted Successfully");

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void retriveClient()
    {
        final Session session = getSession();
        try {
            session.beginTransaction();
            List employee = session.createQuery("from ClientEntity").list();
            for (Object o : employee) {
                ClientEntity helper = (ClientEntity) o;
                System.out.println(helper.getName() + " " + helper.getSurname() + " " + helper.getTelephone() + " " + helper.getAdressByAdressId());
            }
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void retriveSelectedClient(int id)
    {
        final Session session = getSession();
        try {
            session.beginTransaction();
            List employee = session.createQuery("from ClientEntity").list();
            for (Iterator iterator = employee.iterator(); iterator.hasNext();)
            {
                ClientEntity helper = (ClientEntity) iterator.next();
                if(helper.getId()==id)
                    System.out.println(helper.getName()+ " " + helper.getSurname()+ " " + helper.getTelephone()+ " " + helper.getAdressByAdressId());

            }
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public  void  deleteClient(int id1){
        final Session session = getSession();
        try {
            session.beginTransaction();
            ClientEntity klient = new ClientEntity();
            klient = session.byId(ClientEntity.class).getReference(id1);
            session.delete(klient);
            session.getTransaction().commit();
            System.out.println("Deleted Client: " + klient.getName());
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public  void  UpdateClientName(int id1, String name){
        final Session session = getSession();
        try {
            session.beginTransaction();;
            ClientEntity klient = new ClientEntity();
            klient = session.byId(ClientEntity.class).getReference(id1);
            klient.setName(name);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    public  void  UpdateClientSurname(int id1, String surname){
        final Session session = getSession();
        try {
            session.beginTransaction();;
            ClientEntity klient = new ClientEntity();
            klient = session.byId(ClientEntity.class).getReference(id1);
            klient.setSurname(surname);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    public  void  UpdateClientTelephone(int id1, String telephone){
        final Session session = getSession();
        try {
            session.beginTransaction();;
            ClientEntity klient = new ClientEntity();
            klient = session.byId(ClientEntity.class).getReference(id1);
            klient.setTelephone(telephone);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    public  void  UpdateClientAdressId(int id1, Adress AdressByAdressId){
        final Session session = getSession();
        try {
            session.beginTransaction();;
            ClientEntity klient = new ClientEntity();
            klient = session.byId(ClientEntity.class).getReference(id1);
            klient.setAdressByAdressId(AdressByAdressId);
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