package sellables;

import musicGenres.MusicGenre;
import musicGenres.MusicGenreFactory;

/**
 * Abstract CD superclass for a video store
 * 
 * @author Tom Atterbury
 *         
 */
public class SellableCD extends Sellable {
  
  private MusicGenre _priceCode;
  
  /**
   * Create a CD with the given title and category (type)
   * 
   * @param title
   *          CD name
   * @param priceCode
   *          CD category
   */
  public SellableCD(String title, int category) {
    super(title);
    _priceCode = MusicGenreFactory.getGenre(category);
  }
  
  /**
   * Returns the category (type) of CD
   * 
   * @return type of CD
   */
  public MusicGenre getPriceCode() {
    return _priceCode;
  }
  
  /**
   * Set the category (type) of this CD
   * 
   * @param category
   */
  public void setPriceCode(int category) {
    _priceCode = MusicGenreFactory.getGenre(category);
  }
  
  /**
   * Returns the title of the CD
   * 
   * @return title of the CD
   */
  public String getTitle() {
    return _title;
  }
  
  /**
   * Calculate the cost to purchase this CD
   * 
   * @return cost to purchase
   */
  @Override
  public double getPrice() {
    return _priceCode.getPurchasePrice();
  }
  
  /**
   * Determine if CD is a new release or not
   * 
   * @return true if new release, false otherwise
   */
  public boolean isNewRelease() {
    return _priceCode.isNewRelease();
  }
  
  @Override
  public String toString(){
    return _priceCode + " Music CD\t" + _title;
  }
}