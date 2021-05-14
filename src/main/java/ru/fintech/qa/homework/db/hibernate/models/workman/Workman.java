package ru.fintech.qa.homework.db.hibernate.models.workman;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "workman")
public class Workman {
    @Id
    private int id;
    @Column(name = "\"name\"")
    private String name;
    @Column(name = "age")
    private int age;
    @Column(name = "\"position\"")
    private int position;

    public final int getId() {
        return id;
    }

    public final Workman setId(final int id1) {
        this.id = id1;
        return this;
    }

    public final String getName() {
        return name;
    }

    public final Workman setName(final String name1) {
        this.name = name1;
        return this;
    }

    public final int getAge() {
        return age;
    }

    public final Workman setAge(final int age1) {
        this.age = age1;
        return this;
    }

    public final int getPosition() {
        return position;
    }

    public final Workman setPosition(final int position1) {
        this.position = position1;
        return this;
    }
}
