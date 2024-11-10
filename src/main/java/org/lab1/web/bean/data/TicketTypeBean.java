package org.lab1.web.bean.data;

import lombok.Data;
import org.lab1.data.entity.enums.TicketType;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
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
