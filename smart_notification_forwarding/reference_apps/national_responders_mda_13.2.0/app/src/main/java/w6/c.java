package w6;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import com.groboot.mdaemergency.a;
import com.groboot.mdaemergency.models.CalendarEvent;
import com.groboot.mdaemergency.ui.views.WebViewMDA;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static Activity f15118a;

    public static void b(Activity activity) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("account_name", f());
        contentValues.put("account_type", f());
        contentValues.put("name", f());
        contentValues.put("calendar_displayName", f());
        contentValues.put("calendar_color", "232323");
        contentValues.put("calendar_access_level", (Integer) 700);
        contentValues.put("ownerAccount", f());
        contentValues.put("allowedReminders", "METHOD_ALERT, METHOD_EMAIL, METHOD_ALARM");
        contentValues.put("allowedAttendeeTypes", "TYPE_OPTIONAL, TYPE_REQUIRED, TYPE_RESOURCE");
        contentValues.put("allowedAvailability", "AVAILABILITY_BUSY, AVAILABILITY_FREE, AVAILABILITY_TENTATIVE");
        m.e0(l0.U(activity.getContentResolver().insert(CalendarContract.Calendars.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").appendQueryParameter("account_name", f()).appendQueryParameter("account_type", f()).build(), contentValues).getLastPathSegment()));
    }

    public static void c(final Activity activity, final List<CalendarEvent> list, final WebViewMDA.j jVar) {
        f15118a = activity;
        if (com.groboot.mdaemergency.a.p(activity)) {
            e(activity, list, jVar);
        } else {
            com.groboot.mdaemergency.a.g(activity, new a.InterfaceC0096a() { // from class: w6.b
                @Override // com.groboot.mdaemergency.a.InterfaceC0096a
                public final void a(a.c cVar) {
                    c.h(activity, list, jVar, cVar);
                }
            });
        }
    }

    public static void d(Activity activity, CalendarEvent calendarEvent) {
        if (!g(activity)) {
            b(activity);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(l0.C(calendarEvent.DTSTART, l0.f15201n));
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(l0.C(calendarEvent.DTEND, l0.f15201n));
        ContentResolver contentResolver = activity.getContentResolver();
        ContentValues contentValues = new ContentValues();
        contentValues.put("dtstart", Long.valueOf(calendar.getTimeInMillis()));
        contentValues.put("dtend", Long.valueOf(calendar2.getTimeInMillis()));
        contentValues.put("title", calendarEvent.TITLE);
        contentValues.put("description", calendarEvent.DESCRIPTION);
        contentValues.put("calendar_id", Integer.valueOf(m.o()));
        contentValues.put("eventTimezone", calendarEvent.EVENT_TIMEZONE);
        contentValues.put("eventLocation", calendarEvent.LOCATION);
        i(contentResolver, Long.parseLong(contentResolver.insert(CalendarContract.Events.CONTENT_URI, contentValues).getLastPathSegment()), calendarEvent.REMIND_MINUTES);
    }

    public static void e(Activity activity, List<CalendarEvent> list, WebViewMDA.j jVar) {
        Iterator<CalendarEvent> it = list.iterator();
        while (it.hasNext()) {
            d(activity, it.next());
        }
        jVar.a("");
    }

    private static String f() {
        return f15118a.getString(m.l());
    }

    public static boolean g(Activity activity) {
        ContentResolver contentResolver = activity.getContentResolver();
        String[] strArr = {"allowedAttendeeTypes", "account_name", "calendar_displayName", "calendar_location", "calendar_timezone"};
        Uri uri = CalendarContract.Calendars.CONTENT_URI;
        String[] strArr2 = {f(), f(), f()};
        if (androidx.core.content.a.a(activity, "android.permission.READ_CALENDAR") != 0) {
            androidx.core.app.b.n(activity, new String[]{"android.permission.READ_CALENDAR"}, 101101);
        }
        Cursor query = contentResolver.query(uri, strArr, "((account_name = ?) AND (account_type = ?) AND (ownerAccount = ?))", strArr2, null);
        query.getColumnIndex("_id");
        return query.getCount() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(Activity activity, List list, WebViewMDA.j jVar, a.c cVar) {
        if (cVar == a.c.ALLOWED) {
            e(activity, list, jVar);
        }
    }

    @SuppressLint({"MissingPermission"})
    public static void i(ContentResolver contentResolver, long j10, int i10) {
        if (i10 <= 0) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("event_id", Long.valueOf(j10));
        contentValues.put("minutes", Integer.valueOf(i10));
        contentValues.put("method", (Integer) 4);
        contentResolver.insert(CalendarContract.Reminders.CONTENT_URI, contentValues);
    }
}
