package f0;

import F0.AbstractC0008a;
import F0.C0110z2;
import androidx.lifecycle.A;
import androidx.lifecycle.InterfaceC0309t;
import androidx.lifecycle.Z;
import d0.C0355a;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.s;
import t.C0695k;

/* renamed from: f0.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0377f extends AbstractC0373b {

    /* renamed from: a, reason: collision with root package name */
    public final Object f4488a;

    /* renamed from: b, reason: collision with root package name */
    public final C0376e f4489b;

    public C0377f(InterfaceC0309t interfaceC0309t, Z store) {
        this.f4488a = interfaceC0309t;
        j.e(store, "store");
        C0355a defaultCreationExtras = C0355a.f4411b;
        j.e(defaultCreationExtras, "defaultCreationExtras");
        C0110z2 c0110z2 = new C0110z2(store, C0376e.f4485d, defaultCreationExtras);
        kotlin.jvm.internal.e a2 = s.a(C0376e.class);
        String b4 = a2.b();
        if (b4 != null) {
            this.f4489b = (C0376e) c0110z2.r(a2, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(b4));
            return;
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public final void b(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        boolean z3;
        C0376e c0376e = this.f4489b;
        if (c0376e.f4486b.f6369c > 0) {
            printWriter.print(str);
            printWriter.println("Loaders:");
            String str2 = str + "    ";
            int i = 0;
            while (true) {
                C0695k c0695k = c0376e.f4486b;
                if (i < c0695k.f6369c) {
                    C0374c c0374c = (C0374c) c0695k.f6368b[i];
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(c0376e.f4486b.f6367a[i]);
                    printWriter.print(": ");
                    printWriter.println(c0374c.toString());
                    printWriter.print(str2);
                    printWriter.print("mId=");
                    printWriter.print(0);
                    printWriter.print(" mArgs=");
                    Object obj = null;
                    printWriter.println((Object) null);
                    printWriter.print(str2);
                    printWriter.print("mLoader=");
                    printWriter.println(c0374c.f4479l);
                    c0374c.f4479l.dump(AbstractC0008a.n(str2, "  "), fileDescriptor, printWriter, strArr);
                    if (c0374c.f4481n != null) {
                        printWriter.print(str2);
                        printWriter.print("mCallbacks=");
                        printWriter.println(c0374c.f4481n);
                        C0375d c0375d = c0374c.f4481n;
                        c0375d.getClass();
                        printWriter.print(str2 + "  ");
                        printWriter.print("mDeliveredData=");
                        printWriter.println(c0375d.f4484c);
                    }
                    printWriter.print(str2);
                    printWriter.print("mData=");
                    androidx.loader.content.e eVar = c0374c.f4479l;
                    Object obj2 = c0374c.f3544e;
                    if (obj2 != A.f3539k) {
                        obj = obj2;
                    }
                    printWriter.println(eVar.dataToString(obj));
                    printWriter.print(str2);
                    printWriter.print("mStarted=");
                    if (c0374c.f3542c > 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    printWriter.println(z3);
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        I.d.a(this.f4488a, sb);
        sb.append("}}");
        return sb.toString();
    }
}
