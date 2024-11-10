package org.lab1.web.bean.data.extra;

import lombok.Data;
import org.lab1.data.CRUD;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
@Data
public class LessVenueTicketBean {

    public int count(int minVenue){
        return CRUD.getNumberOfLessVenueTickets(minVenue);
    }
}
