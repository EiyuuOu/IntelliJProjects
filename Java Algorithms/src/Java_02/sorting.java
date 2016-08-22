package Java_02;

import Java_01.ArrayStructures;

public class sorting {

    private int[] theArray = new int[50];
    private int arraySize = 10;
    public void generateRandomArray(){
        for (int i = 0; i < arraySize; i++) {
            theArray[i] = (int) (Math.random() * 10) + 10;
        }
    }

        public void printArray() {

            System.out.println("----------");
            for (int i = 0; i < arraySize; i++) {

                System.out.print("| " + i + " | ");
                System.out.println(theArray[i] + " |");

                System.out.println("----------");

            }

        }

        public int getValueAtIndex(int index) {

            if (index < arraySize) return theArray[index];

            return 0;

        }

        public boolean doesArrayContainThisValue(int searchValue) {

            boolean valueInArray = false;

            for (int i = 0; i < arraySize; i++) {

                if (theArray[i] == searchValue) {

                    valueInArray = true;

                }

            }

            return valueInArray;

        }

        public void deleteIndex(int index) {

            if (index < arraySize) {

                for (int i = index; i < (arraySize - 1); i++) {

                    theArray[i] = theArray[i + 1];

                }

                arraySize--;

            }

        }

        public void insertValue(int value) {

            if (arraySize < 50) {

                theArray[arraySize] = value;

                arraySize++;

            }

        }

        public String linearSearchForValue(int value) {

            boolean valueInArray = false;

            String indexsWithValue = "";

            for (int i = 0; i < arraySize; i++) {

                if (theArray[i] == value) {

                    valueInArray = true;

                    indexsWithValue += i + " ";

                }

                printHorzArray(i, -1);

            }

            if (!valueInArray) {

                indexsWithValue = "None";

            }

            System.out.print("The Value was Found in the Following: " + indexsWithValue);

            System.out.println();

            return indexsWithValue;

        }

        public void printHorzArray(int i, int j) {

            for (int n = 0; n < 51; n++) System.out.print("-");

            System.out.println();

            for (int n = 0; n < arraySize; n++) {

                System.out.print("| " + n + "  ");

            }

            System.out.println("|");

            for (int n = 0; n < 51; n++) System.out.print("-");

            System.out.println();

            for (int n = 0; n < arraySize; n++) {

                System.out.print("| " + theArray[n] + " ");

            }

            System.out.println("|");

            for (int n = 0; n < 51; n++) System.out.print("-");

            System.out.println();

            // END OF FIRST PART


            // ADDED FOR BUBBLE SORT

            if (j != -1) {

                // ADD THE +2 TO FIX SPACING

                for (int k = 0; k < ((j * 5) + 2); k++) System.out.print(" ");

                System.out.print(j);

            }


            // THEN ADD THIS CODE

            if (i != -1) {

                // ADD THE -1 TO FIX SPACING

                for (int l = 0; l < (5 * (i - j) - 1); l++) System.out.print(" ");

                System.out.print(i);

            }

            System.out.println();

        }

        public void bubbleSort(){
            for (int i = arraySize - 1; i > i; i--){
                for (int j = 0; j < i; j++){
                    if(theArray[j] > theArray[j+1]){
                        swapValues(j, j+1);
                        printHorzArray(i, j);
                    }
                    printHorzArray(i, j);
                }
            }
        }

        public void swapValues(int indexOne, int indexTwo){
            int temp = theArray[indexOne];
            theArray[indexOne] = theArray[indexTwo];
            theArray[indexTwo] = theArray[temp];
        }

        public void binarySearchForValue(int value){
            int lowIndex = 0;
            int highIndex = arraySize - 1;

            while(lowIndex <= highIndex){
                int middleIndex = (highIndex + lowIndex) / 2;

                if(theArray[middleIndex] < value) lowIndex = middleIndex;
                else if (theArray[middleIndex] > value) highIndex = middleIndex;
                else {
                    System.out.println("\nFound a Match for "+value+"at Index"+middleIndex);
                    lowIndex = highIndex+1;
                }
                printHorzArray(middleIndex, -1);
            }
        }



    public static void main(String[] args){
        sorting newArray = new sorting();
        newArray.generateRandomArray();
        newArray.linearSearchForValue(11);
        newArray.bubbleSort();
        newArray.binarySearchForValue(11);

    }
}
