package rentables;

import musicGenres.MusicGenre;
import musicGenres.MusicGenreFactory;

/**
 * Abstract CD superclass for a video store
 * 
 * @author Tom Atterbury
 *         
 */
public class RentableCD extends Rentable{
  
  private MusicGenre _priceCode;
  
  /**
   * Create a CD with the given title and category (type)
   * 
   * @param title
   *          CD name
   * @param priceCode
   *          CD category
   */
  public RentableCD(String title, int category) {
    super(title);
    _priceCode = MusicGenreFactory.getGenre(category);
  }
  
  /**
   * Returns the hashCode for the genre (type) of this CD
   * 
   * @return CD genre hashCode
   */
  public int getCategoryHash() {
    return _priceCode.hashCode();
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
   * Calculate the cost to rent this CD for a given rental period
   * 
   * @param daysRented
   *          days CD has bee rented
   * @return cost to rent
   */
  public double getPrice(int daysRented) {
    return _priceCode.getRentalPrice(daysRented);
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
    return _priceCode + " CD\t" + _title;
  }
}