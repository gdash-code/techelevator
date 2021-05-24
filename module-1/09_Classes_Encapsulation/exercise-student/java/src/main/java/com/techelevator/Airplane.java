package com.techelevator;

public class Airplane {
    //instance variables
    private String planeNumber;
    private int totalFirstClassSeats;
    private int bookedFirstClassSeats;
    private int totalCoachSeats;
    private int bookedCoachSeats;

    //constuctor
    public Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSeats) {
        this.planeNumber = planeNumber; //plane number assigned to the airplane
        this.totalFirstClassSeats = totalFirstClassSeats; //initial number of first class seats
        this.totalCoachSeats = totalCoachSeats; //initial number of total coach seats
    }

    public int getAvailableFirstClassSeats() {
        return totalFirstClassSeats - bookedFirstClassSeats;
    }

    public int getAvailableCoachSeats() {
        return totalCoachSeats - bookedCoachSeats;
    }

    //method
    boolean forFirstClass = true;

    public boolean reserveSeats(boolean forFirstClass, int totalNumberOfSeats) {
        if (forFirstClass) {
            if (totalFirstClassSeats - bookedFirstClassSeats >= totalNumberOfSeats) {
                bookedFirstClassSeats = totalNumberOfSeats + bookedFirstClassSeats;
                return true;
            } else {
                return false;
            }
        }
    else

    {
        if (totalCoachSeats - bookedCoachSeats >= totalNumberOfSeats) {
            bookedCoachSeats = bookedCoachSeats + totalNumberOfSeats;
            return true;
        } else {
            return false;
        }
    }

}




    public String getPlaneNumber(){
        return planeNumber;
    }
    public int getBookedFirstClassSeats(){
        return bookedFirstClassSeats;
    }
    public int getTotalFirstClassSeats(){
        return totalFirstClassSeats;
    }
    public int getBookedCoachSeats(){
        return bookedCoachSeats;
    }
    public int getTotalCoachSeats(){
        return totalCoachSeats;
    }


}
