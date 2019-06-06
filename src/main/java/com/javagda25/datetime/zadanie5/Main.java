package com.javagda25.datetime.zadanie5;

// Napisz aplikację, która obliczy twój wiek. Podaj wiek w dniach i latach, ale także w sekundach
// (użyj klasy Period i Duration!)

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            System.out.println("Podaj swoją datę urodzin w formie YYYY-MM-DD:");
            String linia = scanner.nextLine();

            LocalDate data_start = LocalDate.parse(linia, dateTimeFormatter);
            LocalDate dataObecna = LocalDate.now();


            Period okres = Period.between(data_start, dataObecna);

            System.out.println("Od moich urodzin minęło: " + okres.getYears() + " lat(a) "
                    + okres.getMonths() + " miesięcy i " + okres.getDays() + " dni.");

            Duration sekundy = Duration.between(data_start.atStartOfDay(), dataObecna.atStartOfDay());
            System.out.println("Od moich urodzin minęło: " + sekundy.getSeconds() + " sekund.");

        } catch (DateTimeParseException dtpe) {
            System.err.println("Zła data");
        }
    }
}
