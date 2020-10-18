package problem1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.TreeMap;
import org.junit.Before;
import org.junit.Test;
import problem1.DigitalEntry.EntryBuilder;

public class ModelTest {

  // Set up for Equals(), hashCode(), toString() tests
  Model testEqualsSame1;
  Model testEqualsSame2;
  Model testEqualsSame3;


  Model testModel;
  Model fileNotFoundModel;

  DigitalEntry testDigitalEntry;
  EntryBuilder testEntryBuilder;

  TreeMap<Integer, DigitalEntry> testTreeMap;
  TreeMap<Integer, DigitalEntry> resultTreeMap;

  TreeMap<Integer, DigitalEntry> copyTreeMap;

  LocalDate testDate;

  @Before
  public void setUp() throws Exception {
    testDate = LocalDate.of(2020, 11, 22);
    testEntryBuilder = new EntryBuilder("XYZ", testDate);
    testEntryBuilder.addCompleted(false);
    testEntryBuilder.addPriority(3);
    testEntryBuilder.addCategory("home");
    testDigitalEntry = new DigitalEntry(testEntryBuilder);
    testModel = new Model("sample/test.csv");
    fileNotFoundModel = new Model("abc.csv");
    testTreeMap = new TreeMap<>();
    copyTreeMap = new TreeMap<>();
    testTreeMap.put(1, testDigitalEntry);

    testEqualsSame1 = new Model("sample/test.csv");
    testEqualsSame1.setCurrentIndex(1);
    testEqualsSame2 = new Model("sample/test.csv");
    testEqualsSame2.setCurrentIndex(1);
    testEqualsSame3 = new Model("sample/test.csv");
    testEqualsSame3.setCurrentIndex(1);

  }

  @Test
  public void filterIncomplete() {
    copyTreeMap.put(1, testDigitalEntry);
    resultTreeMap = Model.filterIncomplete(testTreeMap);

    assertEquals(copyTreeMap, resultTreeMap);

  }

  @Test
  public void filterByCategory() {
    copyTreeMap.put(1, testDigitalEntry);
    resultTreeMap = Model.filterByCategory(testTreeMap, "home");
    assertEquals(copyTreeMap, resultTreeMap);
  }

  @Test(expected = CmdLineExceptions.InvalidIDException.class)
  public void invalidID() throws CmdLineExceptions.InvalidIDException {
    testModel.setCompletedByID(200);
  }

  @Test
  public void setCompletedByID() {
    testModel.setCompletedByID(1);
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
    assertNotEquals(testEqualsSame1, "String");
  }

  @Test
  public void testHashCode() {
    assertEquals(testEqualsSame1.hashCode(), testEqualsSame2.hashCode());
  }

  @Test
  public void testString() {
    String expectedString = "Model{currentIndex=1, rootFile='sample/test.csv'}";
    assertEquals(expectedString, testEqualsSame1.toString());
  }


}

