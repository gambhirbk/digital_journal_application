package problem1;

import static problem1.Constants.HEADERS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A class representing a model
 */


public class Model {

  protected static final int HEADER_LINE = 1;
  protected static final int SECOND_COL = 1;
  private final String rootFile;
  private final TreeMap<Integer, DigitalEntry> entries;
  private Integer currentIndex;

  /**
   * A class representing a model
   *
   * @param CSV_FILE a csv file, a string
   * @throws FileNotFoundException thrown if the file is not found
   */

  public Model(String CSV_FILE) throws FileNotFoundException {
    this.rootFile = CSV_FILE;
    this.currentIndex = 0;
    this.entries = new TreeMap<>();
    this.process_file(this.rootFile);
  }

  /**
   * A helper method to process csv file
   *
   * @param fileName the name of file to process
   * @throws FileNotFoundException thrown if file is not found
   */
  private void process_file(String fileName) throws FileNotFoundException {
    try (Stream<String> lines = new BufferedReader(new FileReader(fileName)).lines()
        .skip(HEADER_LINE)) {
      lines.forEach(
          line -> {
            String[] split = line.split(",");
            List<String> fields = Arrays
                .asList(Arrays.copyOfRange(split, SECOND_COL, split.length));
            try {
              DigitalEntry newEntry = DigitalEntry.buildEntryFromString(fields);
              addEntry(newEntry);
            } catch (Exception e) {
              e.printStackTrace();
            }
          }
      );
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * A static method to filter by incomplete
   *
   * @param inputEntries the input entries to filter
   * @return a TreeMap containing incomplete entries
   */

  public static TreeMap<Integer, DigitalEntry> filterIncomplete(
      TreeMap<Integer, DigitalEntry> inputEntries) {
    return inputEntries.entrySet()
        .stream()
        .filter(x -> !x.getValue().getCompleted())
        .collect(
            Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, TreeMap::new));
  }

  /**
   * A static method to filter by category
   *
   * @param inputEntries the input entries to filter
   * @param category     the user's input category
   * @return a TreeMap containing data filtered by category provided
   */

  public static TreeMap<Integer, DigitalEntry> filterByCategory(
      TreeMap<Integer, DigitalEntry> inputEntries, String category) {
    return inputEntries.entrySet()
        .stream()
        .filter(x -> x.getValue().getCategory().equals(category))
        .collect(
            Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, TreeMap::new));
  }

  /**
   * A static method to sort by date
   *
   * @param inputEntries the input entries to sort
   * @return a TreeMap containing data sorted by date
   */


  public static TreeMap<Integer, DigitalEntry> sortEntriesByDate(
      TreeMap<Integer, DigitalEntry> inputEntries) {
    Comparator<Integer> comparator = new DateComparator(inputEntries);
    TreeMap<Integer, DigitalEntry> sorted = new TreeMap<>(comparator);
    sorted.putAll(inputEntries);
    return sorted;
  }

  /**
   * A static method to sort by priority
   *
   * @param inputEntries the input entries to sort by priority
   * @return a TreeMap containing data sorted by priority
   */

  public static TreeMap<Integer, DigitalEntry> sortEntriesByPriority(
      TreeMap<Integer, DigitalEntry> inputEntries) {
    Comparator<Integer> comparator = new PriorityComparator(inputEntries);
    TreeMap<Integer, DigitalEntry> sorted = new TreeMap<>(comparator);
    sorted.putAll(inputEntries);
    return sorted;
  }


  /**
   * A void method to add entry to the hashMap
   *
   * @param newEntry the digital entry to data to enter
   */

  public void addEntry(DigitalEntry newEntry) {
    this.entries.put(this.currentIndex, newEntry);
    this.currentIndex++;
  }

  /**
   * Getter for a getEntries
   *
   * @return getEntries
   */

  public TreeMap<Integer, DigitalEntry> getEntries() {
    return entries; //already sorted by ID
  }

  /**
   * A void method to write to csv file
   *
   * @throws FileNotFoundException if file is not found
   */

  public void writeToCSV() throws FileNotFoundException {
    StringBuilder output = new StringBuilder();
    output.append(HEADERS + '\n');
    for (Map.Entry<Integer, DigitalEntry> entry : this.entries.entrySet()) {
      output.append(entry.getKey()).append(',').append(entry.getValue().stringValue());
      output.append('\n');
    }
    String toWrite = output.toString();
    File file = new File(this.rootFile); // Create a file object
    try (BufferedWriter outputFile = new BufferedWriter(new FileWriter(file))) {
      outputFile.write(toWrite);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      throw e;
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }

  /**
   * A void method to set completed by id
   *
   * @param toFind an id used to complete record
   * @throws CmdLineExceptions.InvalidIDException thrown if id is invalid
   */

  public void setCompletedByID(Integer toFind) throws CmdLineExceptions {
    DigitalEntry found = this.entries.get(toFind);
    if (found != null) {
      if (!found.getCompleted()) {
        this.entries.remove(toFind);
        found.setCompleted(true);
        this.entries.put(toFind, found);
      }
    } else {
      throw new CmdLineExceptions.InvalidIDException("No such ID exists in the entries");
    }
  }

  /**
   * Setter for current index
   *
   * @param currentIndex the current index
   */

  public void setCurrentIndex(Integer currentIndex) {
    this.currentIndex = currentIndex;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Model)) {
      return false;
    }
    Model model = (Model) o;
    return currentIndex.equals(model.currentIndex) &&
        rootFile.equals(model.rootFile);
  }

  @Override
  public int hashCode() {
    return Objects.hash(currentIndex, rootFile);
  }

  @Override
  public String toString() {
    return "Model{" +
        "currentIndex=" + currentIndex +
        ", rootFile='" + rootFile + '\'' +
        '}';
  }
}
