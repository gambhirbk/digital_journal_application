package problem1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import problem1.DigitalEntry.EntryBuilder;

public class DigitalEntryTest {


  // Set up for Equals(), hashCode(), toString() tests
  DigitalEntry testEqualsSame1;
  DigitalEntry testEqualsSame2;
  DigitalEntry testEqualsSame3;

  DigitalEntry testEqualsDifferent0;
  DigitalEntry testEqualsDifferent1;
  DigitalEntry testEqualsDifferent2;
  DigitalEntry testEqualsDifferent3;
  DigitalEntry testEqualsDifferent4;
  DigitalEntry testEqualsDifferent5;

  EntryBuilder testEntryBuilder1;
  EntryBuilder testEntryBuilder2;
  EntryBuilder testEntryBuilder3;
  EntryBuilder testEntryBuilder4;
  EntryBuilder testEntryBuilder5;


  DigitalEntry testDigitalEntry;
  EntryBuilder testEntryBuilder;

  DigitalEntry testNullDigitalEntry;
  EntryBuilder testNullEntryBuilder;


  LocalDate testDate;
  LocalDate testDate1;

  @Before
  public void setUp() {
    testDate = LocalDate.of(2020, 11, 22);
    testEntryBuilder = new EntryBuilder("XYZ", testDate);
    testEntryBuilder.addCompleted(false);
    testEntryBuilder.addPriority(3);
    testEntryBuilder.addCategory("home");
    testDigitalEntry = new DigitalEntry(testEntryBuilder);

    // Set up for Equals(), hashCode(), toString() tests
    testEqualsSame1 = new DigitalEntry(testEntryBuilder);
    testEqualsSame2 = new DigitalEntry(testEntryBuilder);
    testEqualsSame3 = new DigitalEntry(testEntryBuilder);

    testDate1 = LocalDate.of(2019, 10, 21);

    testEntryBuilder1 = new EntryBuilder("ABC", testDate);
    testEntryBuilder2 = new EntryBuilder("XYZ", testDate1);
    testEntryBuilder3 = new EntryBuilder("XYZ", testDate);
    testEntryBuilder3.addCompleted(true);
    testEntryBuilder4 = new EntryBuilder("XYZ", testDate);
    testEntryBuilder4.addPriority(2);
    testEntryBuilder5 = new EntryBuilder("XYZ", testDate);
    testEntryBuilder5.addCategory("food");

    testEqualsDifferent0 = new DigitalEntry(testEntryBuilder);
    testEqualsDifferent1 = new DigitalEntry(testEntryBuilder1);
    testEqualsDifferent2 = new DigitalEntry(testEntryBuilder2);
    testEqualsDifferent3 = new DigitalEntry(testEntryBuilder3);
    testEqualsDifferent4 = new DigitalEntry(testEntryBuilder4);
    testEqualsDifferent5 = new DigitalEntry(testEntryBuilder5);

    testNullEntryBuilder = new EntryBuilder("XYZ", testDate);
    testNullEntryBuilder.addPriority(3);
    testNullEntryBuilder.addCompleted(null);
    testNullEntryBuilder.addCategory("food");
    testNullDigitalEntry = new DigitalEntry(testNullEntryBuilder);

  }

  @Test
  public void getText() {
    assertEquals("XYZ", testDigitalEntry.getText());
  }

  @Test
  public void getCompleted() {
    assertEquals(false, testDigitalEntry.getCompleted());
  }

  @Test
  public void getCompleted1() {
    testDigitalEntry.setCompleted(true);
    assertEquals(true, testDigitalEntry.getCompleted());
  }


  @Test
  public void getDate() {
    assertEquals(LocalDate.of(2020, 11, 22), testDigitalEntry.getDate());
  }

  @Test
  public void getPriority() {
    assertEquals(3, testDigitalEntry.getPriority(), 0.0);
  }

  @Test
  public void getCategory() {
    assertEquals("home", testDigitalEntry.getCategory());
  }

  @Test(expected = CmdLineExceptions.InvalidPriorityException.class)
  public void invalidPriority1() throws CmdLineExceptions.InvalidPriorityException {
    testEntryBuilder.addPriority(4);
  }

  @Test(expected = CmdLineExceptions.InvalidPriorityException.class)
  public void invalidPriority2() throws CmdLineExceptions.InvalidPriorityException {
    testEntryBuilder.addPriority(0);
  }

  @Test
  public void priorityNull() {

    assertEquals(testNullEntryBuilder, testNullEntryBuilder.addCompleted(null));
  }

  // Equality test
// Case1: Reflexive
  @Test
  public void testEqualsReflexive() {
    assertEquals(testEqualsSame1, testEqualsSame1);
  }

  // Case2: Symmetric
  @Test
  public void testEqualsSymmetric() {
    assertTrue(testEqualsSame1.equals(testEqualsSame2) && testEqualsSame2.equals(testEqualsSame1));
  }

  // Case3: Transitive
  @Test
  public void testEqualsTransitive() {
    assertEquals(testEqualsSame1.equals(testEqualsSame2) &&
            (testEqualsSame2.equals(testEqualsSame3)),
        testEqualsSame1.equals(testEqualsSame3));
  }

  // Case4: Consistent
  @Test
  public void testEqualsConsistent() {
    for (int i = 0; i < 10; i++) {
      assertEquals(testEqualsSame1, testEqualsSame2);
    }
  }

  // Case5: null case
  @Test
  public void testEqualsNull() {
    assertNotEquals(testEqualsSame1,
        null);
  }

  // Case6: Equal class
  @Test
  public void testEqualsClass() {
    assertNotEquals(testEqualsSame1, new Object());
  }

  @Test
  public void testEqualsString() {
    assertNotEquals(testEqualsDifferent0, "String");
  }

  @Test
  public void testEqualsDifferent1() {
    assertNotEquals(testEqualsDifferent0, testEqualsDifferent1);
  }

  @Test
  public void testEqualsDifferent2() {
    assertNotEquals(testEqualsDifferent0, testEqualsDifferent2);
  }

  @Test
  public void testEqualsDifferent3() {
    assertNotEquals(testEqualsDifferent0, testEqualsDifferent3);
  }

  @Test
  public void testEqualsDifferent4() {
    assertNotEquals(testEqualsDifferent0, testEqualsDifferent4);
  }

  @Test
  public void testEqualsDifferent5() {
    assertNotEquals(testEqualsDifferent0, testEqualsDifferent5);
  }

  @Test
  public void testHashCode() {
    assertEquals(testEqualsSame1.hashCode(), testEqualsSame2.hashCode());
    assertNotEquals(testEqualsSame1.hashCode(), testEqualsDifferent1.hashCode());
  }

  @Test
  public void testString() {
    String expectedString = "DigitalEntry{text='XYZ', completed=false, date=2020-11-22, priority=3, category='home'}";
    assertEquals(expectedString, testEqualsSame1.toString());
  }

}