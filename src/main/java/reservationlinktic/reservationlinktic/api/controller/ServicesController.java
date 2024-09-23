package reservationlinktic.reservationlinktic.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import reservationlinktic.reservationlinktic.api.model.Services;
import reservationlinktic.reservationlinktic.api.service.ServicesService;

import java.util.List;

@RestController
@RequestMapping("/api/services")
public class ServicesController {

    @Autowired
    private ServicesService serviceService;

    @PostMapping
    public ResponseEntity<Services> createService(@RequestBody Services service) {
        return ResponseEntity.ok(serviceService.createService(service));
    }

    @GetMapping
    public ResponseEntity<List<Services>> getAllServices() {
        return ResponseEntity.ok(serviceService.getAllServices());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Services> updateService(@PathVariable Long id, @RequestBody Services service) {
        return ResponseEntity.ok(serviceService.updateService(id, service));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteService(@PathVariable Long id) {
        serviceService.deleteService(id);
        return ResponseEntity.noContent().build();
    }
}

