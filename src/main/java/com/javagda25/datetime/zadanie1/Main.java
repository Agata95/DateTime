package com.javagda25.datetime.zadanie1;

// Stwórz aplikację która w pętli przyjmuje polecenie:
//        - wpisanie ‘date’ wypisuje obecny LocalDate
//        - wpisanie ‘time’ wypisuje obecny LocalTime
//        - wpisanie ‘datetime’ wypisuje obecny LocalDateTime
//        (W wybranym przez Ciebie formacie)
//    Jeśli użytkownik wpisze 'quit' to zakoncz program.

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String komenda;
        System.out.println("Dopóki nie wpiszesz QUIT wypiszę data i czas.");

        do {
            System.out.println("Wybierz dostępną opcję: " + Arrays.toString(Wybor.values()));
            komenda = scanner.nextLine();

            if (komenda.equalsIgnoreCase("quit")) {
                break;
            }

            try {
                Wybor komendy = Wybor.valueOf(komenda.toUpperCase());
                switch (komendy) {
                    case DATE:
                        LocalDate data = LocalDate.now();
                        System.out.println(data);
                        break;
                    case TIME:
                        LocalTime czas = LocalTime.now();
                        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");
                        String wynik1 = dateTimeFormatter.format(czas);
                        System.out.println(wynik1);
                        break;
                    case DATE_TIME:
                        LocalDateTime dataICzas = LocalDateTime.now();
                        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                        String wynik = dateTimeFormatter1.format(dataICzas);
                        System.out.println(wynik);
                        break;
                }
            }catch (IllegalArgumentException iae){
                System.err.println("Zły wybór");
                continue;
            }


            } while (!komenda.equalsIgnoreCase("quit")) ;

    }
}
