package gameGenres;

/**
 * Video game genre for shooter games
 * 
 * @author Tom Atterbury
 *         
 */
public class ShooterGameGenre implements GameGenre {
  
  private final int DAYS_RENTED_ALLOWANCE = 2;
  private final double RENTAL_BASE_COST = 2;
  private final double LATE_PENALTY = 1.5;
  private final double PURCHASE_PRICE = 40.0;
  
  private static GameGenre _genre;
  
  /**
   * Singleton instance shared by all shooter games
   * 
   * @return instance of a shooter game genre
   */
  public synchronized static GameGenre getInstance() {
    if (_genre == null) {
      _genre = new ShooterGameGenre();
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
   * Shooter games are not new releases, returns false
   */
  public boolean isNewRelease() {
    return false;
  }
  
  @Override
  public String toString() {
    return "Shooter";
  }
}
