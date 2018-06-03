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
    public ResponseEntity<StackExchangeWrapper> getQuestions(@RequestParam(value = "findstring", required = true) String findString,
                                                             @RequestParam(value = "offset", defaultValue = "1") Long offset, //fixme min value 1
                                                             @RequestParam(value = "limit", defaultValue = "100") Long limit) {
        try{
            return ResponseEntity.ok(stackExchangService.getQuestions(findString, offset, limit));
        }
        catch (Exception ex) {
            throw new RuntimeException(ex); //fixme
        }
    }
}
