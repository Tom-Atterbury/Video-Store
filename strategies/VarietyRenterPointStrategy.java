package strategies;

import java.util.HashSet;
import agents.Customer;
import rentables.Rentable;
import rentables.Rental;

/**
 * Frequent Renter Point Strategy for customers who tend to rent a variety of
 * different categories and items
 * 
 * @author Tom Atterbury
 *         
 */
public class VarietyRenterPointStrategy implements RenterPointStrategy {
  
  @Override
  public int calculateFrequentRenterPoints(Customer customer) {
    int points = 0;
    HashSet<Integer> categories = new HashSet<Integer>();
    
    for (Rental rental : customer.getRentals()) {
      Rentable product = rental.getProduct();
      categories.add(product.getCategoryHash());
      points++;
      
      // If the renter has rented more than 2 different kinds/categories of
      // rentals, they start earning double points
      if (categories.size() > 2) points++;
    }
    
    /*
     * // If the renter has rented more than 2 different kinds/categories of //
     * rentals, double the number of total points if (categories.size() > 2)
     * points *= 2;
     */
    return points;
  }
  
}
