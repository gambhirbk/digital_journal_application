package problem1;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import org.junit.After;
import org.junit.Test;

public class MainTest {

  @Test
  public void testNoResult()
      throws CmdLineExceptions, FileNotFoundException {
    String[] userInput = {"--csv-file", "sample/test.csv", "--add-entry", "--entry-text", "hello",
        "--completed", "true", "--date", "01/01/2020", "--priority", "3", "--category", "home",
        "--complete-entry", "1", "--complete-entry", "2", "--complete-entry", "1",
        "--display", "--show-incomplete", "--sort-by-priority", "--show-category", "Home"};
    Main.main(userInput);
  }

  @Test
  public void testDateWrongFormatButStillProcessable()
      throws CmdLineExceptions, FileNotFoundException {
    String[] userInput = {"--csv-file", "sample/test.csv", "--add-entry", "--entry-text", "hello",
        "--completed", "true", "--date", "3/01/2020", "--priority", "3", "--category", "home",
        "--complete-entry", "1", "--complete-entry", "2", "--complete-entry", "1",
        "--display"};
    Main.main(userInput);
  }

  @Test
  public void testDateWrongFormatButStillProcessable2()
      throws CmdLineExceptions, FileNotFoundException {
    String[] userInput = {"--csv-file", "sample/test.csv", "--add-entry", "--entry-text", "hello",
        "--completed", "true", "--date", "3-01-2020", "--priority", "3", "--category", "home",
        "--complete-entry", "1", "--complete-entry", "2", "--complete-entry", "1",
        "--display"};
    Main.main(userInput);
  }

  @Test
  public void testDuplicateComplete()
      throws CmdLineExceptions, FileNotFoundException {

    String[] userInput = {"--csv-file", "sample/test.csv", "--add-entry", "--entry-text", "hello",
        "--completed", "true", "--date", "01/01/2020", "--priority", "3", "--category", "home",
        "--complete-entry", "1", "--complete-entry", "2", "--complete-entry", "1",
        "--display", "--sort-by-priority", "--show-category", "Home"};
    Main.main(userInput);
  }

  @Test
  public void testSortByDate()
      throws CmdLineExceptions, FileNotFoundException {

    String[] userInput = {"--csv-file", "sample/test.csv", "--add-entry", "--entry-text", "hello",
        "--completed", "true", "--date", "01/01/2020", "--priority", "3", "--category", "home",
        "--complete-entry", "1", "--complete-entry", "2", "--complete-entry", "1",
        "--display", "--sort-by-date", "--show-category", "Home"};
    Main.main(userInput);
  }

  @Test
  public void testSortByPriority()
      throws CmdLineExceptions, FileNotFoundException {
    String[] userInput = {"--csv-file", "sample/test.csv", "--add-entry", "--entry-text", "hello",
        "--completed", "true", "--date", "01/01/2020", "--priority", "3", "--category", "home",
        "--complete-entry", "1", "--complete-entry", "2", "--complete-entry", "1",
        "--display", "--sort-by-priority"};
    Main.main(userInput);
  }

  @Test
  public void testAll()
      throws CmdLineExceptions, FileNotFoundException {
    String[] userInput = {"--csv-file", "sample/test.csv", "--add-entry", "--entry-text", "hello",
        "--completed", "true", "--date", "01/01/2020", "--priority", "3", "--category", "home",
        "--complete-entry", "1", "--complete-entry", "2", "--complete-entry", "1",
        "--display", "--sort-by-date"};
    Main.main(userInput);
  }

  @Test
  public void testDisplayAll()
      throws CmdLineExceptions, FileNotFoundException {
    String[] userInput = {"--csv-file", "sample/test.csv", "--add-entry", "--entry-text", "hello",
        "--completed", "true", "--date", "01/01/2020", "--priority", "3", "--category", "home",
        "--complete-entry", "1", "--complete-entry", "2", "--complete-entry", "1",
        "--display"};
    Main.main(userInput);
  }

  @Test
  public void testDisplayError()
      throws CmdLineExceptions{
    String[] userInput = {"--csv-file", "--add-entry", "--entry-text", "hello",
        "--completed", "true", "--date", "01/01/2020", "--priority", "3", "--category", "home",
        "--complete-entry", "1", "--complete-entry", "2", "--complete-entry", "1",
        "--display"};
    try {
      Main.main(userInput);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  @After
  public void tearDown(){
    try {
      File read = new File("sample/backup_test.csv");
      Scanner sc = new Scanner(read);
      File write = new File("sample/test.csv");
      PrintWriter writer = new PrintWriter(write);

      while (sc.hasNextLine()) {
        String line = sc.nextLine();
        writer.println(line);
      }
      writer.close();
      sc.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}