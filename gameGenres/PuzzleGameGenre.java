package gameGenres;

/**
 * Puzzle games genre behavior definition
 * 
 * @author Tom Atterbury
 *         
 */
public class PuzzleGameGenre implements GameGenre {
  
  private final int DAYS_RENTED_ALLOWANCE = 2;
  private final double RENTAL_BASE_COST = 2;
  private final double LATE_PENALTY = 1.5;
  private final double PURCHASE_PRICE = 10.0;
  
  private static GameGenre _genre;
  
  /**
   * All genres are singletons, so we control instance creation
   * 
   * @return an instance of a puzzle game type
   */
  public synchronized static GameGenre getInstance() {
    if (_genre == null) {
      _genre = new PuzzleGameGenre();
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
   * Always false
   */
  public boolean isNewRelease() {
    return false;
  }
  
  @Override
  public String toString() {
    return "Puzzle";
  }
}
