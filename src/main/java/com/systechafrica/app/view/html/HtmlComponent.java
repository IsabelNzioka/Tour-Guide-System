package com.systechafrica.app.view.html;

import com.systechafrica.app.model.entity.TourCategories;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.lang.reflect.Field;

public class HtmlComponent implements Serializable {
    public static  String table() {
        return StringUtils.EMPTY;
    }

    public static String form(Object model) {
                String formHtml = "<div class='AddToursPage'>" +
                "<form action=\"./add-tour\" method=\"post\">" ;

        Field [] fields = model.getClass().getDeclaredFields();
        for(Field field : fields) {

            String fieldName = field.getName();
            String fieldType = String.valueOf(field.getType());
            boolean isEnum = field.getType().isEnum();
//            fieldName.equals("tourCategories")

            if(isEnum) {
                formHtml += "<select name=\""+ fieldName + "\" id=\""+ fieldName +"\">";
                for (TourCategories category : TourCategories.values()) {
                    formHtml += "<option value=\"" + category.name() + "\">" + category.name().toLowerCase() + "</option>";
                }
                formHtml += "</select><br>";
            } else {
                formHtml +=  "<label for=\""+ fieldName + "\">"+ fieldName + ":</label><br>";
                formHtml +=  "<input type=\""+ fieldType + "\" id=\""+ fieldName +"\" name=\""+ fieldName + "\"><br>" ;
            }


        }
        formHtml += "<button type=\"submit\" class=\"SubmitButton\">Submit</button>";
        formHtml +=  "</form><br/>";
        formHtml += "</div>";

        return formHtml;
    }
}
