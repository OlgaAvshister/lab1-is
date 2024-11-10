package org.lab1.web.bean.data.utils;

import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.SessionScoped;
import lombok.Data;

@ManagedBean("exceptionBean")
@SessionScoped
@Data
public class ExceptionBean {
    int errorCode;
}
