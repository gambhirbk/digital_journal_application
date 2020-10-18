package problem1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * A class representing content row to display the TreeMap entries
 */

public class ContentRow implements AbstractRow {

  protected static final int COLUMN_WIDTH = 17;
  protected static final int OFFSET = 2;
  protected static final int MARGIN = 15;
  private final Integer integer;
  private final DigitalEntry entry;

  /**
   * A constructor for the ContentRow class
   *
   * @param integer an integer representing the row number
   * @param entry   the data entered in the document
   */

  public ContentRow(Integer integer, DigitalEntry entry) {
    this.integer = integer;
    this.entry = entry;
  }

  /**
   * A method to display the content of the table
   */

  @Override
  public void render() {
    ArrayList<String> rowContent = new ArrayList<>();
    rowContent.add(String.valueOf(this.integer));
    String[] entryContent = this.entry.stringValue().split(",");
    rowContent.addAll(Arrays.asList(entryContent));
    String textToSplit = rowContent.get(1);
    int rows = textToSplit.length() / COLUMN_WIDTH + OFFSET;
    int start = 0;
    int end = COLUMN_WIDTH - OFFSET;
    StringBuilder toPrint = new StringBuilder();
    StringBuilder formatBuilder = new StringBuilder();
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < rowContent.size(); j++) {
        formatBuilder.append("|  ").append("%-").append(MARGIN).append("s ");
        if (i == 0) {
          if (j == 1) {
            if (end <= textToSplit.length()) {
              toPrint.append(textToSplit, start, end).append(",");
              start += end;
              end += end;
              start = Math.min(start, textToSplit.length());
              end = Math.min(end, textToSplit.length());
            } else {
              toPrint.append(textToSplit).append(",");
            }
          } else {
            toPrint.append(rowContent.get(j)).append(",");
          }
        } else {
          if (j == 1) {
            if (end <= textToSplit.length()) {
              toPrint.append(textToSplit, start, end).append(",");
              start = end;
              end += end;
              start = Math.min(start, textToSplit.length());
              end = Math.min(end, textToSplit.length());
            } else {
              toPrint.append(" ").append(",");
            }
          } else {
            toPrint.append(" ").append(",");
          }
        }
      }
      if (i < rows - 1) {
        formatBuilder.append('\n');
      }
    }
    String format = formatBuilder.toString();
    String toPrintFinal = toPrint.toString();
    System.out.println(String.format(format, (Object[]) toPrintFinal.split(",")));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContentRow that = (ContentRow) o;
    return Objects.equals(integer, that.integer) &&
        Objects.equals(entry, that.entry);
  }

  @Override
  public int hashCode() {
    return Objects.hash(integer, entry);
  }

  @Override
  public String toString() {
    return "ContentRow{" +
        "integer=" + integer +
        ", entry=" + entry +
        '}';
  }
}
