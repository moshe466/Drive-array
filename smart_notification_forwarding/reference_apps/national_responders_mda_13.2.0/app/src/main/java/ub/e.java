package ub;

import java.io.IOException;

/* loaded from: classes.dex */
public final class e extends RuntimeException {

    /* renamed from: f, reason: collision with root package name */
    private IOException f14576f;

    /* renamed from: g, reason: collision with root package name */
    private IOException f14577g;

    public e(IOException iOException) {
        super(iOException);
        this.f14576f = iOException;
        this.f14577g = iOException;
    }

    public void a(IOException iOException) {
        sb.c.a(this.f14576f, iOException);
        this.f14577g = iOException;
    }

    public IOException b() {
        return this.f14576f;
    }

    public IOException c() {
        return this.f14577g;
    }
}
