package org.lab1.web.bean.data.extra;

import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.SessionScoped;
import lombok.Data;
import org.lab1.data.CRUD;
import org.lab1.data.entity.Ticket;

import java.util.List;

@ManagedBean
@SessionScoped
@Data
public class GreaterNumberBean {
    public List<Ticket> getItems(int maxNumber) {
        return CRUD.getTicketsWithGreaterNumber(maxNumber);
    }
}
