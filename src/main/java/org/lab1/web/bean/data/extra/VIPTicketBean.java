package org.lab1.web.bean.data.extra;

import org.lab1.data.CRUD;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean
@SessionScoped
public class VIPTicketBean {
    public void copy(int id){
        CRUD.copyVIPTicket(id);
    }
}
