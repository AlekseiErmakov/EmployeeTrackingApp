package com.tracking.service.file;

import com.tracking.annotation.custom.LocationContainer;
import lombok.SneakyThrows;
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
    private String defaultImage = "image/default.png";

    @Override
    public void saveImage(MultipartFile file, Class<?> key, Long id) {
        File fileIn = new File(locationMap.get(key) + id + imageSuffix);
        saveFile(fileIn,file);
    }

    @Override
    public byte[] loadImage(Class<?> key, Long id) {
        try {
            File serverFile = new File(locationMap.get(key) + id + imageSuffix);
            return Files.readAllBytes(serverFile.toPath());
        } catch (IOException ex) {
            return getDefaultImage();
        }
    }

    @Override
    public void deleteById(Class<?> key, Long id) {
        File serverFile = new File(locationMap.get(key) + id + imageSuffix);
        serverFile.delete();
    }

    @Override
    public void saveDefaultImage(MultipartFile file) {
        File fileIn = new File(defaultImage);
        saveFile(fileIn,file);
    }

    private void saveFile(File fileIn, MultipartFile file){
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

    @SneakyThrows
    public byte[] getDefaultImage() {
        File serverFile = new File(defaultImage);
        return Files.readAllBytes(serverFile.toPath());
    }


}
