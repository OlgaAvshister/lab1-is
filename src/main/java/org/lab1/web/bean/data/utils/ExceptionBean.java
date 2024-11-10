package org.lab1.web.bean.data.utils;

import lombok.Data;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;

@ManagedBean(name = "exceptionBean")
@SessionScoped
@Data
public class ExceptionBean {
    int errorCode;
}
