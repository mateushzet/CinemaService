import java.util.LinkedList;
import java.util.List;
import java.io.Serializable;

public class Klient implements  Serializable{
    String nazwisko,imie, mail, seans;
    int telefon;
    List<String> miejsce = new LinkedList<String>();

    public Klient(String nazwisko, String imie, String mail, String seans, int telefon, List<String> miejsce) {
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.mail = mail;
        this.seans = seans;
        this.telefon = telefon;
        this.miejsce = miejsce;
    }

    @Override
    public String toString() {
        return "Klient{" +
                "nazwisko='" + nazwisko + '\'' +
                ", imie='" + imie + '\'' +
                ", mail='" + mail + '\'' +
                ", seans='" + seans + '\'' +
                ", telefon=" + telefon +
                ", miejsce=" + miejsce +
                '}';
    }
}


