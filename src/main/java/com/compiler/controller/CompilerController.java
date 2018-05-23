package com.compiler.controller;


import com.compiler.bean.CompilerResponse;
import com.compiler.manager.CompilerManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/compiler")
@CrossOrigin
public class CompilerController {

    private final Logger logger = LoggerFactory.getLogger(CompilerController.class);
    private final CompilerManager compilerManager;

    public CompilerController(CompilerManager compilerManager) {
        this.compilerManager = compilerManager;
    }

    @PostMapping("/upload")
    public ResponseEntity<CompilerResponse> uploadCompilerFile(@RequestParam("file")MultipartFile file){

        logger.info("File name {}", file.getName());
        return ResponseEntity.ok(compilerManager.readFile(file));
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity captureException(Exception e){
        return ResponseEntity.badRequest().body("No es posible validar documento debido a: " + e.getMessage());
    }

}
