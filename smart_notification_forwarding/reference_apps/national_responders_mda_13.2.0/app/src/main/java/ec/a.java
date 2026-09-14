package ec;

import cc.c;
import java.util.Calendar;
import java.util.Date;

/* loaded from: classes.dex */
public class a {
    private static Date a(Date date, int i10, int i11) {
        c(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(i10, i11);
        return calendar.getTime();
    }

    public static Date b(Date date, int i10) {
        return a(date, 12, i10);
    }

    private static void c(Date date) {
        c.c(date, "date", new Object[0]);
    }
}
