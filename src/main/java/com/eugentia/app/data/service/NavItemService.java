package com.eugentia.app.data.service;

import com.eugentia.app.data.entity.NavItem;
import com.eugentia.app.data.repository.NavItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NavItemService {

    private final NavItemRepository repository;

    public NavItemService(NavItemRepository repository) {
        this.repository = repository;
    }

    public Optional<NavItem> get(Long id) {
        return repository.findById(id);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<NavItem> getAll() {
        return repository.findAll();
    }

    public int count() {
        return (int) repository.count();
    }

}
