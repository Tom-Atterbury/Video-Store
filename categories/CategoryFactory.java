package categories;

/**
 * Factory to determine what category to return based on the priceCode provided
 * 
 * @author Tom Atterbury
 *         
 */
public class CategoryFactory {
  
  /**
   * Get the appropriate category behavior for the specified proceCode
   * 
   * @param priceCode
   *          Category type
   * @return instance of the specified category
   */
  public static Category getCategory(int priceCode) {
    switch (priceCode) {
      case (Category.CHILDRENS):
        return ChildrensCategory.getInstance();
      case (Category.ACTION):
        return ActionCategory.getInstance();
      case (Category.NEW_RELEASE):
        return NewReleaseCategory.getInstance();
      case (Category.SCIFI):
        return SciFiCategory.getInstance();
      default:
        return null;
    }
  }
}
