package com.example.hckdemo.controller;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.nio.file.*;
import java.util.*;

@RestController
@RequestMapping("/api/system")
public class SystemFileController {

    private final String BIN_DIR = System.getProperty("user.home") + File.separator + ".webos_bin";
    private static final Map<String, String> restoreMap = new HashMap<>();

    @GetMapping("/roots")
    public List<String> getRoots() {
        return Arrays.stream(File.listRoots()).map(File::getPath).toList();
    }

    @GetMapping("/explore")
    public List<Map<String, Object>> explore(@RequestParam String path) {
        File folder = new File(path);
        List<Map<String, Object>> files = new ArrayList<>();
        if (folder.exists() && folder.isDirectory()) {
            File[] list = folder.listFiles();
            if (list != null) {
                for (File f : list) {
                    Map<String, Object> map = new HashMap<>();
                    map.put("name", f.getName());
                    map.put("isDir", f.isDirectory());
                    map.put("absPath", f.getAbsolutePath());
                    files.add(map);
                }
            }
        }
        return files;
    }

    @PostMapping("/delete")
    public void delete(@RequestParam String filePath) throws Exception {
        File src = new File(filePath);
        File bin = new File(BIN_DIR);
        if (!bin.exists()) bin.mkdirs();
        restoreMap.put(src.getName(), src.getAbsolutePath());
        Files.move(src.toPath(), Paths.get(BIN_DIR, src.getName()), StandardCopyOption.REPLACE_EXISTING);
    }

    @PostMapping("/restore")
    public void restore(@RequestParam String fileName) throws Exception {
        String originalPath = restoreMap.get(fileName);
        if (originalPath != null) {
            Files.move(Paths.get(BIN_DIR, fileName), Paths.get(originalPath), StandardCopyOption.REPLACE_EXISTING);
            restoreMap.remove(fileName);
        }
    }

    @GetMapping("/bin-content")
    public List<String> getBin() {
        File bin = new File(BIN_DIR);
        return bin.exists() ? Arrays.asList(bin.list()) : new ArrayList<>();
    }
    
    @GetMapping("/download")
    public ResponseEntity<Resource> download(@RequestParam String filePath) throws Exception {
        Path path = Paths.get(filePath);
        Resource res = new UrlResource(path.toUri());
        return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + res.getFilename() + "\"")
            .body(res);
    }
}