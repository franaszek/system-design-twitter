package dk.nykredit.upskilling.twitter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/logs")
public class LogController {

    @GetMapping("/{type}")
    public int getLogsCount(@PathVariable String type, @RequestParam String dateStart, @RequestParam String dateFrom) {
        return 12;
    }
}
