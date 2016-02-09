package sellables;

import categories.Category;
import categories.CategoryFactory;

/**
 * Abstract movie superclass for a video store
 * 
 * @author Tom Atterbury
 *         
 */
public class SellableMovie extends Sellable {
  
  private Category _priceCode;
  
  /**
   * Create a movie with the given title and category (type)
   * 
   * @param title
   *          Movie name
   * @param priceCode
   *          Movie category
   */
  public SellableMovie(String title, int category) {
    super(title);
    this.setPriceCode(category);
  }
  
  /**
   * Returns the category (type) of movie
   * 
   * @return type of movie
   */
  public Category getPriceCode() {
    return _priceCode;
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
   * Calculate the cost to purchase this movie
   * 
   * @return cost to purchase
   */
  @Override
  public double getPrice() {
    return _priceCode.getPurchasePrice();
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