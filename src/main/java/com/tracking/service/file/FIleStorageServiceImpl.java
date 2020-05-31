package com.tracking.service.file;

import com.tracking.annotation.custom.LocationContainer;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

@Service
public class FIleStorageServiceImpl implements FileStorageService {

    @LocationContainer
    private Map<Class<?>, String> locationMap = new HashMap<>();

    private String imageSuffix = ".jpg";

    @Override
    public void saveImage(MultipartFile file, Class<?> key, Long id) {
        File fileIn = new File(locationMap.get(key) + id + imageSuffix);
        try (InputStream source = file.getInputStream();
             OutputStream dest = new FileOutputStream(fileIn.getAbsolutePath())) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = source.read(buffer)) > 0) {
                dest.write(buffer, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public byte[] loadImage(Class<?> key, Long id) throws IOException {
        File serverFile = new File(locationMap.get(key) + id + imageSuffix);
        return Files.readAllBytes(serverFile.toPath());
    }


}
