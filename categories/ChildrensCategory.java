package categories;

/**
 * Children's category for books/movies
 * 
 * @author Tom Atterbury
 *         
 */
public class ChildrensCategory implements Category {
  
  private final int DAYS_RENTED_ALLOWANCE = 3;
  private final double RENTAL_BASE_COST = 1.5;
  private final double LATE_PENALTY = 1.5;
  private final double PURCHASE_PRICE = 20.0;
  
  private static Category _category;
  
  /**
   * Children's category singleton instance retreival
   * 
   * @return the instance for a children's book/movie
   */
  public synchronized static Category getInstance() {
    if (_category == null) {
      _category = new ChildrensCategory();
    }
    return _category;
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
    return "Children's";
  }
}
