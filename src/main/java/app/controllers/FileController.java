package app.controllers;

import app.dto.FileDto;
import app.services.MinioService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.compress.utils.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static org.springframework.web.servlet.HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE;

@Slf4j
@RestController
@RequestMapping(value = "/api/file")
public class FileController {

    @Autowired
    private MinioService minioService;

    @GetMapping
    public ResponseEntity<Object> getFiles() {
        return ResponseEntity.ok(minioService.getListObjects());
    }

    @PostMapping(value = "/upload")
    public ResponseEntity<Object> upload(@ModelAttribute FileDto request) {
        return ResponseEntity.ok().body(minioService.uploadFile(request));
    }

    @GetMapping(value = "/**")
    public ResponseEntity<Object> getFile(HttpServletRequest request) throws IOException {
        String pattern = (String) request.getAttribute(BEST_MATCHING_PATTERN_ATTRIBUTE);
        String filename = new AntPathMatcher().extractPathWithinPattern(pattern, request.getServletPath());
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(IOUtils.toByteArray(minioService.getObject(filename)));
    }

}
