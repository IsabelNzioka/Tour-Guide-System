package com.systechafrica.app.bean;

import com.systechafrica.app.model.entity.Tour;

import com.systechafrica.app.view.helper.HtmlComponent;
import com.systechafrica.database.Database;

import java.io.Serializable;
import java.util.List;


public class TourBean extends GenericBean<Tour> implements TourBeanI{



    @Override
    public void addOrUpdateEntity(Tour tour) {
        getDao().addOrUpdateEntity(tour);

    }


}
