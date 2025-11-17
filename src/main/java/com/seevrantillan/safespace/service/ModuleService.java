package com.seevrantillan.safespace.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.seevrantillan.safespace.entity.ModuleEntity;
import com.seevrantillan.safespace.entity.UserEntity;
import com.seevrantillan.safespace.repository.ModuleRepository;
import com.seevrantillan.safespace.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class ModuleService {

    private final ModuleRepository moduleRepository;
    private final UserRepository userRepository;

    public ModuleService(ModuleRepository moduleRepository, UserRepository userRepository) {
        this.moduleRepository = moduleRepository;
        this.userRepository = userRepository;
    }

    // CREATE a module (no user)
    public ModuleEntity createModule(ModuleEntity module) {
        return moduleRepository.save(module);
    }

    // CREATE a module and assign it to a User
    public ModuleEntity createModuleForUser(ModuleEntity module, int userID) {
        UserEntity user = userRepository.findById(userID)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userID));

        module.setUser(user);
        return moduleRepository.save(module);
    }

    // GET module by ID
    public ModuleEntity findModuleById(int id) {
        return moduleRepository.findById(id).orElseThrow();
    }

    // GET all modules
    public List<ModuleEntity> findAllModules() {
        return moduleRepository.findAll();
    }

    @Transactional
    public ModuleEntity updateModule(int id, ModuleEntity updatedModule) {
        ModuleEntity existingModule = moduleRepository.findById(id).orElseThrow();

        existingModule.setTitle(updatedModule.getTitle());
        existingModule.setDescription(updatedModule.getDescription());
        existingModule.setCreatedAt(updatedModule.getCreatedAt());

        if (updatedModule.getUser() != null) {
            existingModule.setUser(updatedModule.getUser());
        }

        return moduleRepository.save(existingModule);
    }

    public void deleteModule(int id) {
        moduleRepository.deleteById(id);
    }
}
