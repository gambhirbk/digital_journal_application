package problem1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

public class EntryCompleteHolderTest {

  private EntryCompleteHolder entryCompleteHolder;
  private EntryCompleteHolder entryCompleteHolder1;
  private EntryCompleteHolder entryCompleteHolder2;
  private EntryCompleteHolder entryCompleteHolder3;


  @Before
  public void setUp() {
    entryCompleteHolder = new EntryCompleteHolder();
    entryCompleteHolder1 = new EntryCompleteHolder();
    entryCompleteHolder2 = new EntryCompleteHolder();
    entryCompleteHolder3 = new EntryCompleteHolder();
  }

  @Test
  public void testEqualsReflective() {
    assertEquals(entryCompleteHolder, entryCompleteHolder1);
  }

  @Test
  public void testEqualsTransitive() {
    assertEquals(entryCompleteHolder1, entryCompleteHolder2);
    assertEquals(entryCompleteHolder2, entryCompleteHolder3);
    assertEquals(entryCompleteHolder2, entryCompleteHolder3);
  }

  @Test
  public void testEqualsSymmetric() {
    assertEquals(entryCompleteHolder1, entryCompleteHolder3);
    assertEquals(entryCompleteHolder3, entryCompleteHolder1);
  }

  @Test
  public void testEqualsConsistent() {
    for (int i = 0; i < 10; i++) {
      assertEquals(entryCompleteHolder1, entryCompleteHolder3);
    }
  }

  @Test
  public void testEqualsNull() {
    assertNotEquals(null, entryCompleteHolder1);
  }

  @Test
  public void testEqualsClass() {
    assertNotEquals(34, entryCompleteHolder1);
  }

  @Test
  public void testEqualsClass1() {
    assertNotEquals(entryCompleteHolder2, new Object());
  }


  @Test
  public void testHashCode() {
    assertEquals(entryCompleteHolder1.hashCode(), entryCompleteHolder2.hashCode());
  }

  @Test
  public void testToString() {
    String expected = "EntryCompleteHolder{}";
    assertEquals(expected, entryCompleteHolder1.toString());
  }
}