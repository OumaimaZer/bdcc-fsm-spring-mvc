package net.zerhouani.bdccfsmspringmvc;

import net.zerhouani.bdccfsmspringmvc.entities.Product;
import net.zerhouani.bdccfsmspringmvc.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BdccFsmSpringMvcApplication {

    public static void main(String[] args) {

        SpringApplication.run(BdccFsmSpringMvcApplication.class, args);
    }

    @Bean
    public CommandLineRunner start(ProductRepository productRepository) {
        return args -> {
            productRepository.save(Product.builder()
                            .name("Computer")
                            .price(5400)
                            .quantity(12)
                    .build());
            productRepository.save(Product.builder()
                    .name("Printer")
                    .price(1200)
                    .quantity(11)
                    .build());
            productRepository.save(Product.builder()
                    .name("SmartPhone")
                    .price(12000)
                    .quantity(33)
                    .build());
            productRepository.findAll().forEach(p->{
                System.out.println(p.toString());
            });
        };
    }
}
