package org.lab1.web.bean.data.extra;

import lombok.Data;
import org.lab1.data.CRUD;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
@Data
public class LessVenueTicketBean {

    public int count(int minVenue){
        return CRUD.getNumberOfLessVenueTickets(minVenue);
    }
}
