import java.util.LinkedList;
import java.util.List;
import java.io.Serializable;

public class Klient implements  Serializable{
    int telefon;
    String nazwisko, imie, mail, seans;
    List<String> miejsce = new LinkedList<String>();
    public Klient(String nazwisko, String imie, String mail, String seans, int telefon) {
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.mail = mail;
        this.seans = seans;
        this.telefon = telefon;
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


