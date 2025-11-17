package com.seevrantillan.safespace.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seevrantillan.safespace.DTO.ModuleDTO;
import com.seevrantillan.safespace.entity.ModuleEntity;
import com.seevrantillan.safespace.entity.UserEntity;
import com.seevrantillan.safespace.repository.ModuleRepository;
import com.seevrantillan.safespace.repository.UserRepository;

@RestController
@RequestMapping("/modules")
public class ModuleController {

    @Autowired
    private ModuleRepository moduleRepository;

    @Autowired
    private UserRepository userRepository;

    // --- GET all modules ---
    @GetMapping
    public List<ModuleEntity> getAllModules() {
        return moduleRepository.findAll();
    }

    // --- GET a module by ID ---
    @GetMapping("/{id}")
    public ResponseEntity<ModuleEntity> getModuleById(@PathVariable Integer id) {
        Optional<ModuleEntity> module = moduleRepository.findById(id);
        // Returns 200 OK or 404 NOT_FOUND
        return module.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // --- CREATE a new module for a user ---
    // FIX: Added 'value = "/create"' to map the endpoint correctly.
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE) 
    public ResponseEntity<?> createModule(@RequestBody ModuleDTO moduleDTO) {
        // 1. Fetch User
        Optional<UserEntity> userOpt = userRepository.findById(moduleDTO.getUserID());
        if (userOpt.isEmpty()) {
            // Returns 400 Bad Request if User ID is invalid
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not found with ID: " + moduleDTO.getUserID());
        }

        // 2. Map DTO to Entity and set relations
        ModuleEntity module = new ModuleEntity();
        module.setTitle(moduleDTO.getTitle());
        module.setDescription(moduleDTO.getDescription());
        module.setCreatedAt(LocalDateTime.now());
        module.setUser(userOpt.get());

        // 3. Save
        ModuleEntity savedModule = moduleRepository.save(module);
        // Returns 201 Created (preferred) or 200 OK
        return ResponseEntity.status(HttpStatus.CREATED).body(savedModule);
    }

    // --- UPDATE an existing module ---
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateModule(@PathVariable Integer id, @RequestBody ModuleDTO moduleDTO) {
        Optional<ModuleEntity> moduleOpt = moduleRepository.findById(id);
        if (moduleOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        ModuleEntity module = moduleOpt.get();
        module.setTitle(moduleDTO.getTitle());
        module.setDescription(moduleDTO.getDescription());

        // Update user if provided in DTO
        if (moduleDTO.getUserID() != null) {
            Optional<UserEntity> userOpt = userRepository.findById(moduleDTO.getUserID());
            if (userOpt.isEmpty()) {
                return ResponseEntity.badRequest().body("User not found with ID: " + moduleDTO.getUserID());
            }
            module.setUser(userOpt.get());
        }

        ModuleEntity updatedModule = moduleRepository.save(module);
        return ResponseEntity.ok(updatedModule);
    }

    // --- DELETE a module ---
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModule(@PathVariable Integer id) {
        if (!moduleRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        moduleRepository.deleteById(id);
        // Returns 204 No Content for successful deletion
        return ResponseEntity.noContent().build();
    }
}