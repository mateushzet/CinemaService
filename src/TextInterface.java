import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class TextInterface {
    int telefon, miejsce;
    char sektor;
    String nazwisko,imie, mail;
    Seans seans;
    Klient klient;
    Scanner scan = new Scanner(System.in);
    public void buyTicket(Seans minionki, Seans auta, Seans pila) throws IOException {

        collectPersonalData();
        chooseSeans(minionki, auta, pila);
        setSeatIdInClientClass();
        bookSeatInHashMap();
        saveClientDataToFile();
    }

    private void setSeatIdInClientClass() {
        klient = new Klient(nazwisko, imie, mail, seans.tytul, telefon);
        String temp = sektor+Integer.toString(miejsce);
        klient.miejsce.add(temp);
    }

    private void collectPersonalData() {
        System.out.println("Witaj w serwisie JavaCinema");
        System.out.println("Podaj nazwisko:");
        nazwisko = scan.nextLine();
        System.out.println("Podaj imie:");
        imie = scan.nextLine();
        System.out.println("Podaj mail:");
        mail = scan.nextLine();
        System.out.println("Podaj telefon:");
        telefon = scan.nextInt();
    }

    private void chooseSeans(Seans minionki, Seans auta, Seans pila) {
        System.out.println("Wybierz seans:");
        System.out.println("1. Minionki");
        System.out.println("2. Pila");
        System.out.println("3. Auta" );
        int tempSeans;
        int tempInt;
        char tempChar;
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
    }

    private void saveClientDataToFile() {
        System.out.println(klient.toString());
        try{
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(".\\klient.dat"));
        out.writeObject(klient);
        }
        catch (Exception e){
            System.out.println("error");
        }
    }

    private void bookSeatInHashMap() {
        HashMap<Integer, Integer> tempHashMap = (seans.liczbaMiejsc.get(sektor));
        System.out.println(miejsce);
        tempHashMap.put(miejsce,1);
        seans.liczbaMiejsc.replace(sektor, tempHashMap);
        System.out.println(seans.liczbaMiejsc);
    }

    public boolean isNotEmpty(){
       if(seans.liczbaMiejsc.get(sektor).get(miejsce) == 0)
           return false;
       else{
           System.out.println();
           System.out.println("MIEJSCE ZAJĘTE");
           System.out.println();
           return true;
       }
    }
}
