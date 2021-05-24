package com.techelevator;

//implement class
public class HomeworkAssignment {

    //instance variables: Are these private because they cannot be adjusted ?
    private int earnedMarks;
    private int possibleMarks;
    private String submitterName;

//lettergrade
    //method

    public String getLetterGrade() {
        if((((double)earnedMarks / possibleMarks) * 100.0) >= 90.0) {
    return "A";

        }else if((((double)earnedMarks / possibleMarks) * 100.0) >= 80.0){
    return "B";

        }else if((((double)earnedMarks/possibleMarks) * 100.0) >=70.0) {
    return "C";

        }else if((((double)earnedMarks/possibleMarks) * 100.0) >= 60.0) {
    return"D";
        } else {
    return "F";}
        }
    //homework assignment class has a single constructor accepts two arguments

    public HomeworkAssignment (int possibleMarks, String submitterName){
       this.possibleMarks = possibleMarks;
       this.submitterName = submitterName;
    }

    public int getPossibleMarks() {
        return possibleMarks;
    }

    public String getSubmitterName() {
        return this.submitterName;
    }


    public int getEarnedMarks() {
        return this.earnedMarks;
    }

    public void setEarnedMarks(int earnedMarks){
        this.earnedMarks = earnedMarks;
    }



}







//TODO: CREATE LETTERGRADE FROM EARNEDMARKS AND POSSIBLEMARKS
//TODO: MAKE RETURNS DOUBLE FOR LETTERGRADE

