package com.example.hckdemo.controller;

import com.example.hckdemo.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/system")
public class FileApiController {

    @Autowired
    private FileService fileService;

    @GetMapping("/files")
    public List<String> getFiles(@RequestParam(defaultValue = "") String path) {
        return fileService.listFiles(path);
    }
}