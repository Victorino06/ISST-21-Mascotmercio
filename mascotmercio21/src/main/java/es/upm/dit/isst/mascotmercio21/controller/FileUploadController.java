package es.upm.dit.isst.mascotmercio21.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

@RestController
public class FileUploadController {

    public static String generateRandomString(int length) {
        
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

     
        StringBuilder sb = new StringBuilder(length);

      
        Random random = new Random();

        
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }

        // Convert StringBuilder to String and return
        return sb.toString();
    }

    private static final String UPLOAD_DIR = "./../mascotmercio21front/src/main/resources/static/fotos/";

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return "SELECT_FILE";
        }

        Path uploadDir = Paths.get(UPLOAD_DIR);
        if (!Files.exists(uploadDir)) {
            Files.createDirectories(uploadDir);
        }

        try {
            byte[] bytes = file.getBytes();
            String[] parts = file.getOriginalFilename().split("\\.");
            int len = parts.length;
            String newName = generateRandomString(10) + "." + parts[len - 1];
            Path path = Paths.get(UPLOAD_DIR + newName);
            Files.write(path, bytes);
            return newName.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "UPLOAD_FAIL";
        }
    }
}

