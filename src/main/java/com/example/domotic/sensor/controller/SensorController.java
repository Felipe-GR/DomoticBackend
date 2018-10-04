package com.example.domotic.sensor.controller;

import com.example.domotic.home.exception.ResourceNotFoundException;
import com.example.domotic.home.repository.HomeRepository;
import com.example.domotic.sensor.model.Sensor;
import com.example.domotic.sensor.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Created by vrglx33
 */
@RestController
@RequestMapping("/api")
public class SensorController {

    @Autowired
    SensorRepository sensorRepository;
    @Autowired
    HomeRepository homeRepository;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/sensors")
    public List<Sensor> getAllSensors() {
        return sensorRepository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/sensors")
    public Sensor createSensor(@Valid @RequestBody Sensor sensor) {
        return sensorRepository.save(sensor);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/sensors/{id}")
    public Sensor getSensorById(@PathVariable(value = "id") Long sensorId) {
        return sensorRepository.findById(sensorId).orElseThrow(() -> new RuntimeException("error finding sensor"));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/sensors/{id}")
    public Sensor updateSensor(@PathVariable(value = "id") Long sensorId,
                           @Valid @RequestBody Sensor sensorDetails) {

        Sensor note = sensorRepository.findById(sensorId)
                .orElseThrow(() -> new ResourceNotFoundException("Sensor", "id", sensorId));

        note.setName(sensorDetails.getName());
        note.setStatus(sensorDetails.getStatus());
        note.setName(sensorDetails.getName());
        note.setDescription(sensorDetails.getDescription());
        note.setHome(sensorDetails.getHome());

        Sensor updatedSensor = sensorRepository.save(note);
        return updatedSensor;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/sensors/{id}")
    public ResponseEntity<?> deleteSensor(@PathVariable(value = "id") Long sensorId) {
        Sensor home = sensorRepository.findById(sensorId)
                .orElseThrow(() -> new ResourceNotFoundException("Sensor", "id", sensorId));

        sensorRepository.delete(home);

        return ResponseEntity.ok().build();
    }
}
