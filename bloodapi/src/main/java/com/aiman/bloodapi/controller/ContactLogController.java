package com.aiman.bloodapi.controller;

import com.aiman.bloodapi.model.ContactLOG;
import com.aiman.bloodapi.repository.ContactLOGRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact-logs")
public class ContactLogController {

    @Autowired
    private ContactLOGRepository contactLOGRepository;

    @PostMapping
    public ContactLOG addContact(@RequestBody ContactLOG contact) {
        return contactLOGRepository.save(contact);
    }

    @GetMapping
    public List<ContactLOG> getAll() {
        return contactLOGRepository.findAll();
    }

    @GetMapping("/{id}")
    public ContactLOG getOne(@PathVariable Long id) {
        return contactLOGRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public ContactLOG update(@PathVariable Long id, @RequestBody ContactLOG updated) {
        ContactLOG existing = contactLOGRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setContactPerson(updated.getContactPerson());
            existing.setPhoneNumber(updated.getPhoneNumber());
            existing.setEmail(updated.getEmail());
            existing.setMessage(updated.getMessage());
            return contactLOGRepository.save(existing);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        contactLOGRepository.deleteById(id);
    }
}

