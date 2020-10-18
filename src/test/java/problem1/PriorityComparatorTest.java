package problem1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.TreeMap;
import org.junit.Before;
import org.junit.Test;
import problem1.DigitalEntry.EntryBuilder;

public class PriorityComparatorTest {

  // Set up for Equals(), hashCode(), toString() tests
  PriorityComparator testEqualsSame1;
  PriorityComparator testEqualsSame2;
  PriorityComparator testEqualsSame3;

  TreeMap<Integer, DigitalEntry> testMap1;
  TreeMap<Integer, DigitalEntry> testMap2;
  TreeMap<Integer, DigitalEntry> testMap3;

  PriorityComparator testEqualsDifferent0;
  PriorityComparator testEqualsDifferent1;
  PriorityComparator testEqualsDifferent2;

  PriorityComparator priorityComparator1;

  DigitalEntry digitalEntry1;
  DigitalEntry digitalEntry2;


  EntryBuilder entryBuilder1;
  EntryBuilder entryBuilder2;

  LocalDate date1;
  LocalDate date2;

  TreeMap<Integer, DigitalEntry> map1;

  @Before
  public void setUp() {
    date1 = LocalDate.of(2020, 11, 22);
    date2 = LocalDate.of(2020, 5, 13);

    entryBuilder1 = new EntryBuilder("XYZ", date1);
    entryBuilder1.addCompleted(false);
    entryBuilder1.addPriority(2);
    entryBuilder1.addCategory("home");

    entryBuilder2 = new EntryBuilder("xyz", date2);
    entryBuilder1.addCompleted(false);
    entryBuilder1.addPriority(1);
    entryBuilder1.addCategory("school");

    digitalEntry1 = new DigitalEntry(entryBuilder1);
    digitalEntry2 = new DigitalEntry(entryBuilder2);

    map1 = new TreeMap<>();

    map1.put(1, digitalEntry1);
    map1.put(2, digitalEntry2);
    map1.put(3, digitalEntry1);
    priorityComparator1 = new PriorityComparator(map1);

    // Set up for Equals(), hashCode(), toString() tests

    testMap1 = new TreeMap<>();
    testMap1.put(1, digitalEntry1);

    testMap2 = new TreeMap<>();
    testMap2.put(2, digitalEntry1);

    testMap3 = new TreeMap<>();
    testMap2.put(1, digitalEntry2);

    testEqualsSame1 = new PriorityComparator(testMap1);
    testEqualsSame2 = new PriorityComparator(testMap1);
    testEqualsSame3 = new PriorityComparator(testMap1);

    testEqualsDifferent0 = new PriorityComparator(testMap1);
    testEqualsDifferent1 = new PriorityComparator(testMap2);
    testEqualsDifferent2 = new PriorityComparator(testMap3);
  }

  @Test
  public void testCompare() {
    assertEquals(-1, priorityComparator1.compare(1, 2), 0.0);
    assertEquals(1, priorityComparator1.compare(1, 3), 0.0);
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

  // Case7: Different class state

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
  public void testHashCode() {
    assertEquals(testEqualsSame1.hashCode(), testEqualsSame2.hashCode());
    assertNotEquals(testEqualsSame1.hashCode(), testEqualsDifferent1.hashCode());
  }

  @Test
  public void testString() {
    String expectedString = "DigitalEntryComparator{map={1=DigitalEntry{text='XYZ', completed=false, date=2020-11-22, priority=1, category='school'}}}";
    assertEquals(expectedString, testEqualsSame1.toString());
  }
}