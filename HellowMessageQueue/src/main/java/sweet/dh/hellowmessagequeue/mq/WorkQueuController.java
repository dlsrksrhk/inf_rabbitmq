package sweet.dh.hellowmessagequeue.mq;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class WorkQueuController {

    private final WorkQueueProducer workQueueProducer;

    @PostMapping("/workqueue")
    public String workQueue(@RequestParam String message, @RequestParam int duration, @RequestParam boolean error) {
        workQueueProducer.sendWorkQueue(message, duration, error);
        return "Work queue sent = " + message + ", (" + duration + ")";
        /**
         * curl -X POST "http://localhost:8080/api/workqueue?message=Task1&duration=2000&error=false"
         * curl -X POST "http://localhost:8080/api/workqueue?message=Task2&duration=4000&error=false"
         * curl -X POST "http://localhost:8080/api/workqueue?message=Task3&duration=5000&error=true"
         */
    }

}