package Prueba;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.lang.ExceptionInInitializerError;import java.lang.Integer;import java.lang.String;import java.lang.System;import java.lang.Throwable;

// su - postgres
//psql template1

/**
 * Created by Dionis on 22/11/2015.
 */
public class ManageEmployee {

    private static SessionFactory factory;
    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    public static SessionFactory createSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure();
        serviceRegistry = new ServiceRegistryBuilder().applySettings(
                configuration.getProperties()). buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }

    public static void main(String[] args) {

        createDB();

        try {
            factory = createSessionFactory();
        }catch (Throwable ex){
            System.err.println("Failed to create "+ex);
            throw new ExceptionInInitializerError(ex);
        }

        ManageEmployee ME = new ManageEmployee();

        Integer empID1 = ME.addEmployee("Daisy","Das", 5000);
        Integer empID2 = ME.addEmployee("Zara","Ali", 5000);
        Integer empID3 = ME.addEmployee("John","Paul", 10000);

        System.out.println(empID1);
        System.out.println(empID2);
        System.out.println(empID3);
    }

    public Integer addEmployee( String fname, String lname, int salary) {

        Session session = factory.openSession();
        Transaction tx = null;
        Integer employeeID = null;

        try {
            tx = session.beginTransaction();
            Employee employee = new Employee(fname, lname, salary);
            employeeID = (Integer) session.save(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return employeeID;
    }

    public static void createDB(){


        }

}
