package at.refugeescode.Morse;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@Service
public class Parser {

  private   ResourceLoader resourceLoader;

    public Parser(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public Map<String, String> prepareMorseDict(){
        Map <String, String> morseDict = new HashMap <>();

        try {
            String fileName = "classpath:morse-code.csv";
            Resource resource = resourceLoader.getResource(fileName);
            Path path = Paths.get(resource.getURI());
            Files.lines(path)
                    .map(line -> line.split(";"))
                    .forEach(line -> morseDict.put(line[0], line[1]));

        } catch (IOException e) {
            e.printStackTrace();
        }
        morseDict.put(" ", " ");
        return morseDict;
    }
}
