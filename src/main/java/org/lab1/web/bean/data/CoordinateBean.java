package org.lab1.web.bean.data;

import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.SessionScoped;
import org.lab1.data.entity.Coordinates;
import org.lab1.web.bean.data.abstracts.UsedManagerBean;

import java.util.List;
import java.util.stream.Collectors;

@ManagedBean("coordinatesBean")
@SessionScoped
public class CoordinateBean extends UsedManagerBean<Coordinates> {

    public CoordinateBean() {
        super(Coordinates.class, "coordinate");
    }

    @Override
    public List<Long> getIdList() {
        return getItems().stream().map(Coordinates::getId).collect(Collectors.toList());
    }

    @Override
    public void emptyInstance() {
        super.getItemsStack().push(new Coordinates());
        super.getSelectedItem().setId(-1);
    }

    @Override
    public List<String> getFieldNames() {
        return List.of("id", "x", "y");
    }


}
