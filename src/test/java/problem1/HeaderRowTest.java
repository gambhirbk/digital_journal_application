package problem1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

public class HeaderRowTest {

  HeaderRow headerRowEquals1;
  HeaderRow headerRowEquals2;
  HeaderRow headerRowEquals3;

  @Before
  public void setUp() {
    String[] cat = {"Cats"};
    headerRowEquals1 = new HeaderRow(cat);
    headerRowEquals2 = new HeaderRow(cat);
    headerRowEquals3 = new HeaderRow(cat);
  }

  @Test
  public void testEqualsReflective() {
    assertEquals(headerRowEquals1, headerRowEquals1);
  }

  @Test
  public void testEqualsTransitive() {
    assertEquals(headerRowEquals1, headerRowEquals2);
    assertEquals(headerRowEquals2, headerRowEquals3);
    assertEquals(headerRowEquals1, headerRowEquals3);
  }

  @Test
  public void testEqualsSymmetric() {
    assertEquals(headerRowEquals1, headerRowEquals2);
    assertEquals(headerRowEquals2, headerRowEquals1);
  }

  @Test
  public void testEqualsConsistent() {
    for (int i = 0; i < 10; i++) {
      assertEquals(headerRowEquals1, headerRowEquals2);
    }
  }

  @Test
  public void testEqualsNull() {
    assertNotEquals(null, headerRowEquals1);
  }

  @Test
  public void testEqualsClass() {
    assertNotEquals(34, headerRowEquals2);
  }

  @Test
  public void testEqualsClass1() {
    assertNotEquals(headerRowEquals1, new Object());
  }

  @Test
  public void testHashCode() {
    assertEquals(headerRowEquals1.hashCode(), headerRowEquals2.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals(headerRowEquals1.toString(), "HeaderRow{}");
  }
}