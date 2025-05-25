package com.emcikem.llm.service.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.util.Strings;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.math.BigInteger;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
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

    public static String md5HashCode(InputStream fis) {
        try {
            //拿到一个MD5转换器,如果想使用SHA-1或SHA-256，则传入SHA-1,SHA-256
            MessageDigest md = MessageDigest.getInstance("MD5");

            //分多次将一个文件读入，对于大型文件而言，比较推荐这种方式，占用内存比较少。
            byte[] buffer = new byte[1024];
            int length = -1;
            while ((length = fis.read(buffer, 0, 1024)) != -1) {
                md.update(buffer, 0, length);
            }
            fis.close();
            //转换并返回包含16个元素字节数组,返回数值范围为-128到127
            byte[] md5Bytes  = md.digest();
            BigInteger bigInt = new BigInteger(1, md5Bytes);//1代表绝对值
            return bigInt.toString(16);//转换为16进制
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 根据传递的文本计算对应的哈希值
     * @param text
     * @return
     */
    public static String generateTextHash(String text) {
        // 1. 将续页计算哈希值的内容加上None这个字符串，避免传递了空字符串导致计算出错
        text += "None";

        // 2. 实验sha3_256将数据转换成哈希值后返回
        try {
            // 创建SHA-3的MessageDigest实例
            MessageDigest sha3Digest = MessageDigest.getInstance("SHA3-256");

            // 计算哈希值
            byte[] hashBytes = sha3Digest.digest(text.getBytes());

            // 将哈希值转换为十六进制字符串
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception ex) {
            return Strings.EMPTY;
        }
    }

    public static void main(String[] args) {
        System.out.println(generateTextHash("Hello World!"));
    }
}