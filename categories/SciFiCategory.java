package categories;

/**
 * Behavior for a science fiction book/movie
 * 
 * @author Tom Atterbury
 *         
 */
public class SciFiCategory implements Category {
  
  private final int DAYS_RENTED_ALLOWANCE = 3;
  private final double RENTAL_BASE_COST = 1.5;
  private final double LATE_PENALTY = 1.5;
  private final double PURCHASE_PRICE = 16.0;
  
  private static Category _genre;
  
  /**
   * Singleton instantiation of this category
   * 
   * @return the instance of a sci-fi category item
   */
  public synchronized static Category getInstance() {
    if (_genre == null) {
      _genre = new SciFiCategory();
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
  
  @Override
  public boolean isNewRelease() {
    return false;
  }
  
  @Override
  public String toString() {
    return "Science Fiction";
  }
}
