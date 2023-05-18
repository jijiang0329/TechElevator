package com.techelevator;

public class Scratch {

    //main
    public static void main(String[] args) {

        String christopher = "Christopher";
        String claire = "Claire";
        String angel = "Angel";
        String david = "David";

        //We can initialize an array with values right away
        String[] classRoster = {"Christopher", "Claire", "Angel", "David"};

        //We can initialize an array by just telling it how much room we need
        String[] classRoster2 = new String[17];

        //We can do this with any data type
        int[] intArray = {1,2,3,4,5}; // java can infer the size from the values we give it,
                                      // so we gave it 5 values it knows the array is size 5
        int[] intArray2 = new int[5];

        double[] doubleArray = new double[10];

        boolean[] boolArray = new boolean[5];

        //ARRAYS MUST KNOW THEIR SIZE WHEN WE DECLARE THEM
        // ARRAYS CANNOT SHRINK OR GROW - THEY WILL ALWAYS BE THAT INITIAL SIZE

        //if we want to find the length of an array, we just use the property .length
        int sizeOfArray = classRoster.length;

        //We can also initialize an array using a variable
        int length = 10;
        String[] myStringArray = new String[length];

        //THE INDEX ALWAYS STARTS AT 0
        //So to get the first element from an array, use index 0
        String firstValue = classRoster[0];
        System.out.println(firstValue);

        //To get the last element from an array - we subtract 1 from the length
        String lastValue = classRoster[ classRoster.length - 1];
        System.out.println(lastValue);

        //To get the second value
        String secondValue = classRoster[1];

        //Anytime that you see something break and complain about an IndexOutOfBoundsException it means
        //that we are referencing a location in our array that does not exist. Double check that you started at 0
        //common way to provoke the error:
        //String last = classRoster[classRoster.length];


        //Example of how to recreate a larger array, for instance adding 2 more students to our classRoster
        int newClassSize = classRoster.length + 2; // ie we have 2 new students
        String[] newClassRoster = new String[newClassSize];
        newClassRoster[0] = classRoster[0]; //copy the value from the first index of our old class to our new class
        newClassRoster[1] = classRoster[1];
        newClassRoster[2] = classRoster[2];
        newClassRoster[3] = classRoster[3];
        newClassRoster[4] = "New Student 1";
        newClassRoster[5] = "New Student 2";

        /////////////////////////////////
        // LOOPS
        //////////////////////////////////

        //While Loop
        boolean isMorning = true;
        int hour = 5;
        while(isMorning) {
            //stare at the sun
            System.out.println("We are in the loop");
            //if we are only incrementing by 1, we have an even easier shortcut than +=
            hour ++;
            if(hour >= 12) {
                //we can set the condition to false and the loop will not run again
                // isMorning = false;
                //or we can we use the keyword break
                break;
            }
        }
        System.out.println("We are out of the loop");


        String[] groceries = {"milk","eggs","bread","goldfish crackers", "apples"};

        //What's useful about loops is that we can walk through arrays
       /* int currentItem = 0;
        while(currentItem < groceries.length) {

            String groceryItem = groceries[currentItem];
            System.out.println("I bought " + groceryItem);
            currentItem++;
        } */

        //  initializor     condition              increment
        for(int item = 0; item < groceries.length; item++) {
            System.out.println("I bought " + groceries[item]);
        }


        int[] numbers = {1, 100, 22, 66, 999, 4};


        int maxNumber = numbers[0];
        int minNumber = numbers[0];

        //because we already assigned the 0 index above, we can start with index 1
        for(int i = 1; i < numbers.length; i++) {

            //check if our current max number is smaller than the new number
            if(maxNumber < numbers[i]){
                //if so, overwrite
                maxNumber = numbers[i];
            }

            if(minNumber > numbers[i]){
                minNumber = numbers[i];
            }

        }

        System.out.println("Max: " + maxNumber);
        System.out.println("Min: " + minNumber);







    }
}
