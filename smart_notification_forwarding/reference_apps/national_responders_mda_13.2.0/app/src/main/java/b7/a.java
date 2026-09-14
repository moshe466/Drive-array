package b7;

import android.bluetooth.BluetoothAdapter;

/* loaded from: classes.dex */
public class a extends c {

    /* renamed from: j, reason: collision with root package name */
    protected String f4130j;

    /* renamed from: k, reason: collision with root package name */
    protected String f4131k;

    protected a(c7.d dVar, String str, int i10, int i11) {
        this.f4130j = "";
        this.f4139h = dVar;
        this.f4131k = str;
        this.f4133b = i10;
        this.f4134c = i11;
    }

    public a(String str) {
        this(str, 5000, 500);
    }

    public a(String str, int i10, int i11) {
        this(new c7.b(c7.a.a(str), d.PRINTING_CHANNEL), c7.a.a(str), i10, i11);
    }

    private void n() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null) {
            defaultAdapter.cancelDiscovery();
        }
    }

    private String p() {
        try {
            return BluetoothAdapter.getDefaultAdapter().getRemoteDevice(this.f4131k).getName();
        } catch (IllegalArgumentException e10) {
            throw new e("Error reading from connection: " + e10.getMessage());
        }
    }

    @Override // b7.c, b7.b
    public void c() {
        n();
        super.c();
        this.f4130j = p();
    }

    @Override // b7.c, b7.b
    public void close() {
        if (this.f4138g) {
            i7.c.c(5000L);
        }
        this.f4130j = "";
        super.close();
    }

    public String o() {
        return this.f4130j;
    }

    public String q() {
        return this.f4131k;
    }

    public String toString() {
        return "Bluetooth:" + q() + ":" + o();
    }
}
