import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) {
        Klient klient = new Klient("ziecina","mateusz","mati@onet.pl","minionki",293849489);
        Seans seans = new Seans("tytul",10, 10, 18);

        // tworzymy obiekt klasy ObjectOutputStream do zapisywania do pliku
        ObjectOutputStream wy = new ObjectOutputStream(new FileOutputStream(".\\klient.dat"));
    }
}
