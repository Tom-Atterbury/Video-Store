package categories;

/**
 * New release category for books/movies
 * 
 * @author Tom Atterbury
 *         
 */
public class NewReleaseCategory implements Category {
  
  private final double RENTAL_COST_FACTOR = 3;
  private final double PURCHASE_PRICE = 30.0;
  
  private static Category _category;
  
  /**
   * Singleton instantiation of a new release category
   * 
   * @return the instance of a new release title
   */
  public synchronized static Category getInstance() {
    if (_category == null) {
      _category = new NewReleaseCategory();
    }
    return _category;
  }
  
  @Override
  public double getRentalPrice(int daysRented) {
    return daysRented * RENTAL_COST_FACTOR;
  }
  
  @Override
  public boolean isNewRelease() {
    return true;
  }
  
  @Override
  public double getPurchasePrice() {
    return PURCHASE_PRICE;
  }
  
  @Override
  public String toString() {
    return "New Release";
  }
}
