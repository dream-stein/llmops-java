package com.emcikem.llm.service.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileUtil {

    public static File convertMultipartFileToFile(MultipartFile multipartFile) {
        try {
            // 创建临时文件
            File file = File.createTempFile("temp", null);
            try (InputStream inputStream = multipartFile.getInputStream();
                 FileOutputStream outputStream = new FileOutputStream(file)) {
                // 缓冲区大小
                byte[] buffer = new byte[4096];
                int bytesRead;
                // 循环读取输入流中的数据并写入输出流
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
            }
            return file;
        } catch (Exception ex) {
            return null;
        }
    }

    public static File pngConverter(URI uri) {
        File outputFile = null;
        try (InputStream inputStream = uri.toURL().openStream();
             OutputStream outputStream = Files.newOutputStream(Paths.get(uri.getPath() + ".png"))) {

            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }

            outputFile = new File(uri.getPath() + ".png");
            Files.delete(Paths.get(uri));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputFile;
    }

    public static void pngCleaner(Path path) {
        try (Stream<Path> stream = Files.list(path)) {
            stream.filter(Files::isRegularFile)
                    .filter(file -> file.toString().endsWith(".png"))
                    .forEach(file -> {
                        try {
                            Files.delete(file);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void mkDir(Path path) {
        try {
            Files.createDirectories(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void mkFile(Path path) {
        try {
            if (Files.exists(path)) {
                return;
            }
            Files.createFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void delete(Path path) {
        try {
            Files.deleteIfExists(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readJson(Path path) {
        FileUtil.mkFile(path);
        try {
            return new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeJson(Path path, String json) {
        FileUtil.mkFile(path);
        try (FileWriter fileWriter = new FileWriter(path.toString())) {
            fileWriter.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}