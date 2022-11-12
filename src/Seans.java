import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Seans implements Serializable {

    private static final long serialVersionUID = 951731988235421841L;
    String tytul;
    int dzien;
    int godzina;
    int ograniczeniaWiekowe;
    HashMap<Character, HashMap<Integer, Integer>> liczbaMiejsc = new HashMap<Character, HashMap<Integer, Integer>>();
    @Override
    public String toString() {
        return
                "dzien: " + dzien +
                ", godzina: " + godzina +
                ", ograniczeniaWiekowe: " + ograniczeniaWiekowe;
    }
    public Seans(String tytul, int dzien, int godzina, int ograniczeniaWiekowe) {
        this.tytul = tytul;
        this.dzien = dzien;
        this.godzina = godzina;
        this.ograniczeniaWiekowe = ograniczeniaWiekowe;
        fillMap();
    }
    public void fillMap(){
        ArrayList<HashMap<Integer, Integer>> hashMapList = new ArrayList<HashMap<Integer, Integer>>();
        for(int j = 0; j<10;j++)
            hashMapList.add(new HashMap<Integer,Integer>());
        for(Integer i = 0; i<=20; i++) {
            for(int j = 0; j<10;j++)
                 hashMapList.get(j).put(i,0);
        }
        liczbaMiejsc.put('a', hashMapList.get(0));
        liczbaMiejsc.put('b', hashMapList.get(1));
        liczbaMiejsc.put('c', hashMapList.get(2));
        liczbaMiejsc.put('d', hashMapList.get(3));
        liczbaMiejsc.put('e', hashMapList.get(4));
        liczbaMiejsc.put('f', hashMapList.get(5));
        liczbaMiejsc.put('g', hashMapList.get(6));
        liczbaMiejsc.put('h', hashMapList.get(7));
        liczbaMiejsc.put('i', hashMapList.get(8));
        liczbaMiejsc.put('j', hashMapList.get(9));

    }
}
