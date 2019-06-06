package com.javagda25.datetime.zadanie4;

// Napisz aplikację, która wyświetli "różnicę" dwóch PODANYCH PRZEZ UŻYTKOWNIKA dat w formacie:
//  "years: , months: , days: "
// Wskazówka: skorzystaj z DateTimeFormatter oraz metody:
// LocalDateTime.parse(ciag_znakow, formatter).
// Do wypisania dni/lat/miesięcy z Period, wykorzystaj jego gettery.

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            System.out.println("Podaj pierwszą datę w formie YYYY-MM-DD:");
            String linia1 = scanner.nextLine();
            System.out.println("Podaj drugą datę w formie YYYY-MM-DD:");
            String linia2 = scanner.nextLine();

            LocalDate data_start = LocalDate.parse(linia1, dateTimeFormatter);
            LocalDate data_stop = LocalDate.parse(linia2, dateTimeFormatter);

            Period okres = Period.between(data_start, data_stop);

            System.out.println("Różnica dat: " + data_start + " i " + data_stop + " wynosi: " + okres.getYears() + " lat(a) "
                    + okres.getMonths() + " miesięcy i " + okres.getDays() + " dni.");
        } catch (DateTimeParseException dtpe) {
            System.err.println("Zła data");
        }

    }
}
