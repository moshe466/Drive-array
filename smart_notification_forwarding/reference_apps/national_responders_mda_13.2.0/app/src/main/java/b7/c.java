package b7;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public abstract class c implements f {

    /* renamed from: d, reason: collision with root package name */
    protected c7.e f4135d;

    /* renamed from: e, reason: collision with root package name */
    protected OutputStream f4136e;

    /* renamed from: f, reason: collision with root package name */
    protected InputStream f4137f;

    /* renamed from: h, reason: collision with root package name */
    protected c7.d f4139h;

    /* renamed from: i, reason: collision with root package name */
    protected OutputStream f4140i;

    /* renamed from: a, reason: collision with root package name */
    private int f4132a = 1024;

    /* renamed from: b, reason: collision with root package name */
    protected int f4133b = 0;

    /* renamed from: c, reason: collision with root package name */
    protected int f4134c = 0;

    /* renamed from: g, reason: collision with root package name */
    protected boolean f4138g = false;

    private void g(String str, Exception exc) {
        if (str == null) {
            str = "";
        }
        throw new e(str + (exc.getMessage() != null ? exc.getMessage() : exc.getClass().getSimpleName()), exc);
    }

    @Override // b7.b
    public boolean a() {
        return this.f4138g;
    }

    @Override // b7.b
    public void b(byte[] bArr, int i10, int i11) {
        if (this.f4136e == null || !a()) {
            throw new e("The connection is not open");
        }
        while (i11 > 0) {
            try {
                int i12 = this.f4132a;
                if (i11 <= i12) {
                    i12 = i11;
                }
                this.f4136e.write(bArr, i10, i12);
                m(bArr, i10, i12);
                this.f4136e.flush();
                i7.c.c(10L);
                i10 += i12;
                i11 -= i12;
            } catch (IOException e10) {
                g("Error writing to connection: ", e10);
                return;
            }
        }
    }

    @Override // b7.b
    public void c() {
        if (this.f4138g) {
            return;
        }
        try {
            c7.e c10 = this.f4139h.c();
            this.f4135d = c10;
            this.f4136e = c10.a();
            this.f4137f = this.f4135d.b();
            this.f4138g = true;
        } catch (Exception e10) {
            this.f4138g = false;
            g("Could not connect to device: ", e10);
        }
    }

    @Override // b7.b
    public void close() {
        if (this.f4138g) {
            this.f4138g = false;
            try {
                this.f4136e.close();
                this.f4137f.close();
                this.f4135d.close();
            } catch (IOException e10) {
                g("Could not disconnect from device: ", e10);
            }
        }
    }

    public int d() {
        try {
            return this.f4137f.available();
        } catch (IOException e10) {
            g("Error reading from connection: ", e10);
            return -1;
        }
    }

    public byte[] e() {
        return f(-1);
    }

    public byte[] f(int i10) {
        int d10 = d();
        if (d10 <= 0) {
            return null;
        }
        if (i10 >= 0) {
            d10 = Math.min(i10, d10);
        }
        byte[] bArr = new byte[d10];
        try {
            this.f4137f.read(bArr);
        } catch (IOException e10) {
            g("Error reading from connection: ", e10);
        }
        return bArr;
    }

    @Override // b7.b
    public void h(byte[] bArr) {
        b(bArr, 0, bArr.length);
    }

    @Override // b7.b
    public int i() {
        return this.f4134c;
    }

    @Override // b7.b
    public byte[] j(byte[] bArr, int i10, int i11, i iVar) {
        if (!a()) {
            throw new e("No Printer Connection");
        }
        h(bArr);
        l(i10);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (d() > 0) {
            try {
                byteArrayOutputStream.write(e());
            } catch (IOException e10) {
                g(e10.getMessage(), e10);
            }
            if (!iVar.a(byteArrayOutputStream.toByteArray())) {
                l(i11);
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override // b7.b
    public int k() {
        return this.f4133b;
    }

    public void l(int i10) {
        long currentTimeMillis = System.currentTimeMillis() + i10;
        while (d() == 0 && System.currentTimeMillis() < currentTimeMillis) {
            i7.c.c(50L);
        }
    }

    protected void m(byte[] bArr, int i10, int i11) {
        OutputStream outputStream = this.f4140i;
        if (outputStream != null) {
            try {
                outputStream.write(bArr, i10, i11);
            } catch (IOException e10) {
                throw new g("Error writing to log: " + e10.getLocalizedMessage());
            }
        }
    }
}
