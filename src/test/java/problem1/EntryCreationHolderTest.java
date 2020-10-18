package problem1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class EntryCreationHolderTest {

  EntryCreationHolder entryWithoutText;
  EntryCreationHolder entryWithoutDate;
  // Set up for Equals(), hashCode(), toString() tests
  private EntryCreationHolder entryCreationHolder;
  private EntryCreationHolder entryCreationHolder1;
  private EntryCreationHolder entryCreationHolder2;
  private EntryCreationHolder entryCreationHolder3;

  @Before
  public void setUp() {
    entryWithoutText = new EntryCreationHolder();
    entryWithoutDate = new EntryCreationHolder();

    entryCreationHolder = new EntryCreationHolder();
    entryCreationHolder1 = new EntryCreationHolder();
    entryCreationHolder2 = new EntryCreationHolder();
    entryCreationHolder3 = new EntryCreationHolder();
  }

  @Test(expected = CmdLineExceptions.ArgumentNotFoundException.class)
  public void processWithoutText() throws CmdLineExceptions.ArgumentNotFoundException {
    ArrayList<String> userInput = new ArrayList<>();
    userInput.add("--csv-file");
    userInput.add("sample/test.csv");
    userInput.add("--add-entry");
    userInput.add("--completed");
    userInput.add("--date");
    userInput.add("01/01/2020");
    userInput.add("--priority");
    userInput.add("3");
    userInput.add("--category");
    userInput.add("home");
    userInput.add("--complete-entry");
    userInput.add("1");
    userInput.add("--complete-entry");
    userInput.add("2");
    userInput.add("--complete-entry");
    userInput.add("1");
    userInput.add("--display");
    userInput.add("--sort-by-date");

    entryWithoutText.process(userInput);
  }

  @Test(expected = CmdLineExceptions.ArgumentNotFoundException.class)
  public void processWithoutDate() throws CmdLineExceptions.ArgumentNotFoundException {
    ArrayList<String> userInput = new ArrayList<>();

    userInput.add("--csv-file");
    userInput.add("sample/test.csv");
    userInput.add("--entry-text");
    userInput.add("hello");
    userInput.add("--add-entry");
    userInput.add("--completed");
    userInput.add("--priority");
    userInput.add("3");
    userInput.add("--category");
    userInput.add("home");
    userInput.add("--complete-entry");
    userInput.add("1");
    userInput.add("--complete-entry");
    userInput.add("2");
    userInput.add("--complete-entry");
    userInput.add("1");
    userInput.add("--display");
    userInput.add("--sort-by-date");

    entryWithoutText.process(userInput);
  }

  @Test
  public void testEqualsReflective() {
    assertEquals(entryCreationHolder, entryCreationHolder1);
  }

  @Test
  public void testEqualsTransitive() {
    assertEquals(entryCreationHolder1, entryCreationHolder2);
    assertEquals(entryCreationHolder2, entryCreationHolder3);
    assertEquals(entryCreationHolder2, entryCreationHolder3);
  }

  @Test
  public void testEqualsSymmetric() {
    assertEquals(entryCreationHolder1, entryCreationHolder3);
    assertEquals(entryCreationHolder3, entryCreationHolder1);
  }

  @Test
  public void testEqualsConsistent() {
    for (int i = 0; i < 10; i++) {
      assertEquals(entryCreationHolder1, entryCreationHolder3);
    }
  }

  @Test
  public void testEqualsNull() {
    assertNotEquals(null, entryCreationHolder1);
  }

  @Test
  public void testEqualsClass() {
    assertNotEquals(34, entryCreationHolder1);
  }

  @Test
  public void testEqualsClass1() {
    assertNotEquals(entryCreationHolder2, new Object());
  }


  @Test
  public void testHashCode() {
    assertEquals(entryCreationHolder1.hashCode(), entryCreationHolder2.hashCode());
  }

  @Test
  public void testToString() {
    String expected = "EntryCreationHolder{}";
    assertEquals(expected, entryCreationHolder1.toString());
  }
}