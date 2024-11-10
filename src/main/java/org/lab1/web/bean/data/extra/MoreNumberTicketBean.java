package org.lab1.web.bean.data.extra;

import lombok.Data;
import org.lab1.data.CRUD;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
@Data
public class MoreNumberTicketBean {
    public int count(int maxNumber){
        return CRUD.getNumberOfMoreNumberTickets(maxNumber);
    }
}
