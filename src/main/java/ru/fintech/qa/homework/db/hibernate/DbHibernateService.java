package ru.fintech.qa.homework.db.hibernate;

import org.hibernate.Session;
import ru.fintech.qa.homework.db.hibernate.models.zoo.Zoo;

public class DbHibernateService {

    public static long countRowsInTable(final String name, final Session session) {
        return session
                .createNativeQuery("SELECT * FROM " + name)
                .stream()
                .count();
    }

    public static Zoo getZooByName(final String name, final Session session) {
        return session
                .createNativeQuery("SELECT * FROM zoo WHERE \"name\" = " + "'" + name + "'", Zoo.class)
                .getSingleResult();
    }

}
