import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

    public static void main(String[] args) {
        Klient klient1 = null ;
        TextInterface textInterface = new TextInterface();

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ odczyt

        try {

           ObjectInputStream in = new ObjectInputStream(new FileInputStream(".\\klient.dat"));


            textInterface.auta = (Seans) in.readObject();
            textInterface.minionki = (Seans) in.readObject();
            textInterface.pila = (Seans) in.readObject();


            System.out.println(textInterface.auta.toString());
            System.out.println(textInterface.minionki.toString());
            System.out.println(textInterface.pila.toString());

            klient1 = (Klient) in.readObject();
            System.out.println(klient1.toString());

            in.close();
        } catch (Exception e) {
            System.out.println("Error");
        }

        textInterface.buyTicket();

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@ zapis

        try {

          ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(".\\klient.dat"));
          out.writeObject(textInterface.klient);
          out.writeObject(textInterface.auta);
          out.writeObject(textInterface.minionki);
          out.writeObject(textInterface.pila);
          out.writeObject(klient1);


            out.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
