package ru.geekbrains.lesson8.MVP.models;

import ru.geekbrains.lesson8.MVP.presenters.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

public class BookingModel implements Model {


    private Collection<Table> tables;

    /*Метод для загрузки всех досутпных столиков с возвратом списка столиков
    * при первом вызове метода инициализируется коллекция и наполняется столиками, а при повторном сразу возвр-ся
    * коллекция столиков
    * */
    public Collection<Table> loadTables(){
        if (tables == null){
            tables = new ArrayList<>();

            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }

        return tables;
    }

    /**
     * Бронирование столика
     * @param reservationDate дата бронирования
     * @param tableNo номер столика
     * @param name имя
     * @return номер бронирования
     */
    public int reservationTable(Date reservationDate, int tableNo, String name){
        Optional<Table> table = loadTables().stream().filter(t -> t.getNo() == tableNo).findFirst();
        if (table.isPresent()){
            Reservation reservation = new Reservation(reservationDate, name);
            table.get().getReservations().add(reservation);
            return reservation.getId();
        }
        throw new RuntimeException("Некорректный номер столика.");
    }

    /**
     * Изменение брони столика
     * @param oldReservation старый номер брони
     * @param reservationDate дата бронирования
     * @param tableNo номер столика
     * @param name имя пользователя
     * @return новый номер бронирования
     */
    @Override
    public int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        Optional<Table> table = loadTables().stream().filter(t -> t.getNo() == tableNo).findFirst();
        if (table.isPresent()){
            table.get().getReservations().remove(oldReservation);
            Reservation reservation = new Reservation(reservationDate,name);
            table.get().getReservations().add(reservation);
            return reservation.getId();
        }
        throw new RuntimeException("Такого номера резерва не существует.");
    }

}
