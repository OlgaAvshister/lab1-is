package org.lab1.web.bean.data;

import org.lab1.data.entity.enums.EventType;

import java.util.List;

public class EventTypeBean {
    private final List<EventType> typeList;

    public EventTypeBean() {
        typeList = List.of(EventType.values());
    }
}
