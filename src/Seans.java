import java.io.Serializable;
import java.util.HashMap;

public class Seans implements Serializable {
    String tytul;
    int dzien;
    int godzina;
    int ograniczeniaWiekowe;
    HashMap<Character, HashMap<Integer, Boolean>> liczbaMiejsc ;

    @Override
    public String toString() {
        return "Seans{" +
                "tytul='" + tytul + '\'' +
                ", dzien=" + dzien +
                ", godzina=" + godzina +
                ", ograniczeniaWiekowe=" + ograniczeniaWiekowe +
                ", liczbaMiejsc=" + liczbaMiejsc +
                '}';
    }

    public Seans(String tytul, int dzien, int godzina, int ograniczeniaWiekowe, HashMap<Character, HashMap<Integer, Boolean>> liczbaMiejsc) {
        this.tytul = tytul;
        this.dzien = dzien;
        this.godzina = godzina;
        this.ograniczeniaWiekowe = ograniczeniaWiekowe;
        this.liczbaMiejsc = liczbaMiejsc;
    }
}
