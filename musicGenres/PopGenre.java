package musicGenres;

/**
 * Popular music item genre
 * 
 * @author Tom Atterbury
 *        
 */
public class PopGenre implements MusicGenre {
  
  private final int DAYS_RENTED_ALLOWANCE = 2;
  private final double RENTAL_BASE_COST = 2;
  private final double LATE_PENALTY = 1.5;
  private final double PURCHASE_PRICE = 25.0;
  
  private static MusicGenre _genre;
  
  /**
   * Ensures this genre is a singleton
   * @return instance of a Pop music genre
   */
  public synchronized static MusicGenre getInstance() {
    if (_genre == null) {
      _genre = new PopGenre();
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
   * Pop music cannot be new release at this time, returns false
   */
  public boolean isNewRelease() {
    return false;
  }
  
  @Override
  public String toString() {
    return "Pop";
  }
}
