package com.systechafrica.app.view.html;

import com.systechafrica.app.model.entity.TourCategory;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;

public class HtmlComponent implements Serializable {
    public static  String table(List<?> models) {
        if(models == null || models.isEmpty())
            return StringUtils.EMPTY;

        Field [] fields = models.get(0).getClass().getDeclaredFields();

        StringBuilder toursList = new StringBuilder("<h2></h2><table class='TourList'><tr>");

        for (Field  field : fields)
            toursList.append("<th>" + field.getName() + "</th>");
        toursList.append("</tr>");

        for(Object model : models) {
            toursList.append("<tr>");
                    for(Field field : fields) {
                        try {
                            field.setAccessible(true); //if the fields are private
                            toursList.append("<td>").append(field.get(model)).append("</td>");
                        } catch (IllegalAccessException e ) {
                            throw  new RuntimeException(e);
                        }

                    }
                    toursList.append("</tr>");
        }
            toursList.append("</table>");
        return toursList.toString();
    }

    public static String form(Class<?> model) {
                String formHtml = "<div class='AddToursPage'>" +
                "<form action=\"./add-tour\" method=\"post\">" ;

        Field [] fields = model.getDeclaredFields();
        for(Field field : fields) {

            String fieldName = field.getName();
            String fieldType = String.valueOf(field.getType());

            boolean isEnum = field.getType().isEnum();
            field.getType().getEnumConstants();

            if(isEnum) {
                formHtml += "<select name=\""+ fieldName + "\" id=\""+ fieldName +"\">";

                for (Object category : field.getType().getEnumConstants()) {
                    formHtml += "<option value=\"" + category + "\">" + category+ "</option>";
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
