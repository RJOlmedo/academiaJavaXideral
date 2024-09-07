package com.example.gadgetapi.service;

import com.example.gadgetapi.model.Gadget;
import com.example.gadgetapi.repository.GadgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GadgetService {

    @Autowired
    private GadgetRepository gadgetRepository;

    public List<Gadget> getAllGadgets() {
        return gadgetRepository.findAll();
    }

    public Optional<Gadget> getGadgetById(Long id) {
        return gadgetRepository.findById(id);
    }

    public Gadget saveGadget(Gadget gadget) {
        return gadgetRepository.save(gadget);
    }

    public void deleteGadget(Long id) {
        gadgetRepository.deleteById(id);
    }
}
