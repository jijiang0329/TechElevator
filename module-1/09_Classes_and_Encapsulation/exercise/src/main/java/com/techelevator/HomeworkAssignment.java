package com.techelevator;

public class HomeworkAssignment {
    private int earnedMarks;
    private int possibleMarks;
    private String submitterName;
    private String letterGrade;

    public HomeworkAssignment(int possibleMarks, String submitterName) {
        this.possibleMarks = possibleMarks;
        this.submitterName = submitterName;
    }

    public int getEarnedMarks() {
        return earnedMarks;
    }

    public void setEarnedMarks(int earnedMarks) {
        this.earnedMarks = earnedMarks;
    }

    public String getSubmitterName() {
        return submitterName;
    }

    public int getPossibleMarks() {
        return possibleMarks;
    }

    public String getLetterGrade() {
        int percent = earnedMarks*100 / possibleMarks;

        if (percent>=90)
            return "A";
        else if (percent>=80)
            return "B";
        else if (percent>=70)
            return "C";
        else if (percent>=60)
            return "D";
        else
            return "F";
    }
}
