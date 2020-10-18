package problem1;

import java.util.Arrays;


/**
 * A class representing row
 */

public class FooterRow implements AbstractRow {

  protected static final int MAX_LENGTH = 108;

  /**
   * A constructor for FooterRow class
   */
  public FooterRow() {
  }

  /**
   * A method to add header line to the array
   */

  @Override
  public void render() {
    char[] headerLine = new char[MAX_LENGTH];
    Arrays.fill(headerLine, '=');
    System.out.println(new String(headerLine));
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof FooterRow;
  }

  @Override
  public int hashCode() {
    return FooterRow.class.hashCode();
  }

  @Override
  public String toString() {
    return "FooterRow{}";
  }
}
