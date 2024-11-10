package org.lab1.web.bean.data;

import org.lab1.data.entity.enums.Color;

import java.util.List;

public class ColorBean {
    private List<Color> typeList;

    public ColorBean() {
        typeList = List.of(Color.values());
    }
}
