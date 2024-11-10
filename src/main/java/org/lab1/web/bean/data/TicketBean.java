package org.lab1.web.bean.data;

import lombok.Getter;
import lombok.Setter;
import org.lab1.data.CRUD;
import org.lab1.data.entity.*;
import org.lab1.web.bean.data.abstracts.ManagerBean;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;
import jakarta.faces.context.FacesContext;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@ManagedBean(name = "ticketBean")
@SessionScoped
@Getter
@Setter
public class TicketBean extends ManagerBean<Ticket> {

    public TicketBean() {
        super(Ticket.class, "ticket");
    }

    @Override
    public void addItem() {
        Ticket selectedItem = super.itemsStack.pop();

        if (selectedItem.getOwner() == null)
            selectedItem.setOwner(getCurrentOwner());

        FacesContext facesContext = FacesContext.getCurrentInstance();


        if (selectedItem.getEvent() == null) {
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Choose event", null));
            return;
        }
        if (selectedItem.getCoordinates() == null) {
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Choose coordinates", null));
            return;
        }
        if (selectedItem.getVenue() == null) {
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Choose venue", null));
            return;
        }
        Event selectedEvent = CRUD.find(Event.class, selectedItem.getPassedEventId());
        selectedItem.setEvent(selectedEvent);

        Coordinates selectedCoord = CRUD.find(Coordinates.class, selectedItem.getPassedCoordinatesId());
        selectedItem.setCoordinates(selectedCoord);

        Venue selectedVenue = CRUD.find(Venue.class, selectedItem.getPassedVenueId());
        selectedItem.setVenue(selectedVenue);

        CRUD.add(selectedItem);
        System.out.println("editItem: " + selectedItem);
    }

    @Override
    public void editItem() {
        Ticket selectedItem = super.itemsStack.pop();

        if (selectedItem.getOwner() == null)
            selectedItem.setOwner(getCurrentOwner());

        if (!Objects.equals(selectedItem.getPassedEventId(), selectedItem.getEvent().getId())) {
            Event selectedEvent = CRUD.find(Event.class, selectedItem.getPassedEventId());
            selectedItem.setEvent(selectedEvent);
        }

        if (selectedItem.getPassedCoordinatesId() != selectedItem.getCoordinates().getId()) {
            Coordinates selectedCoord = CRUD.find(Coordinates.class, selectedItem.getPassedCoordinatesId());
            selectedItem.setCoordinates(selectedCoord);
        }

        if (selectedItem.getPassedVenueId() != selectedItem.getVenue().getId()) {
            Venue selectedVenue = CRUD.find(Venue.class, selectedItem.getPassedVenueId());
            selectedItem.setVenue(selectedVenue);
        }

        CRUD.update(selectedItem);
        System.out.println("editItem: " + selectedItem);

        editStack();
    }


    @Override
    public List<Long> getIdList() {
        return getItems().stream().map(Ticket::getId).collect(Collectors.toList());
    }

    @Override
    public void emptyInstance() {
        super.getItemsStack().push(new Ticket());
        super.getSelectedItem().setId(-1);
        super.getSelectedItem().setCoordinates(
                new Coordinates()
        );

        super.getSelectedItem().setVenue(
                new Venue()
        );

        super.getSelectedItem().setEvent(
                new Event()
        );
    }


    @Override
    public List<String> getFieldNames() {
        return List.of(
                "id",
                "name",
                "coordinates",
                "creationDate",
                "person",
                "event",
                "price",
                "type",
                "discount",
                "number",
                "venue"
        );
    }
}
