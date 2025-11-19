
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WordTest {

    // Testar att antalet rader sparas rätt
    @Test
    public void testOfLines() {
        WordLogic count = new WordLogic();
        count.userCount("Leopard");
        count.userCount("Zebra");
        count.userCount("Noshörning");
        assertEquals(3, count.getLines());
    }

    // Testar att antalet tecken på ord sparas rätt
    @Test
    public void testOfCharacters() {
        WordLogic count = new WordLogic();
        count.userCount("Panda");
        count.userCount("Lejon");
        assertEquals(10, count.getCharacters());
    }

    // Testar att ordet "stop" inte räknas med i antal tecken
    @Test
    public void testOfStop() {
        WordLogic count = new WordLogic();
        count.userCount("Krokodil");
        count.userCount("Stop");
        count.userCount("Giraff");
        assertEquals(14, count.getCharacters());
    }

    // Testar att antal ord och att ordet "stop" inte räknas med
    @Test
    public void testOfWords() {
        WordLogic count = new WordLogic();
        count.userCount("Djur i Afrika");
        count.userCount("STOP");
        assertEquals(3, count.getWords());
    }
}
