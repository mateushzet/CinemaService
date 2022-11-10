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
        //@@@@@@@@@@@@@@@@ odczyt danych o biletach
        String strLine;
        String dane = new String();
        FileInputStream f = new FileInputStream(".\\tickets.txt");
        DataInputStream in = new DataInputStream(f);
        BufferedReader r = new BufferedReader(new InputStreamReader(in));
        while ((strLine = r.readLine()) != null)
            dane += strLine;
        in.close();

        System.out.println("Pula wykupionych biletów");
        System.out.println(dane);

        collectPersonalData();
        chooseSeans(minionki, auta, pila);
        setSeatIdInClientClass();
        bookSeatInHashMap();
        saveClientDataToFile(dane);
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

    private void saveClientDataToFile(String dane) {
        System.out.println(klient.toString());
        try{
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(".\\klient.dat"));
        out.writeObject(klient);
        }
        catch (Exception e){
            System.out.println("error");
        }

        try{
        FileWriter f = new FileWriter(".\\tickets.txt");
        BufferedWriter out = new BufferedWriter(f);
        out.append(dane+seans.tytul+": "+sektor+Integer.toString(miejsce)+", ");
        out.newLine();
        out.close();}
        catch (Exception e){
            System.out.println("error");
        }
    }

    private void bookSeatInHashMap() {

        HashMap<Character, HashMap<Integer, Integer>> liczbaMiejsc = new HashMap<Character, HashMap<Integer, Integer>>();

        HashMap<Integer, Integer> tempHashMap = (seans.liczbaMiejsc.get(sektor));
        tempHashMap.put(miejsce,1);
        seans.liczbaMiejsc.replace(sektor, tempHashMap);
        System.out.println(seans.liczbaMiejsc);
        System.out.println(tempHashMap);
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
