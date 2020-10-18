package problem1;

import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/**
 * An abstract class representing a digital entry comparator
 */

public abstract class DigitalEntryComparator implements Comparator<Integer> {

  Map<Integer, DigitalEntry> map = new TreeMap<>();

  /**
   * A constructor for the DigitalEntryComparator class
   *
   * @param map a TreeMap with integer and digital entry data
   */
  public DigitalEntryComparator(TreeMap<Integer, DigitalEntry> map) {
    this.map.putAll(map);
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof DigitalEntryComparator)) {
      return false;
    }
    DigitalEntryComparator that = (DigitalEntryComparator) o;
    return map.equals(that.map);
  }

  @Override
  public int hashCode() {
    return Objects.hash(map);
  }

  @Override
  public String toString() {
    return "DigitalEntryComparator{" +
        "map=" + map +
        '}';
  }
}
