package strategies;

import agents.Customer;

/**
 * Frequent Renter Point Strategy interface
 * 
 * @author Tom Atterbury
 *        
 */
public interface RenterPointStrategy {
  public int calculateFrequentRenterPoints(Customer customer);
}
