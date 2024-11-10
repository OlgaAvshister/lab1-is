package org.lab1.web.bean.data.abstracts;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import org.lab1.data.CRUD;
import org.lab1.data.entity.Ownerable;
import org.lab1.data.entity.Ticket;
import org.lab1.web.bean.data.Identable;
import org.lab1.web.bean.data.TicketBean;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public abstract class UsedManagerBean<T extends Ownerable & Identable> extends ManagerBean<T> {
    public UsedManagerBean(Class<T> classType, String name) {
        super(classType, name);
    }

    public static TicketBean getTicketBean() {
        Map<String, Object> session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        return (TicketBean) session.get("ticketBean");
    }

    @Override
    public void removeItem() {
        T selectedItem = super.itemsStack.pop();

        try {
            CRUD.delete(selectedItem);
            System.out.println("editItem: " + selectedItem);
        } catch (Exception e) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            T searchedItem = CRUD.find(super.classType, selectedItem.getId());
            if (searchedItem == null) {
                facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Item was removed", null));
            } else {
                List<Ticket> editList = CRUD.findTicketByClassId(classType, selectedItem.getId());

                if (!editList.isEmpty()) {
                    TicketBean viewScopedBean = getTicketBean();
                    viewScopedBean.getItemsStack().addAll(editList);
                    finishEditItem();
                    ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
                    try {
                        externalContext.redirect(externalContext.getRequestContextPath() + "/views/data/pages/ticket/main.xhtml");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }

                }


            }
        }
    }

    public void finishEditItem() {
        System.out.println("finishEditItem");
        TicketBean ticketBean = getTicketBean();
        ticketBean.editStack();
    }
}
