package reservationlinktic.reservationlinktic.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reservationlinktic.reservationlinktic.api.model.Services;
import reservationlinktic.reservationlinktic.api.repository.ServicesRepository;
import reservationlinktic.reservationlinktic.api.exception.ResourceNotFoundException;

import java.util.List;

@Service
public class ServicesService {

    @Autowired
    private ServicesRepository serviceRepository;

    public Services createService(Services service) {
        return serviceRepository.save(service);
    }

    public List<Services> getAllServices() {
        return serviceRepository.findAll();
    }

    public Services updateService(Long id, Services serviceDetails) {
        Services service = serviceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Service not found with id: " + id));
        service.setServiceName(serviceDetails.getServiceName());
        return serviceRepository.save(service);
    }

    public void deleteService(Long id) {
        serviceRepository.deleteById(id);
    }
}
