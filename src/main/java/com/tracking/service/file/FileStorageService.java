package com.tracking.service.file;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileStorageService {
    void saveImage(MultipartFile file, Class<?> key, Long id);

    byte[] loadImage(Class<?> key, Long id) throws IOException;

    void deleteById(Class<?> key, Long id);

    void saveDefaultImage(MultipartFile file);

    byte[] getDefaultImage();

}
