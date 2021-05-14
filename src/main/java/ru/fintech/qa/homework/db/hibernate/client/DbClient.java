package ru.fintech.qa.homework.db.hibernate.client;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.fintech.qa.homework.db.hibernate.models.animal.Animal;
import ru.fintech.qa.homework.db.hibernate.models.place.Place;
import ru.fintech.qa.homework.db.hibernate.models.workman.Workman;
import ru.fintech.qa.homework.db.hibernate.models.zoo.Zoo;

public class DbClient {
    private static SessionFactory sessionFactory = null;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = buildSessionFactory();
        }
        return sessionFactory;
    }

    private static SessionFactory buildSessionFactory() {
        return new Configuration()
                .configure()
                .addAnnotatedClass(Animal.class)
                .addAnnotatedClass(Place.class)
                .addAnnotatedClass(Workman.class)
                .addAnnotatedClass(Zoo.class)
                .buildSessionFactory();
    }
}
