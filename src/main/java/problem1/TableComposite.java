package problem1;

import java.util.ArrayList;
import java.util.List;

/**
 * A class representing a Table composite for display
 */

public class TableComposite implements AbstractRow {

  private final List<AbstractRow> rows = new ArrayList<>();

  /**
   * A method for displaying rows
   */

  @Override
  public void render() {
    for (AbstractRow r : rows) {
      r.render();
    }
  }

  /**
   * A void method to add to the list
   *
   * @param r An abstract row to add to the list
   */

  public void add(AbstractRow r) {
    this.rows.add(r);
  }

  /**
   * A void method to remove to the list
   *
   * @param r An abstract row to remove from the list
   */

  public void remove(AbstractRow r) {
    rows.remove(r);
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof TableComposite;
  }

  @Override
  public int hashCode() {
    return TableComposite.class.hashCode();
  }

  @Override
  public String toString() {
    return "TableComposite{" +
        "rows=" + rows +
        '}';
  }
}
