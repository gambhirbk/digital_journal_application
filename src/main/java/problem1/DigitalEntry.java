package problem1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

/**
 * A class representing a digital entry class
 */
public class DigitalEntry {

  protected static final int LOWEST_PRIORITY = 3;
  protected static final int HIGHEST_PRIORITY = 1;
  private final String text;
  private final LocalDate date;
  private final Integer priority;
  private final String category;
  private Boolean completed;

  /**
   * A class representing digital entry
   *
   * @param builder the builder to build the contents
   */

  public DigitalEntry(EntryBuilder builder) {
    this.text = builder.text;
    this.completed = builder.completed;
    this.date = builder.date;
    this.priority = builder.priority;
    this.category = builder.category;
  }

  /**
   * A static method to build entry from string
   *
   * @param fields a list of string provided
   * @return DigitalEntry class with fields
   * @throws CmdLineExceptions.InvalidPriorityException thrown if priority is invalid
   */

  public static DigitalEntry buildEntryFromString(List<String> fields)
      throws CmdLineExceptions {
    String content = fields.get(0);
    Boolean completed = Boolean.parseBoolean(fields.get(1).toLowerCase());
    LocalDate date = parseDateFromString(fields.get(2));
    Integer priority = Integer.valueOf(fields.get(3));
    String category = fields.get(4);
    return new EntryBuilder(content, date)
        .addCompleted(completed)
        .addCategory(category)
        .addPriority(priority)
        .build();
  }

  /***
   * Helper method to generate date from String
   * @param input a string representing date
   * @return a Local Date object for Digital Entry
   */
  private static LocalDate parseDateFromString(String input) {
    LocalDate date = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    try {
      date = LocalDate.parse(input, formatter);
    } catch (Exception e1) {
      try {
        String[] dateInfo = input.split("/|-");
        date = LocalDate.of(Integer.parseInt(dateInfo[2]), Integer.parseInt(dateInfo[1]),
            Integer.parseInt(dateInfo[0]));
      } catch (Exception e2) {
        System.out.println("Date should be format MM/dd/yyyy. Default to today");
      }
    }
    return date;
  }

  /**
   * Getter for the text
   *
   * @return the text, a string
   */

  public String getText() {
    return text;
  }

  /**
   * Getter for completed
   *
   * @return boolean, true if completed, otherwise false
   */

  public Boolean getCompleted() {
    return completed;
  }

  /**
   * Setter for completed
   *
   * @param completed a boolean, true or false
   */

  public void setCompleted(Boolean completed) {
    this.completed = completed;
  }

  /**
   * Getter for date
   *
   * @return date, a LocalDate
   */

  public LocalDate getDate() {
    return date;
  }

  /**
   * Getter for priority
   *
   * @return priority, an Integer
   */

  public Integer getPriority() {
    return priority;
  }

  /**
   * Getter for category
   *
   * @return a category, a String
   */

  public String getCategory() {
    return category;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DigitalEntry that = (DigitalEntry) o;
    return Objects.equals(text, that.text) &&
        Objects.equals(completed, that.completed) &&
        Objects.equals(date, that.date) &&
        Objects.equals(priority, that.priority) &&
        Objects.equals(category, that.category);
  }

  @Override
  public int hashCode() {
    return Objects.hash(text, completed, date, priority, category);
  }

  @Override
  public String toString() {
    return "DigitalEntry{" +
        "text='" + text + '\'' +
        ", completed=" + completed +
        ", date=" + date +
        ", priority=" + priority +
        ", category='" + category + '\'' +
        '}';
  }

  public String stringValue() {
    String thisDate = date.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
    return text + "," + completed +
        "," + thisDate +
        "," + priority +
        "," + category;
  }

  /**
   * A static class representing EntryBuilder
   */

  public static class EntryBuilder {

    private final String text;
    private final LocalDate date;
    private Boolean completed;
    private Integer priority;
    private String category;

    /**
     * Constructor for the EntryBuilder class
     *
     * @param text the text provided, a string
     * @param date date provided, a LocalDate
     */

    public EntryBuilder(String text, LocalDate date) {
      this.text = text;
      this.date = date;
      this.completed = false;
      this.priority = LOWEST_PRIORITY;
      this.category = "";
    }

    /**
     * A method to add completed to entry
     *
     * @param completed a boolean to add
     * @return the EntryBuilder class after adding completed
     */

    public EntryBuilder addCompleted(Boolean completed) {
      if (completed != null) { // the csv file might contain null
        this.completed = completed;
      }
      return this;
    }

    /**
     * A method to add priority to entry
     *
     * @param priority, an Integer to add
     * @return the EntryBuilder class after adding priority
     */


    public EntryBuilder addPriority(Integer priority) throws CmdLineExceptions {
      if (checkPriority(priority) && priority != null) {
        this.priority = priority;
      }
      return this;
    }

    /**
     * A method to add category to entry
     *
     * @param category, a category to add
     * @return the EntryBuilder class after adding category
     */


    public EntryBuilder addCategory(String category) {
      this.category = category;
      return this;
    }

    /**
     * A method to build digital entry
     *
     * @return a new digital entry object
     */

    public DigitalEntry build() {
      return new DigitalEntry(this);
    }

    /**
     * A helper method to check priority
     *
     * @param priority a priority to check
     * @return Boolean, true if priority is within range, otherwise false
     * @throws CmdLineExceptions.InvalidPriorityException thrown if the priority is invalid
     */

    private boolean checkPriority(Integer priority) throws CmdLineExceptions {
      if (priority < HIGHEST_PRIORITY || priority > LOWEST_PRIORITY) {
        throw new CmdLineExceptions.InvalidPriorityException("Priority must be between 1 and 3");
      }
      return true;
    }
  }
}
