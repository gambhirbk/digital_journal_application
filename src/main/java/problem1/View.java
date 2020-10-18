package problem1;

import static problem1.Constants.HEADERS;

import java.util.Map;
import java.util.Objects;

/**
 * A class representing the view
 */

public class View {

  private final Map<Integer, DigitalEntry> allEntries;

  /**
   * A constructor representing View
   *
   * @param allEntries the map that has entries to display
   */

  public View(Map<Integer, DigitalEntry> allEntries) {
    this.allEntries = allEntries;
  }

  /**
   * A method to print all the entries
   */

  public void printAllEntries() {
    if (this.allEntries == null || this.allEntries.isEmpty()) {
      System.out.println("Queries return no result");
      return;
    }
    TableComposite table = new TableComposite();
    table.add(new HeaderRow(HEADERS.split(",")));
    for (Map.Entry<Integer, DigitalEntry> entry : this.allEntries.entrySet()) {
      table.add(new ContentRow(entry.getKey(), entry.getValue()));
    }
    table.add(new FooterRow());
    table.render();
  }

//  @Override
//  public boolean equals(Object o) {
//    if (this == o) {
//      return true;
//    }
//    if (o == null || getClass() != o.getClass()) {
//      return false;
//    }
//
//    View view = (View) o;
//
//    return Objects.equals(allEntries, view.allEntries);
//  }
//
//  @Override
//  public int hashCode() {
//    return allEntries != null ? allEntries.hashCode() : 0;
//  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    View view = (View) o;
    return Objects.equals(allEntries, view.allEntries);
  }

  @Override
  public int hashCode() {
    return Objects.hash(allEntries);
  }

  @Override
  public String toString() {
    return "View{" +
        "allEntries=" + allEntries +
        '}';
  }
}

