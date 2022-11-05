import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) {
        Klient mateusz = new Klient("ziecina","mateusz","mati@onet.pl","minionki",293849489);
        Seans seans = new Seans("tytul",10, 10, 18);
try {

    // tworzymy obiekt klasy ObjectOutputStream do zapisywania do pliku
    ObjectOutputStream wy = new ObjectOutputStream(new FileOutputStream(".\\klient.dat"));

    // no i zapisujemy
    wy.writeObject(mateusz);
    wy.close();
}catch (Exception e) {System.out.println("Error");}

// tworzymy obiekt klasy ObjectInputStream do odczytywania z pliku
        ObjectInputStream we = new ObjectInputStream(new FileInputStream(".\\klient.dat"));

        // odczytujemy z pliku; (klient) - to rzutowanie z Object na klient
        Klient k1 = (Klient) we.readObject();

        // i ładnie na konsolę wyrzucamy wynik
        System.out.println(k1);
        Klient p2 = (Klient)we.readObject();
        System.out.println(p2);
        we.close();
    }
}
