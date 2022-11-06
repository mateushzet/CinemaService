import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) {
        Klient klient1 = null ;
        Seans minionki = null ;
        Seans auta = null ;
        Seans pila = null ;

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ odczyt

        try {

           ObjectInputStream in = new ObjectInputStream(new FileInputStream(".\\klient.dat"));


            auta = (Seans) in.readObject();
            minionki = (Seans) in.readObject();
            pila = (Seans) in.readObject();


            System.out.println(auta.toString());
            System.out.println(minionki.toString());
            System.out.println(pila.toString());

            klient1 = (Klient) in.readObject();
            System.out.println(klient1.toString());

            in.close();
        } catch (Exception e) {
            System.out.println("Error");
        }

        TextInterface textInterface = new TextInterface();
        textInterface.buyTicket();

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@ zapis

        try {

          ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(".\\klient.dat"));
          out.writeObject(textInterface.klient);
          out.writeObject(auta);
          out.writeObject(minionki);
          out.writeObject(pila);
          out.writeObject(klient1);


            out.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
