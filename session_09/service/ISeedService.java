package com.data.session_09.service;

import com.data.session_09.model.entity.Seed;

import java.util.List;

public interface ISeedService {
    List<Seed> findAll(int page, int size);
    Long countTotal();
    Seed findById(Long id);
    void save(Seed seed);
    void update(Seed seed);
    void delete(Long id);
}
