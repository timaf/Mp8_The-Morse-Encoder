package at.refugeescode.Ui;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@Scope("session")
public class MainEndpoint {

    private Encoder encoder;

    public MainEndpoint(Encoder encoder) {
        this.encoder = encoder;
    }

    @ModelAttribute("message")
    Message message() {
        return new Message();
    }

    @ModelAttribute("encodedWord")
    String ecodedWord() {
        return encoder.getEncodedWord();
    }

    @GetMapping
    String page(){
        return "main";
    }

    @PostMapping
    String post(Message message){
         encoder.bringResult(message);
         return "redirect:/";
    }
}
