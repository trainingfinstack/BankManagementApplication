package customerRegistration.coreJava.src.main.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
           configuration.addAnnotatedClass(customerRegistration.coreJava.src.main.com.tutorial.projectwithMaven.Customer.class);
           configuration.addAnnotatedClass(customerRegistration.coreJava.src.main.com.tutorial.projectwithMaven.Account.class);
           configuration.configure("src/main/resources/hibernate.cfg.xml");
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties());
            sessionFactory = configuration.buildSessionFactory(builder.build());
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
