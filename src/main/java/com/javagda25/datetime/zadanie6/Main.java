package com.javagda25.datetime.zadanie6;

// Napisz aplikację która po odpowiedzi użytkownika na pytania:
//    1) Podaj datę urodzenia w formacie: yyyy-MM-dd":
//    2) Kobieta, czy mężczyzna (k/m) - mężczyźni żyją średnio o 10 lat krócej
//    3) Czy palisz papierosy? y/n   (palący żyją średnio 9 lat i 3 miesiące krócej)
//    4) Czy żyjesz w stresie? (jeśli tak, istnieje 10% prawdopodobieństwo, że umrzesz na zawał serca w wieku 60 lat)
//
//
// Wskazówka dot. ‘prawdopodobieństwa’:
//
// Random generator = new Random();
// int losowaLiczba = generator.nextInt(100);
// if (losowaLiczba < 10) {
//    // 10 %
// }
//
// ...poda użytkownikowi przybliżoną datę śmierci. Załóż, że "startowa" długość życia to 100 lat. Aplikacja ma podawać
// datę z dokładnością do miesiąca. Możesz dodać dodatkowe warunki. Możesz użyc klasy java.time.Period
//
// * Wyświetl na końcu, ile użytkownik stracił czasu na bezsensownym sprawdzaniu daty śmierci
// **(+300pkt) Dodaj nowe dodatkowe warunki i randomizuj niektóre wartości

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj datę urodzenia w formacie: yyyy-MM-dd\":");
        String linia1 = scanner.nextLine();

        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dataUrodzenia = LocalDate.parse(linia1, format);
        LocalDate dlugoscZycia = dataUrodzenia.plusYears(100);
        System.out.println(dlugoscZycia);


        System.out.println("Kobieta, czy mężczyzna? (k/m)");
        String linia2 = scanner.nextLine();
        LocalDate a = dlugoscZycia;

        if (linia2.equalsIgnoreCase("m")) {

            a = dlugoscZycia.minusYears(10);
        }

        System.out.println(a);


        System.out.println("Czy palisz papierosy? (y/n)");
        String linia3 = scanner.nextLine();
        LocalDate b = a;

        if (linia3.equalsIgnoreCase("y")) {
            b = a.minusYears(9).minusMonths(3);
        }
        System.out.println(b);


        System.out.println("Czy żyjesz w stresie? (y/n)");
        String linia4 = scanner.nextLine();
        LocalDate c = b;
        Random random = new Random();
        int losowaLiczba = random.nextInt(100);
        if (linia4.equalsIgnoreCase("y")) {
            if (losowaLiczba < 10) {
                c = dlugoscZycia.minusYears(40);
            }
        }
        System.out.println("Wysolowana liczba: " + losowaLiczba);

        System.out.println("Prawdopodobnie Twoja data śmierci to: " + c);
        Period okres = Period.between(dataUrodzenia,c);

        System.out.println("Będziesz żył: " + okres.getYears() + " lat i " + okres.getMonths() + " miesięcy.");


    }
}
