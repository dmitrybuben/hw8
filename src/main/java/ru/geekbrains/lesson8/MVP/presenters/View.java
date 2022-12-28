package ru.geekbrains.lesson8.MVP.presenters;

import ru.geekbrains.lesson8.MVP.models.Table;

import java.util.Collection;

public interface View {

    void showTables(Collection<Table> tables);
    void setObserver(ViewObserver observer);
    void printReservationTableResult(int reservationNo);
    void printChangeReservationTableResult(int changeReservationNo);

}
