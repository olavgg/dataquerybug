package com.example;

import com.example.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * User: olav
 * Date: 01.10.2019
 * Time: 15:56
 */

@Component
public class WorkPermitJob{

    private static Logger log = LoggerFactory.getLogger(WorkPermitJob.class);

    @Autowired
    private BookService bookService;

    @Scheduled(cron = "0 */1 * * * ?")
    public void analyzeWorkPermits() {
        log.debug("work permit job starting");

        List<String> bookTitles = bookService.getTitles();
        log.debug("titles count: " + bookTitles.size());

        log.debug("work permit job complete");
    }
}
