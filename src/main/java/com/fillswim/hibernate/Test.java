package com.fillswim.hibernate;

import com.fillswim.hibernate.Entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {

        Map<String, String> settings = new HashMap<>();
        settings.put("connection.driver_class", "com.mysql.jdbc.Driver");
        settings.put("current_session_context_class", "thread");
        settings.put("hibernate.dialect", "org.hibernate.dialect.MariaDBDialect");
        settings.put("hibernate.hbm2ddl.auto", "update");
        settings.put("connection.driver_class", "com.mysql.jdbc.Driver");

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(settings).build();
        MetadataSources metadataSources = new MetadataSources(serviceRegistry);
        metadataSources.addAnnotatedClass(Employee.class);
        Metadata metadata = metadataSources.buildMetadata();

        try (SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
             Session session = sessionFactory.openSession()) {

            Employee employee = new Employee("Oleg", "Smirnov", "IT", 1000);

            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();

        }

    }
}
