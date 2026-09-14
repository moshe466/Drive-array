package M1;

import F1.k;
import android.content.Context;
import android.content.IntentFilter;
import android.view.MenuItem;
import h.y;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import javax.crypto.AEADBadTagException;
import l.t;
import p3.h;
import t.C0694j;

/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public Object f1405a;

    /* renamed from: b, reason: collision with root package name */
    public Object f1406b;

    public f(Context context) {
        this.f1405a = context;
    }

    public static byte[] i(byte[] bArr, ByteBuffer byteBuffer) {
        int length;
        int i;
        if (bArr.length % 16 == 0) {
            length = bArr.length;
        } else {
            length = (bArr.length + 16) - (bArr.length % 16);
        }
        int remaining = byteBuffer.remaining();
        int i3 = remaining % 16;
        if (i3 == 0) {
            i = remaining;
        } else {
            i = (remaining + 16) - i3;
        }
        int i4 = i + length;
        ByteBuffer order = ByteBuffer.allocate(i4 + 16).order(ByteOrder.LITTLE_ENDIAN);
        order.put(bArr);
        order.position(length);
        order.put(byteBuffer);
        order.position(i4);
        order.putLong(bArr.length);
        order.putLong(remaining);
        return order.array();
    }

    public void c() {
        k kVar = (k) this.f1405a;
        if (kVar != null) {
            try {
                ((y) this.f1406b).f4912n.unregisterReceiver(kVar);
            } catch (IllegalArgumentException unused) {
            }
            this.f1405a = null;
        }
    }

    public abstract IntentFilter d();

    public byte[] e(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2) {
        if (byteBuffer.remaining() >= 16) {
            int position = byteBuffer.position();
            byte[] bArr3 = new byte[16];
            byteBuffer.position(byteBuffer.limit() - 16);
            byteBuffer.get(bArr3);
            byteBuffer.position(position);
            byteBuffer.limit(byteBuffer.limit() - 16);
            if (bArr2 == null) {
                bArr2 = new byte[0];
            }
            try {
                byte[] bArr4 = new byte[32];
                ((d) this.f1406b).a(bArr, 0).get(bArr4);
                if (MessageDigest.isEqual(h.j(bArr4, i(bArr2, byteBuffer)), bArr3)) {
                    byteBuffer.position(position);
                    d dVar = (d) this.f1405a;
                    dVar.getClass();
                    ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
                    dVar.k(bArr, allocate, byteBuffer);
                    return allocate.array();
                }
                throw new GeneralSecurityException("invalid MAC");
            } catch (GeneralSecurityException e4) {
                throw new AEADBadTagException(e4.toString());
            }
        }
        throw new GeneralSecurityException("ciphertext too short");
    }

    public void f(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (byteBuffer.remaining() >= bArr2.length + 16) {
            int position = byteBuffer.position();
            d dVar = (d) this.f1405a;
            dVar.getClass();
            if (byteBuffer.remaining() >= bArr2.length) {
                dVar.k(bArr, byteBuffer, ByteBuffer.wrap(bArr2));
                byteBuffer.position(position);
                byteBuffer.limit(byteBuffer.limit() - 16);
                if (bArr3 == null) {
                    bArr3 = new byte[0];
                }
                byte[] bArr4 = new byte[32];
                ((d) this.f1406b).a(bArr, 0).get(bArr4);
                byte[] j2 = h.j(bArr4, i(bArr3, byteBuffer));
                byteBuffer.limit(byteBuffer.limit() + 16);
                byteBuffer.put(j2);
                return;
            }
            throw new IllegalArgumentException("Given ByteBuffer output is too small");
        }
        throw new IllegalArgumentException("Given ByteBuffer output is too small");
    }

    public abstract int g();

    public MenuItem h(MenuItem menuItem) {
        if (menuItem instanceof D.a) {
            D.a aVar = (D.a) menuItem;
            if (((C0694j) this.f1406b) == null) {
                this.f1406b = new C0694j(0);
            }
            MenuItem menuItem2 = (MenuItem) ((C0694j) this.f1406b).get(aVar);
            if (menuItem2 == null) {
                t tVar = new t((Context) this.f1405a, aVar);
                ((C0694j) this.f1406b).put(aVar, tVar);
                return tVar;
            }
            return menuItem2;
        }
        return menuItem;
    }

    public abstract d j(byte[] bArr, int i);

    public abstract void k();

    public void l() {
        c();
        IntentFilter d2 = d();
        if (d2.countActions() == 0) {
            return;
        }
        if (((k) this.f1405a) == null) {
            this.f1405a = new k(this, 1);
        }
        ((y) this.f1406b).f4912n.registerReceiver((k) this.f1405a, d2);
    }

    public f(y yVar) {
        this.f1406b = yVar;
    }
}
