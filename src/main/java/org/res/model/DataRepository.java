package org.res.model;

import java.util.ArrayList;
import java.util.List;

public class DataRepository
{
    public static DataRepository INSTANCE= new DataRepository();
    private int lastId=4;

    public DataRepository() {

    }

    private final String[] PERFORMANCES_DATA= {
            "1,2025-12-30 15:00,Hamlet,250",
            "2,2025-12-30 19:00,Richard III,250",
            "3,2025-12-31 18:00,MacBeth,200"
    };

    public List<Performance> getAllPerformances() {
        List<Performance> result= new ArrayList<>();
        for (String s:PERFORMANCES_DATA) {
            result.add(Performance.parse(s));
        }
        return result;
    }

    public Reservation newReservation(Performance p) {
        Reservation r= new Reservation();
        r.setId(lastId++);
        r.setPerformanceId(p.getId());
        return r;
    }
}
