package at.refugeescode.Morse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class MorseTest {

    @Autowired
    private Morse morse;

    @Test
    void morseEncode() {
        String actual = morse.morseEncode("S");
        assertEquals("···", actual);
    }
}