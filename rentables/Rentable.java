package rentables;

/**
 * Class to hold common methods and fields for all rentable items
 * 
 * @author Tom Atterbury
 *         
 */
public abstract class Rentable {
  
  String _title;
  boolean _isNewRelease;
  
  /**
   * Sets the title of the rentable, and sets to default non-New Release
   * 
   * @param title
   *          of the rentable item
   */
  public Rentable(String title) {
    _title = title;
    _isNewRelease = false;
  }
  
  /**
   * Get the title of the rentable item
   * 
   * @return String representation of the name of the item
   */
  public String getTitle() {
    return _title;
  }
  
  /**
   * Cost to rent this item for the specified number of days
   * 
   * @param daysRented
   *          integer value representing the number of days this item was/will
   *          be rented
   * @return cost to rent as a double precision number
   */
  public abstract double getPrice(int daysRented);
  
  /**
   * Returns an integer representation of the category of this rentable
   * 
   * @return integer hashCode for the rentable category
   */
  public abstract int getCategoryHash();
  
  /**
   * Is this a new release item
   * 
   * @return true if the item is a New Release, false otherwise
   */
  public abstract boolean isNewRelease();
  
}
