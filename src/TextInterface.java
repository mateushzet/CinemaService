import java.io.*;
import java.util.Scanner;

public class TextInterface {
    int telefon, seat;
    char sector;
    String nazwisko,imie, mail;
    Seans seans;
    Klient klient;
    Scanner scan = new Scanner(System.in);
    public void buyTicket(Seans minionki, Seans auta, Seans pila) throws IOException {

        String ticketsData = getTicketsData();
        collectPersonalData();
        chooseSeans(minionki, auta, pila);
        setSeatIdInClientClass();
        bookSeatInHashMap();
        saveClientDataToFile(ticketsData);
    }

    private static String getTicketsData() throws IOException {
        String strLine;
        String dane = new String();
        FileInputStream f = new FileInputStream(".\\tickets.txt");
        DataInputStream in = new DataInputStream(f);
        BufferedReader r = new BufferedReader(new InputStreamReader(in));
        while ((strLine = r.readLine()) != null)
            dane += strLine;
        in.close();
        return dane;
    }

    private void setSeatIdInClientClass() {
        klient = new Klient(nazwisko, imie, mail, seans.tytul, telefon);
        String temp = sector +Integer.toString(seat);
        klient.miejsce.add(temp);
    }

    private void collectPersonalData() {
        System.out.println("Podaj nazwisko:");
        nazwisko = scan.nextLine();
        System.out.println("Podaj imie:");
        imie = scan.nextLine();

        boolean inCorrectMail;
        do {
            inCorrectMail = false;
            System.out.println("Podaj mail:");
            mail = scan.nextLine();
            if (!(mail.contains("@")) || !(mail.contains("."))){
                inCorrectMail = true;
                System.out.println("Podano niewłaściwy mail!");
            }
        }while(inCorrectMail);

        boolean inCorrectNumber;
        do{
            inCorrectNumber = false;
        System.out.println("Podaj telefon:");
        try{
        telefon = scan.nextInt();
        }catch (Exception e){
            telefon = 100000000;
        }
        if(telefon<100000000 || telefon > 999999999){
            System.out.println("Podano niewłaściwy numer!");
            inCorrectNumber = true;
        }}while(inCorrectNumber);
    }

    private void chooseSeans(Seans minionki, Seans auta, Seans pila) {
        boolean fullSeansChoosen = false;
        int tempSeans;
        int tempInt;
        char tempChar;
        do{
            System.out.println("Wybierz seans:");
            System.out.println("1. Minionki "+minionki.toString());
            System.out.println("2. Pila "+pila.toString());
            System.out.println("3. Auta "+auta.toString());
            fullSeansChoosen = false;
            tempSeans = scan.nextInt();
            switch (tempSeans) {
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
            if (seansIsFull()) {
                System.out.println("Brak wolnych miejsc na dany seans");
                fullSeansChoosen = true;
            }
        }while(fullSeansChoosen);
        System.out.println("Rozkład miejsc na danym seansie:");
        printSeans();
        do {
            do {


                System.out.println("Podaj sektor:");
                tempChar = scan.next().charAt(0);
            }while( tempChar != 'a' && tempChar != 'b' && tempChar != 'c' && tempChar != 'd' && tempChar != 'e' && tempChar != 'f' && tempChar != 'g' && tempChar != 'h' &&  tempChar != 'i' && tempChar != 'j');
            sector = tempChar;

        do {
            System.out.println("Podaj miejsce:");
            tempInt = scan.nextInt();
        }while( tempInt <0 || tempInt >20);
            seat = tempInt;


        } while(seatIsNotEmpty());
    }

    private void printSeans() {
        System.out.print("  |");
        for (int i = 0; i<10; i++) {
            System.out.print(" "+i+"|");
        }
        for (int i = 10; i<20; i++) {
            System.out.print(i+"|");
        }
        System.out.println();
        printSector('a');
        System.out.println();
        printSector('b');
        System.out.println();
        printSector('c');
        System.out.println();
        printSector('d');
        System.out.println();
        printSector('e');
        System.out.println();
        printSector('f');
        System.out.println();
        printSector('g');
        System.out.println();
        printSector('h');
        System.out.println();
        printSector('i');
        System.out.println();
        printSector('j');
        System.out.println();
    }

    private void saveClientDataToFile(String dane) {
        System.out.println();
        System.out.println("Zrealizowano rezerwacje: "+klient.toString());
        System.out.println();
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
        out.append(dane+seans.tytul+": "+ sector +Integer.toString(seat)+", ");
        out.newLine();
        out.close();}
        catch (Exception e){
            System.out.println("error");
        }
    }

    private void bookSeatInHashMap() {
        seans.liczbaMiejsc.get(sector).replace(seat,1);
    }

    public boolean seatIsNotEmpty(){
       if(seans.liczbaMiejsc.get(sector).get(seat) == 0)
           return false;
       else{
           System.out.println();
           System.out.println("MIEJSCE ZAJĘTE, wybierz inne");
           System.out.println();
           return true;
       }
    }

    public boolean sectorIsFull(char sector){
        if(seans.liczbaMiejsc.get(sector).containsValue(0))
            return false;
        else return true;
    }

    public boolean seansIsFull(){
        if(sectorIsFull('a') && sectorIsFull('b') && sectorIsFull('c') && sectorIsFull('d') && sectorIsFull('e')
           &&sectorIsFull('f') && sectorIsFull('g') && sectorIsFull('h') && sectorIsFull('i') && sectorIsFull('j'))
            return true;
        else return false;
    }

    public void printSector(char tempSector){
        System.out.print(tempSector+" |");
        for(int i = 0; i<20;i++) {
            System.out.print(seans.liczbaMiejsc.get(tempSector).get(i)+" |");
        }
    }
}
