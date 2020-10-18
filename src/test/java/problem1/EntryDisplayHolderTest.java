package problem1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

public class EntryDisplayHolderTest {

  EntryDisplayHolder displayEquals1;
  EntryDisplayHolder displayEquals2;
  EntryDisplayHolder displayEquals3;

  @Before
  public void setUp() {
    displayEquals1 = new EntryDisplayHolder();
    displayEquals2 = new EntryDisplayHolder();
    displayEquals3 = new EntryDisplayHolder();
  }

  @Test
  public void testEqualsReflective() {
    assertEquals(displayEquals1, displayEquals1);
  }

  @Test
  public void testEqualsTransitive() {
    assertEquals(displayEquals1, displayEquals2);
    assertEquals(displayEquals2, displayEquals3);
    assertEquals(displayEquals1, displayEquals3);
  }

  @Test
  public void testEqualsSymmetric() {
    assertEquals(displayEquals1, displayEquals3);
    assertEquals(displayEquals3, displayEquals1);
  }

  @Test
  public void testEqualsConsistent() {
    for (int i = 0; i < 10; i++) {
      assertEquals(displayEquals1, displayEquals2);
    }
  }

  @Test
  public void testEqualsNull() {
    assertNotEquals(null, displayEquals1);
  }

  @Test
  public void testEqualsClass() {
    assertNotEquals(34, displayEquals2);
  }

  @Test
  public void testEqualsClass1() {
    assertNotEquals(displayEquals1, new Object());
  }

  @Test
  public void testHashCode() {
    assertEquals(displayEquals1.hashCode(), displayEquals2.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals(displayEquals1.toString(), "DataProcessor{}");
  }
}