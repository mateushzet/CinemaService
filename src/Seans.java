import java.io.Serializable;
import java.util.HashMap;

public class Seans implements Serializable {
    String tytul;
    int dzien;
    int godzina;
    int ograniczeniaWiekowe;
    HashMap<Character, HashMap<Integer, Integer>> liczbaMiejsc = new HashMap<Character, HashMap<Integer, Integer>>();

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

    public Seans(String tytul, int dzien, int godzina, int ograniczeniaWiekowe/*, HashMap<Character,HashMap<Integer, Boolean>> liczbaMiejsc*/) {
        this.tytul = tytul;
        this.dzien = dzien;
        this.godzina = godzina;
        this.ograniczeniaWiekowe = ograniczeniaWiekowe;
        fillMap();
    }

    public void fillMap(){
        HashMap<Integer, Integer> temp = new HashMap<Integer, Integer>();
        for(Integer i = 0; i<=20; i++) {
            temp.put(i,0);
        }
        liczbaMiejsc.put('a', temp);
        liczbaMiejsc.put('b', temp);
        liczbaMiejsc.put('c', temp);
        liczbaMiejsc.put('d', temp);
        liczbaMiejsc.put('e', temp);
        liczbaMiejsc.put('f', temp);
        liczbaMiejsc.put('g', temp);
        liczbaMiejsc.put('h', temp);
        liczbaMiejsc.put('i', temp);
        liczbaMiejsc.put('j', temp);

    }
}
