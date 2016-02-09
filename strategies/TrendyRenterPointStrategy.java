package strategies;

import agents.Customer;
import rentables.Rentable;
import rentables.Rental;

/**
 * Frequent Renter Point Strategy for trendy young customers who rent new
 * releases
 * 
 * @author Tom Atterbury
 *        
 */
public class TrendyRenterPointStrategy implements RenterPointStrategy {
  
  @Override
  public int calculateFrequentRenterPoints(Customer customer) {
    int points = 0;
    boolean anyNewReleasesRented = false;
    
    for (Rental rental : customer.getRentals()) {
      Rentable product = rental.getProduct();
      if (product.isNewRelease() && !anyNewReleasesRented)
        anyNewReleasesRented = true;
        
      // Start earning double frequent renter points for young adult customers
      // who have rented at least one new release item
      if (anyNewReleasesRented
          && (18 <= customer.getAge() && customer.getAge() <= 22))
        points++;
        
      points++;
    }
    
    /*
     * // Earn double frequent renter points for young adult customers who have
     * // rented at least one new release item if (anyNewReleasesRented && (18
     * <= customer.getAge() && customer.getAge() <= 22)) points *= 2;
     */
    return points;
  }
  
}
