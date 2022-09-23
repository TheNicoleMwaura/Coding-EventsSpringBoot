package org.launchcode.codingevents.data;

import org.launchcode.codingevents.models.Event;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//EventData is responsible for maintaining  event objects once they are created
public class EventData {
    //need a place to put events , static means only one hashmap
   private static final Map<Integer, Event> events = new HashMap<>();

   //add an event
    public static void add(Event event){
        //events.put(event.getId(), event);
    }
    //remove an event
    public static void remove(int id){
        events.remove(id);
    }

    //get a single event
    public static Event getById(int id){
        return events.get(id); // returns the item with the specific key/id
    }
   //get all events
   //returns a collection of all events
    public static Collection<Event> getAll(){
        return events.values();
    }
}
