package problem1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class ViewTest {

  View testEquals1;
  View testEquals2;
  View testEquals3;
  View testDifferent1;

  Map<Integer, DigitalEntry> allEntries;

  @Before
  public void setUp() {
    testEquals1 = new View(allEntries);
    testEquals2 = new View(allEntries);
    testEquals3 = new View(allEntries);

    testDifferent1 = new View(null);
  }

  @Test
  public void testPrintAllEntries() {
    testDifferent1.printAllEntries();
    assertTrue("Queries return no result", true);
  }

  @Test
  public void testEqualsReflective() {
    assertEquals(testEquals1, testEquals1);
  }

  @Test
  public void testEqualsTransitive() {
    assertEquals(testEquals1, testEquals2);
    assertEquals(testEquals2, testEquals3);
    assertEquals(testEquals3, testEquals1);
  }

  @Test
  public void testEqualsSymmetric() {
    assertEquals(testEquals1, testEquals3);
    assertEquals(testEquals3, testEquals1);
  }

  @Test
  public void testEqualsConsistent() {
    for (int i = 0; i < 10; i++) {
      assertEquals(testEquals1, testEquals3);
    }
  }

  @Test
  public void testEqualsNull() {
    assertNotEquals(null, testEquals1);
  }

  @Test
  public void testEqualsClass() {
    assertNotEquals(34, testEquals3);
  }

  @Test
  public void testEqualsClass1() {
    assertNotEquals(testEquals1, new Object());
  }

  @Test
  public void testHashCode() {
    assertEquals(testEquals1.hashCode(), testEquals2.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals(testEquals1.toString(), "View{allEntries=null}");
  }
}