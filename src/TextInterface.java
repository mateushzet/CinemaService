import java.util.Scanner;

public class TextInterface {
    String nazwisko,imie, mail, seans;
    int telefon;
    Scanner scan = new Scanner(System.in);
    Klient klient;
    public void buyTicket(){
        System.out.println("Witaj w serwisie JavaCinema");
        System.out.println("Podaj nazwisko:");
        nazwisko = scan.nextLine();
        System.out.println("Podaj imie:");
        imie = scan.nextLine();
        System.out.println("Podaj mail:");
        mail = scan.nextLine();
        System.out.println("Podaj seans:");
        seans = scan.nextLine();
        System.out.println("Podaj telefon:");
        telefon = scan.nextInt();
        klient = new Klient(nazwisko, imie, mail, seans, telefon);
        klient.toString();
    }
    public boolean verify(){

    }
}
