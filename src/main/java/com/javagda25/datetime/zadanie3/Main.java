package com.javagda25.datetime.zadanie3;

// Napisz aplikację, która wyświetli "różnicę" dwóch dat w formacie: "years: , months: , days: "
// Wskazówka: skorzystaj z klasy Period:
// Period period = Period.between(data_start, data_stop);

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class Main {
    public static void main(String[] args) {
        LocalDate data_start = LocalDate.of(2016, 11, 15);
        LocalDate data_stop = LocalDate.of(2019, 06, 06);

        Period okres = Period.between(data_start, data_stop);

        System.out.println("Różnica dat: " + data_start + " i " + data_stop + " wynosi: " + okres.getYears() + " lat(a) "
                + okres.getMonths() + " miesięcy i " + okres.getDays() + " dni.");

    }
}
