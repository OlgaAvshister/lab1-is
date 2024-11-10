package org.lab1.web.bean.data.extra;

import lombok.Data;
import org.lab1.data.CRUD;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
@Data
public class MoreNumberTicketBean {
    public int count(int maxNumber){
        return CRUD.getNumberOfMoreNumberTickets(maxNumber);
    }
}
