package rentables;

import categories.Category;
import categories.CategoryFactory;

/**
 * Abstract book superclass for a video store
 * 
 * @author Tom Atterbury
 *         
 */
public class RentableBook extends Rentable {
  
  private Category _priceCode;
  
  /**
   * Create a book with the given title and category (type)
   * 
   * @param title
   *          Book name
   * @param priceCode
   *          Book category
   */
  public RentableBook(String title, int category) {
    super(title);
    this.setPriceCode(category);
  }
  
  /**
   * Returns the hasCode representation of the book's category
   * 
   * @return type of book
   */
  public int getCategoryHash() {
    return _priceCode.hashCode();
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
   * Calculate the cost to rent this book for a given rental period
   * 
   * @param daysRented
   *          days book has bee rented
   * @return cost to rent
   */
  public double getPrice(int daysRented) {
    return _priceCode.getRentalPrice(daysRented);
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
  public String toString() {
    return _priceCode + " Book\t" + _title;
  }
}