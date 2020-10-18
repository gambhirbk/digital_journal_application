package problem1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.HashMap;
import org.junit.Before;
import org.junit.Test;

public class EntryCSVHolderTest {

  EntryCSVHolder csvHolderTest1;
  EntryCSVHolder csvHolderTest2;
  EntryCSVHolder csvHolderTest3;

  @Before
  public void setUp() {
    csvHolderTest1 = new EntryCSVHolder();
    csvHolderTest2 = new EntryCSVHolder();
    csvHolderTest3 = new EntryCSVHolder();
  }

  @Test
  public void testProcess(){
    ArrayList<String> userInput = new ArrayList<>();
    userInput.add("--csv-file");
    userInput.add("sample/test.csv");
    csvHolderTest1.process(userInput);
    HashMap<String, ArrayList<String>> output = new HashMap<>();
    ArrayList<String> arguments = new ArrayList<>();
    arguments.add("sample/test.csv");
    output.put("--csv-file",arguments);
    assertEquals(output,csvHolderTest1.getCurrentOutput());
  }

  @Test
  public void testEqualsReflective() {
    assertEquals(csvHolderTest1, csvHolderTest1);
  }

  @Test
  public void testEqualsTransitive() {
    assertEquals(csvHolderTest1, csvHolderTest2);
    assertEquals(csvHolderTest2, csvHolderTest3);
    assertEquals(csvHolderTest1, csvHolderTest3);
  }

  @Test
  public void testEqualsSymmetric() {
    assertEquals(csvHolderTest1, csvHolderTest3);
    assertEquals(csvHolderTest3, csvHolderTest1);
  }

  @Test
  public void testEqualsConsistent() {
    for (int i = 0; i < 10; i++) {
      assertEquals(csvHolderTest1, csvHolderTest2);
    }
  }

  @Test
  public void testEqualsNull() {
    assertNotEquals(null, csvHolderTest1);
  }

  @Test
  public void testEqualsClass() {
    assertNotEquals(34, csvHolderTest2);
  }

  @Test
  public void testEqualsClass1() {
    assertNotEquals(csvHolderTest1, new Object());
  }

  @Test
  public void testHashCode() {
    assertEquals(csvHolderTest1.hashCode(), csvHolderTest2.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals(csvHolderTest1.toString(), "EntryCSVHolder{}");
  }
}