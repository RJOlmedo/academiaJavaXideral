package com.example.gadgetapi.repository;

import com.example.gadgetapi.model.Gadget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GadgetRepository extends JpaRepository<Gadget, Long> {
}
