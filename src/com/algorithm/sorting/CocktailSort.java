package com.algorithm.sorting;

public class CocktailSort {
    private void swapValue(int[] array, int before, int after) {
        int tmp = array[before];
        array[before] = array[after];
        array[after] = tmp;
    }

    private int[] cocktailSort(int[] array) {
        boolean status;
        int bottom = 0;
        int top = array.length;

        while(true) {
            // Left -> Right
            status = false;
            for(int up = 0; up < top - 1; up++) {
                if(array[up] > array[up + 1]) {
                    swapValue(array, up, up + 1);
                    status = true;
                }
            }
            if(!status)
                return array;

            // Right -> Left
            top--;
            status = false;
            for(int down = top; down > bottom; down--) {
                if(array[down] < array[down - 1]) {
                    swapValue(array, down - 1, down);
                    status = true;
                }
            }

            if(!status)
                return array;
            bottom++;
        }
    }
    public static void main(String[] args) {
        CocktailSort s = new CocktailSort();
        int[] sorted = s.cocktailSort(new int[] {5, 9, 1, 4, 8, 2, 0, 6});

        System.out.print("Sorted: ");
        for(int x: sorted) {
            System.out.print(x + " ");
        }

        /*
         * Time complexity: O(n^2)
         * Space complexity: O(n)
         */
    }
}
