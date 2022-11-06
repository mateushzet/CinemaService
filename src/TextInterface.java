import java.util.Scanner;

public class TextInterface {
    Seans minionki = null ;
    Seans auta = null ;
    Seans pila = null ;
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
                seans = minionki;
                break;
            case 2:
                seans = pila;
                break;
            case 3:
                seans = auta;
                break;
            default:
                System.out.println("Wybrano niepoprawny seans");
        }



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
        String temp = sektor+Integer.toString(miejsce);
        klient.miejsce.add(temp);
        System.out.println(klient.toString());
    }
    public boolean isNotEmpty(){
       if(seans.liczbaMiejsc.get(sektor).get(miejsce) == 0)
           return false;
       else return true;
    }
}
