package com.techelevator;

public class Exercise02_BoardingGate {

    /*
    Local Jetways is a regional airline operating at local airports.
    They use a basic passenger manifest to represent seat occupancy on their plane.
        Each passenger seat is represented as an element in a boolean array.
        A value of AVAILABLE (true) indicates that seat is currently available.
        A value of OCCUPIED (false) indicates the seat is not available.
     */
    private static final boolean AVAILABLE = true;
    private static final boolean OCCUPIED = false;


    public static void main(String[] args) {
        int expectedValue = 0;
        int actualValue = 0;

        boolean[] test1 = new boolean[]{};
        actualValue = getNumberOfFullRows(test1);
        validate(0 , actualValue);

        boolean[] test2 = {OCCUPIED,OCCUPIED,OCCUPIED, AVAILABLE,AVAILABLE,AVAILABLE };
        actualValue = getNumberOfFullRows(test2);
        validate(1 , actualValue);

        boolean[] test3 = {OCCUPIED,AVAILABLE,OCCUPIED, AVAILABLE,OCCUPIED,AVAILABLE };
        actualValue = getNumberOfFullRows(test3);
        validate(0 , actualValue);

        boolean[] test4 = {OCCUPIED,OCCUPIED,OCCUPIED, OCCUPIED,OCCUPIED,OCCUPIED };
        actualValue = getNumberOfFullRows(test4);
        validate(2 , actualValue);

        boolean[] test5 = {OCCUPIED,OCCUPIED,OCCUPIED, OCCUPIED,OCCUPIED,OCCUPIED, OCCUPIED,OCCUPIED,AVAILABLE  };
        actualValue = getNumberOfFullRows(test5);
        validate(2 , actualValue);

    }

    private static void validate(int expectedValue, int actualValue){
        System.out.println("expected value:" + expectedValue + " - actual value:" + actualValue);
        System.out.println("test passed: " + (expectedValue == actualValue));
    }

    /*
    The crew determined that it would be nice to know how many rows on the plane are at full occupancy.
    Each row has three seats and a row is at full occupancy if all three seats have someone sitting in them.

    Using the boolean array, implement the logic to count the number of full rows on the plane.
    Note: A new row starts at every third element. For example, row one begins with index 0, row two begins with index 3, and so on.

    Examples:
    getNumberOfFullRows([OCCUPIED, OCCUPIED, OCCUPIED, AVAILABLE, AVAILABLE, AVAILABLE]) → 1
    getNumberOfFullRows([AVAILABLE, AVAILABLE, AVAILABLE, AVAILABLE, AVAILABLE, AVAILABLE]) → 0
    getNumberOfFullRows([OCCUPIED, AVAILABLE, AVAILABLE, OCCUPIED, AVAILABLE, AVAILABLE]) → 0
     */
    public static int getNumberOfFullRows(boolean[] seatingChart) {
        int fullRows = 0;

        for (int i = 0; i < seatingChart.length; i += 3) {
            if (seatingChart[i] == OCCUPIED && seatingChart[i + 1] == OCCUPIED && seatingChart[i + 2] == OCCUPIED ){
                fullRows++;
            }

        }
        return fullRows;
    }


}
