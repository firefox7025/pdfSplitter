package com.nextgear.clarity.imagesplitter;

import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;

public class FindPdfs {

    public static List<File> findPaths(String rootPath) throws IOException {
        return Files.walk(Paths.get(rootPath))
                .filter(x -> FilenameUtils.getExtension(x.toString()).equals("pdf"))
                .map(Path::toFile)
                .collect(Collectors.toList());
    }

}
