// src/main/java/com/example/shop/ShopApplication.java
package org.example.shop;

import org.example.shop.model.Product;
import org.example.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

@SpringBootApplication
public class ShopApplication implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(ShopApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
       /* productRepository.save(new Product("рукавиці", "Теплі зимові рукавиці", 100, "images/gloves.jpg", "woman","winter", new ArrayList<String>(Arrays.asList("XS","S","L")), "gloves"));
        productRepository.save(new Product("шапка", "Зимова шапка", 120, "images/hat.jpg", "man", "summer",  new ArrayList<String>(Arrays.asList("XS","S","M","XL","XXL")), "hat"));
        productRepository.save(new Product("шуба", "Тепла шуба", 500, "images/coat.jpg", "woman", "winter",  new ArrayList<String>(Arrays.asList("XS","S","L")), "coat"));
        productRepository.save(new Product("футболка", "Легка літня футболка", 70, "images/tshirt.jpg", "man","summer",  new ArrayList<String>(Arrays.asList("XS","S","M","L")), "coat"));
        productRepository.save(new Product("туфлі", "Стильні туфлі", 350, "images/shoes.jpg", "man", "summer",  new ArrayList<String>(Arrays.asList("XS","S","M","XL","XXL")), "shoes"));
        productRepository.save(new Product("костюм", "Костюм Джеймса Бонда", 200, "images/siut.jpg", "man", "summer",  new ArrayList<String>(Arrays.asList("S","M","L")), "costume"));
        productRepository.save(new Product("куртка", "куртка Джо Байдена", 450, "images/coat1.jpg", "man", "winter",  new ArrayList<String>(Arrays.asList("S","L")), "coat"));
        productRepository.save(new Product("туфлі жіночі", "круті туфлі", 670, "images/shoes1.jpg", "woman", "summer",  new ArrayList<String>(Arrays.asList("XS","S","M","XL","XXL")), "shoes"));
        productRepository.save(new Product("туфлі жічночі", "туфлі кращі", 340, "images/shoes2.jpg", "woman", "summer",  new ArrayList<String>(Arrays.asList("XS","S","L")), "shoes"));
        productRepository.save(new Product("жіночий піджак", "крутий піджак для зустрічей", 450, "images/coat2.jpg", "woman", "winter",  new ArrayList<String>(Arrays.asList("XS","S","M")), "coat"));
        productRepository.save(new Product("пальто жіноче", "пальто Лесі Нікітюк", 520, "images/shoes2.jpg", "woman", "winter",  new ArrayList<String>(Arrays.asList("XS","S","L")), "coat"));
        productRepository.save(new Product("кепка чоловіча", "Кепка Бетмена", 150, "images/hat1.jpg", "man", "summer",  new ArrayList<String>(Arrays.asList("S","M","L")), "hat"));
        productRepository.save(new Product("Штани на флісі чоловічі", "дуже теплі", 450, "images/trousers.jpg", "man", "winter",  new ArrayList<String>(Arrays.asList("XS","S","L")), "trousers"));
        productRepository.save(new Product("Штани жіночі", "спортивін штани жіночі", 500, "images/trousers1.jpg", "woman", "summer",  new ArrayList<String>(Arrays.asList("XS","S","L")), "trousers"));
        productRepository.save(new Product("Штани жіночі", "сірі штани", 450, "images/trousers2.jpg", "woman", "summer",  new ArrayList<String>(Arrays.asList("XS","S","L")), "trousers"));
*/
    }
}