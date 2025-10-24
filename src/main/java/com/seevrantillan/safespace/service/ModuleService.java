package com.seevrantillan.safespace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seevrantillan.safespace.entity.ModuleEntity;
import com.seevrantillan.safespace.repository.ModuleRepository;

@Service
public class ModuleService {

    @Autowired
    private final ModuleRepository repository;

    public ModuleService(ModuleRepository repository) {
        this.repository = repository;
    }

    public ModuleEntity createModule(ModuleEntity module) {
        return repository.save(module);
    }

    public List<ModuleEntity> getAllModules() {
        return repository.findAll();
    }

    public ModuleEntity getModuleById(long moduleId) {
        return repository.findById(moduleId).orElseThrow(() -> new IllegalArgumentException("Module not found with ID: " + moduleId));
    }

    public ModuleEntity updateModule(long moduleId, ModuleEntity moduleDetails) {
        ModuleEntity existingModule = repository.findById(moduleId)
                .orElseThrow(() -> new IllegalArgumentException("Module not found with ID: " + moduleId));

        existingModule.setTitle(moduleDetails.getTitle());
        existingModule.setDescription(moduleDetails.getDescription());
        existingModule.setCreatedAt(moduleDetails.getCreatedAt());

        return repository.save(existingModule);
    }
}
