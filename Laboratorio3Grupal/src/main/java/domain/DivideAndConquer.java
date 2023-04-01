package domain;

public class DivideAndConquer {
    public static int binarySearch(int sortedArray[], int value){
        int low = 0;
        int high = sortedArray.length-1;
        int middle = (low+high)/2;
        while ((low<=high) && (sortedArray[middle]!=value)) {
            if (value<sortedArray[middle])
                high = middle - 1;
            else
                low = middle + 1;
            middle = (low+high)/2;
        }//while
        if (low>high)
            return -1; //element doesn't exist
        return middle;
    }
    public static int binarySearchRecursive (int sortedArray[], int value, int low, int high){
        int middle = (low+high)/2;
        if(low>high)
            return -1;
        else if(value==sortedArray[middle])
            return middle;
        else if (value<sortedArray[middle])
            return binarySearchRecursive(sortedArray, value, low, middle-1);
        else
            return binarySearchRecursive(sortedArray, value, middle+1, high);
    }
}
