package com.techelevator;

public class Main {
    public static void main(String[] args) {
        HomeworkAssignment test = new HomeworkAssignment(100, "OOP");
        test.setEarnedMarks(91);
        System.out.println(test.getLetterGrade());
    }
}
