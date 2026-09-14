package N0;

import F0.C0035g2;
import F0.G1;
import java.io.IOException;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import l.C0508f;
import l.ViewOnKeyListenerC0509g;

/* loaded from: classes.dex */
public final class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1451a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final Object f1452b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f1453c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f1454d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f1455e;

    public f(C0035g2 c0035g2, C0508f c0508f, l.o oVar, l.m mVar) {
        this.f1455e = c0035g2;
        this.f1452b = c0508f;
        this.f1453c = oVar;
        this.f1454d = mVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1451a) {
            case 0:
                ArrayList arrayList = (ArrayList) this.f1453c;
                G1 g12 = (G1) this.f1455e;
                i iVar = (i) this.f1452b;
                byte[] bArr = new byte[5];
                bArr[0] = -91;
                try {
                    for (h hVar = iVar.get(); hVar != null; hVar = iVar.get()) {
                        int i = hVar.f1461c;
                        if (i <= 1048576) {
                            p.a(bArr, i);
                            g12.d(bArr, 0, 5);
                            g12.e(hVar.f1460b);
                            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                g gVar = (g) arrayList.get(i3);
                                MessageDigest messageDigest = (MessageDigest) ((ArrayList) this.f1454d).get(i3);
                                byte[] bArr2 = gVar.f1458c;
                                int i4 = gVar.f1457b;
                                int digest = messageDigest.digest(bArr2, (hVar.f1459a * i4) + 5, i4);
                                if (digest != i4) {
                                    throw new RuntimeException("Unexpected output size of " + gVar.f1456a + " digest: " + digest);
                                }
                            }
                        } else {
                            throw new RuntimeException("Chunk size greater than expected: " + i);
                        }
                    }
                    return;
                } catch (IOException e4) {
                    e = e4;
                    throw new RuntimeException(e);
                } catch (DigestException e5) {
                    e = e5;
                    throw new RuntimeException(e);
                }
            default:
                ViewOnKeyListenerC0509g viewOnKeyListenerC0509g = (ViewOnKeyListenerC0509g) ((C0035g2) this.f1455e).f526b;
                l.o oVar = (l.o) this.f1453c;
                C0508f c0508f = (C0508f) this.f1452b;
                if (c0508f != null) {
                    viewOnKeyListenerC0509g.f5364C = true;
                    c0508f.f5360b.c(false);
                    viewOnKeyListenerC0509g.f5364C = false;
                }
                if (oVar.isEnabled() && oVar.hasSubMenu()) {
                    ((l.m) this.f1454d).q(oVar, null, 4);
                    return;
                }
                return;
        }
    }

    public f(i iVar, ArrayList arrayList) {
        this.f1452b = iVar;
        this.f1453c = arrayList;
        this.f1454d = new ArrayList(arrayList.size());
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            try {
                ((ArrayList) this.f1454d).add(MessageDigest.getInstance(((g) obj).f1456a.f1491b));
            } catch (NoSuchAlgorithmException e4) {
                throw new RuntimeException(e4);
            }
        }
        this.f1455e = new G1((MessageDigest[]) ((ArrayList) this.f1454d).toArray(new MessageDigest[0]), 9);
    }
}
