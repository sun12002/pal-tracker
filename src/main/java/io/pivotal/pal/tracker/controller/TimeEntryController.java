package io.pivotal.pal.tracker.controller;

import io.pivotal.pal.tracker.repository.TimeEntryRepository;
import io.pivotal.pal.tracker.repository.TimeEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TimeEntryController {

    private TimeEntryRepository timeEntryRepository;

    @Autowired
    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    @GetMapping("/time-entries/{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable long id){
        TimeEntry timeEntry = timeEntryRepository.find(id);
        if (timeEntry == null) {
            return new ResponseEntity<TimeEntry>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<TimeEntry>(timeEntry, HttpStatus.OK);
    }

    @PostMapping("/time-entries")
    public ResponseEntity create(@RequestBody TimeEntry timeEntry){
        return new ResponseEntity<TimeEntry>(timeEntryRepository.create(timeEntry), HttpStatus.CREATED);
    }

    @GetMapping("/time-entries")
    public ResponseEntity<List<TimeEntry>> list() {
        return new ResponseEntity<List<TimeEntry>>(timeEntryRepository.list(), HttpStatus.OK);
    }

    @PutMapping("/time-entries/{id}")
    public ResponseEntity update(@PathVariable long id, @RequestBody TimeEntry timeEntry){
        TimeEntry entry = timeEntryRepository.update(id, timeEntry);
        if (entry == null) {
            return new ResponseEntity<TimeEntry>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<TimeEntry>(entry, HttpStatus.OK);
    }

    @DeleteMapping("/time-entries/{id}")
    public ResponseEntity<TimeEntry> delete(@PathVariable long id) {
        timeEntryRepository.delete(id);
        return new ResponseEntity<TimeEntry>(HttpStatus.NO_CONTENT);
    }



}
