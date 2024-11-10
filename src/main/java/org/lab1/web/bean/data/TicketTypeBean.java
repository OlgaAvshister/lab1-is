package org.lab1.web.bean.data;

import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.SessionScoped;
import lombok.Data;
import org.lab1.data.entity.enums.TicketType;

import java.util.List;

@ManagedBean
@SessionScoped
@Data
public class TicketTypeBean {
    private List<TicketType> typeList;

    public TicketTypeBean() {
        typeList = List.of(TicketType.values());
    }
}
