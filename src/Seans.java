import java.io.Serializable;
import java.util.HashMap;

public class Seans implements Serializable {
    String tytul;
    int dzien;
    int godzina;
    int ograniczeniaWiekowe;
    HashMap<Character, HashMap<Integer, Integer>> liczbaMiejsc ;

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
        for(int i = 0; i<=20; i++){
            liczbaMiejsc.put('a', new HashMap<Integer,Integer>(i,0));
            liczbaMiejsc.put('b', new HashMap<Integer,Integer>(i,0));
            liczbaMiejsc.put('c', new HashMap<Integer,Integer>(i,0));
            liczbaMiejsc.put('d', new HashMap<Integer,Integer>(i,0));
            liczbaMiejsc.put('e', new HashMap<Integer,Integer>(i,0));
            liczbaMiejsc.put('f', new HashMap<Integer,Integer>(i,0));
            liczbaMiejsc.put('g', new HashMap<Integer,Integer>(i,0));
            liczbaMiejsc.put('h', new HashMap<Integer,Integer>(i,0));
            liczbaMiejsc.put('i', new HashMap<Integer,Integer>(i,0));
            liczbaMiejsc.put('j', new HashMap<Integer,Integer>(i,0));
        }
    }
}
