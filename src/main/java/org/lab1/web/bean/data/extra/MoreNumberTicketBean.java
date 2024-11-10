package org.lab1.web.bean.data.extra;

import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.SessionScoped;
import lombok.Data;
import org.lab1.data.CRUD;

@ManagedBean
@SessionScoped
@Data
public class MoreNumberTicketBean {
    public int count(int maxNumber) {
        return CRUD.getNumberOfMoreNumberTickets(maxNumber);
    }
}
