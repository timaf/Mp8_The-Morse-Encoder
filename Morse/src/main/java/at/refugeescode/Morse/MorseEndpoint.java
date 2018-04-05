package at.refugeescode.Morse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/morse")
public class MorseEndpoint {

    private Morse morse;

    public MorseEndpoint(Morse morse) {
        this.morse = morse;
    }

    @PostMapping
    String morse(@RequestBody String letter){
        return morse.morseEncode(letter);
    }

}
