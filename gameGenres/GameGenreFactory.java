package gameGenres;

/**
 * Factory to determine what game genre instance to return
 * 
 * @author Tom Atterbury
 *         
 */
public class GameGenreFactory {
  
  /**
   * Return an instance of the specified game genre
   * 
   * @param priceCode
   *          genre type
   * @return instance of the specified type
   */
  public static GameGenre getGameGenre(int priceCode) {
    switch (priceCode) {
      case (GameGenre.PUZZLE):
        return PuzzleGameGenre.getInstance();
      case (GameGenre.SHOOTER):
        return ShooterGameGenre.getInstance();
      default:
        return null;
    }
  }
}
