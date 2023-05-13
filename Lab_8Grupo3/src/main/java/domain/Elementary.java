/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Profesor Lic. Gilberth Chaves A.
 */
public class Elementary {
    private int itCounter;

    public int getItCounter() {
        return itCounter;
    }

    public void bubbleSort(int a[]){
        itCounter=0;
        for(int i=1;i<a.length;i++){
            for(int j=0;j<a.length-i;j++){
                if(a[j]>a[j+1]){
                    int aux=a[j];
                    a[j]=a[j+1];
                    a[j+1]=aux;
                }//if
                itCounter++;
            }//for j
             }//for i

    }
    
    public void improvedBubbleSort(int a[]){
        itCounter=0;
	    boolean swapped = true; //intercambiado
	    for(int i=1;swapped;i++){
            swapped = false;
            for(int j=0;j<a.length-i;j++){
                if(a[j]>a[j+1]){
                    int aux=a[j];
                    a[j]=a[j+1];
                    a[j+1]=aux;
                    swapped = true;

                }//if
                itCounter++;
            }//for j
	    }//for i

    }

    private  String minR="";
    private  String minIndexR="";

    public String getMinR() {
        return minR;
    }

    public String getMinIndexR() {
        return minIndexR;
    }

    public void selectionSort(int a[]){
        itCounter=0;
        for(int i=0;i<a.length-1;i++){
            int min=a[i];
            int minIndex=i;
            for(int j=i+1;j<a.length;j++){
                if(a[j]<min){
                    min=a[j];
                    minIndex=j;
                }//if
                itCounter++;
            }//for j
            minR+=min+" ";
            minIndexR+=minIndex+" ";
            a[minIndex]=a[i];
            a[i]=min;
        }//for i
    }
    
    public void countingSort(int a[]) {
        int max = util.Utility.maxArray(a); //va de 0 hasta el elemento maximo
        // create buckets
        int counter[] = new int[max + 1];
        // fill buckets
        for (int element : a) {
            counter[element]++; //incrementa el num de ocurrencias del elemento
        }
        // sort array
        int index = 0;
        for (int i = 0; i < counter.length; i++) {
            while (counter[i]>0) { //significa q al menos hay un elemento (q existe)
                a[index++] = i;
                counter[i]--;
            }
        }//for i
    }

}
