package sellables;

import java.text.DecimalFormat;

/**
 * Class to represent a purchase for a video store
 * 
 * @author Tom Atterbury
 *         
 */
public class Sale {
  
  private Sellable _product;
  private int _quantity;
  private DecimalFormat _dollarFormat = new DecimalFormat("#.00");
  
  /**
   * Create a new purchase with the given Product and number of days rented
   * 
   * @param product
   *          Sellable product for this purchase
   * @param daysRented
   *          Number of days the Product was rented
   */
  public Sale(Sellable product, int quantity) {
    _product = product;
    _quantity = quantity;
  }
  
  /**
   * Return the Sellable product associated with this purchase
   * 
   * @return Sellable product
   */
  public Sellable getProduct() {
    return _product;
  }
  
  /**
   * Calculate amount owed for this purchase
   * 
   * @return Cost for this purchase
   */
  public double getAmountOwed() {
    return _product.getPrice() * _quantity;
  }
  
  /**
   * Get the title of the Sellable product for this purchase
   * 
   * @return Sellable product title
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