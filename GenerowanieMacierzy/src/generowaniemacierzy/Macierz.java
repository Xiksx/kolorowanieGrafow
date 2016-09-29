/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generowaniemacierzy;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author j
 */
public class Macierz {
    
    public int[][] macierzPrzejsc;
    public int maxKlika;
    
    public Macierz(int size){
        int[][] macierz = new int[size][size];
        
        int val = size-1;
        Random rand = new Random();
        
        //pętla wierszy
        for(int i=0; i<size-1; i++){
            //pętla kolumn
            for(int j=i; j<size; j++){
                if(i==j) {
                    macierz[i][j] = 0;
                    macierz[j][i] = 0;
                } else {
                    int temp = (int) Math.round(rand.nextDouble());
                    macierz[i][j] = temp;
                    macierz[j][i] = temp;
                }
            };
            int[] row = macierz[i];
            if(!GenerowanieMacierzy.findIfOneExists(row, i)){
                int j = ((i+1)+rand.nextInt(size-i-1));
                macierz[i][j] = 1;
                macierz[j][i] = 1;
            }
        }
        macierzPrzejsc = macierz;
        maxKlika = BronKerbosh();
    }
    
    public static void WypiszNaEkran(Macierz matrix){
        int[][] macierzPrzejsc = matrix.macierzPrzejsc;
        int size = macierzPrzejsc.length;
        System.out.println("---------------------------");
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.print(macierzPrzejsc[i][j]);
            }
            System.out.println();
        }
        System.out.println("---------------------------");
    }
    
    private int BronKerbosh(int lWierzcholkow, ArrayList<Integer> czesciowyWynik, ArrayList<Integer> kandydaci, ArrayList<Integer> pominiete){
    
        if(kandydaci.size() == 0 || pominiete.size() == 0) return czesciowyWynik.size();
    
        ArrayList<Integer> zbiorN = new ArrayList<>();
        ArrayList<Integer> sasiad = new ArrayList<>();
        for(int v : kandydaci){
            for(int i =0;i<this.macierzPrzejsc.length; i++){
                if(macierzPrzejsc[v][i]==1) sasiad.add(i);
            }
            zbiorN.clear();
            for(int sas : sasiad){
                zbiorN.add(sas);
            }
            
            BronKerbosh(lWierzcholkow,czesciowyWynik.add(v),kandydaci.removeAll(zbiorN));
        }

        return -1;
    }
}
