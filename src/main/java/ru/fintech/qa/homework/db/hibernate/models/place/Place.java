package ru.fintech.qa.homework.db.hibernate.models.place;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "places")
public class Place {
    @Id
    private int id;
    @Column(name = "\"row\"")
    private int row;
    @Column(name = "place_num")
    private int placeNum;
    @Column(name = "\"name\"")
    private String name;

    public final int getId() {
        return id;
    }

    public final Place setId(final int id1) {
        this.id = id1;
        return this;
    }

    public final int getRow() {
        return row;
    }

    public final Place setRow(final int row1) {
        this.row = row1;
        return this;
    }

    public final int getPlaceNum() {
        return placeNum;
    }

    public final Place setPlaceNum(final int placeNum1) {
        this.placeNum = placeNum1;
        return this;
    }

    public final String getName() {
        return name;
    }

    public final Place setName(final String name1) {
        this.name = name1;
        return this;
    }
}
