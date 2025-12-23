package com.example.hckdemo.service;

import org.springframework.stereotype.Service;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FileService {

    // You can change this to "C:/" to see your whole system
    private final String ROOT_PATH = System.getProperty("user.home"); 

    public List<String> listFiles(String subPath) {
        File folder = new File(ROOT_PATH + File.separator + subPath);
        if (folder.exists() && folder.isDirectory()) {
            return Arrays.stream(folder.list()).collect(Collectors.toList());
        }
        return List.of("Folder not found or access denied");
    }
}