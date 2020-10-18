package problem1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CommandLineProcessorTest {

  CommandLineProcessor testEqualsSame1;
  CommandLineProcessor testEqualsSame2;
  CommandLineProcessor testEqualsSame3;

  @Before
  public void setUp() {
    String[] userInput1 = {"--csv-file", "something", "--add-entry", "--entry-text", "hello",
        "--completed", "true", "--date", "1/1/2020", "--priority", "3", "--category", "home",
        "--complete-entry", "1", "--complete-entry", "2", "--complete-entry", "1",
        "--display", "--show-incomplete", "--sort-by-priority", "--show-category", "home"};
    testEqualsSame1 = new CommandLineProcessor(userInput1);
    testEqualsSame2 = new CommandLineProcessor(userInput1);
    testEqualsSame3 = new CommandLineProcessor(userInput1);
  }



  @Test(expected = CmdLineExceptions.ArgumentNotFoundException.class)
  public void argumentNotFound()
      throws CmdLineExceptions.ArgumentNotFoundException, CmdLineExceptions.UnknownArgumentException {
    String[] userInput = {"something", "--add-entry", "--entry-text", "hello", "--completed",
        "true", "--date", "1/1/2020", "--priority", "3", "--category", "home",
        "--complete-entry", "1", "--complete-entry", "2", "--complete-entry", "1",
        "--display", "--show-incomplete", "--sort-by-priority", "--show-category", "home"};
    CommandLineProcessor test = new CommandLineProcessor(userInput);
    test.argumentSeparator();
  }

  @Test(expected = CmdLineExceptions.UnknownArgumentException.class)
  public void inValidArgument()
      throws CmdLineExceptions.ArgumentNotFoundException, CmdLineExceptions.UnknownArgumentException {
    String[] userInput = {"--csv-file", "something", "--add-entry", "--entry-text", "hello",
        "--completed", "true", "--date", "1/1/2020", "--priority", "3", "--category", "home",
        "--complete-entry", "1", "--complete-entry", "2", "--complete-entry", "1",
        "--display", "--show-incomplete", "--sort-by-priority", "--show-category", "home",
        "--test"};
    CommandLineProcessor test = new CommandLineProcessor(userInput);
    test.argumentSeparator();
  }

  @Test(expected = CmdLineExceptions.UnknownArgumentException.class)
  public void inValidArgumentId()
      throws CmdLineExceptions.ArgumentNotFoundException, CmdLineExceptions.UnknownArgumentException {
    String[] userInput = {"--csv-file", "something", "--add-entry", "--entry-text", "hello",
        "--completed", "true", "--date", "1/1/2020", "--priority", "3", "--category", "home",
        "--complete-entry", "1", "--complete-entry", "2", "--complete-entry",
        "--display", "--show-incomplete", "--sort-by-priority", "--show-category", "home"};
    CommandLineProcessor test = new CommandLineProcessor(userInput);
    test.argumentSeparator();
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

  @Test
  public void testHashCode() {
    assertEquals(testEqualsSame1.hashCode(), testEqualsSame2.hashCode());
  }


  @Test
  public void testString() {
    String expectedString = "CommandLineProcessor{cmdArguments=[--csv-file, something, --add-entry, --entry-text, hello, --completed, true, --date, 1/1/2020, --priority, 3, --category, home, --complete-entry, 1, --complete-entry, 2, --complete-entry, 1, --display, --show-incomplete, --sort-by-priority, --show-category, home]}";
    assertEquals(expectedString, testEqualsSame3.toString());
  }
}