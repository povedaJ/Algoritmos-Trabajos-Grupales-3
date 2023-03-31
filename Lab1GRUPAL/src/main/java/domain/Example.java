package domain;

public class Example {

    /** Returns the sum of the integers in given array.
     * @param arr
     * @return  */
    public int example1(int[] arr) {
        int n = arr.length, total = 0;
        for (int j=0; j < n; j++) // loop from 0 to n-1
            total += arr[j];
        return total;
    }

    /** Returns the sum of the integers with even index in given array.
     * @param arr
     * @return  */
    public int example2(int[] arr) {
        int n = arr.length, total = 0;
        for (int j=0; j < n; j += 2) // note the increment of 2
            total += arr[j];
        return total;
    }

    /** Returns the sum of the prefix sums of given array.
     * @param arr
     * @return  */
    public int example3(int[] arr) {
        int n = arr.length, total = 0;
        for (int j=0; j < n; j++) // loop from 0 to n-1
            for (int k=0; k <= j; k++) // loop from 0 to j
                total += arr[j];
        return total;
    }

    /** Returns the sum of the prefix sums of given array.
     * @param arr
     * @return  */
    public int example4(int[] arr) {
        int n = arr.length, prefix = 0, total = 0;
        for (int j=0; j < n; j++) { // loop from 0 to n-1
            prefix += arr[j];
            total += prefix;
        }
        return total;
    }

    /** Returns the number of times second array stores sum of prefix sums from first.
     * @param first
     * @param second
     * @return  */
    public int example5(int[] first, int[] second) { // assume equal-length arrays
        int n = first.length, count = 0;
        for (int i=0; i < n; i++) { // loop from 0 to n-1
            int total = 0;
            for (int j=0; j < n; j++) // loop from 0 to n-1
                for (int k=0; k <= j; k++) // loop from 0 to j
                    total += first[k];
            if (second[i] == total) count++;
        }
        return count;
    }

}
