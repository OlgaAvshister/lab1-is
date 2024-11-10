package org.lab1.web.bean.data.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MenuBean {
    static String prefix = "tables/";
    static String postfix = "/main.xhtml";

    String contentName = "coordinate";

    public String goCoordinates() {
        return "coordinate";
    }

    public String goAddress() {
        return "address";
    }

    public String goEvent() {
        return "event";
    }

    public String goPerson() {
        return "person";
    }

    public String goLocation() {
        return "location";
    }

    public String goVenue() {
        return "venue";
    }

    public String goExtra() {
        return "extra";
    }

    public String goTicket() {
        return "ticket";
    }

    public String setContentName(String contentName) {
        this.contentName = contentName;
        return contentName;
    }

    public String getContentName() {
        return prefix + contentName + postfix;
    }


}
