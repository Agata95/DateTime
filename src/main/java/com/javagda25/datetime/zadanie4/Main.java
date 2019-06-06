package com.javagda25.datetime.zadanie4;

// Napisz aplikację, która wyświetli "różnicę" dwóch PODANYCH PRZEZ UŻYTKOWNIKA dat w formacie:
//  "years: , months: , days: "
// Wskazówka: skorzystaj z DateTimeFormatter oraz metody:
// LocalDateTime.parse(ciag_znakow, formatter).
// Do wypisania dni/lat/miesięcy z Period, wykorzystaj jego gettery.

import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        LocalDate data_start = LocalDate.now();
//        LocalDate data_stop = LocalDate.now();

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Podaj pierwszą datę:");
            String linia1 = scanner.nextLine();
            System.out.println("Podaj drugą datę:");
            String linia2 = scanner.nextLine();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            LocalDateTime data_start = LocalDateTime.parse(linia1, dateTimeFormatter);
            LocalDateTime data_stop = LocalDateTime.parse(linia2, dateTimeFormatter);

            Period okres = Period.between(data_start.toLocalDate(), data_stop.toLocalDate());

            System.out.println("Różnica dat: " + data_start + " i " + data_stop + " wynosi: " + okres.getYears() + " lat "
                    + okres.getMonths() + " miesięcy " + okres.getDays() + " dni.");
        } catch (DateTimeParseException dtpe) {
            System.err.println("Zła data");
        }

    }
}
