package musicGenres;

/**
 * Interface for all Music genres
 * 
 * @author Tom Atterbury
 *        
 */
public interface MusicGenre {
  
  public static final int ROCK = 0;
  public static final int POP = 1;
  
  /**
   * Return the cost to rent this genre of music for the specified number of
   * days
   * 
   * @param daysRented
   * @return cost to rent this type of music
   */
  public double getRentalPrice(int daysRented);
  
  /**
   * Return the cost to buy this genre of music
   * 
   * @return cost to purchase this type of music
   */
  public double getPurchasePrice();
  
  public boolean isNewRelease();
}
