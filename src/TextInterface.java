import java.util.Scanner;

public class TextInterface {
    Seans minionki ;
    Seans auta ;
    Seans pila ;
    String nazwisko,imie, mail;
    Seans seans;
    int telefon, miejsce;
    char sektor;
    Scanner scan = new Scanner(System.in);
    Klient klient;
    public void buyTicket(){
        char tempChar;
        int tempInt;
        int tempSeans;
        System.out.println("Witaj w serwisie JavaCinema");
        System.out.println("Podaj nazwisko:");
        nazwisko = scan.nextLine();
        System.out.println("Podaj imie:");
        imie = scan.nextLine();
        System.out.println("Podaj mail:");
        mail = scan.nextLine();

        System.out.println("Wybierz seans:");
        System.out.println("1. Minionki");
        System.out.println("2. Pila");
        System.out.println("3. Auta" );
        tempSeans = scan.nextInt();
        switch(tempSeans) {
            case 1:
                seans = .minionki;
                break;
            case 2:
                // code block
                break;
            case 3:
                // code block
                break;
            default:
                System.out.println("Wybrano niepoprawny seans");
        }

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
