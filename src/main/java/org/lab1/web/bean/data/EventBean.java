package org.lab1.web.bean.data;

import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.SessionScoped;
import org.lab1.data.entity.Event;
import org.lab1.web.bean.data.abstracts.UsedManagerBean;

import java.util.List;
import java.util.stream.Collectors;

@ManagedBean("eventBean")
@SessionScoped
public class EventBean extends UsedManagerBean<Event> {

    public EventBean() {
        super(Event.class, "event");
    }

    @Override
    public List<Long> getIdList() {
        return getItems().stream().map(Event::getId).collect(Collectors.toList());

    }

    @Override
    public void emptyInstance() {
        super.getItemsStack().push(new Event());
        super.getSelectedItem().setId(-1L);
    }

    @Override
    public List<String> getFieldNames() {
        return List.of("id", "name", "date", "minAge", "ticketsCount", "eventType");
    }

}
