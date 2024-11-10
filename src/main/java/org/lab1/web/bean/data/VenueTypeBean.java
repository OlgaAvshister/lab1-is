package org.lab1.web.bean.data;

import org.lab1.data.entity.enums.VenueType;

import java.util.List;

public class VenueTypeBean {
    private List<VenueType> typeList;

    public VenueTypeBean() {
        typeList = List.of(VenueType.values());
    }
}
