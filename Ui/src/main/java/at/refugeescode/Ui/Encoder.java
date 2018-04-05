package at.refugeescode.Ui;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Scope("session")
public class Encoder {

    private RestTemplate restTemplate;

    @Value("${encoder.url}")
    private String encoderUrl;

    private String word;
    private String encodedWord;

    public Encoder(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void bringResult(Message message){
        word = message.getText();
        encodedWord = restTemplate.postForObject(encoderUrl, word, String.class);
    }
    public String getEncodedWord() {
        return encodedWord;
    }

    public String getWord() {
        return word;
    }



}
