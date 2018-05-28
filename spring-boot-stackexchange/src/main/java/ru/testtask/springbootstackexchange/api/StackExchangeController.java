package ru.testtask.springbootstackexchange.api;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.testtask.springbootstackexchange.domain.StackExchangeItem;
import ru.testtask.springbootstackexchange.services.StackExchangService;

import java.util.List;

/**
 * Контроллер для rest api
 */
@Controller
@RequestMapping("api/rest")
public class StackExchangeController {
    private final StackExchangService stackExchangService;

    public StackExchangeController(StackExchangService stackExchangService) {
        this.stackExchangService = stackExchangService;
    }

    @RequestMapping(value = "/questions",
            produces = {"application/json"},
            method = RequestMethod.GET)
    public ResponseEntity<List<StackExchangeItem>> getQuestions(@RequestParam(value = "findstring") String findString,
                                                                @RequestParam(value = "offset") Long offset,
                                                                @RequestParam(value = "limit") Long limit) {
        try{
            return ResponseEntity.ok(stackExchangService.getQuestions(findString, offset, limit));
        }
        catch (Exception ex) {
            throw new RuntimeException(ex); //fixme
        }
    }
}
