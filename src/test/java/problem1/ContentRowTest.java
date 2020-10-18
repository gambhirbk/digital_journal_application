package problem1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import problem1.DigitalEntry.EntryBuilder;

public class ContentRowTest {

  ContentRow contentEquals1;
  ContentRow contentEquals2;
  ContentRow contentEquals3;
  ContentRow contentDifferent1;

  DigitalEntry digitalEntry1;
  DigitalEntry digitalEntry2;

  EntryBuilder entryBuilder1;
  EntryBuilder entryBuilder2;

  LocalDate date1;
  LocalDate date2;

  @Before
  public void setUp() {
    date1 = LocalDate.of(2020, 11, 22);
    date2 = LocalDate.of(2020, 12, 29);

    entryBuilder1 = new EntryBuilder("ABC", date1);
    entryBuilder2 = new EntryBuilder("XYZ", date2);

    digitalEntry1 = new DigitalEntry(entryBuilder1);
    digitalEntry2 = new DigitalEntry(entryBuilder2);

    contentEquals1 = new ContentRow(2, digitalEntry1);
    contentEquals2 = new ContentRow(2, digitalEntry1);
    contentEquals3 = new ContentRow(2, digitalEntry1);

    contentDifferent1 = new ContentRow(3, digitalEntry2);
  }

  @Test
  public void testEqualsReflective() {
    assertEquals(contentEquals1, contentEquals1);
  }

  @Test
  public void testEqualsTransitive() {
    assertEquals(contentEquals1, contentEquals2);
    assertEquals(contentEquals2, contentEquals3);
    assertEquals(contentEquals1, contentEquals3);
  }

  @Test
  public void testEqualsSymmetric() {
    assertEquals(contentEquals1, contentEquals3);
    assertEquals(contentEquals3, contentEquals1);
  }

  @Test
  public void testEqualsConsistent() {
    for (int i = 0; i < 10; i++) {
      assertEquals(contentEquals1, contentEquals2);
    }
  }

  @Test
  public void testEqualsNull() {
    assertNotEquals(null, contentEquals1);
  }

  @Test
  public void testEqualsClass() {
    assertNotEquals(34, contentEquals2);
  }

  @Test
  public void testEqualsClass1() {
    assertNotEquals(contentEquals1, new Object());
  }

  @Test
  public void testDifferentEqualsClass() {
    assertNotEquals(contentEquals1, contentDifferent1);
  }

  @Test
  public void testHashCode() {
    assertEquals(contentEquals1.hashCode(), contentEquals2.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals(contentEquals1.toString(),
        "ContentRow{integer=2, entry=DigitalEntry{text='ABC', completed=false,"
            + " date=2020-11-22, priority=3, category=''}}");
  }
}