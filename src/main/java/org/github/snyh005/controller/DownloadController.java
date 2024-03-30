package org.github.snyh005.controller;

import org.github.snyh005.facade.DownloadFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/download")
public class DownloadController {

    private final DownloadFacade downloadFacade;

    public DownloadController(DownloadFacade downloadFacade) {
        this.downloadFacade = downloadFacade;
    }

    @PostMapping()
    public ResponseEntity download(@RequestBody List<String> urls) throws InterruptedException {
        downloadFacade.download(urls);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
