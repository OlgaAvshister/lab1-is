package org.lab1.web.bean.data.extra;

import org.lab1.data.CRUD;

public class DiscountTicketBean {
    public void copy(int id, int discount) {
        CRUD.copyDiscountTicket(id, discount);
    }
}
