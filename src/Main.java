import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Seans minionki = null;
        Seans auta = null;
        Seans pila = null;
        TextInterface textInterface = new TextInterface();

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ odczyt
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(".\\seans.dat"));

            auta = (Seans) in.readObject();
            minionki = (Seans) in.readObject();
            pila = (Seans) in.readObject();
            in.close();
        } catch (Exception e) {
            System.out.println("Error nie otwarto pliku");
        }
while(true) {
    System.out.println("Witaj w serwisie rezerwacji biletów JAVA CINEMA");
    System.out.println("Wybierz opcje:");
    System.out.println("1) zarezerwowane bilety");
    System.out.println("2) zarezerwuj bilet");
    Scanner sc = new Scanner(System.in);
    int x = sc.nextInt();
    switch (x) {
        case 1:
            String strLine;
            String dane = new String();
            FileInputStream f = new FileInputStream(".\\tickets.txt");
            DataInputStream in = new DataInputStream(f);
            BufferedReader r = new BufferedReader(new InputStreamReader(in));
            while ((strLine = r.readLine()) != null)
                dane += strLine;
            in.close();
            System.out.println();
            System.out.println("Pula wykupionych biletów");
            System.out.println(dane);
            System.out.println();
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
