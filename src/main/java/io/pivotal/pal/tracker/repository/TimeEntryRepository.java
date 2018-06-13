package io.pivotal.pal.tracker.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

public interface TimeEntryRepository {

    TimeEntry create(TimeEntry timeEntry);

    TimeEntry find(long id);

    List<TimeEntry> list();

    TimeEntry update(long id, TimeEntry timeEntry);

    TimeEntry delete(long id);
}
