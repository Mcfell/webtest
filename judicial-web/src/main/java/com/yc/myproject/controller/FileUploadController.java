package com.yc.myproject.controller;

import com.yc.myproject.domain.DO.Result;
import com.yc.myproject.service.StorageService;
import com.yc.myproject.service.upload.StorageFileNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;

@Controller
public class FileUploadController {

    private final StorageService storageService;

    @Autowired
    public FileUploadController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/uploadForm")
    public String listUploadedFiles(Model model) throws IOException {
        return "uploadForm";
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) throws IOException {

        Resource file = storageService.loadAsResource(filename);
//        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
//                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
        String contentType = Files.probeContentType(storageService.load(filename));

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE,contentType).body(file);
    }

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public Result<String> handleFileUpload(@RequestParam("file") MultipartFile file,
                                           RedirectAttributes redirectAttributes) {
        return new Result<>(storageService.store(file));
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }

}
