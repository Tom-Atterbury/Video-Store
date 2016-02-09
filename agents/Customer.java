package agents;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import rentables.Rental;
import sellables.Sale;
import strategies.RenterPointStrategy;

/**
 * Customer class for a video store
 * 
 * @author Tom Atterbury
 *         
 */
public class Customer {
  
  private String _name;
  private ArrayList<Rental> _rentals;
  private ArrayList<Sale> _purchases;
  private RenterPointStrategy _frpStrategy;
  private double _totalAmountOwed;
  private DecimalFormat _dollarFormat = new DecimalFormat("#.00");
  private int _age;
  
  /**
   * Customer constructor, initializes with the given name, an empty rental list
   * and 0 frequent renter points
   * 
   * @param name
   *          Customer name
   */
  public Customer(String name, int age, RenterPointStrategy strategy) {
    _name = name;
    _age = age;
    _totalAmountOwed = 0;
    _frpStrategy = strategy;
    _rentals = new ArrayList<Rental>();
    _purchases = new ArrayList<Sale>();
  }
  
  /**
   * Add a rental to the customer's list of rentals
   * 
   * @param rental
   */
  public void rent(Rental rental) {
    _rentals.add(rental);
    _totalAmountOwed += rental.getAmountOwed();
  }
  
  /**
   * Add a purchase to the customer's list of purchases
   * 
   * @param sale
   */
  public void buy(Sale purchase) {
    _purchases.add(purchase);
    _totalAmountOwed += purchase.getAmountOwed();
  }
  
  /**
   * Get the customer's name
   * 
   * @return Customer name
   */
  public String getName() {
    return _name;
  }
  
  /**
   * Generate a statement for the customer detailing the rentals and purchases
   * made as well as the total amount owed.
   * 
   * @return statement of rentals, purchases, and total amount owed
   */
  public String printStatement() {
    String result = "Record for " + getName() + "\n\n";
    
    // Show figures for each rental
    if (!_rentals.isEmpty()) {
      result += "Rentals:\n";
      for (Rental rental : _rentals) {
        result += rental;
      }
      result += "\n";
    }
    
    // Show figures for each purchase
    if (!_purchases.isEmpty()) {
      result += "Purchases:\n";
      for (Sale sale : _purchases) {
        result += sale;
      }
      result += "\n";
    }
    
    // add footer lines
    result += "Amount owed is $" + _dollarFormat.format(_totalAmountOwed)
        + "\n";
    result += "You earned " + _frpStrategy.calculateFrequentRenterPoints(this)
        + " frequent renter points";
    return result;
  }
  
  /**
   * Prints the rental record for the customer to an HTML file
   */
  public void printHTML() {
    try {
      // Create a file for output
      PrintWriter outputFile = new PrintWriter(
          new File("Rental_Record-" + _name + ".html"));
          
      // Generate the HTML and print to the file
      String html = generateHTMLString();
      outputFile.println(html);
      
      // Close the output file
      outputFile.close();
      
    } catch (FileNotFoundException e) {
      // If there is an error opening/creating the file, print a stack trace
      e.printStackTrace();
    }
  }
  
  /**
   * Generates a customer statement using HTML style tags
   * 
   * @return statement of rentals and amount owed using HTML style tags
   */
  private String generateHTMLString() {
    String html = "";
    
    // HTML tags and record header
    html += "<html>\n";
    html += "<body>\n";
    html += "<H2> Record for " + getName() + " <p>\n";
    
    // Show table of figures for each rental
    if (!_rentals.isEmpty()) {
      html += "<H3> Rentals: <br>\n";
      html += "<H4> <table>\n";
      html += "<tr> <th> Title </th> <th> Price </th> </tr>\n";
      for (Rental rental : _rentals) {
        html += "<tr> <td> " + rental.getTitle() + " </td> ";
        html += "<td> $" + _dollarFormat.format(rental.getAmountOwed())
            + " </td> </tr>\n";
      }
      html += "</table> <p>\n";
    }
    
    // Show table of figures for each purchase
    if (!_purchases.isEmpty()) {
      html += "<H3> Purchases: <br>\n";
      html += "<H4> <table>\n";
      html += "<tr> <th> Title </th> <th> Price </th> </tr>\n";
      for (Sale sale : _purchases) {
        html += "<tr> <td> " + sale.getTitle() + " </td> ";
        html += "<td> $" + _dollarFormat.format(sale.getAmountOwed())
            + " </td> </tr>\n";
      }
      html += "</table> <p>\n";
    }
    
    // Add summary and close HTML tags
    html += "Amount owed: $" + _dollarFormat.format(_totalAmountOwed)
        + " <br>\n";
    html += "Renter Points Earned: "
        + String.valueOf(_frpStrategy.calculateFrequentRenterPoints(this))
        + "\n";
    html += "</body>\n";
    html += "</html>";
    
    return html;
  }
  
  /**
   * Return a list of rental items for this customer
   * 
   * @return list of rentals
   */
  public List<Rental> getRentals() {
    return _rentals;
  }
  
  /**
   * Get the age of the customer
   * 
   * @return integer value for number of years since customer's birth
   */
  public int getAge() {
    return _age;
  }
  
}
