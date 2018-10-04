package com.example.domotic.home.controller;

import com.example.domotic.home.exception.ResourceNotFoundException;
import com.example.domotic.home.model.Home;
import com.example.domotic.home.repository.HomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by rajeevkumarsingh on 27/06/17.
 */
@RestController
@RequestMapping("/api")
public class HomeController {

    @Autowired
    HomeRepository homeRepository;
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/homes")
    public List<Home> getAllHomes() {
        return homeRepository.findAll();
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/homes")
    public Home createHome(@Valid @RequestBody Home home) {
        return homeRepository.save(home);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/homes/{id}")
    public Home getHomeById(@PathVariable(value = "id") Long noteId) {
        return homeRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Home", "id", noteId));
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/homes/{id}")
    public Home updateHome(@PathVariable(value = "id") Long homeId,
                                           @Valid @RequestBody Home homeDetails) {

        Home note = homeRepository.findById(homeId)
                .orElseThrow(() -> new ResourceNotFoundException("Home", "id", homeId));

        note.setName(homeDetails.getName());
        note.setOwner(homeDetails.getOwner());
        note.setLatitude(homeDetails.getLatitude());
        note.setLongitude(homeDetails.getLongitude());

        Home updatedHome = homeRepository.save(note);
        return updatedHome;
    }

    @DeleteMapping("/notes/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long homeId) {
        Home home = homeRepository.findById(homeId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", homeId));

        homeRepository.delete(home);

        return ResponseEntity.ok().build();
    }
}
