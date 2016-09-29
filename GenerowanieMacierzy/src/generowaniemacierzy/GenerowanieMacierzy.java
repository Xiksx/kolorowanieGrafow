package generowaniemacierzy;

import java.util.ArrayList;

public class GenerowanieMacierzy {

    public static ArrayList<Macierz> listaMacierzy;
    
    public static void main(String[] args) {
        listaMacierzy = new ArrayList<>();
        new GenerowanieMacierzy();
        GenerowanieMacierzy.ileChceszMacierzy(20, 4);
    }

    public static void ileChceszMacierzy(int ile,int jakirozmiar){
        for(int i = 0; i< ile;i++){
            listaMacierzy.add(new Macierz(jakirozmiar));
        }
    }
    
    public static boolean findIfOneExists(int[] table,int index){
        boolean result =false;
        for(int i=index; i<table.length;i++){
            if(table[i] == 1) {
                return true;
            }
        }
        return result;
    }
    
}
