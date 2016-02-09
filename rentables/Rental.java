package rentables;

import java.text.DecimalFormat;

/**
 * Class to represent a rental for a video store
 * 
 * @author Tom Atterbury
 *         
 */
public class Rental {
  
  private Rentable _product;
  private int _daysRented;
  private DecimalFormat _dollarFormat = new DecimalFormat("#.00");
  
  /**
   * Create a new rental with the given Product and number of days rented
   * 
   * @param product
   *          Rentable product for this rental
   * @param daysRented
   *          Number of days the Product was rented
   */
  public Rental(Rentable product, int daysRented) {
    _product = product;
    _daysRented = daysRented;
  }
  
  /**
   * Return the number of days rented
   * 
   * @return Rental period
   */
  public int getDaysRented() {
    return _daysRented;
  }
  
  /**
   * Return the Rentable product associated with this rental
   * 
   * @return Rentable product
   */
  public Rentable getProduct() {
    return _product;
  }
  
  /**
   * Calculate amount owed for this rental
   * 
   * @return Cost for this rental
   */
  public double getAmountOwed() {
    return _product.getPrice(_daysRented);
  }
  
  /**
   * Get the title of the Rentable product for this rental
   * 
   * @return Rentable product title
   */
  public String getTitle() {
    return _product.getTitle();
  }
  
  @Override
  public String toString() {
    return "\t$" + _dollarFormat.format(this.getAmountOwed()) + "\t" + _product
        + "\n";
  }
  
}