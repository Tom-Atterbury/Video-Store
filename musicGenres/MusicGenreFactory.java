package musicGenres;

/**
 * Factory to return the appropriate MusicGenre class for a given category
 * 
 * @author Tom Atterbury
 *        
 */
public class MusicGenreFactory {
  
  public static MusicGenre getGenre(int priceCode) {
    switch (priceCode) {
      case (MusicGenre.POP):
        return PopGenre.getInstance();
      case (MusicGenre.ROCK):
        return RockGenre.getInstance();
      default:
        return null;
    }
  }
}
