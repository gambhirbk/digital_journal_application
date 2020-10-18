package problem1;

import java.util.TreeMap;

/**
 * A class representing date comparator
 */

public class DateComparator extends DigitalEntryComparator {

  /**
   * A constructor for the DateComparator class
   *
   * @param map The TreeMap containing integer and digital entry
   */

  public DateComparator(TreeMap<Integer, DigitalEntry> map) {
    super(map);
  }

  /**
   * A method to compare to dates
   *
   * @param o1 an integer id
   * @param o2 an integer id
   * @return 1 if two dates are equal, otherwise the compare value
   */

  @Override
  public int compare(Integer o1, Integer o2) {
    int compare = map.get(o1).getDate().compareTo(map.get(o2).getDate());
    if (compare == 0) {
      return 1;
    } else {
      return compare;
    }
  }

  @Override
  public boolean equals(Object o) {
    return super.equals(o);
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public String toString() {
    return super.toString();
  }
}