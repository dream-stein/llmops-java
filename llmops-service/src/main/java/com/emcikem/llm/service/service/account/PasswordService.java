package com.emcikem.llm.service.service.account;

import org.springframework.stereotype.Service;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.regex.Pattern;

/**
 * Create with Emcikem on 2025/4/8
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Service
public class PasswordService {

    private static final String PASSWORD_REGEX = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,16}$";
    private static final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX);

    // 迭代次数
    private static final int ITERATIONS = 10000;
    // 生成的密钥长度
    private static final int KEY_LENGTH = 256;

    public boolean validatePassword(String password) {
        return PASSWORD_PATTERN.matcher(password).matches();
    }

    public boolean comparePassword(String password, String hashedPassword) {
        return hashPassword(password, generateSalt()).equals(hashedPassword);
    }

    public static String hashPassword(String password, String salt) {
        try {
            KeySpec spec = new PBEKeySpec(password.toCharArray(), Base64.getDecoder().decode(salt), ITERATIONS, KEY_LENGTH);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            byte[] hash = factory.generateSecret(spec).getEncoded();
            return Base64.getEncoder().encodeToString(hash);
        } catch (Exception e) {
            throw new RuntimeException("密码哈希过程出错", e);
        }
    }

    /**
     * 生成盐值
     * @return
     */
    public static String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    public static void main(String[] args) {
        String password = "mysecretpassword";
        String salt = generateSalt();
        String hashedPassword = hashPassword(password, salt);

        System.out.println("盐值: " + salt);
        System.out.println("哈希后的密码: " + hashedPassword);
    }
}
