package ru.fintech.qa.homework.db.hibernate;

import org.hibernate.Session;

public class DbHibernateService {

    public static long countRowsInTable(final String name, final Session session) {
        return session
                .createNativeQuery("SELECT * FROM " + name)
                .stream()
                .count();
    }
}
