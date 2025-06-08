package net.zerhouani.bdccfsmspringmvc.repository;

import net.zerhouani.bdccfsmspringmvc.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
