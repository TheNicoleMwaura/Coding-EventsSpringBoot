package org.launchcode.codingevents.models;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


//Event is responsible for organizing user-inputted information into a Java object,
// persistence class/ entity means event objects can be stored in a database

@Entity
public class Event extends AbstractEntity {

    @NotBlank(message = "Name is required. ")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;
    /*@Valid
    * makes sure that an Event object will not be considered valid unless
    *  it has an EventDetails object that is also valid
    * (i.e. it has valid description and contactEmail fields).
    *
    *The cascade parameter specifies which ORM operations should cascade
    *cascadeAll specifies that all database operations—including save and delete—should cascade.*/
    @OneToOne(cascade = CascadeType.ALL)  //saves/deletes eventDetails when an event object is created
    @Valid
    @NotNull
    private EventDetails eventDetails;

    @ManyToOne
    @NotNull(message = "Category is required" )
    private EventCategory eventCategory;

    @ManyToMany
    private final List<Tag> tags = new ArrayList<>();

    public Event(String name, EventCategory eventCategory ) {
        this.name = name;
        this.eventCategory = eventCategory;

    }

    public Event(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public EventCategory getEventCategory() {
        return eventCategory;
    }

    public void setEventCategory(EventCategory eventCategory) {
        this.eventCategory = eventCategory;
    }

    public EventDetails getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(EventDetails eventDetails) {
        this.eventDetails = eventDetails;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void addTag(Tag tag) {
        this.tags.add(tag);
    }

    @Override
    public String toString() {
        return name;
    }


}
