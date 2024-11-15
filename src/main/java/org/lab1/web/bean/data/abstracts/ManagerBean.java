package org.lab1.web.bean.data.abstracts;

import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import lombok.Data;
import org.lab1.data.CRUD;
import org.lab1.data.entity.Ownerable;
import org.lab1.data.entity.User;
import org.lab1.web.bean.auth.UserBean;
import org.lab1.web.bean.data.Identable;
import org.primefaces.PrimeFaces;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Stack;

@ManagedBean("managerBean")
@SessionScoped
@Data
public abstract class ManagerBean<T extends Ownerable & Identable> {
    protected final Class<T> classType;
    protected final String editPanelName;
    protected final String componentDialogName;
    protected final String name;
    public T selectedItem;

    protected Stack<T> itemsStack;

    public ManagerBean(Class<T> classType, String name) {
        this.editPanelName = name + "EditPanel";
        this.componentDialogName = name + "ComponentDialog";
        this.name = name;
        this.itemsStack = new Stack<>();
        this.classType = classType;

        emptyInstance();
    }

    protected T getSelectedItem() {
        return itemsStack.peek();
    }

    public void setSelectedItem(T selectedItem) {
        itemsStack.push(selectedItem);
        System.out.println("selectedItem: " + selectedItem);
    }

    public abstract List<Long> getIdList();

    public abstract void emptyInstance();

    public void addItem() {
        T selectedItem = itemsStack.pop();
        if (selectedItem.getOwner() == null)
            selectedItem.setOwner(getCurrentOwner());
        CRUD.add(selectedItem);
        System.out.println("addItem: " + selectedItem);
    }

    protected User getCurrentOwner() {
        Map<String, Object> session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        return CRUD.find(User.class, ((UserBean) session.get("userBean")).getId());
    }


    public void editStack() {

        if ((!itemsStack.empty()) && (itemsStack.peek().getId() > 0)) {
            PrimeFaces.current().ajax().update(editPanelName);
            PrimeFaces.current().executeScript("PF('" + componentDialogName + "').show()");
        }
    }

    public List<T> getItems() {
        return CRUD.findAll(classType);
    }

    public void editItem() {
        T selectedItem = itemsStack.pop();
        if (selectedItem.getOwner() == null)
            selectedItem.setOwner(getCurrentOwner());
        CRUD.update(selectedItem);
        System.out.println("editItem: " + selectedItem);
        editStack();
    }

    public void freeStack() {
        itemsStack.clear();
        emptyInstance();
    }

    public void removeItem() {
        T selectedItem = itemsStack.pop();
        if (selectedItem.getOwner() == null)
            selectedItem.setOwner(getCurrentOwner());
        CRUD.delete(selectedItem);
        System.out.println("editItem: " + selectedItem);
        editStack();
    }


    public abstract List<String> getFieldNames();

    public Object getFieldValue(T item, String fieldName) throws Exception {
        try {
            Field field = this.classType.getDeclaredField(fieldName);
            field.setAccessible(true); // Make private fields accessible
            return field.get(item);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}




