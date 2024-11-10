package org.lab1.web.bean.data.extra;

import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.SessionScoped;
import org.lab1.data.CRUD;

@ManagedBean
@SessionScoped
public class VIPTicketBean {
    public void copy(int id) {
        CRUD.copyVIPTicket(id);
    }
}
