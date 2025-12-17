package org.res.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Performance {

    public static final DateTimeFormatter DATETIME_FORMAT=
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    private int id;
    private LocalDateTime date;
    private String title;
    private int capacity;
    private List<Reservation> reservations;

    public static Performance parse(String source) {
        String[] tokens= source.split(",");
        Performance p= new Performance();
        p.setId(Integer.parseInt(tokens[0]));
        p.setDate(LocalDateTime.parse(tokens[1],DATETIME_FORMAT));
        p.setTitle(tokens[2]);
        p.setCapacity(Integer.parseInt(tokens[3]));
        return p;
    }

    public String toString() {
        return String.format("%s - %s (%d Offen)", DATETIME_FORMAT.format(date), title, capacity);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
