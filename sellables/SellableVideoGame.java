package sellables;

import categories.Category;
import categories.CategoryFactory;

/**
 * Abstract video game superclass for a video store
 * 
 * @author Tom Atterbury
 *         
 */
public class SellableVideoGame extends Sellable {
  
  private Category _priceCode;
  
  /**
   * Create a video game with the given title and category (type)
   * 
   * @param title
   *          Video Game name
   * @param priceCode
   *          Video Game category
   */
  public SellableVideoGame(String title, int category) {
    super(title);
    this.setPriceCode(category);
  }
  
  /**
   * Returns the category (type) of video game
   * 
   * @return type of video game
   */
  public Category getPriceCode() {
    return _priceCode;
  }
  
  /**
   * Set the category (type) of this video game
   * 
   * @param category
   */
  public void setPriceCode(int category) {
    _priceCode = CategoryFactory.getCategory(category);
  }
  
  /**
   * Returns the title of the video game
   * 
   * @return title of the video game
   */
  public String getTitle() {
    return _title;
  }
  
  /**
   * Calculate the cost to purchase this video game
   * 
   * @return cost to purchase
   */
  @Override
  public double getPrice() {
    return _priceCode.getPurchasePrice();
  }
  
  /**
   * Determine if video game is a new release or not
   * 
   * @return true if new release, false otherwise
   */
  public boolean isNewRelease() {
    return _priceCode.isNewRelease();
  }
  
  @Override
  public String toString(){
    return _priceCode + " Video Game\t" + _title;
  }
}