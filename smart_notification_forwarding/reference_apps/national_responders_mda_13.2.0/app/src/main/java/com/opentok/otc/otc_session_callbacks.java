package com.opentok.otc;

/* loaded from: classes.dex */
public class otc_session_callbacks {

    /* renamed from: a, reason: collision with root package name */
    private transient long f8605a;

    /* renamed from: b, reason: collision with root package name */
    protected transient boolean f8606b;

    public otc_session_callbacks() {
        this(opentokJNI.new_otc_session_callbacks(), true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public otc_session_callbacks(long j10, boolean z10) {
        this.f8606b = z10;
        this.f8605a = j10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long b(otc_session_callbacks otc_session_callbacksVar) {
        if (otc_session_callbacksVar == null) {
            return 0L;
        }
        return otc_session_callbacksVar.f8605a;
    }

    public synchronized void a() {
        long j10 = this.f8605a;
        if (j10 != 0) {
            if (this.f8606b) {
                this.f8606b = false;
                opentokJNI.delete_otc_session_callbacks(j10);
            }
            this.f8605a = 0L;
        }
    }

    protected void finalize() {
        a();
    }
}
