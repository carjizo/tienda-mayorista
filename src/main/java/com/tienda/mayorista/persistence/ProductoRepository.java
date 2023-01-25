package com.tienda.mayorista.persistence;

import com.tienda.mayorista.domain.Product;
import com.tienda.mayorista.domain.repository.ProductRepository;
import com.tienda.mayorista.persistence.crud.ProductoCrudRepository;
import com.tienda.mayorista.persistence.entity.Producto;
import com.tienda.mayorista.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {

    @Autowired
    private ProductoCrudRepository productoCrudRepository;

    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(String category) {
        List<Producto> productos = productoCrudRepository.findByCategoria(category);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository
                .findById(productId)
                .map(producto -> mapper.toProduct(producto));
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    public void delete(int idProducto){
        productoCrudRepository.deleteById(idProducto);
    }
}
