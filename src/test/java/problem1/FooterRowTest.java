package problem1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

public class FooterRowTest {

  FooterRow footerEquals1;
  FooterRow footerEquals2;
  FooterRow footerEquals3;

  @Before
  public void setUp() {
    footerEquals1 = new FooterRow();
    footerEquals2 = new FooterRow();
    footerEquals3 = new FooterRow();
  }

  @Test
  public void testEqualsReflective() {
    assertEquals(footerEquals1, footerEquals1);
  }

  @Test
  public void testEqualsTransitive() {
    assertEquals(footerEquals1, footerEquals2);
    assertEquals(footerEquals2, footerEquals3);
    assertEquals(footerEquals1, footerEquals3);
  }

  @Test
  public void testEqualsSymmetric() {
    assertEquals(footerEquals1, footerEquals3);
    assertEquals(footerEquals3, footerEquals1);
  }

  @Test
  public void testEqualsConsistent() {
    for (int i = 0; i < 10; i++) {
      assertEquals(footerEquals1, footerEquals2);
    }
  }

  @Test
  public void testEqualsNull() {
    assertNotEquals(null, footerEquals1);
  }

  @Test
  public void testEqualsClass() {
    assertNotEquals(34, footerEquals2);
  }

  @Test
  public void testEqualsClass1() {
    assertNotEquals(footerEquals1, new Object());
  }

  @Test
  public void testHashCode() {
    assertEquals(footerEquals1.hashCode(), footerEquals2.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals(footerEquals1.toString(), "FooterRow{}");
  }
}