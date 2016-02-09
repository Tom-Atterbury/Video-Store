package gameGenres;

/**
 * Interface for all video game genres, defines common behavior and available
 * types
 * 
 * @author Tom Atterbury
 *         
 */
public interface GameGenre {
  
  public static final int PUZZLE = 0;
  public static final int SHOOTER = 1;
  
  /**
   * Get the cost to rent this type of game for a number of days
   * 
   * @param daysRented
   *          days the game was/will be rented
   * @return cost to rent
   */
  public double getRentalPrice(int daysRented);
  
  /**
   * Get the cost to purchase a certain type of game
   * 
   * @return cost to buy
   */
  public double getPurchasePrice();
  
  /**
   * Determine if the game is a new release title
   * 
   * @return true if the game is a new release, false otherwise
   */
  public boolean isNewRelease();
}
