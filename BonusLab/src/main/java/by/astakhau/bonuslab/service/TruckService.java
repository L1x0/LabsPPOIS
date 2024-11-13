package by.astakhau.bonuslab.service;

import by.astakhau.bonuslab.data.Truck;
import by.astakhau.bonuslab.data.TruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TruckService {

    private final TruckRepository truckRepository;

    @Autowired
    public TruckService(TruckRepository truckRepository) {
        this.truckRepository = truckRepository;
    }

    public Truck saveTruck(Truck truck) {
        return truckRepository.save(truck);
    }

    public Optional<Truck> getTruckById(Long id) {
        return truckRepository.findById(id);
    }

    public Iterable<Truck> getAllTrucks() {
        return truckRepository.findAll();
    }

    public void deleteTruckById(Long id) {
        truckRepository.deleteById(id);
    }
}
