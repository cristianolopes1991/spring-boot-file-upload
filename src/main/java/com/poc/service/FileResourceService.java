package com.poc.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.nio.file.Files.copy;
import static java.nio.file.Paths.get;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

@Service
public class FileResourceService {

    //define a location
    public static final String DIRECTORY = System.getProperty("user.home") + "/Donwloads/uploads";

    public List<String> upload(List<MultipartFile> multipartFiles) throws IOException {
        List<String> filenames = new ArrayList<>();

        for (MultipartFile file : multipartFiles) {
            var filename = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
            Path fileStorage = get(DIRECTORY, filename).toAbsolutePath().normalize();
            copy(file.getInputStream(), fileStorage, REPLACE_EXISTING);
            filenames.add(filename);
        }

        return filenames;
    }


}
