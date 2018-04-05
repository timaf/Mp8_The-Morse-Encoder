package at.refugeescode.Morse;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class Morse {

     private Parser parser;

     private Map <String, String> morseDict;

    public Morse(Parser parser) {
        this.parser = parser;
        morseDict = parser.prepareMorseDict();;
    }

    public String morseEncode(String letter){
        return morseDict.get(letter.toUpperCase());
    }
}
