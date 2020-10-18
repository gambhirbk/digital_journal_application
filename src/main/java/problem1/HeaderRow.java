package problem1;

import java.util.Arrays;

/**
 * A class representing a header row
 */

public class HeaderRow implements AbstractRow {

  protected static final int MAX_LENGTH = 108;
  protected static final int MARGIN = 15;
  private final String[] content;

  /**
   * A constructor for a header row
   *
   * @param content the content of the header row
   */

  public HeaderRow(String[] content) {
    this.content = content;
  }

  /**
   * Getter for the content
   *
   * @return content
   */

  public String[] getContent() {
    return content;
  }

  /**
   * A method to display/print the header row
   */

  @Override
  public void render() {
    char[] headerLine = new char[MAX_LENGTH];
    Arrays.fill(headerLine, '=');
    System.out.println(new String(headerLine));
    StringBuilder formatBuilder = new StringBuilder();
    for (int i = 0; i < this.getContent().length; i++) {
      formatBuilder.append("|  ").append("%-").append(MARGIN).append("s ");
    }
    String format = formatBuilder.toString();
    System.out.println(String.format(format, (Object[])this.content));
    char[] separatorLine = new char[MAX_LENGTH];
    Arrays.fill(separatorLine, '-');
    System.out.println(new String(separatorLine));
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof HeaderRow;
  }

  @Override
  public int hashCode() {
    return HeaderRow.class.hashCode();
  }

  @Override
  public String toString() {
    return "HeaderRow{}";
  }
}
