package utils.hibernate;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import model.*;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Create configuration instance
            Configuration configuration = new Configuration();
            
            // Load hibernate.cfg.xml from resources
            configuration.configure("hibernate.cfg.xml");
            
            // Add annotated classes (your Hibernate models)
            configuration.addAnnotatedClass(UserInfo.class);
            configuration.addAnnotatedClass(Doctor.class);
            configuration.addAnnotatedClass(Location.class);
            configuration.addAnnotatedClass(Department.class);
            configuration.addAnnotatedClass(Appointment.class);
            configuration.addAnnotatedClass(History.class);
            configuration.addAnnotatedClass(PatientExpedient.class);
            configuration.addAnnotatedClass(LoginInfo.class);

            // Build service registry
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            
            // Create session factory
            return configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }
}