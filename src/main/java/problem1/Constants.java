package problem1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A class representing constants
 */


public class Constants {

  public static final String CSV_ARG = "--csv-file";
  public static final String COMMAND_ADD_ENTRY = "--add-entry";
  public static final String ENTRY_TEXT = "--entry-text";
  public static final String ENTRY_COMPLETED = "--completed";
  public static final String ENTRY_DATE = "--date";
  public static final String ENTRY_PRIORITY = "--priority";
  public static final String ENTRY_CATEGORY = "--category";
  public static final String COMMAND_COMPLETE = "--complete-entry";
  public static final String COMMAND_DISPLAY = "--display";
  public static final String DISPLAY_INCOMPLETE = "--show-incomplete";
  public static final String DISPLAY_CATEGORY = "--show-category";
  public static final String DISPLAY_BY_DATE = "--sort-by-date";
  public static final String DISPLAY_BY_PRIORITY = "--sort-by-priority";
  public static final String FLAG_IDENTIFIER = "--";
  public static final int NOT_FOUND = -1;
  public static final List<String> PROCESSABLE = new ArrayList<>(
      Arrays.asList(CSV_ARG, COMMAND_ADD_ENTRY, COMMAND_COMPLETE, COMMAND_DISPLAY));
  public static final String HEADERS = "id,text,completed,due,priority,category";
}
