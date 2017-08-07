package kata;

import java.util.List;

// TODO: complete this object/class

public class PaginationHelper<I> {

  private List<I> list;
  private int itemsPerPage;

  /**
   * The constructor takes in an array of items and a integer indicating how many
   * items fit within a single page
   */
  public PaginationHelper(List<I> collection, int itemsPerPage) {
    this.list = collection;
    this.itemsPerPage = itemsPerPage;
  }

  /**
   * returns the number of items within the entire collection
   */
  public int itemCount() {
    return list.size();
  }

  /**
   * returns the number of pages
   */
  public int pageCount() {
    if (list.size() > 0)
      return list.size() / itemsPerPage + 1;
    else
      return 0;
  }

  /**
   * returns the number of items on the current page. page_index is zero based.
   * this method should return -1 for pageIndex values that are out of range
   */
  public int pageItemCount(int pageIndex) {
    int pageNums = pageCount();
    if (pageIndex < 0)
      return -1;
    if (pageIndex < pageNums - 1)
      return itemsPerPage;
    else if (pageIndex == pageNums - 1)
      return list.size() - (pageNums - 1) * itemsPerPage;
    else
      return -1;
  }

  /**
   * determines what page an item is on. Zero based indexes
   * this method should return -1 for itemIndex values that are out of range
   */
  public int pageIndex(int itemIndex) {
    if (itemIndex < 0 || itemIndex >= list.size())
      return -1;
    return itemIndex / itemsPerPage;
  }
}
