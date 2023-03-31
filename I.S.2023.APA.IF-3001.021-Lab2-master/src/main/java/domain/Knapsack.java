package domain;

import java.util.Arrays;

public class Knapsack {
    private Item[] list; //lista de objetos candidatos para la mochila
    private double capacity; //capacidad máxima en la mochila

    public Knapsack(Item[] list, double capacity) {
        this.list = list;
        this.capacity = capacity;
    }

    private void bubbleSort() {
        int n = list.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if(list[j].getValueWeight()<list[j+1].getValueWeight()){
                    Item temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;

                }
                /*if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }*/
    }

    //Devuelve una lista con los objetos agregados a la mochila
    public Item[] solve(){
    bubbleSort(); //primero ordeno la lista de objetos tipo Item
        Item knapsackList[] = new Item[this.list.length];
        int i=0; int j=0;
        double totalWeight = 0; //total de peso agregado a la mochila
        int n = list.length;
        while(i<n){
            if(totalWeight+list[i].getWeight()<=capacity){
                //sumo el peso del elemento a cargar
                totalWeight+=list[i].getWeight();
                //agrego el elemento a la mochila
                knapsackList[j++] = list[i];
            }
            //si no entra al if es porque el elemento no se puede
            //agregar a la mochila
            i++; //incremento la pos del indice
        }
        return knapsackList; //método que resuelve el problema
    }

    @Override
    public String toString() {
       double totalWeight=0;
       double totalValue=0;
       Item solution[] = solve();
       String result="\nKNAPSACK PROBLEM SOLUTION";
       result+="\nMAX WEIGHT: "+this.capacity;
       result+="\nITEMS LIST...";
       result+="\n\t\tName\t\t\t\tValue\t\t\tWeight";
       int n = solution.length;
        for (int i = 0; i < n; i++) {
            Item item = solution[i];
            if(item==null) break; //rompe el bucle for
            totalWeight+=item.getWeight();
            totalValue+=item.getValue();
            result+="\n("+(i+1)+")"+item.toString();
        }
        result+="\nTOTALS:\t\t\t\t\t\t\t$"+util.Utility.format(totalValue);
        result+="\t\t\t"+util.Utility.format(totalWeight);
        return result;
    }
}
