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

@ManagedBean(name = "addressBean")
@SessionScoped
@Getter
@Setter
public class AddressBean extends UsedManagerBean<Address> {
    private String itemName = "address";

    public AddressBean() {
        super(Address.class, "address");
    }

    @Override
    public List<Long> getIdList() {
        return getItems().stream().map(Address::getId).collect(Collectors.toList());
    }

    @Override
    public void emptyInstance() {
        super.getItemsStack().push(new Address());
        super.getSelectedItem().setId(-1L);
    }

    @Override
    public List<String> getFieldNames() {
        return List.of("id",
                "street",
                "zipcode"
        );
    }


}
