package a2;

import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
public class b extends Exception {

    /* renamed from: f, reason: collision with root package name */
    @Deprecated
    protected final Status f54f;

    public b(Status status) {
        super(status.j() + ": " + (status.l() != null ? status.l() : ""));
        this.f54f = status;
    }

    public Status a() {
        return this.f54f;
    }
}
