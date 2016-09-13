import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;
import java.util.*;

public class ResumeTest {

  @Test
  public void Resume_instantiateNewResume_true() {
    Resume myResume = new Resume("test", "test", "test", "test", 1998, 1999);
    assertTrue(myResume instanceof Resume);
  }

  @Test
  public void Resume_sortedByYear() {
    ArrayList<Resume> myResume = new ArrayList<Resume>();
    Resume myResume1 = new Resume("test", "test", "test", "test", 1998, 1999);
    Resume myResume2 = new Resume("bob", "test", "test", "test", 1987, 1999);
    myResume.add(myResume1);
    myResume.add(myResume2);
    String[] array = {"bob", "test"};
    int counter = 0;
    Collections.sort(myResume, Resume.yearSort);
    for (final Resume job : myResume) {
        assertEquals(array[counter], job.getTitle());
        counter++;
    }
  }
}
