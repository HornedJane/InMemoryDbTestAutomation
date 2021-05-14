package ru.fintech.qa.homework.db.hibernate.models.zoo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "zoo")
public class Zoo {
    @Id
    private int id;
    @Column(name = "\"name\"")
    private String name;

    public final int getId() {
        return id;
    }

    public final Zoo setId(final int id1) {
        this.id = id1;
        return this;
    }

    public final String getName() {
        return name;
    }

    public final Zoo setName(final String name1) {
        this.name = name1;
        return this;
    }
}
