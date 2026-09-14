package f6;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.groboot.mdaemergency.locations.geofencing.GeofenceService;
import il.org.mda.health.R;

/* loaded from: classes.dex */
public class j1 extends a6.a {
    public static boolean q2(Context context) {
        return (w6.m.k() == null || w6.m.k().getDeviceName() == null || !w6.m.k().getDeviceName().startsWith("ONEPLUS") || !w6.m.t() || w6.m.O() == null || w6.m.O() == com.groboot.mdaemergency.enums.b.NOT_AVAILABLE || w6.m.O() == com.groboot.mdaemergency.enums.b.SATURDAY || w6.l0.j0(GeofenceService.class, context)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r2(View view) {
        W1();
    }

    @Override // a6.a
    protected void n2() {
        l2(R.layout.oneplus_lock_fragment);
        k2(R.id.close).setOnClickListener(new View.OnClickListener() { // from class: f6.i1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                j1.this.r2(view);
            }
        });
        ((TextView) k2(R.id.txt_text)).setText("על מנת לאכן אותך באופן רציף\nאנא פתח את התהליכים\nולחץ על המנעול כפי המוצג בתמונה:");
    }

    @Override // a6.a
    public void o2() {
    }
}
