package com.tracking.service.file;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public interface FileStorageService {
    void saveImage(MultipartFile file,Class<?> key, Long id);

    byte[] getImage(Class<?>key, Long id) throws IOException;

    File getDepartmentImage(Long id);
}
