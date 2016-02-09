package strategies;

import agents.Customer;
import rentables.Rental;

/**
 * Default Frequent Renter Point Strategy, this is how it originally was done
 * 
 * @author Tom Atterbury
 *         
 */
public class DefaultRenterPointStrategy implements RenterPointStrategy {
  
  private final int BONUS_POINT_RENTAL_LENGTH_MINIMUM = 2;
  
  @Override
  public int calculateFrequentRenterPoints(Customer customer) {
    int points = 0;
    
    for (Rental rental : customer.getRentals()) {
      // Add bonus points for new releases that were rented for 2+ days
      if (rental.getProduct().isNewRelease()
          && (rental.getDaysRented() >= BONUS_POINT_RENTAL_LENGTH_MINIMUM)) {
        points++;
      }
      points++;
    }
    
    return points;
  }
  
}
