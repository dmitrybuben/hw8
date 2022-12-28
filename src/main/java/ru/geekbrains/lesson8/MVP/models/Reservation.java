package ru.geekbrains.lesson8.MVP.models;

import java.util.Date;

public class Reservation {

    private static int counter;
    private final int id;
    private Date date;
    private String name;

    {
        id = ++counter;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public Reservation(Date date, String name) {
        this.date = date;
        this.name = name;
    }
}

