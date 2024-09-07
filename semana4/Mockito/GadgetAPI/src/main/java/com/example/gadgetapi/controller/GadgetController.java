package com.example.gadgetapi.controller;

import com.example.gadgetapi.model.Gadget;
import com.example.gadgetapi.service.GadgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/gadgets")
public class GadgetController {

    @Autowired
    private GadgetService gadgetService;

    @GetMapping
    public List<Gadget> getAllGadgets() {
        return gadgetService.getAllGadgets();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gadget> getGadgetById(@PathVariable Long id) {
        Optional<Gadget> gadget = gadgetService.getGadgetById(id);
        return gadget.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Gadget createGadget(@RequestBody Gadget gadget) {
        return gadgetService.saveGadget(gadget);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Gadget> updateGadget(@PathVariable Long id, @RequestBody Gadget updatedGadget) {
        Optional<Gadget> optionalGadget = gadgetService.getGadgetById(id);
        if (optionalGadget.isPresent()) {
            Gadget existingGadget = optionalGadget.get();
            existingGadget.setName(updatedGadget.getName());
            existingGadget.setBrand(updatedGadget.getBrand());
            existingGadget.setPrice(updatedGadget.getPrice());
            existingGadget.setDescription(updatedGadget.getDescription());
            return ResponseEntity.ok(gadgetService.saveGadget(existingGadget));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGadget(@PathVariable Long id) {
        if (gadgetService.getGadgetById(id).isPresent()) {
            gadgetService.deleteGadget(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
