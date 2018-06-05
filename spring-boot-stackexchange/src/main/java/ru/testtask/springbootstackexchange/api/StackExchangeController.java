package ru.testtask.springbootstackexchange.api;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.testtask.springbootstackexchange.domain.StackExchangeItem;
import ru.testtask.springbootstackexchange.domain.StackExchangeWrapper;
import ru.testtask.springbootstackexchange.services.StackExchangService;

import java.util.List;

/**
 * Контроллер для rest api
 */
@Controller
@EnableAutoConfiguration
@CrossOrigin(origins = "*")
@RequestMapping("api/rest")
public class StackExchangeController {
    private final StackExchangService stackExchangService;

    public StackExchangeController(StackExchangService stackExchangService) {
        this.stackExchangService = stackExchangService;
    }

    @RequestMapping(value = "/questions",
            produces = {"application/json"},
            method = RequestMethod.GET)
    public ResponseEntity<StackExchangeWrapper> getQuestions(@RequestParam(value = "title", required = true) String title,
                                                             @RequestParam(value = "page", defaultValue = "1") Long page,
                                                             @RequestParam(value = "pagesize", defaultValue = "100") Long pagesize) {
        if (page < 1L)
            page = 1L;
        return ResponseEntity.ok(stackExchangService.getQuestions(title, page, pagesize));
    }

}
