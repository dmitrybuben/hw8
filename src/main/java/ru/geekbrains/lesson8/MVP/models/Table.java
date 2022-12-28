package ru.geekbrains.lesson8.MVP.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

public class Table {


    private static int counter;
    private final int no;

    /*Столику соответствует коллекция резерваций на него*/
    private final Collection<Reservation> reservations = new ArrayList<>();


    {
        no = ++counter;
    }

    public int getNo() {
        return no;
    }

    /*Доступ к резервациям столика - геттер*/
    public Collection<Reservation> getReservations() {
        return reservations;
    }

    @Override
    public String toString() {
        return String.format(Locale.getDefault(), "Столик #%d", no);
    }
}
