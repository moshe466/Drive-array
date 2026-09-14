package g7;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public abstract class a implements d7.a {

    /* renamed from: a, reason: collision with root package name */
    protected b7.b f9904a;

    public a(b7.b bVar) {
        this.f9904a = bVar;
    }

    protected l a(String str) {
        return new m(str);
    }

    @Override // d7.a
    public void b(String str) {
        c(str, new e7.a());
    }

    public void c(String str, d7.b bVar) {
        l a10 = a(str);
        InputStream inputStream = null;
        try {
            try {
                inputStream = ((m) a10).b();
                i7.b.a(this.f9904a, bVar, inputStream, a10.a());
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (IOException e10) {
            throw new b7.e(e10.getMessage());
        }
    }
}
