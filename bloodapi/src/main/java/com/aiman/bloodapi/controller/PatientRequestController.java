package com.aiman.bloodapi.controller;

import com.aiman.bloodapi.model.PatientRequest;
import com.aiman.bloodapi.repository.PatientRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patient-requests")
public class PatientRequestController {

    @Autowired
    private PatientRequestRepository patientRequestRepository;
    @GetMapping("/test")
    public String test(){
        return "chal gya hai";
    }


    @PostMapping
    public PatientRequest addRequest(@RequestBody PatientRequest request) {
        return patientRequestRepository.save(request);
    }

    @GetMapping
    public List<PatientRequest> getAll() {
        return patientRequestRepository.findAll();
    }

    @GetMapping("/{id}")
    public PatientRequest getOne(@PathVariable Long id) {
        return patientRequestRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public PatientRequest update(@PathVariable Long id, @RequestBody PatientRequest updated) {
        PatientRequest req = patientRequestRepository.findById(id).orElse(null);
        if (req != null) {
            req.setPatientName(updated.getPatientName());
            req.setHospital(updated.getHospital());
            req.setCity(updated.getCity());
            req.setBloodGroup(updated.getBloodGroup());
            req.setContactNumber(updated.getContactNumber());
            req.setFulfilled(updated.isFulfilled());
            return patientRequestRepository.save(req);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        patientRequestRepository.deleteById(id);
    }
}
