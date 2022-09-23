package org.launchcode.codingevents.models;


// enum type class can have only one set of pre-defined values
public enum EventType {
    CONFERENCE("Conference"), //calls the constructor with the specific string
    MEETUP("Meetup"),
    WORKSHOP("Workshop"),
    SOCIAL("Social");

    private final String displayName;


    EventType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
