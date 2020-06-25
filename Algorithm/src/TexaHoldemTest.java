import org.junit.Test;
import static org.junit.Assert.*;
public class TexaHoldemTest {
    String white1 = "2C3H4S8CAH";
    String black1 = "2H3D5S9CKD";

    String white2 = "2S8SASQS3S";
    String black2 = "2H4S4C2D4H";

    String white3 = "2C3H4S5C6H";
    String black3 = "2H3H5H9HkH";

    String white4 = "2D3H5C9SKH";
    String black4 = "2H3D5S9CKD";





    @Test
    public void main() {
        assertEquals("WhiteWin", new TexaHoldem(black1,white1).compare());
        assertEquals("WhiteWin", new TexaHoldem(black2,white2).compare());
        assertEquals("BlackWin", new TexaHoldem(black3,white3).compare());
        assertEquals("Tie", new TexaHoldem(black4,white4).compare());



    }
}
