
/**
 * This class has the type of vehicle whether it is a car or van
 * it has several methods for checking whether the car r van could be rented or not
 */
public class VehicleType {

    private int carSeats;
    private int vanSeats = 15;
    private DateTime LastMaintenance;
    private String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    //Constructor of Car type
    public VehicleType(int seats) {
        this.carSeats = seats;
    }

    public VehicleType() {
    }

    ;

    //Constructor for Van type
    public VehicleType(int seats, DateTime LastMaintenance) {
        this.vanSeats = seats;
        this.LastMaintenance = LastMaintenance;
    }

    /**
     * @param type method to get seats of vehicle by accepting type of vehicle
     */
    public int getSeats(String type) {
        if (type.equals("car")) {
            return this.carSeats;
        } else {
            return this.vanSeats;
        }
    }

    /**
     * method to get seats of vehicle
     */
    public int getCarSeats() {
        return this.carSeats;
    }

    /**
     * method to set seats of vehicle by accepting seats
     */
    public void setCarSeats(int seats) {
        this.carSeats = seats;
    }

    /**
     * method to get index from the days array
     */
    public int indexOf(String day) {
        for (int index = 0; index < days.length; index++)
            if (days[index].equals(day))
                return index;
        return -1;
    }

    /**
     * method to get Last Maintenance
     */
    public DateTime getLastMaintenance() {
        return this.LastMaintenance;
    }

    /**
     * method to set Last Maintenance
     */
    public void setLastMaintenance(DateTime date) {
        this.LastMaintenance = date;
    }

    /**
     * @param date,type checking which day the vehicle is being rented and setting minimum days it can be rented
     *                  method to check whether a vehicle can be rented for a specific number of days
     */
    public int canBeRentedForMinimumDays(String type) {
        if (type.equals("car")) {
            return 3;
        } else {
            return 1; //van can be rented only 1 day
        }
    }

    /**
     * @param rentDate,type,numOfRentDays method to check whether a vehicle is under maintenance or not
     * @return true or false based on the input
     */
    public boolean IsUnderMaintenance(DateTime rentDate, String type, int numOfRentDays) {
        DateTime nextMaintenance = new DateTime(this.LastMaintenance, 12);
        if (type.equals("van") && numOfRentDays <= 12) {
            return false;
        } else if (type.equals("car")) {
            return false;
        }
        return true;

    }
}

