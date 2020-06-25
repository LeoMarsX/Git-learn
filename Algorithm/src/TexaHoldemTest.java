import org.junit.Test;
import static org.junit.Assert.*;
public class TexaHoldemTest {
    String white1 = "2D3H5C9SKH";
    String black1 = "2H3D5S9CKD"; // Tie

    String white2 = "2C3H4S5C6H";
    String black2 = "2H3H5H9HkH"; // Black Win

    String white3 = "2S8SASQS3S";
    String black3 = "2H4S4C2D4H"; // White Win

    String white4 = "2C3H4S8CAH";
    String black4 = "2H3D5S9CKD"; // White Wins---2

    @Test
    public void main() {
        assertEquals("Tie", new TexaHoldem(black1,white1).compare());
        assertEquals("Black Win", new TexaHoldem(black2,white2).compare());
        assertEquals("White Win", new TexaHoldem(black3,white3).compare());
        assertEquals("White Win", new TexaHoldem(black4,white4).compare());
    }
}
