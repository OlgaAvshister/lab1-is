package org.lab1.web.bean.data.extra;

import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.RequestScoped;
import lombok.Data;
import org.lab1.data.CRUD;

@ManagedBean
@RequestScoped
@Data
public class LessVenueTicketBean {

    public int count(int minVenue) {
        return CRUD.getNumberOfLessVenueTickets(minVenue);
    }
}
