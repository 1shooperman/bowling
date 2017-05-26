import org.junit.*;
import static org.junit.Assert.*;

public class BowlingTest {

    @Test
    public void strike() {
        assertEquals(300, Bowling.answer("X|X|X|X|X|X|X|X|X|X||XX"));
    }
  
    @Test
    public void nines() {
        assertEquals(90, Bowling.answer("9-|9-|9-|9-|9-|9-|9-|9-|9-|9-||"));
    }
   
    @Test
    public void fivesToSpare() {
        assertEquals(150, Bowling.answer("5/|5/|5/|5/|5/|5/|5/|5/|5/|5/||5"));
    }
    
    @Test
    public void oneSixtySeven() {
        assertEquals(167, Bowling.answer("X|7/|9-|X|-8|8/|-6|X|X|X||81"));    
    }
    
    @Test
    public void invalidInput() {
        assertEquals(0, Bowling.answer("Z|Z|Z|Z|Z"));
    }
}

