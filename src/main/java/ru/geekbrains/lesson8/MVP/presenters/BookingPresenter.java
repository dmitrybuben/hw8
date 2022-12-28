package ru.geekbrains.lesson8.MVP.presenters;

import ru.geekbrains.lesson8.MVP.models.Table;

import java.util.Collection;
import java.util.Date;

public class BookingPresenter implements ViewObserver {

    /*полями показываем зависимости от Model и View*/
    private final Model model;
    private final View view;
    private Collection<Table> tables;

    public BookingPresenter(Model model, View view) {
        this.model = model;
        this.view = view;
        this.view.setObserver(this);
    }

    /**
     * Получить список всех столиков
     */
    public void loadTables(){
        tables = model.loadTables();
    }

    /**
     * Отобразить список столиков
     */
    public void updateView(){
        view.showTables(tables);
    }

    protected void printReservationTableResult(int reservationNo){
        view.printReservationTableResult(reservationNo);
    }

    private void printChangeReservationTableResult(int changeReservationNo) {
        view.printChangeReservationTableResult(changeReservationNo);
    }

    @Override
    public void onReservationTable(Date reservationDate, int tableNo, String name) {
        int reservationNo = model.reservationTable(reservationDate, tableNo, name);
        printReservationTableResult(reservationNo);
    }

    @Override
    public void onChangeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        int changeReservationNo = model.changeReservationTable(oldReservation, reservationDate, tableNo, name);
        printChangeReservationTableResult(changeReservationNo);
    }

}
