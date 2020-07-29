import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class MattParkerTest {
    MattParker mattParker;

    @BeforeEach
    void setUp() {
        mattParker = new MattParker();
    }

    @Test
    void intToString() {
        assertNull(mattParker.convertIntToWord(10));

        assertEquals( mattParker.convertIntToWord(13),"δεκατρια");
        assertEquals("δεκατεσσερα", mattParker.convertIntToWord(14));
        assertEquals("δεκαπεντε",mattParker.convertIntToWord(15));
        assertEquals( "δεκαεξι",mattParker.convertIntToWord(16));
        assertEquals("δεκαεφτα", mattParker.convertIntToWord(17));
        assertEquals("δεκαοχτω",mattParker.convertIntToWord(18));
        assertEquals("δεκαεννια",mattParker.convertIntToWord(19));

        assertEquals( "εικοσι",mattParker.convertIntToWord(20));
        assertEquals( "εικοσιενα",mattParker.convertIntToWord(21));
        assertEquals("εικοσιεννια",mattParker.convertIntToWord(29));

        assertEquals("τριαντα",mattParker.convertIntToWord(30));
        assertEquals("τριανταενα",mattParker.convertIntToWord(31));

        assertEquals("σαραντα", mattParker.convertIntToWord(40));
        assertEquals("σαρανταπεντε",mattParker.convertIntToWord(45));

        assertEquals("πενηντα",mattParker.convertIntToWord(50));
        assertEquals("πενηνταπεντε",mattParker.convertIntToWord(55));

        assertEquals("εξηντα",mattParker.convertIntToWord(60));
        assertEquals("εξηνταπεντε",mattParker.convertIntToWord(65));

        assertEquals("εβδομηντα",mattParker.convertIntToWord(70));
        assertEquals("εβδομηνταπεντε",mattParker.convertIntToWord(75));

        assertEquals("ογδοντα",mattParker.convertIntToWord(80));
        assertEquals("ογδονταπεντε",mattParker.convertIntToWord(85));

        assertEquals("ενενηντα",mattParker.convertIntToWord(90));
        assertEquals("ενενηνταπεντε",mattParker.convertIntToWord(95));
        assertEquals("ενενηνταεννια",mattParker.convertIntToWord(99));
    }
}