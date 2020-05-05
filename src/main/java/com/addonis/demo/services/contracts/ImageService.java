package com.addonis.demo.services.contracts;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    void saveImageFile(int userId, MultipartFile file);
    void saveImageFileToAddon(int addonId, MultipartFile file);
    void checkIfImageExists(MultipartFile file);
}
