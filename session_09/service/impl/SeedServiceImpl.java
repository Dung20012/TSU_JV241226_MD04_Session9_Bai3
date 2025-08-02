package com.data.session_09.service.impl;

import com.data.session_09.model.entity.Seed;
import com.data.session_09.repository.ISeedRepository;
import com.data.session_09.service.ISeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SeedServiceImpl implements ISeedService {
    @Autowired
    private ISeedRepository seedRepository;

    @Override
    public List<Seed> findAll(int page, int size) {
        return seedRepository.findAll(page, size);
    }

    @Override
    public Long countTotal() {
        return seedRepository.countTotal();
    }

    @Override
    public Seed findById(Long id) {
        return seedRepository.findById(id);
    }

    @Override
    public void save(Seed seed) {
        seedRepository.save(seed);
    }

    @Override
    public void update(Seed seed) {
        seedRepository.update(seed);
    }

    @Override
    public void delete(Long id) {
        seedRepository.delete(id);
    }
}
