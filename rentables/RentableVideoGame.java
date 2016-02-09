package rentables;

import gameGenres.GameGenre;
import gameGenres.GameGenreFactory;

/**
 * Abstract video game superclass for a video store
 * 
 * @author Tom Atterbury
 *         
 */
public class RentableVideoGame extends Rentable {
  
  private GameGenre _priceCode;
  
  /**
   * Create a video game with the given title and category (type)
   * 
   * @param title
   *          Video Game name
   * @param priceCode
   *          Video Game category
   */
  public RentableVideoGame(String title, int category) {
    super(title);
    this.setPriceCode(category);
  }
  
  /**
   * Returns the hashCode representation of the video game's category (type)
   * 
   * @return video game category hash
   */
  public int getCategoryHash() {
    return _priceCode.hashCode();
  }
  
  /**
   * Set the category (type) of this video game
   * 
   * @param category
   */
  public void setPriceCode(int category) {
    _priceCode = GameGenreFactory.getGameGenre(category);
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
   * Calculate the cost to rent this video game for a given rental period
   * 
   * @param daysRented
   *          days video game has bee rented
   * @return cost to rent
   */
  public double getPrice(int daysRented) {
    return _priceCode.getRentalPrice(daysRented);
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