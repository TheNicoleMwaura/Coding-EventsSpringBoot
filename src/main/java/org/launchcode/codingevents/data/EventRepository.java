package org.launchcode.codingevents.data;

import org.launchcode.codingevents.models.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//Extending the CrudRepository interface gives us access to methods
// to perform all the CRUD operations that we made happen in SQL.

@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {
}
