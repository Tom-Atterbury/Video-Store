package testbench;
import agents.Customer;
import categories.Category;
import gameGenres.GameGenre;
import musicGenres.MusicGenre;
import rentables.RentableMovie;
import rentables.RentableVideoGame;
import rentables.Rental;
import sellables.Sale;
import sellables.SellableBook;
import sellables.SellableCD;
import sellables.SellableMovie;
import strategies.TrendyRenterPointStrategy;
import strategies.VarietyRenterPointStrategy;

/**
 * Sample video store to test functionality of classes
 * 
 * @author Tom Atterbury
 *         
 */
public class VideoStore {
  
  public static void main(String[] args) {
    // Create some new customers
    Customer bob = new Customer("Bob Anderson", 46,
        new VarietyRenterPointStrategy());
        
    Customer jane = new Customer("Jane Doe", 20,
        new TrendyRenterPointStrategy());
        
    // Perform a series of rentals and purchases for each customer
    
    // Bob rents new release Aloha for 2 days
    bob.rent(new Rental(new RentableMovie("Aloha", Category.NEW_RELEASE), 2));
    
    // Jane rents children's movie Frozen for 5 days
    jane.rent(new Rental(new RentableMovie("Frozen", Category.CHILDRENS), 5));
    
    // Bob rents Star Wars, a Sci-fi movie, for 12 days
    bob.rent(new Rental(new RentableMovie("Star Wars", Category.SCIFI), 12));
    
    // Jane rents new release Pitch Perfect 2 for 1 day
    jane.rent(new Rental(
        new RentableMovie("Pitch Perfect 2", Category.NEW_RELEASE), 1));
        
    // Bob buys Brave, a children's movie
    bob.buy(new Sale(new SellableMovie("Brave", Category.CHILDRENS), 1));
    
    // Jane rents a shooter game for a week
    jane.rent(
        new Rental(new RentableVideoGame("Halo 5", GameGenre.SHOOTER), 7));
        
    // Jane buys 2 Lullaby CDs
    jane.buy(new Sale(new SellableCD("Lullaby", MusicGenre.POP), 2));
    
    // Jane buys a Davinci Code book
    jane.buy(new Sale(new SellableBook("Davinci Code", Category.ACTION), 1));
    
    // Bob rents a childrens game for 2 weeks
    bob.rent(new Rental(
        new RentableVideoGame("Super Mario Bros.", GameGenre.PUZZLE), 14));
        
    // Bob buys 5 Elvis cds
    bob.buy(new Sale(new SellableCD("Elvis: The King", MusicGenre.ROCK), 5));
    
    // Display a statement for Bob
    System.out.println(bob.printStatement());
    System.out.println();
    bob.printHTML();
    
    // Display a statement for Jane
    System.out.println(jane.printStatement());
    System.out.println();
    jane.printHTML();
  }
  
}
