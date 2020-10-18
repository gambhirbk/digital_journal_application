package problem1;

import java.util.TreeMap;

/**
 * A class representing a priority comparator
 */

public class PriorityComparator extends DigitalEntryComparator {

  /**
   * A constructor representing a priority comparator
   *
   * @param map containing priority and digital entry
   */

  public PriorityComparator(TreeMap<Integer, DigitalEntry> map) {
    super(map);
  }

  /**
   * A method to compare two integer is equal
   *
   * @param o1 the first integer
   * @param o2 the second integer
   * @return 1 if the two integers are equal, else compare
   */

  @Override
  public int compare(Integer o1, Integer o2) {
    int compare = map.get(o1).getPriority().compareTo(map.get(o2).getPriority());
    if (compare == 0) {
      return 1; // important to not overwrite
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
