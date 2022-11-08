import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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

//            System.out.println(auta.toString());
//            System.out.println(minionki.toString());
//            System.out.println(pila.toString());

            in.close();
        } catch (Exception e) {
            System.out.println("Error nie otwarto pliku");
        }

        textInterface.buyTicket(minionki, auta, pila);
        saveSeansDataToFile(minionki, auta, pila);
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
    private void load(){

    }
}
