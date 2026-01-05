package util;

public class TotalPrice {
public static double total=0;

    public static void addToPrice(double price) {
	 total+=price;
    } 

    public static double returnTotal() {
    	return total;
    }
    

}
