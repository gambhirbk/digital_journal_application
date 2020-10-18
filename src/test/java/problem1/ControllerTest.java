package problem1;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.Before;
import org.junit.Test;

public class ControllerTest {

  Model testModel;
  Controller testController;
  ArrayList<String> testHashMapValues;
  ArrayList<String> copyTestHashMapValues;
  HashMap<String, ArrayList<String>> testTasks;
  HashMap<String, ArrayList<String>> copyTestTasks;

  @Before
  public void setUp() throws Exception {
    testModel = new Model("sample/test.csv");
    testHashMapValues = new ArrayList<>();
    testHashMapValues.add("apple");
    testHashMapValues.add("banana");

    testTasks = new HashMap<>();
    testTasks.put("fruits", testHashMapValues);

    testController = new Controller(testModel, testTasks);
  }

  @Test
  public void getModel() throws FileNotFoundException {
    assertEquals(new Model("sample/test.csv"), testController.getModel());
  }

  @Test
  public void getTasks() {
    copyTestHashMapValues = new ArrayList<>();
    copyTestHashMapValues.add("apple");
    copyTestHashMapValues.add("banana");

    copyTestTasks = new HashMap<>();
    copyTestTasks.put("fruits", testHashMapValues);
    assertEquals(copyTestTasks, testController.getTasks());
  }
}