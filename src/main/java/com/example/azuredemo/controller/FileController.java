package com.example.azuredemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Slf4j
@Controller
public class FileController {

    @GetMapping(
            value = "/get-file",
            produces = MediaType.APPLICATION_OCTET_STREAM_VALUE
    )
    public ResponseEntity<ByteArrayResource> getFile() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("data.txt");

        assert inputStream != null;

        ByteArrayResource resource = new ByteArrayResource(inputStream.readAllBytes());

        log.info("file download starting");

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" +"file.txt")
                .contentType(MediaType.APPLICATION_OCTET_STREAM) //
                .contentLength(resource.contentLength()) //
                .body(resource);
    }

}
