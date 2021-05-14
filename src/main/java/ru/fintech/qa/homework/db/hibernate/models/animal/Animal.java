package ru.fintech.qa.homework.db.hibernate.models.animal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "animal")
public class Animal {
    @Id
    private int id;
    @Column(name = "\"name\"")
    private String name;
    @Column(name = "age")
    private int age;
    @Column(name = "\"type\"")
    private int type;
    @Column(name = "sex")
    private int sex;
    @Column(name = "place")
    private int place;

    public final int getId() {
        return id;
    }

    public final Animal setId(final int id1) {
        this.id = id1;
        return this;
    }

    public final String getName() {
        return name;
    }

    public final Animal setName(final String name1) {
        this.name = name1;
        return this;
    }

    public final int getAge() {
        return age;
    }

    public final Animal setAge(final int age1) {
        this.age = age1;
        return this;
    }

    public final int getType() {
        return type;
    }

    public final Animal setType(final int type1) {
        this.type = type1;
        return this;
    }

    public final int getSex() {
        return sex;
    }

    public final Animal setSex(final int sex1) {
        this.sex = sex1;
        return this;
    }

    public final int getPlace() {
        return place;
    }

    public final Animal setPlace(final int place1) {
        this.place = place1;
        return this;
    }
}
