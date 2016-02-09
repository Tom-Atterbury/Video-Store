package rentables;

import categories.Category;
import categories.CategoryFactory;

/**
 * Abstract movie superclass for a video store
 * 
 * @author Tom Atterbury
 *         
 */
public class RentableMovie extends Rentable {
  
  private Category _priceCode;
  
  /**
   * Create a movie with the given title and category (type)
   * 
   * @param title
   *          Movie name
   * @param priceCode
   *          Movie category
   */
  public RentableMovie(String title, int category) {
    super(title);
    this.setPriceCode(category);
  }
  
  /**
   * Returns the hashCode for the movie's category (type)
   * 
   * @return type of movie
   */
  public int getCategoryHash() {
    return _priceCode.hashCode();
  }
  
  /**
   * Set the category (type) of this movie
   * 
   * @param category
   */
  public void setPriceCode(int category) {
    _priceCode = CategoryFactory.getCategory(category);
  }
  
  /**
   * Returns the title of the movie
   * 
   * @return title of the movie
   */
  public String getTitle() {
    return _title;
  }
  
  /**
   * Calculate the cost to rent this movie for a given rental period
   * 
   * @param daysRented
   *          days movie has bee rented
   * @return cost to rent
   */
  public double getPrice(int daysRented) {
    return _priceCode.getRentalPrice(daysRented);
  }
  
  /**
   * Determine if movie is a new release or not
   * 
   * @return true if new release, false otherwise
   */
  public boolean isNewRelease() {
    return _priceCode.isNewRelease();
  }
  
  @Override
  public String toString(){
    return _priceCode + " Movie\t" + _title;
  }
}