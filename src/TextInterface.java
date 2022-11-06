import java.util.Scanner;

public class TextInterface {
    String nazwisko,imie, mail;
    Seans seans;
    int telefon, miejsce;
    char sektor;
    Scanner scan = new Scanner(System.in);
    Klient klient;
    public void buyTicket(){
        char tempChar;
        int tempInt;
        System.out.println("Witaj w serwisie JavaCinema");
        System.out.println("Podaj nazwisko:");
        nazwisko = scan.nextLine();
        System.out.println("Podaj imie:");
        imie = scan.nextLine();
        System.out.println("Podaj mail:");
        mail = scan.nextLine();
        System.out.println("Wybierz seans:");
        seans = new Seans("tytul", 10, 10, 18);

        do {
            do {
                System.out.println("Podaj sektor:");
                tempChar = scan.next().charAt(0);
            }while( tempChar != 'a' && tempChar != 'b' && tempChar != 'c' && tempChar != 'd' && tempChar != 'e' && tempChar != 'f' && tempChar != 'g' && tempChar != 'h' &&  tempChar != 'i' && tempChar != 'j');
            sektor = tempChar;

        do {
            System.out.println("Podaj miejsce:");
            tempInt = scan.nextInt();
        }while( tempInt <1 || tempInt >20);
            miejsce = tempInt;


        } while(isNotEmpty());
        System.out.println("Podaj telefon:");
        telefon = scan.nextInt();
        klient = new Klient(nazwisko, imie, mail, seans.tytul, telefon);
        System.out.println(klient.toString());
    }
    public boolean isNotEmpty(){
       if(seans.liczbaMiejsc.get(sektor).get(miejsce) == 0)
           return false;
       else return true;
    }
}
