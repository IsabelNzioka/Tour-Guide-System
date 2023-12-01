package com.systechafrica.app.utility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

@BookingNo
public class BookingNoGenerator {

    public String generate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        return "BN" + dateFormat.format(new Date()) + "-" + ThreadLocalRandom.current().nextInt(0, 1000 + 1);
    }
}
