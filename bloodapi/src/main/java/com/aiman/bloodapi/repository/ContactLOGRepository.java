package com.aiman.bloodapi.repository;

import com.aiman.bloodapi.model.ContactLOG;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactLOGRepository extends JpaRepository<ContactLOG, Long> {
    List<ContactLOG> findByEmail(String email);
    List<ContactLOG> findByPhoneNumber(String phoneNumber);
    List<ContactLOG> findByContactPerson(String contactPerson);
    Long countByEmail(String email);
    List<ContactLOG> findByEmailAndContactPerson(String email, String contactPerson);

}
