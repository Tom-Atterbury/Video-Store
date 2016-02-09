package sellables;

import categories.Category;
import categories.CategoryFactory;

/**
 * Abstract book superclass for a video store
 * 
 * @author Tom Atterbury
 *         
 */
public class SellableBook extends Sellable {
  
  private Category _priceCode;
  
  /**
   * Create a book with the given title and category (type)
   * 
   * @param title
   *          Book name
   * @param priceCode
   *          Book category
   */
  public SellableBook(String title, int category) {
    super(title);
    this.setPriceCode(category);
  }
  
  /**
   * Returns the category (type) of book
   * 
   * @return type of book
   */
  public Category getPriceCode() {
    return _priceCode;
  }
  
  /**
   * Set the category (type) of this book
   * 
   * @param category
   */
  public void setPriceCode(int category) {
    _priceCode = CategoryFactory.getCategory(category);
  }
  
  /**
   * Returns the title of the book
   * 
   * @return title of the book
   */
  public String getTitle() {
    return _title;
  }
  
  /**
   * Calculate the cost to purchase this book
   * 
   * @return cost to purchase
   */
  @Override
  public double getPrice() {
    return _priceCode.getPurchasePrice();
  }
  
  /**
   * Determine if book is a new release or not
   * 
   * @return true if new release, false otherwise
   */
  public boolean isNewRelease() {
    return _priceCode.isNewRelease();
  }
  
  @Override
  public String toString(){
    return _priceCode + " Book\t" + _title;
  }
}