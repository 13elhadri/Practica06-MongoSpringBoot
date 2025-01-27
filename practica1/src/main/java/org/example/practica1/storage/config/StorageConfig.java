package org.example.practica1.storage.config;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.example.practica1.storage.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class StorageConfig {
    private final StorageService storageService;

    @Value("${upload.delete}")
    private String deleteAll;

    @Autowired
    public StorageConfig(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostConstruct
    public void init() {
        if (deleteAll.equals("true")) {
            log.info("Borrando ficheros de almacenamiento...");
            storageService.deleteAll();
        }

        storageService.init();
    }
}
