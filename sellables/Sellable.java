package sellables;

/**
 * An item that is able to be purchased by a customer
 * 
 * @author Tom Atterbury
 *         
 */
public abstract class Sellable {
  
  String _title;
  boolean _isNewRelease;
  
  /**
   * Constructor for all sellable items, sets the name and initializes to
   * non-New Release
   * 
   * @param title
   *          Item name
   */
  public Sellable(String title) {
    _title = title;
    _isNewRelease = false;
  }
  
  /**
   * Get the title of the item
   * 
   * @return String representation of the item's title
   */
  public String getTitle() {
    return _title;
  }
  
  /**
   * Get the price to purchase one of these items
   * 
   * @return price of each item
   */
  public abstract double getPrice();
  
  /**
   * Determine if the item is a new release item or not
   * 
   * @return boolean representation of new release state
   */
  public abstract boolean isNewRelease();
  
}
