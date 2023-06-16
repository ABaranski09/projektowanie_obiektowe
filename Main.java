import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Ksiazka {
    private String tytul;
    private boolean dostepna;
    public Ksiazka(String tytul) {
        this.tytul = tytul;
        this.dostepna = true;
    }
    public String getTytul() {
        return tytul;
    }
    public boolean isDostepna() {
        return dostepna;
    }
    public void setDostepna(boolean dostepna) {
        this.dostepna = dostepna;
    }
}
class WypozyczalniaKsiazek {
    private List<Ksiazka> ksiazki;

    public WypozyczalniaKsiazek() {
        this.ksiazki = new ArrayList<>();
    }
    public void dodajKsiazke(Ksiazka ksiazka) {
        ksiazki.add(ksiazka);
    }
    public void wypozyczKsiazke(String tytul) {
        for (Ksiazka ksiazka : ksiazki) {
            if (ksiazka.getTytul().equals(tytul)) {
                if (ksiazka.isDostepna()) {
                    ksiazka.setDostepna(false);
                    System.out.println("Książka '" + tytul + "' została wypożyczona.");
                } else {
                    System.out.println("Książka '" + tytul + "' jest niedostępna.");
                }
                return;
            }
        }
        System.out.println("Książka o tytule '" + tytul + "' nie istnieje w wypożyczalni.");
    }
}
public class Main {
    public static void main(String[] args) {
        WypozyczalniaKsiazek wypozyczalnia = new WypozyczalniaKsiazek();

        wypozyczalnia.dodajKsiazke(new Ksiazka("Harry Potter i Kamień Filozoficzny"));
        wypozyczalnia.dodajKsiazke(new Ksiazka("Władca Pierścieni: Drużyna Pierścienia"));
        wypozyczalnia.dodajKsiazke(new Ksiazka("Metro 2033"));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Podaj tytuł książki do wypożyczenia (lub 'end' aby zakończyć): ");
            String tytul = scanner.nextLine();

            if (tytul.equalsIgnoreCase("end")) {
                break;
            }

            wypozyczalnia.wypozyczKsiazke(tytul);
        }

        scanner.close();
    }
}