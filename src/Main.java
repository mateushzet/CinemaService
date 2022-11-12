import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Seans minionki = null;
        Seans auta = null;
        Seans pila = null;

        //     Pobieranie klas z pliku

        TextInterface textInterface = new TextInterface();
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(".\\seans.dat"));

            auta = (Seans) in.readObject();
            minionki = (Seans) in.readObject();
            pila = (Seans) in.readObject();
            in.close();
        } catch (Exception e) {
            System.out.println("Error nie otwarto pliku");
        }

        startService(minionki, auta, pila, textInterface);
    }

    private static void startService(Seans minionki, Seans auta, Seans pila, TextInterface textInterface) throws IOException {
        while(true) {
            printMainMenu();
            Scanner sc = new Scanner(System.in);
            int x = sc.nextInt();
            switch (x) {
                case 1:
                    String ticketsData = getTicketsData();
                    printTicketsPool(ticketsData);
                    break;
                case 2:
                    textInterface.buyTicket(minionki, auta, pila);
                    saveSeansDataToFile(minionki, auta, pila);
                    break;
                default:
                    break;
            }

                }
    }

    private static void printMainMenu() {
        System.out.println("Witaj w serwisie rezerwacji biletów JAVA CINEMA");
        System.out.println("Wybierz opcje:");
        System.out.println("1) zarezerwowane bilety");
        System.out.println("2) zarezerwuj bilet");
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

    private static void printTicketsPool(String dane) {
        System.out.println();
        System.out.println("Pula wykupionych biletów");
        System.out.println(dane);
        System.out.println();
    }

    private static void saveSeansDataToFile(Seans minionki, Seans auta, Seans pila) {
        try {
          ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(".\\seans.dat"));
          out.writeObject(auta);
          out.writeObject(minionki);
          out.writeObject(pila);
            out.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
