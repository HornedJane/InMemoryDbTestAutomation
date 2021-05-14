import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.fintech.qa.homework.db.client.DbClient;
import ru.fintech.qa.homework.db.hibernate.DbHibernateService;
import ru.fintech.qa.homework.db.hibernate.models.animal.Animal;
import ru.fintech.qa.homework.db.hibernate.models.place.Place;
import ru.fintech.qa.homework.db.hibernate.models.workman.Workman;
import ru.fintech.qa.homework.utils.BeforeUtils;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class ServiceTests {
    private Session session;

    @BeforeAll
    public static void beforeAll() {
        BeforeUtils.createData();
    }

    @BeforeEach
    public final void beforeEach() {
        SessionFactory sessionFactory = DbClient.getSessionFactory();
        session = sessionFactory.openSession();
    }

    @AfterEach
    public final void afterEach() {
        session.close();
    }

    @Test
    public void animalCountTest() {
        long count = DbHibernateService.countRowsInTable("animal", session);
        Assertions.assertEquals(10, count);
    }

    @Test
    public void animalDuplicateIdInsertTest() {
        int erCount = 0;
        Animal animal;
        for (int i = 1; i < 11; i++) {
            animal = new Animal();
            animal.setId(i);
            animal.setName("test");
            animal.setAge(2);
            animal.setType(1);
            animal.setSex(1);
            animal.setPlace(1);
            try {
                session.beginTransaction();
                session.save(animal);
                session.getTransaction().commit();
            } catch (PersistenceException e) {
                erCount++;
            }
        }
        Assertions.assertEquals(10, erCount);
    }

    @Test
    public void nullNameWorkmanTest() {
        boolean flag = false;
        Workman workman = new Workman();
        workman.setId(7);
        workman.setName(null);
        workman.setAge(23);
        workman.setPosition(1);
        try {
            session.beginTransaction();
            session.save(workman);
            session.getTransaction().commit();
        } catch (PersistenceException e) {
            flag = true;
        }
        Assertions.assertTrue(flag);
    }

    @Test
    public void placeCountAfterInsertTest() {
        Place place = new Place();
        place.setId(6);
        place.setRow(1);
        place.setPlaceNum(185);
        place.setName("test");
        session.beginTransaction();
        session.save(place);
        session.getTransaction().commit();
        long count = DbHibernateService.countRowsInTable("places", session);
        Assertions.assertEquals(6, count);
    }

    @Test
    public void zooSpecificNamesTest() {
        boolean flag = true;
        long count = DbHibernateService.countRowsInTable("zoo", session);
        if (count != 3) {
            flag = false;
        }
        try {
            session.createNativeQuery("SELECT * FROM zoo WHERE \"name\" = 'Центральный'").getSingleResult();
            session.createNativeQuery("SELECT * FROM zoo WHERE \"name\" = 'Северный'").getSingleResult();
            session.createNativeQuery("SELECT * FROM zoo WHERE \"name\" = 'Западный'").getSingleResult();
        } catch (NoResultException e) {
            flag = false;
        }
        Assertions.assertTrue(flag);
    }
}
