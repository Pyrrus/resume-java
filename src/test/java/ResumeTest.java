import org.junit.*;
import static org.junit.Assert.*;

public class ResumeTest {

  @Test
  public void Resume_instantiateNewResume_true() {
    Resume myResume = new Resume("test", "test", "test", "test", 1998, 1999);
    assertTrue(myResume instanceof Resume);
  }
}
