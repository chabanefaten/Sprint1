package com.faten.parfums.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service; // Import the Service annotation

import com.faten.parfums.entities.Parfum;
import com.faten.parfums.repos.ParfumRepository;

@Service // Add the Service annotation
public class ParfumServiceImpl implements ParfumService {
    
    @Autowired
    ParfumRepository parfumRepository;

    @Override
    public Parfum saveParfum(Parfum p) {
        return parfumRepository.save(p);
    }

    @Override
    public Parfum updateParfum(Parfum p) {
        return parfumRepository.save(p);
    }

    @Override
    public void deleteParfum(Parfum p) {
        parfumRepository.delete(p);
    }

    @Override
    public void deleteParfumById(Long id) {
        parfumRepository.deleteById(id);
    }

    @Override
    public Parfum getParfum(Long id) {
        return parfumRepository.findById(id).get();
    }

    @Override
    public List<Parfum> getAllParfums() {
        return parfumRepository.findAll();
    }
    @Override
    public Page<Parfum> getAllParfumsParPage(int page, int size) {
    return parfumRepository.findAll(PageRequest.of(page, size));
    }

}
