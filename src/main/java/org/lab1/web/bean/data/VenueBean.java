package org.lab1.web.bean.data;

import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.SessionScoped;
import lombok.Getter;
import lombok.Setter;
import org.lab1.data.entity.Venue;
import org.lab1.web.bean.data.abstracts.UsedManagerBean;

import java.util.List;
import java.util.stream.Collectors;

@ManagedBean("venueBean")
@SessionScoped
@Getter
@Setter
public class VenueBean extends UsedManagerBean<Venue> {
    private String itemName = "venue";

    public VenueBean() {
        super(Venue.class, "venue");
    }


    @Override
    public List<Long> getIdList() {
        return getItems().stream().map(Venue::getId).collect(Collectors.toList());
    }

    @Override
    public void emptyInstance() {
        super.getItemsStack().push(new Venue());
        super.getSelectedItem().setId(-1L);
    }

    @Override
    public List<String> getFieldNames() {
        return List.of("id",
                "name",
                "capacity",
                "type",
                "address"
        );
    }


}
