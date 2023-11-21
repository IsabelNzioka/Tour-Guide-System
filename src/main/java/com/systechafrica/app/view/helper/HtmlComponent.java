package com.systechafrica.app.view.helper;

import com.systechafrica.app.model.entity.Tour;
import com.systechafrica.app.model.entity.TourCategory;
import com.systechafrica.app.model.entity.User;
import com.systechafrica.database.Database;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class HtmlComponent implements Serializable {
    public static  String table(List<?> dataList, Class<?> dataClass) {
        if (!dataClass.isAnnotationPresent(HtmlTable.class))
            return StringUtils.EMPTY;

        HtmlTable htmlTable = dataClass.getAnnotation(HtmlTable.class);
        Field[] fields = dataClass.getDeclaredFields();

        StringBuilder toursList = new StringBuilder();
             toursList.append("<div class='TableData'>" );
             toursList.append("<div class='TableActions'>");

//            TODO - append actions  --- Add for tours only
              toursList.append("<a class=\"linkBtn\" href=\"").append(htmlTable.addUrl()).append("\">Add</a><br/>");
              toursList.append("<a class=\"linkBtn\" href=\"").append("\">Search ....</a><br/>");
              toursList.append("<a class=\"linkBtn\" href=\"").append("\">Filter by ....</a><br/>");

              toursList.append("</div><table class='TourList'><tr>");

        for (Field  field : fields) {
            if (!field.isAnnotationPresent(TableColHeader.class))
                continue;
            toursList.append("<th>" + field.getAnnotation(TableColHeader.class).headerLabel() + "</th>");
        }
        toursList.append("<th>Actions</th>");
        toursList.append("</tr>");

        if(dataList != null && !dataList.isEmpty()) {
            for(Object data : dataList) {
                toursList.append("<tr>");
                for(Field field : fields) {
                    if (!field.isAnnotationPresent(TableColHeader.class))
                        continue;
                    try {
                        field.setAccessible(true); //if the fields are private
                        TableColHeader colHeader = field.getAnnotation(TableColHeader.class);
                        Object colData;
                         if (StringUtils.isNotBlank(colHeader.dateFormat())){
                                Date dateValue = (Date) field.get(data);
                                colData = (dateValue != null) ? new SimpleDateFormat(colHeader.dateFormat()).format(dateValue) : "";
                            //  TODO - USE REQUIRED FIELD
                            // colData = new SimpleDateFormat(colHeader.dateFormat()).format((Date) field.get(data));
                       } else if (StringUtils.isNotBlank(colHeader.numberFormat()))
                            colData = new DecimalFormat(colHeader.numberFormat())
                                .format(Optional.ofNullable(field.get(data)).orElse(BigDecimal.ZERO));
                        else
                            colData = field.get(data);


                        // toursList.append("<td>").append(field.get(data)).append("</td>");
                        toursList.append("<td>")
                        .append(Optional.ofNullable(colData).orElse(""))
                        .append("</td>");

                    } catch (IllegalAccessException e ) {
                        throw  new RuntimeException(e);
                    }

                }
                toursList.append("<td> <i class=\"fa-regular fa-pen-to-square\"></i> <i class=\"fa-solid fa-trash-can\"></i></td>");
                toursList.append("</tr>");
            }
        }
            toursList.append("</table></div>");
        return toursList.toString();
    }



    
    public static String form(Class<?> model) {
        HtmlForm htmlForm = null;
        if(model.isAnnotationPresent((HtmlForm.class)))
           htmlForm = model.getAnnotation((HtmlForm.class));

        if(htmlForm == null)
            return StringUtils.EMPTY;

        String formHtml = "<div class='AddToursPage'>" +
                "<form action=\""+ htmlForm.url() + "\" method=\""+ htmlForm.httpMethod() +"\">" ;

        Field [] fields = model.getDeclaredFields();

        for(Field field : fields) {
            if(!field.isAnnotationPresent(HtmlFormField.class))
                continue;

            HtmlFormField formField = field.getAnnotation(HtmlFormField.class);
            
            String fieldName = field.getName();
            String fieldType = String.valueOf(field.getType());
            boolean isEnum = field.getType().isEnum();
//          getEnumConstants() - Returns the elements of this enum class or null if this Class object does not represent an enum type

            if(isEnum) {
                formHtml +=  "<label for=\""+ (StringUtils.isBlank(formField.labelFor()) ? fieldName : formField.labelFor()) + "\">"+
                        (StringUtils.isBlank(formField.label()) ? fieldName : formField.label())  + ":</label><br>";
                formHtml += "<select name=\""+ (StringUtils.isBlank(formField.labelFor()) ? fieldName : formField.labelFor())  + "\" id=\""+
                        fieldName +"\">";

                for (Object category : field.getType().getEnumConstants()) {
                    formHtml += "<option value=\"" + category + "\">" + category.toString().toLowerCase()+ "</option>";
                }
                formHtml += "</select><br>";
            } else {
                formHtml +=  "<label for=\""+ (StringUtils.isBlank(formField.labelFor()) ? fieldName : formField.labelFor()) + "\">"+
                                             (StringUtils.isBlank(formField.label()) ? fieldName : formField.label())  + ":</label><br>";

                formHtml +=  "<input type=\""+ formField.type() + "\" id=\""+     //text, number, ...
                                             (StringUtils.isBlank(formField.id()) ? fieldName : formField.id()) +"\" name=\""+
                                              (StringUtils.isBlank(formField.name()) ? fieldName : formField.name())  + "\"><br>" ;
            }

        }
        formHtml += "<button type=\"submit\" class=\"SubmitButton\">Submit</button>";
        formHtml +=  "</form><br/>";
        formHtml += "</div>";

        return formHtml;
    }





    public static String card(List<?> models) {
        if (models == null || models.isEmpty())
            return StringUtils.EMPTY;
    
        Field[] fields = models.get(0).getClass().getDeclaredFields();
    
        StringBuilder toursList = new StringBuilder("<div class='ToursList'>");
    
        for (Object model : models) {
            toursList.append("<div class='card'>");
    
            for (Field field : fields) {
                HtmlCard formField = field.getAnnotation(HtmlCard.class);
                 if (!field.isAnnotationPresent(HtmlCard.class))
                            continue;
                try {
                     field.setAccessible(true); //if the fields are private
                    if(formField.name().equals("Tour Image")){
                        toursList.append("<img src='" + field.get(model) + "' alt='Tour Image' >");
                           } else {
                    toursList.append("<p class=' "+formField.className() + "'>").append(formField.name()).append(field.get(model)).append("</p>");}
                } catch (IllegalAccessException e ) {
                    throw  new RuntimeException(e);
                }
            }
    
            toursList.append("</div>");
        }
     toursList.append("</div>");
        return toursList.toString();
    }

    public static String statCard() {
        StringBuilder statDetails = new StringBuilder("<div class='StatCard'>");
        statDetails.append("<div class='TotalStat'> <p>Total Customers </p> <h1>9,789</h1> </div>");
        statDetails.append("<div class='MembersStat'> <p>Members </p> <h1>1,789</h1> </div>");
        statDetails.append("<div class='ActiveStat'> <p>Active Now</p> <h1>789</h1> </div>");
                    statDetails.append("</div>");
        return statDetails.toString();
    }

    public static String tourStatCard() {
        StringBuilder statDetails = new StringBuilder("<div class='StatCard'>");
        statDetails.append("<div class='TotalStat'> <p>Total Tours </p> <h1>1,789</h1> </div>");
        statDetails.append("<div class='MembersStat'> <p>Upcoming Tours</p> <h1>989</h1> </div>");
        statDetails.append("<div class='ActiveStat'> <p>Pending Tours</p> <h1>189</h1> </div>");
        statDetails.append("</div>");
        return statDetails.toString();
    }




    // ///////////////////
    private static String ifBlank(String target, String alternative){
        return StringUtils.isBlank(target)? alternative : StringUtils.trimToEmpty(target);
    }
}

