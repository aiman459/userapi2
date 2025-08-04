package com.aiman.bloodapi.controller;

import com.aiman.bloodapi.model.Donor;
import com.aiman.bloodapi.repository.DonorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/donors")
public class DonorController {

    @Autowired
    private DonorRepository donorRepository;

    @PostMapping
    public Donor addDonor(@RequestBody Donor donor) {
        return donorRepository.save(donor);
    }

    @GetMapping
    public List<Donor> getAll() {
        return donorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Donor getOne(@PathVariable Long id) {
        return donorRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Donor updateDonor(@PathVariable Long id, @RequestBody Donor d) {
        Donor donor = donorRepository.findById(id).orElse(null);
        if (donor != null) {
            donor.setName(d.getName());
            donor.setEmail(d.getEmail());
            donor.setPhone(d.getPhone());
            donor.setBloodGroup(d.getBloodGroup());
            donor.setCity(d.getCity());
            donor.setIsAvailable(d.getIsAvailable());
            return donorRepository.save(donor);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteDonor(@PathVariable Long id) {
        donorRepository.deleteById(id);
    }
}
