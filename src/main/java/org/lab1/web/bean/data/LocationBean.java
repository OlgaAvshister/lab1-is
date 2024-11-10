package org.lab1.web.bean.data;

import lombok.Getter;
import lombok.Setter;
import org.lab1.data.entity.Address;
import org.lab1.data.entity.Location;
import org.lab1.web.bean.data.abstracts.UsedManagerBean;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ManagedBean(name = "locationBean")
@SessionScoped
@Getter
@Setter
public class LocationBean extends UsedManagerBean<Location> {
    private String itemName = "location";

    public LocationBean() {
        super(Location.class, "location");
    }


    @Override
    public List<Long> getIdList() {
        return getItems().stream().map(Location::getId).collect(Collectors.toList());
    }

    @Override
    public void emptyInstance() {
        super.getItemsStack().push(new Location());
        super.getSelectedItem().setId(-1L);
    }

    @Override
    public List<String> getFieldNames() {
        return List.of("id",
                "name",
                "x",
                "y"
        );
    }


}
