package org.example.shop;

import org.mindrot.jbcrypt.BCrypt;

public class SimplePasswordEncoder {
    public String encode(String rawPassword) {
        return BCrypt.hashpw(rawPassword, BCrypt.gensalt());
    }

    public boolean matches(String rawPassword, String encodedPassword) {
        return BCrypt.checkpw(rawPassword, encodedPassword);
    }
}
