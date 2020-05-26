package CRUD;

import DataBase.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;


public class OrdersArchiveCRUD {
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


    public void saveOrdersArchiveEntity(int orderScore, int carScore, int idBase, int order,Date rentalDate, Date returnDate, int car, int seller, int client) {
        final Session session = getSession();
        try {
            session.beginTransaction();
            OrdersArchiveEntity OrdersArchive = new OrdersArchiveEntity();
            OrdersArchive.setOrderScore(orderScore);
            OrdersArchive.setCarScore(carScore);
            OrdersArchive.setRentalBaseEntitybyID(idBase);
            OrdersArchive.setOrders_Id(order);
            OrdersArchive.setRentalDate(rentalDate);
            OrdersArchive.setReturnDate(returnDate);
            OrdersArchive.setCarByCarId(car);
            OrdersArchive.setSellerBySellerId(seller);
            OrdersArchive.setClientByClientId(client);
            session.save(OrdersArchive);
            session.getTransaction().commit();
            System.out.println("Inserted Successfully");

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void retriveOrdersArchiveEntity() {
        final Session session = getSession();
        try {
            session.beginTransaction();
            List employee = session.createQuery("from OrdersArchiveEntity").list();
            for (Iterator iterator = employee.iterator(); iterator.hasNext(); ) {
                OrdersArchiveEntity helper = (OrdersArchiveEntity) iterator.next();
                System.out.println(helper.getOrderScore() + " " + helper.getCarScore() + " " + helper.getRentalBaseEntitybyID() + " " + helper.getOrders_Id());
            }
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void retriveSelectedOrdersArchiveEntity(int id) {
        final Session session = getSession();
        try {
            session.beginTransaction();
            List employee = session.createQuery("from OrdersArchiveEntity").list();
            for (Iterator iterator = employee.iterator(); iterator.hasNext(); ) {
                OrdersArchiveEntity helper = (OrdersArchiveEntity) iterator.next();
                if (helper.getId() == id)
                    System.out.println(helper.getOrderScore() + " " + helper.getCarScore() + " " + helper.getRentalBaseEntitybyID() + " " + helper.getOrders_Id());
            }
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    public void deleteOrdersArchiveEntity(int id1) {
        final Session session = getSession();
        try {
            session.beginTransaction();
            ;
            OrdersArchiveEntity order = new OrdersArchiveEntity();
            order = session.byId(OrdersArchiveEntity.class).getReference(id1);
            session.delete(order);
            session.getTransaction().commit();
            System.out.println("Deleted Order");
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void UpdateOrdersArchiveEntityOrderScore(int id1, int orderscore) {
        final Session session = getSession();
        try {
            session.beginTransaction();
            ;
            OrdersArchiveEntity order = new OrdersArchiveEntity();
            order = session.byId(OrdersArchiveEntity.class).getReference(id1);
            order.setOrderScore(orderscore);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }



    public void UpdateOrdersArchiveEntityCarScore(int id1, int carscore) {
        final Session session = getSession();
        try {
            session.beginTransaction();
            ;
            OrdersArchiveEntity order = new OrdersArchiveEntity();
            order = session.byId(OrdersArchiveEntity.class).getReference(id1);
            order.setCarScore(carscore);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void UpdateOrdersArchiveRentalDate(int id1, Date rental) {
        final Session session = getSession();
        try {
            session.beginTransaction();
            ;
            OrdersArchiveEntity order = new OrdersArchiveEntity();
            order = session.byId(OrdersArchiveEntity.class).getReference(id1);
            order.setRentalDate(rental);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void UpdateOrdersArchiveEntityReturnDate( int id1, Date date) {
        final Session session = getSession();
        try {
            session.beginTransaction();
            ;
            OrdersArchiveEntity order = new OrdersArchiveEntity();
            order = session.byId(OrdersArchiveEntity.class).getReference(id1);
            order.setReturnDate(date);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }



    public void UpdateOrdersArchiveEntityBaseId(int id1, int base) {
        final Session session = getSession();
        try {
            session.beginTransaction();
            ;
            OrdersArchiveEntity order = new OrdersArchiveEntity();
            order = session.byId(OrdersArchiveEntity.class).getReference(id1);
            order.setRentalBaseEntitybyID(base);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
/*
    public void UpdateOrdersArchiveEntityOrderID(int id1, OrdersEntity value) {
        final Session session = getSession();
        try {
            session.beginTransaction();
            ;
            OrdersArchiveEntity order = new OrdersArchiveEntity();
            order = session.byId(OrdersArchiveEntity.class).getReference(id1);
            order.setOrders_Id(value);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
*/

    public static void main(String[] args) {
        OrdersArchiveCRUD test = new OrdersArchiveCRUD();

        test.saveOrdersArchiveEntity(5,5,5,5, new Date(2015-12-06), new Date(2015-12-06),1,1,1);

    }
}