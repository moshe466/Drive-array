package a;

import F2.l;
import F2.p;
import J.Q;
import J.S;
import M.b;
import O2.c;
import P2.C0171v;
import P2.G;
import R.InterfaceC0183h;
import U2.r;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Trace;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EdgeEffect;
import com.uh.sf.R;
import io.flutter.plugin.platform.e;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.WeakHashMap;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.u;
import m.Q0;
import org.apache.tika.fork.ForkServer;
import p0.AbstractC0599a;
import s2.C0679d;
import s2.C0680e;
import w2.InterfaceC0763d;
import x2.EnumC0779a;

/* renamed from: a.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0228a {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f2732a = false;

    /* renamed from: b, reason: collision with root package name */
    public static Method f2733b = null;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f2734c = false;

    /* renamed from: d, reason: collision with root package name */
    public static Field f2735d = null;

    /* renamed from: e, reason: collision with root package name */
    public static long f2736e = 0;

    /* renamed from: f, reason: collision with root package name */
    public static Method f2737f = null;

    /* renamed from: g, reason: collision with root package name */
    public static Method f2738g = null;

    /* renamed from: h, reason: collision with root package name */
    public static Method f2739h = null;
    public static boolean i = true;

    public static final Object A(r rVar, r rVar2, p pVar) {
        Object c0171v;
        Object E3;
        try {
            u.a(2, pVar);
            c0171v = pVar.invoke(rVar2, rVar);
        } catch (Throwable th) {
            c0171v = new C0171v(th, false);
        }
        EnumC0779a enumC0779a = EnumC0779a.f6740a;
        if (c0171v != enumC0779a && (E3 = rVar.E(c0171v)) != G.f1608e) {
            if (!(E3 instanceof C0171v)) {
                return G.x(E3);
            }
            throw ((C0171v) E3).f1707a;
        }
        return enumC0779a;
    }

    public static void B(ViewGroup viewGroup, boolean z3) {
        if (Build.VERSION.SDK_INT >= 29) {
            e.n(viewGroup, z3);
        } else if (i) {
            try {
                e.n(viewGroup, z3);
            } catch (NoSuchMethodError unused) {
                i = false;
            }
        }
    }

    public static final void C(Object obj) {
        if (!(obj instanceof C0680e)) {
        } else {
            throw ((C0680e) obj).f6334a;
        }
    }

    public static String D(String str) {
        if (str.length() <= 127) {
            return str;
        }
        return str.substring(0, 127);
    }

    public static Object a(Parcel parcel, Parcelable.Creator creator) {
        if (parcel.readInt() != 0) {
            return creator.createFromParcel(parcel);
        }
        return null;
    }

    public static void b(StringBuilder sb, Object obj, l lVar) {
        boolean z3;
        if (lVar != null) {
            sb.append((CharSequence) lVar.invoke(obj));
            return;
        }
        if (obj == null) {
            z3 = true;
        } else {
            z3 = obj instanceof CharSequence;
        }
        if (z3) {
            sb.append((CharSequence) obj);
        } else if (obj instanceof Character) {
            sb.append(((Character) obj).charValue());
        } else {
            sb.append((CharSequence) obj.toString());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(R2.p r4, F2.a r5, y2.AbstractC0787c r6) {
        /*
            boolean r0 = r6 instanceof R2.n
            if (r0 == 0) goto L13
            r0 = r6
            R2.n r0 = (R2.n) r0
            int r1 = r0.f2068c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f2068c = r1
            goto L18
        L13:
            R2.n r0 = new R2.n
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f2067b
            x2.a r1 = x2.EnumC0779a.f6740a
            int r2 = r0.f2068c
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            kotlin.jvm.internal.k r4 = r0.f2066a
            r5 = r4
            F2.a r5 = (F2.a) r5
            C(r6)     // Catch: java.lang.Throwable -> L2c
            goto L6a
        L2c:
            r4 = move-exception
            goto L70
        L2e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L36:
            C(r6)
            w2.i r6 = r0.getContext()
            P2.B r2 = P2.B.f1595b
            w2.g r6 = r6.get(r2)
            if (r6 != r4) goto L74
            r6 = r5
            kotlin.jvm.internal.k r6 = (kotlin.jvm.internal.k) r6     // Catch: java.lang.Throwable -> L2c
            r0.f2066a = r6     // Catch: java.lang.Throwable -> L2c
            r0.f2068c = r3     // Catch: java.lang.Throwable -> L2c
            P2.m r6 = new P2.m     // Catch: java.lang.Throwable -> L2c
            w2.d r0 = m3.b.z(r0)     // Catch: java.lang.Throwable -> L2c
            r6.<init>(r3, r0)     // Catch: java.lang.Throwable -> L2c
            r6.r()     // Catch: java.lang.Throwable -> L2c
            R.L r0 = new R.L     // Catch: java.lang.Throwable -> L2c
            r2 = 1
            r0.<init>(r6, r2)     // Catch: java.lang.Throwable -> L2c
            R2.o r4 = (R2.o) r4     // Catch: java.lang.Throwable -> L2c
            r4.S(r0)     // Catch: java.lang.Throwable -> L2c
            java.lang.Object r4 = r6.q()     // Catch: java.lang.Throwable -> L2c
            if (r4 != r1) goto L6a
            return r1
        L6a:
            r5.invoke()
            s2.i r4 = s2.C0684i.f6340a
            return r4
        L70:
            r5.invoke()
            throw r4
        L74:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "awaitClose() can only be invoked from the producer context"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: a.AbstractC0228a.c(R2.p, F2.a, y2.c):java.lang.Object");
    }

    public static int d(Comparable comparable, Comparable comparable2) {
        if (comparable == comparable2) {
            return 0;
        }
        if (comparable == null) {
            return -1;
        }
        if (comparable2 == null) {
            return 1;
        }
        return comparable.compareTo(comparable2);
    }

    public static int e(Comparable comparable, Comparable comparable2, l... lVarArr) {
        if (lVarArr.length > 0) {
            for (l lVar : lVarArr) {
                int d2 = d((Comparable) lVar.invoke(comparable), (Comparable) lVar.invoke(comparable2));
                if (d2 != 0) {
                    return d2;
                }
            }
            return 0;
        }
        throw new IllegalArgumentException("Failed requirement.");
    }

    public static final long f(long j2, c sourceUnit, c targetUnit) {
        j.e(sourceUnit, "sourceUnit");
        j.e(targetUnit, "targetUnit");
        return targetUnit.f1547a.convert(j2, sourceUnit.f1547a);
    }

    public static final C0680e g(Throwable exception) {
        j.e(exception, "exception");
        return new C0680e(exception);
    }

    public static void h(String str, String str2, Object obj) {
        if (Log.isLoggable(v(str), 3)) {
            String.format(str2, obj);
        }
    }

    public static byte[] i(String str) {
        if (str.length() % 2 == 0) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i3 = 0; i3 < length; i3++) {
                int i4 = i3 * 2;
                int digit = Character.digit(str.charAt(i4), 16);
                int digit2 = Character.digit(str.charAt(i4 + 1), 16);
                if (digit != -1 && digit2 != -1) {
                    bArr[i3] = (byte) ((digit * 16) + digit2);
                } else {
                    throw new IllegalArgumentException("input is not hexadecimal");
                }
            }
            return bArr;
        }
        throw new IllegalArgumentException("Expected a string of even length");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.Object, J.Q] */
    public static boolean j(View view, KeyEvent keyEvent) {
        ArrayList arrayList;
        int size;
        int indexOfKey;
        WeakHashMap weakHashMap = S.f954a;
        if (Build.VERSION.SDK_INT < 28) {
            ArrayList arrayList2 = Q.f950d;
            Q q3 = (Q) view.getTag(R.id.tag_unhandled_key_event_manager);
            WeakReference weakReference = null;
            Q q4 = q3;
            if (q3 == null) {
                ?? obj = new Object();
                obj.f951a = null;
                obj.f952b = null;
                obj.f953c = null;
                view.setTag(R.id.tag_unhandled_key_event_manager, obj);
                q4 = obj;
            }
            WeakReference weakReference2 = q4.f953c;
            if (weakReference2 == null || weakReference2.get() != keyEvent) {
                q4.f953c = new WeakReference(keyEvent);
                if (q4.f952b == null) {
                    q4.f952b = new SparseArray();
                }
                SparseArray sparseArray = q4.f952b;
                if (keyEvent.getAction() == 1 && (indexOfKey = sparseArray.indexOfKey(keyEvent.getKeyCode())) >= 0) {
                    weakReference = (WeakReference) sparseArray.valueAt(indexOfKey);
                    sparseArray.removeAt(indexOfKey);
                }
                if (weakReference == null) {
                    weakReference = (WeakReference) sparseArray.get(keyEvent.getKeyCode());
                }
                if (weakReference != null) {
                    View view2 = (View) weakReference.get();
                    if (view2 == null || !view2.isAttachedToWindow() || (arrayList = (ArrayList) view2.getTag(R.id.tag_unhandled_key_listeners)) == null || (size = arrayList.size() - 1) < 0) {
                        return true;
                    }
                    throw e0.a.b(size, arrayList);
                }
                return false;
            }
            return false;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean k(J.InterfaceC0122j r6, android.view.View r7, android.view.Window.Callback r8, android.view.KeyEvent r9) {
        /*
            r0 = 0
            if (r6 != 0) goto L5
            goto Le4
        L5:
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 28
            if (r1 < r2) goto L10
            boolean r6 = r6.superDispatchKeyEvent(r9)
            return r6
        L10:
            boolean r1 = r8 instanceof android.app.Activity
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L82
            android.app.Activity r8 = (android.app.Activity) r8
            r8.onUserInteraction()
            android.view.Window r6 = r8.getWindow()
            r7 = 8
            boolean r7 = r6.hasFeature(r7)
            if (r7 == 0) goto L65
            android.app.ActionBar r7 = r8.getActionBar()
            int r1 = r9.getKeyCode()
            r4 = 82
            if (r1 != r4) goto L65
            if (r7 == 0) goto L65
            boolean r1 = a.AbstractC0228a.f2732a
            if (r1 != 0) goto L4d
            java.lang.Class r1 = r7.getClass()     // Catch: java.lang.NoSuchMethodException -> L4b
            java.lang.String r4 = "onMenuKeyEvent"
            java.lang.Class<android.view.KeyEvent> r5 = android.view.KeyEvent.class
            java.lang.Class[] r5 = new java.lang.Class[]{r5}     // Catch: java.lang.NoSuchMethodException -> L4b
            java.lang.reflect.Method r1 = r1.getMethod(r4, r5)     // Catch: java.lang.NoSuchMethodException -> L4b
            a.AbstractC0228a.f2733b = r1     // Catch: java.lang.NoSuchMethodException -> L4b
        L4b:
            a.AbstractC0228a.f2732a = r3
        L4d:
            java.lang.reflect.Method r1 = a.AbstractC0228a.f2733b
            if (r1 == 0) goto L62
            java.lang.Object[] r4 = new java.lang.Object[]{r9}     // Catch: java.lang.Throwable -> L62
            java.lang.Object r7 = r1.invoke(r7, r4)     // Catch: java.lang.Throwable -> L62
            if (r7 != 0) goto L5c
            goto L62
        L5c:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Throwable -> L62
            boolean r0 = r7.booleanValue()     // Catch: java.lang.Throwable -> L62
        L62:
            if (r0 == 0) goto L65
            goto L81
        L65:
            boolean r7 = r6.superDispatchKeyEvent(r9)
            if (r7 == 0) goto L6c
            goto L81
        L6c:
            android.view.View r6 = r6.getDecorView()
            boolean r7 = J.S.c(r6, r9)
            if (r7 == 0) goto L77
            goto L81
        L77:
            if (r6 == 0) goto L7d
            android.view.KeyEvent$DispatcherState r2 = r6.getKeyDispatcherState()
        L7d:
            boolean r3 = r9.dispatch(r8, r2, r8)
        L81:
            return r3
        L82:
            boolean r1 = r8 instanceof android.app.Dialog
            if (r1 == 0) goto Ld5
            android.app.Dialog r8 = (android.app.Dialog) r8
            boolean r6 = a.AbstractC0228a.f2734c
            if (r6 != 0) goto L9b
            java.lang.Class<android.app.Dialog> r6 = android.app.Dialog.class
            java.lang.String r7 = "mOnKeyListener"
            java.lang.reflect.Field r6 = r6.getDeclaredField(r7)     // Catch: java.lang.NoSuchFieldException -> L99
            a.AbstractC0228a.f2735d = r6     // Catch: java.lang.NoSuchFieldException -> L99
            r6.setAccessible(r3)     // Catch: java.lang.NoSuchFieldException -> L99
        L99:
            a.AbstractC0228a.f2734c = r3
        L9b:
            java.lang.reflect.Field r6 = a.AbstractC0228a.f2735d
            if (r6 == 0) goto La6
            java.lang.Object r6 = r6.get(r8)     // Catch: java.lang.IllegalAccessException -> La6
            android.content.DialogInterface$OnKeyListener r6 = (android.content.DialogInterface.OnKeyListener) r6     // Catch: java.lang.IllegalAccessException -> La6
            goto La7
        La6:
            r6 = r2
        La7:
            if (r6 == 0) goto Lb4
            int r7 = r9.getKeyCode()
            boolean r6 = r6.onKey(r8, r7, r9)
            if (r6 == 0) goto Lb4
            goto Ld4
        Lb4:
            android.view.Window r6 = r8.getWindow()
            boolean r7 = r6.superDispatchKeyEvent(r9)
            if (r7 == 0) goto Lbf
            goto Ld4
        Lbf:
            android.view.View r6 = r6.getDecorView()
            boolean r7 = J.S.c(r6, r9)
            if (r7 == 0) goto Lca
            goto Ld4
        Lca:
            if (r6 == 0) goto Ld0
            android.view.KeyEvent$DispatcherState r2 = r6.getKeyDispatcherState()
        Ld0:
            boolean r3 = r9.dispatch(r8, r2, r8)
        Ld4:
            return r3
        Ld5:
            if (r7 == 0) goto Ldd
            boolean r7 = J.S.c(r7, r9)
            if (r7 != 0) goto Le3
        Ldd:
            boolean r6 = r6.superDispatchKeyEvent(r9)
            if (r6 == 0) goto Le4
        Le3:
            return r3
        Le4:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.AbstractC0228a.k(J.j, android.view.View, android.view.Window$Callback, android.view.KeyEvent):boolean");
    }

    public static void l(Exception exc, String str, String str2) {
        String v2 = v(str);
        if (Log.isLoggable(v2, 6)) {
            Log.e(v2, str2, exc);
        }
    }

    public static final Object m(InterfaceC0183h interfaceC0183h, p pVar, InterfaceC0763d interfaceC0763d) {
        return interfaceC0183h.a(new U.j(pVar, null), interfaceC0763d);
    }

    public static String n(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b4 : bArr) {
            int i3 = b4 & ForkServer.ERROR;
            sb.append("0123456789abcdef".charAt(i3 / 16));
            sb.append("0123456789abcdef".charAt(i3 % 16));
        }
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x0047, code lost:
    
        if (r5.f6792c == r8.hashCode()) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.content.res.ColorStateList o(android.content.Context r8, int r9) {
        /*
            android.content.res.Resources r0 = r8.getResources()
            android.content.res.Resources$Theme r8 = r8.getTheme()
            z.i r1 = new z.i
            r1.<init>(r0, r8)
            java.lang.Object r2 = z.k.f6797c
            monitor-enter(r2)
            java.util.WeakHashMap r3 = z.k.f6796b     // Catch: java.lang.Throwable -> L3c
            java.lang.Object r3 = r3.get(r1)     // Catch: java.lang.Throwable -> L3c
            android.util.SparseArray r3 = (android.util.SparseArray) r3     // Catch: java.lang.Throwable -> L3c
            r4 = 0
            if (r3 == 0) goto L50
            int r5 = r3.size()     // Catch: java.lang.Throwable -> L3c
            if (r5 <= 0) goto L50
            java.lang.Object r5 = r3.get(r9)     // Catch: java.lang.Throwable -> L3c
            z.h r5 = (z.h) r5     // Catch: java.lang.Throwable -> L3c
            if (r5 == 0) goto L50
            android.content.res.Configuration r6 = r5.f6791b     // Catch: java.lang.Throwable -> L3c
            android.content.res.Configuration r7 = r0.getConfiguration()     // Catch: java.lang.Throwable -> L3c
            boolean r6 = r6.equals(r7)     // Catch: java.lang.Throwable -> L3c
            if (r6 == 0) goto L4d
            if (r8 != 0) goto L3f
            int r6 = r5.f6792c     // Catch: java.lang.Throwable -> L3c
            if (r6 == 0) goto L49
            goto L3f
        L3c:
            r8 = move-exception
            goto Laf
        L3f:
            if (r8 == 0) goto L4d
            int r6 = r5.f6792c     // Catch: java.lang.Throwable -> L3c
            int r7 = r8.hashCode()     // Catch: java.lang.Throwable -> L3c
            if (r6 != r7) goto L4d
        L49:
            android.content.res.ColorStateList r3 = r5.f6790a     // Catch: java.lang.Throwable -> L3c
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L3c
            goto L52
        L4d:
            r3.remove(r9)     // Catch: java.lang.Throwable -> L3c
        L50:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L3c
            r3 = r4
        L52:
            if (r3 == 0) goto L55
            return r3
        L55:
            java.lang.ThreadLocal r2 = z.k.f6795a
            java.lang.Object r3 = r2.get()
            android.util.TypedValue r3 = (android.util.TypedValue) r3
            if (r3 != 0) goto L67
            android.util.TypedValue r3 = new android.util.TypedValue
            r3.<init>()
            r2.set(r3)
        L67:
            r2 = 1
            r0.getValue(r9, r3, r2)
            int r2 = r3.type
            r3 = 28
            if (r2 < r3) goto L76
            r3 = 31
            if (r2 > r3) goto L76
            goto L7e
        L76:
            android.content.res.XmlResourceParser r2 = r0.getXml(r9)
            android.content.res.ColorStateList r4 = z.c.a(r0, r2, r8)     // Catch: java.lang.Exception -> L7e
        L7e:
            if (r4 == 0) goto Laa
            java.lang.Object r2 = z.k.f6797c
            monitor-enter(r2)
            java.util.WeakHashMap r0 = z.k.f6796b     // Catch: java.lang.Throwable -> L96
            java.lang.Object r3 = r0.get(r1)     // Catch: java.lang.Throwable -> L96
            android.util.SparseArray r3 = (android.util.SparseArray) r3     // Catch: java.lang.Throwable -> L96
            if (r3 != 0) goto L98
            android.util.SparseArray r3 = new android.util.SparseArray     // Catch: java.lang.Throwable -> L96
            r3.<init>()     // Catch: java.lang.Throwable -> L96
            r0.put(r1, r3)     // Catch: java.lang.Throwable -> L96
            goto L98
        L96:
            r8 = move-exception
            goto La8
        L98:
            z.h r0 = new z.h     // Catch: java.lang.Throwable -> L96
            android.content.res.Resources r1 = r1.f6793a     // Catch: java.lang.Throwable -> L96
            android.content.res.Configuration r1 = r1.getConfiguration()     // Catch: java.lang.Throwable -> L96
            r0.<init>(r4, r1, r8)     // Catch: java.lang.Throwable -> L96
            r3.append(r9, r0)     // Catch: java.lang.Throwable -> L96
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L96
            goto Lae
        La8:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L96
            throw r8
        Laa:
            android.content.res.ColorStateList r4 = r0.getColorStateList(r9, r8)
        Lae:
            return r4
        Laf:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L3c
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: a.AbstractC0228a.o(android.content.Context, int):android.content.res.ColorStateList");
    }

    public static float p(EdgeEffect edgeEffect) {
        if (Build.VERSION.SDK_INT >= 31) {
            return M.c.b(edgeEffect);
        }
        return 0.0f;
    }

    public static Drawable q(Context context, int i3) {
        return Q0.b().c(context, i3);
    }

    public static final Class s(kotlin.jvm.internal.e eVar) {
        Class a2 = eVar.a();
        j.c(a2, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        return a2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x001b. Please report as an issue. */
    public static final Class t(L2.c cVar) {
        j.e(cVar, "<this>");
        Class a2 = ((d) cVar).a();
        if (a2.isPrimitive()) {
            String name = a2.getName();
            switch (name.hashCode()) {
                case -1325958191:
                    if (name.equals("double")) {
                        return Double.class;
                    }
                    break;
                case 104431:
                    if (name.equals("int")) {
                        return Integer.class;
                    }
                    break;
                case 3039496:
                    if (name.equals("byte")) {
                        return Byte.class;
                    }
                    break;
                case 3052374:
                    if (name.equals("char")) {
                        return Character.class;
                    }
                    break;
                case 3327612:
                    if (name.equals("long")) {
                        return Long.class;
                    }
                    break;
                case 3625364:
                    if (name.equals("void")) {
                        return Void.class;
                    }
                    break;
                case 64711720:
                    if (name.equals("boolean")) {
                        return Boolean.class;
                    }
                    break;
                case 97526364:
                    if (name.equals("float")) {
                        return Float.class;
                    }
                    break;
                case 109413500:
                    if (name.equals("short")) {
                        return Short.class;
                    }
                    break;
            }
        }
        return a2;
    }

    public static final int u(int i3, int i4, int i5) {
        if (i5 > 0) {
            if (i3 < i4) {
                int i6 = i4 % i5;
                if (i6 < 0) {
                    i6 += i5;
                }
                int i7 = i3 % i5;
                if (i7 < 0) {
                    i7 += i5;
                }
                int i8 = (i6 - i7) % i5;
                if (i8 < 0) {
                    i8 += i5;
                }
                return i4 - i8;
            }
        } else if (i5 < 0) {
            if (i3 > i4) {
                int i9 = -i5;
                int i10 = i3 % i9;
                if (i10 < 0) {
                    i10 += i9;
                }
                int i11 = i4 % i9;
                if (i11 < 0) {
                    i11 += i9;
                }
                int i12 = (i10 - i11) % i9;
                if (i12 < 0) {
                    i12 += i9;
                }
                return i12 + i4;
            }
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
        return i4;
    }

    public static String v(String str) {
        if (Build.VERSION.SDK_INT < 26) {
            String concat = "TRuntime.".concat(str);
            if (concat.length() > 23) {
                return concat.substring(0, 23);
            }
            return concat;
        }
        return "TRuntime.".concat(str);
    }

    public static void w(Exception exc) {
        if (exc instanceof InvocationTargetException) {
            Throwable cause = exc.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new RuntimeException(cause);
        }
    }

    public static boolean x() {
        if (Build.VERSION.SDK_INT >= 29) {
            return AbstractC0599a.c();
        }
        try {
            if (f2737f == null) {
                f2736e = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                f2737f = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) f2737f.invoke(null, Long.valueOf(f2736e))).booleanValue();
        } catch (Exception e4) {
            w(e4);
            return false;
        }
    }

    public static float y(EdgeEffect edgeEffect, float f4, float f5) {
        if (Build.VERSION.SDK_INT >= 31) {
            return M.c.c(edgeEffect, f4, f5);
        }
        b.a(edgeEffect, f4, f5);
        return f4;
    }

    public static final boolean z(C0679d c0679d) {
        if (j.a(c0679d.f6332a, "processor")) {
            CharSequence charSequence = (CharSequence) c0679d.f6333b;
            for (int i3 = 0; i3 < charSequence.length(); i3++) {
                if (Character.isDigit(charSequence.charAt(i3))) {
                }
            }
            return true;
        }
        return false;
    }

    public abstract void E(byte[] bArr, int i3, int i4);

    public abstract String r();
}
