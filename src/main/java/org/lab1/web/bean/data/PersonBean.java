package org.lab1.web.bean.data;

import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.SessionScoped;
import lombok.Getter;
import lombok.Setter;
import org.lab1.data.entity.Person;
import org.lab1.web.bean.data.abstracts.UsedManagerBean;

import java.util.List;
import java.util.stream.Collectors;

@ManagedBean("personBean")
@SessionScoped
@Getter
@Setter
public class PersonBean extends UsedManagerBean<Person> {
    private String itemName = "person";

    public PersonBean() {
        super(Person.class, "person");
    }

    @Override
    public List<Long> getIdList() {
        return getItems().stream().map(Person::getId).collect(Collectors.toList());
    }

    @Override
    public void emptyInstance() {
        super.getItemsStack().push(new Person());
        super.getSelectedItem().setId(-1L);
    }

    @Override
    public List<String> getFieldNames() {
        return List.of("id",
                "eyeColor",
                "hairColor",
                "location",
                "height"
        );
    }


}
