package com.aiman.bloodapi.controller;

import com.aiman.bloodapi.model.BloodGroup;
import com.aiman.bloodapi.repository.BloodGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blood-groups")
public class BloodGroupController {

    @Autowired
    private BloodGroupRepository bloodGroupRepository;

    @GetMapping("/test")
    public String test() {
        return "BloodGroup endpoint working";
    }

    @PostMapping
    public BloodGroup addGroup(@RequestBody BloodGroup group) {
        return bloodGroupRepository.save(group);
    }

    @GetMapping
    public List<BloodGroup> getAll() {
        return bloodGroupRepository.findAll();
    }

    @GetMapping("/{id}")
    public BloodGroup getOne(@PathVariable Long id) {
        return bloodGroupRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public BloodGroup update(@PathVariable Long id, @RequestBody BloodGroup updated) {
        BloodGroup group = bloodGroupRepository.findById(id).orElse(null);
        if (group != null) {
            group.setGroupType(updated.getGroupType());
            return bloodGroupRepository.save(group);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bloodGroupRepository.deleteById(id);
    }
}

