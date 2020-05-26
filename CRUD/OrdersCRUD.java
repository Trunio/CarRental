package CRUD;

import DataBase.CarEntity;
import DataBase.ClientEntity;
import DataBase.OrdersEntity;
import DataBase.SellerEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;


public class OrdersCRUD {
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


    public void saveOrdersEntity(Date rentalDate, Date returnDate, CarEntity car, SellerEntity seller, ClientEntity client) {
        final Session session = getSession();
        try {
            session.beginTransaction();
            OrdersEntity orders = new OrdersEntity();
            orders.setRentalDate(rentalDate);
            orders.setReturnDate(returnDate);
            orders.setCarByCarId(car);
            orders.setSellerBySellerId(seller);
            orders.setClientByClientId(client);
            session.save(orders);
            session.getTransaction().commit();
            System.out.println("Inserted Successfully");

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void retriveOrdersEntity() {
        final Session session = getSession();
        try {
            session.beginTransaction();
            List employee = session.createQuery("from OrdersEntity").list();
            for (Iterator iterator = employee.iterator(); iterator.hasNext(); ) {
                OrdersEntity helper = (OrdersEntity) iterator.next();
                System.out.println(helper.getRentalDate() + " " + helper.getReturnDate() + " " + helper.getCarByCarId() + " " + helper.getSellerBySellerId() + " " + helper.getClientByClientId());
            }
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void retriveSelectedOrdersEntity(int id) {
        final Session session = getSession();
        try {
            session.beginTransaction();
            List employee = session.createQuery("from OrdersEntity").list();
            for (Iterator iterator = employee.iterator(); iterator.hasNext(); ) {
                OrdersEntity helper = (OrdersEntity) iterator.next();
                if (helper.getId() == id)
                    System.out.println(helper.getRentalDate() + " " + helper.getReturnDate() + " " + helper.getCarByCarId() + " " + helper.getSellerBySellerId() + " " + helper.getClientByClientId());
            }
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    public void deleteOrdersEntity(int id1) {
        final Session session = getSession();
        try {
            session.beginTransaction();
            OrdersEntity order = new OrdersEntity();
            order = session.byId(OrdersEntity.class).getReference(id1);
            session.delete(order);
            session.getTransaction().commit();
            System.out.println("Deleted Order");
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void UpdateOrdersEntityRentalDate(int id1, Date rentalDate) {
        final Session session = getSession();
        try {
            session.beginTransaction();
            ;
            OrdersEntity order = new OrdersEntity();
            order = session.byId(OrdersEntity.class).getReference(id1);
            order.setRentalDate(rentalDate);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void UpdateOrdersEntityReturnDate(int id1, Date returnDate) {
        final Session session = getSession();
        try {
            session.beginTransaction();
            ;
            OrdersEntity order = new OrdersEntity();
            order = session.byId(OrdersEntity.class).getReference(id1);
            order.setReturnDate(returnDate);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void UpdateOrdersEntityCarID(int id1, CarEntity car) {
        final Session session = getSession();
        try {
            session.beginTransaction();
            ;
            OrdersEntity order = new OrdersEntity();
            order = session.byId(OrdersEntity.class).getReference(id1);
            order.setCarByCarId(car);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void UpdateOrdersEntitySellerID(int id1, SellerEntity seller) {
        final Session session = getSession();
        try {
            session.beginTransaction();
            ;
            OrdersEntity order = new OrdersEntity();
            order = session.byId(OrdersEntity.class).getReference(id1);
            order.setSellerBySellerId(seller);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void UpdateOrdersEntityClientID(int id1, ClientEntity client) {
        final Session session = getSession();
        try {
            session.beginTransaction();
            ;
            OrdersEntity order = new OrdersEntity();
            order = session.byId(OrdersEntity.class).getReference(id1);
            order.setClientByClientId(client);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void main(String[] args) {
        OrdersCRUD delte = new OrdersCRUD();
        delte.deleteOrdersEntity(1);

    }
}