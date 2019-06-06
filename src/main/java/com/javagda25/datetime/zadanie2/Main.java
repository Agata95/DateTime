package com.javagda25.datetime.zadanie2;

// Napisz aplikację, która wyświetli datę sprzed 10 dni i datę za dziesięć dni.
// Wskazówka: skorzystaj z metody plusDays() na obiekcie LocalDate.

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LocalDate data = LocalDate.now();

        LocalDate data1 = data.plusDays(10);
        LocalDate data2 = data.minusDays(10);

        System.out.println("Dzisiaj jest " + data + ", za 10 dni będzie " + data1 + ", a 10 dni temu było " + data2 + ".");

    }
}
