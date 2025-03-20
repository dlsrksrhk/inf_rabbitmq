package sweet.dh.hellowmessagequeue.step0;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MessageController {
    private final Sender sender;

    @GetMapping("/send")
    public String sendMessage(@RequestParam String message) {
        sender.send(message);
        return "Message sent" + message;
    }
}
