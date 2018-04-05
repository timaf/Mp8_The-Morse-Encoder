package at.refugeescode.Encoder;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import java.util.function.Consumer;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class EncoderEndpointTest {

    @MockBean
    private RestTemplate restTemplate;

    @Autowired
    private EncoderEndpoint encoderEndpoint;

    @Value("${morse.url}")
    private String morseUrl;

    @Test
    void encodeTest() {
        String word = "Sarah";
        Stream.of(word.split(""))
                .forEach(mockEncode());

        String encoded = encoderEndpoint.encode(word);
        assertEquals("SARAH", encoded);

    }

    private Consumer<String> mockEncode() {
        return letter -> when(restTemplate.postForObject(morseUrl,letter,String.class))
                .thenReturn(letter.toUpperCase());
    }
}