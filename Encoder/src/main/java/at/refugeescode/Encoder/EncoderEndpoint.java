package at.refugeescode.Encoder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/encode")
public class EncoderEndpoint {

    private RestTemplate restTemplate;

    @Value("${morse.url}")
    private String morseUrl;

    public EncoderEndpoint(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    String sayHello(){
        return "Enter your word";
    }

    @PostMapping
    String encode(@RequestBody String word){
        return Stream.of(word.split(""))
                .map(letter -> restTemplate.postForObject(morseUrl, letter, String.class))
                .collect(Collectors.joining(""));
    }
}
