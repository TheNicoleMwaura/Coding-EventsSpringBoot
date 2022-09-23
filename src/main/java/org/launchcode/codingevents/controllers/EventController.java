package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventData;
import org.launchcode.codingevents.data.EventRepository;
import org.launchcode.codingevents.models.Event;
import org.launchcode.codingevents.models.EventType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("events") //root path
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @GetMapping
    public String displayAllEvents(Model model) {
        model.addAttribute("events", eventRepository.findAll());

        return "events/index";
    }
    //lives at /events/create
    @GetMapping("create")
    public String displayCreateEventForm(Model model){
        model.addAttribute("title", "Create Event");
        model.addAttribute(new Event());
        model.addAttribute("types",EventType.values()); //returns an array of the 4 values of the enum(event type)
        return "events/create";
    }

    //lives at /events/create
    @PostMapping("create")
    public String processCreateEventForm(@ModelAttribute @Valid Event newEvent,
                                         Errors errors, Model model){//spring creates a new object for us
        if(errors.hasErrors()){
            model.addAttribute("title" , "Create Event");
            return "events/create";
        }
        eventRepository.save(newEvent);
        return "redirect:/events"; //redirects the page to the root path (different page)

    }
    //lives at /events/delete
    @GetMapping("delete")
    public String displayDeleteEventForm(Model model){
        model.addAttribute("title" , "Delete Events");
        model.addAttribute("events", eventRepository.findAll());
        return "events/delete";
    }

    @PostMapping("delete")
    public String processDeleteEventsForm(@RequestParam(required = false) int[] eventIds){

        if(eventIds != null) {
            for (int id : eventIds) {
               eventRepository.deleteById(id);
            }
        }
        return "redirect:"; //redirects to /events
    }

}
