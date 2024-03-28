package org.github.controller;

import org.github.service.DownloadService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController("/download")
public class DownloadController {

    private final DownloadService downloadService;

    public DownloadController(DownloadService downloadService) {
        this.downloadService = downloadService;
    }

    @PostMapping()
    public ResponseEntity download(@RequestBody List<String> urls) throws InterruptedException {
        downloadService.download(urls);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
