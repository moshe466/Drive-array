package v6;

import android.widget.TextView;
import com.groboot.mdaemergency.models.FirstResponderPayload;

/* loaded from: classes.dex */
public class o extends com.groboot.mdaemergency.alwaysOn.b {

    /* renamed from: g, reason: collision with root package name */
    FirstResponderPayload f14701g;

    /* renamed from: h, reason: collision with root package name */
    TextView f14702h;

    /* renamed from: i, reason: collision with root package name */
    TextView f14703i;

    /* renamed from: j, reason: collision with root package name */
    TextView f14704j;

    /* renamed from: k, reason: collision with root package name */
    TextView f14705k;

    /* renamed from: l, reason: collision with root package name */
    TextView f14706l;

    private void b() {
        FirstResponderPayload firstResponderPayload = this.f14701g;
        if (firstResponderPayload == null) {
            return;
        }
        this.f14702h.setText(firstResponderPayload.AcceptanceCallTime);
        this.f14703i.setText(this.f14701g.MissionNum + "");
        this.f14704j.setText(this.f14701g.Address);
        this.f14705k.setText(this.f14701g.DispatchingType);
        this.f14706l.setText(this.f14701g.MedicalClassification);
    }

    public void setFirstResponderCall(FirstResponderPayload firstResponderPayload) {
        this.f14701g = firstResponderPayload;
        b();
    }
}
