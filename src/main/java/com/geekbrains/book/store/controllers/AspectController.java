package com.geekbrains.book.store.controllers;

import com.geekbrains.book.store.beans.AspectLogs;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/logs")
@AllArgsConstructor
public class AspectController {
    private AspectLogs aspectLogs;

    @GetMapping
    @ResponseBody
    public Map<String, Integer> getLogs() {
        return aspectLogs.getLogs();
    }
}
