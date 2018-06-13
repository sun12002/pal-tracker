package io.pivotal.pal.tracker.repository;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private long counter;

    private HashMap<Long, TimeEntry> timeEntryHashMap;

    public InMemoryTimeEntryRepository() {
        counter = 0;
        timeEntryHashMap = new HashMap<>();
    }

    public TimeEntry create(TimeEntry timeEntry) {
        timeEntry.setId(++counter);
        timeEntryHashMap.put(counter,timeEntry);
        return timeEntry;
    }

    public TimeEntry find(long id){
        return timeEntryHashMap.get(id);
    }

    public List<TimeEntry> list(){

        ArrayList<Long> ids = new ArrayList<>(timeEntryHashMap.keySet());
        Collections.sort((ids));
        ArrayList<TimeEntry> timeEntriesSortedById = new ArrayList<>();

        for (long id : ids) {
            timeEntriesSortedById.add(timeEntryHashMap.get(id));
        }

        return timeEntriesSortedById;
    }

    public TimeEntry update(long id, TimeEntry timeEntry){
        timeEntry.setId(id);
        timeEntryHashMap.put(id, timeEntry);
        return timeEntry;
    }

    public TimeEntry delete(long id){
        return timeEntryHashMap.remove(id);
    }

}
