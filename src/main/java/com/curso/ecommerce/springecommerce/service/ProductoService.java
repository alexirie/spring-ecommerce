package com.curso.ecommerce.springecommerce.service;

import com.curso.ecommerce.springecommerce.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

    public List<Producto> findAll();

    public Producto save(Producto producto);

    public Optional<Producto> get(Integer id);

    public void update(Producto producto);

    public void delete(Integer id);
}
