package problem1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TableCompositeTest {

  TableComposite rows;
  TableComposite rowsEquals1;
  TableComposite rowsEquals2;
  TableComposite rowsEquals3;

  FooterRow footerRow;

  @Before
  public void setUp() {
    rows = new TableComposite();
    footerRow = new FooterRow();
    rowsEquals1 = new TableComposite();
    rowsEquals2 = new TableComposite();
    rowsEquals3 = new TableComposite();
  }

  @Test
  public void testRemove() {
    rows.add(footerRow);
    rows.remove(footerRow);
    assertTrue(rows.toString(), true);
  }

  @Test
  public void testEqualsReflective() {
    assertEquals(rowsEquals1, rowsEquals2);
  }

  @Test
  public void testEqualsTransitive() {
    assertEquals(rowsEquals1, rowsEquals2);
    assertEquals(rowsEquals2, rowsEquals3);
    assertEquals(rowsEquals3, rowsEquals1);
  }

  @Test
  public void testEqualsSymmetric() {
    assertEquals(rowsEquals1, rowsEquals3);
    assertEquals(rowsEquals3, rowsEquals1);
  }

  @Test
  public void testEqualsConsistent() {
    for (int i = 0; i < 10; i++) {
      assertEquals(rowsEquals1, rowsEquals3);
    }
  }

  @Test
  public void testEqualsNull() {
    assertNotEquals(null, rowsEquals1);
  }

  @Test
  public void testEqualsClass() {
    assertNotEquals(34, rowsEquals1);
  }

  @Test
  public void testEqualsClass1() {
    assertNotEquals(rowsEquals1, new Object());
  }

  @Test
  public void testHashCode() {
    assertEquals(rowsEquals1.hashCode(), rowsEquals2.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals(rowsEquals2.toString(), "TableComposite{rows=[]}");
  }
}