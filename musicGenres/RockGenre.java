package musicGenres;

/**
 * Music genre for Rock 'n Roll music items
 * 
 * @author Tom Atterbury
 *         
 */
public class RockGenre implements MusicGenre {
  
  private final int DAYS_RENTED_ALLOWANCE = 3;
  private final double RENTAL_BASE_COST = 1.5;
  private final double LATE_PENALTY = 1.5;
  private final double PURCHASE_PRICE = 20.0;
  
  private static MusicGenre _genre;
  
  /**
   * Make this a singleton, only one is needed to specify behavior for all Rock
   * music rentals/purchases
   * 
   * @return instantiated Genre category for music items
   */
  public synchronized static MusicGenre getInstance() {
    if (_genre == null) {
      _genre = new RockGenre();
    }
    return _genre;
  }
  
  @Override
  public double getRentalPrice(int daysRented) {
    double cost = RENTAL_BASE_COST;
    
    // Add late penalty
    if (daysRented > DAYS_RENTED_ALLOWANCE) {
      cost += (daysRented - DAYS_RENTED_ALLOWANCE) * LATE_PENALTY;
    }
    return cost;
  }
  
  @Override
  public double getPurchasePrice() {
    return PURCHASE_PRICE;
  }
  
  /**
   * All Rock music genres are not new release items, returns false
   */
  public boolean isNewRelease() {
    return false;
  }
  
  @Override
  public String toString() {
    return "Rock";
  }
}
