package categories;

/**
 * Action book/movie category (previously Regular)
 * 
 * @author Tom Atterbury
 *         
 */
public class ActionCategory implements Category {
  
  private final int DAYS_RENTED_LIMIT = 2;
  private final double RENTAL_BASE_COST = 2;
  private final double LATE_PENALTY = 1.5;
  private final double PURCHASE_PRICE = 25.0;
  
  private static Category _genre;
  
  /**
   * Get the instance for this category of movie/book
   * 
   * @return the instance for all Action category books/movies
   */
  public synchronized static Category getInstance() {
    if (_genre == null) {
      _genre = new ActionCategory();
    }
    return _genre;
  }
  
  @Override
  public double getRentalPrice(int daysRented) {
    double cost = RENTAL_BASE_COST;
    
    // Add late penalty
    if (daysRented > DAYS_RENTED_LIMIT) {
      cost += (daysRented - DAYS_RENTED_LIMIT) * LATE_PENALTY;
    }
    
    return cost;
  }
  
  @Override
  public boolean isNewRelease() {
    return false;
  }
  
  @Override
  public double getPurchasePrice() {
    return PURCHASE_PRICE;
  }
  
  @Override
  public String toString() {
    return "Action";
  }
}
