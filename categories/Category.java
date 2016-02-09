package categories;

/**
 * Base behavior for all categories
 * 
 * @author Tom Atterbury
 *         
 */
public interface Category {
  
  public static final int ACTION = 0;
  public static final int NEW_RELEASE = 1;
  public static final int CHILDRENS = 2;
  public static final int SCIFI = 3;
  
  /**
   * Returns the cost to rent this category of movie/book for the specified
   * number of days
   * 
   * @param daysRented
   *          number of days item is rented
   * @return cost to rent
   */
  public double getRentalPrice(int daysRented);
  
  /**
   * Get the cost to purchase this category of book/movie
   * 
   * @return purchase price
   */
  public double getPurchasePrice();
  
  /**
   * Get state of category
   * 
   * @return true if the item is a New Release category, false otherwise
   */
  public boolean isNewRelease();
}
