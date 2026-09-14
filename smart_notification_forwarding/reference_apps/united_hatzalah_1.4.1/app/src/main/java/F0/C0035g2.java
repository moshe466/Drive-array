package F0;

import J.InterfaceC0117e;
import P2.C0163m;
import a.AbstractC0228a;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContentInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import androidx.profileinstaller.ProfileInstallReceiver;
import com.android.apksig.internal.pkcs7.Attribute;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.lang.reflect.Proxy;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IllegalFormatException;
import java.util.List;
import java.util.Locale;
import l.C0508f;
import l.SubMenuC0502F;
import l.ViewOnKeyListenerC0509g;
import m.C0548i;
import m.InterfaceC0554l;
import org.apache.tika.fork.ForkServer;
import w0.C0747c;
import w0.C0748d;

/* renamed from: F0.g2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0035g2 implements InterfaceC0117e, X1.h, OnCompleteListener, l.y, l.k, i0.d, k0.M, m.J0, InterfaceC0554l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f525a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f526b;

    public /* synthetic */ C0035g2(Object obj, int i) {
        this.f525a = i;
        this.f526b = obj;
    }

    public static String z(String str, String str2, Object... objArr) {
        if (objArr.length > 0) {
            try {
                str2 = String.format(Locale.US, str2, objArr);
            } catch (IllegalFormatException e4) {
                Log.e("PlayCore", "Unable to format ".concat(str2), e4);
                str2 = str2 + " [" + TextUtils.join(", ", objArr) + "]";
            }
        }
        return AbstractC0008a.o(str, " : ", str2);
    }

    @Override // J.InterfaceC0117e
    public ClipData a() {
        ClipData clip;
        clip = ((ContentInfo) this.f526b).getClip();
        return clip;
    }

    @Override // l.y
    public void b(l.m mVar, boolean z3) {
        switch (this.f525a) {
            case 13:
                ((h.y) this.f526b).r(mVar);
                return;
            default:
                if (mVar instanceof SubMenuC0502F) {
                    ((SubMenuC0502F) mVar).f5337A.k().c(false);
                }
                l.y yVar = ((C0548i) this.f526b).f5672e;
                if (yVar != null) {
                    yVar.b(mVar, z3);
                    return;
                }
                return;
        }
    }

    @Override // k0.M
    public int c(View view) {
        return (view.getLeft() - ((k0.u) view.getLayoutParams()).f5275a.left) - ((ViewGroup.MarginLayoutParams) ((k0.u) view.getLayoutParams())).leftMargin;
    }

    @Override // l.y
    public boolean d(l.m mVar) {
        switch (this.f525a) {
            case 13:
                Window.Callback callback = ((h.y) this.f526b).f4913o.getCallback();
                if (callback != null) {
                    callback.onMenuOpened(108, mVar);
                    return true;
                }
                return true;
            default:
                C0548i c0548i = (C0548i) this.f526b;
                if (mVar == c0548i.f5670c) {
                    return false;
                }
                ((SubMenuC0502F) mVar).f5338B.getClass();
                c0548i.getClass();
                l.y yVar = c0548i.f5672e;
                if (yVar == null) {
                    return false;
                }
                return yVar.d(mVar);
        }
    }

    @Override // m.J0
    public void e(l.m mVar, MenuItem menuItem) {
        ((ViewOnKeyListenerC0509g) this.f526b).f5369f.removeCallbacksAndMessages(mVar);
    }

    @Override // l.k
    public void f(l.m mVar) {
        h.I i = (h.I) this.f526b;
        Window.Callback callback = i.f4735b;
        if (i.f4734a.f5772a.o()) {
            callback.onPanelClosed(108, mVar);
        } else if (callback.onPreparePanel(0, null, mVar)) {
            callback.onMenuOpened(108, mVar);
        }
    }

    @Override // i0.d
    public void g(int i, Object obj) {
        String str;
        switch (i) {
            case 1:
                str = "RESULT_INSTALL_SUCCESS";
                break;
            case 2:
                str = "RESULT_ALREADY_INSTALLED";
                break;
            case 3:
                str = "RESULT_UNSUPPORTED_ART_VERSION";
                break;
            case 4:
                str = "RESULT_NOT_WRITABLE";
                break;
            case 5:
                str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                break;
            case 6:
                str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                break;
            case 7:
                str = "RESULT_IO_EXCEPTION";
                break;
            case 8:
                str = "RESULT_PARSE_EXCEPTION";
                break;
            case 9:
            default:
                str = "";
                break;
            case 10:
                str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                break;
            case 11:
                str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                break;
        }
        if (i == 6 || i == 7 || i == 8) {
            Log.e("ProfileInstaller", str, (Throwable) obj);
        }
        ((ProfileInstallReceiver) this.f526b).setResultCode(i);
    }

    @Override // J.InterfaceC0117e
    public int getSource() {
        int source;
        source = ((ContentInfo) this.f526b).getSource();
        return source;
    }

    @Override // k0.M
    public int h() {
        return ((k0.t) this.f526b).s();
    }

    @Override // l.k
    public boolean i(l.m mVar, MenuItem menuItem) {
        return false;
    }

    @Override // k0.M
    public int j() {
        k0.t tVar = (k0.t) this.f526b;
        return tVar.f5273f - tVar.t();
    }

    @Override // X1.h
    public Object k(String str) {
        return ((A.n) this.f526b).b(str, null);
    }

    @Override // J.InterfaceC0117e
    public int l() {
        int flags;
        flags = ((ContentInfo) this.f526b).getFlags();
        return flags;
    }

    @Override // m.J0
    public void m(l.m mVar, l.o oVar) {
        ViewOnKeyListenerC0509g viewOnKeyListenerC0509g = (ViewOnKeyListenerC0509g) this.f526b;
        Handler handler = viewOnKeyListenerC0509g.f5369f;
        C0508f c0508f = null;
        handler.removeCallbacksAndMessages(null);
        ArrayList arrayList = viewOnKeyListenerC0509g.f5371k;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i < size) {
                if (mVar == ((C0508f) arrayList.get(i)).f5360b) {
                    break;
                } else {
                    i++;
                }
            } else {
                i = -1;
                break;
            }
        }
        if (i == -1) {
            return;
        }
        int i3 = i + 1;
        if (i3 < arrayList.size()) {
            c0508f = (C0508f) arrayList.get(i3);
        }
        handler.postAtTime(new N0.f(this, c0508f, oVar, mVar), mVar, SystemClock.uptimeMillis() + 200);
    }

    @Override // J.InterfaceC0117e
    public ContentInfo n() {
        return (ContentInfo) this.f526b;
    }

    @Override // k0.M
    public View o(int i) {
        return ((k0.t) this.f526b).o(i);
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(Task task) {
        C0163m c0163m = (C0163m) this.f526b;
        Exception exception = task.getException();
        if (exception == null) {
            if (task.isCanceled()) {
                c0163m.m(null);
                return;
            } else {
                c0163m.resumeWith(task.getResult());
                return;
            }
        }
        c0163m.resumeWith(AbstractC0228a.g(exception));
    }

    @Override // k0.M
    public int p(View view) {
        return view.getRight() + ((k0.u) view.getLayoutParams()).f5275a.right + ((ViewGroup.MarginLayoutParams) ((k0.u) view.getLayoutParams())).rightMargin;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x0784, code lost:
    
        if (r6 != 0) goto L35;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0573. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String[] q() {
        /*
            Method dump skipped, instructions count: 1974
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: F0.C0035g2.q():java.lang.String[]");
    }

    public C0748d r(Object obj, kotlin.jvm.internal.e eVar, Activity activity, B0.b bVar) {
        Object newProxyInstance = Proxy.newProxyInstance((ClassLoader) this.f526b, new Class[]{v()}, new C0747c(eVar, bVar));
        kotlin.jvm.internal.j.d(newProxyInstance, "newProxyInstance(loader,…onsumerClass()), handler)");
        obj.getClass().getMethod("addWindowLayoutInfoListener", Activity.class, v()).invoke(obj, activity, newProxyInstance);
        return new C0748d(obj.getClass().getMethod("removeWindowLayoutInfoListener", v()), obj, newProxyInstance);
    }

    public S0.g s(String str) {
        List list = (List) ((HashMap) this.f526b).get(str);
        if (list != null && !list.isEmpty()) {
            if (list.size() <= 1) {
                return (S0.g) list.get(0);
            }
            throw new Exception(e0.a.e("Attribute ", str, " has multiple values"));
        }
        return null;
    }

    public T0.a t() {
        boolean z3;
        int i;
        int i3;
        int i4;
        ByteBuffer byteBuffer = (ByteBuffer) this.f526b;
        int position = byteBuffer.position();
        if (!byteBuffer.hasRemaining()) {
            return null;
        }
        byte b4 = byteBuffer.get();
        int i5 = b4 & 31;
        if (i5 == 31) {
            i5 = 0;
            while (byteBuffer.hasRemaining()) {
                byte b5 = byteBuffer.get();
                if (i5 <= 16777215) {
                    i5 = (i5 << 7) | (b5 & Byte.MAX_VALUE);
                    if ((b5 & 128) == 0) {
                    }
                } else {
                    throw new Exception("Tag number too large");
                }
            }
            throw new Exception("Truncated tag number");
        }
        if ((b4 & 32) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (byteBuffer.hasRemaining()) {
            byte b6 = byteBuffer.get();
            int i6 = b6 & ForkServer.ERROR;
            if ((b6 & 128) == 0) {
                i4 = b6 & Byte.MAX_VALUE;
                i3 = byteBuffer.position() - position;
                u(i4);
            } else {
                if (i6 != 128) {
                    int i7 = b6 & Byte.MAX_VALUE;
                    if (i7 <= 4) {
                        i = 0;
                        for (int i8 = 0; i8 < i7; i8++) {
                            if (byteBuffer.hasRemaining()) {
                                byte b7 = byteBuffer.get();
                                if (i <= 8388607) {
                                    i = (i << 8) | (b7 & ForkServer.ERROR);
                                } else {
                                    throw new Exception("Length too large");
                                }
                            } else {
                                throw new Exception("Truncated length");
                            }
                        }
                        i3 = byteBuffer.position() - position;
                        u(i);
                    } else {
                        throw new Exception(AbstractC0008a.j(i7, "Length too large: ", " bytes"));
                    }
                } else {
                    int position2 = byteBuffer.position() - position;
                    if (z3) {
                        int position3 = byteBuffer.position();
                        while (byteBuffer.hasRemaining()) {
                            if (byteBuffer.remaining() > 1 && byteBuffer.getShort(byteBuffer.position()) == 0) {
                                i = byteBuffer.position() - position3;
                                byteBuffer.position(byteBuffer.position() + 2);
                            } else {
                                t();
                            }
                        }
                        throw new Exception("Truncated indefinite-length contents: " + (byteBuffer.position() - position3) + " bytes read");
                    }
                    int i9 = 0;
                    boolean z4 = false;
                    while (byteBuffer.hasRemaining()) {
                        byte b8 = byteBuffer.get();
                        int i10 = i9 + 1;
                        if (i10 >= 0) {
                            if (b8 == 0) {
                                if (z4) {
                                    i = i9 - 1;
                                } else {
                                    z4 = true;
                                }
                            } else {
                                z4 = false;
                            }
                            i9 = i10;
                        } else {
                            throw new Exception("Indefinite-length contents too long");
                        }
                    }
                    throw new Exception(AbstractC0008a.j(i9, "Truncated indefinite-length contents: ", " bytes read"));
                    i3 = position2;
                }
                i4 = i;
            }
            int position4 = byteBuffer.position();
            byteBuffer.position(position);
            int limit = byteBuffer.limit();
            byteBuffer.limit(position4);
            ByteBuffer slice = byteBuffer.slice();
            byteBuffer.position(byteBuffer.limit());
            byteBuffer.limit(limit);
            slice.position(i3);
            slice.limit(i3 + i4);
            ByteBuffer slice2 = slice.slice();
            slice.clear();
            return new T0.a(slice, slice2, (b4 & ForkServer.ERROR) >> 6, i5);
        }
        throw new Exception("Missing length");
    }

    public String toString() {
        switch (this.f525a) {
            case 3:
                return "ContentInfoCompat{" + ((ContentInfo) this.f526b) + "}";
            default:
                return super.toString();
        }
    }

    public void u(int i) {
        ByteBuffer byteBuffer = (ByteBuffer) this.f526b;
        if (byteBuffer.remaining() >= i) {
            byteBuffer.position(byteBuffer.position() + i);
        } else {
            StringBuilder w3 = AbstractC0008a.w(i, "Truncated contents. Need: ", " bytes, available: ");
            w3.append(byteBuffer.remaining());
            throw new Exception(w3.toString());
        }
    }

    public Class v() {
        Class<?> loadClass = ((ClassLoader) this.f526b).loadClass("java.util.function.Consumer");
        kotlin.jvm.internal.j.d(loadClass, "loader.loadClass(\"java.util.function.Consumer\")");
        return loadClass;
    }

    public void w(String str, Object... objArr) {
        if (Log.isLoggable("PlayCore", 3)) {
            z((String) this.f526b, str, objArr);
        }
    }

    public void x(RemoteException remoteException, String str, Object... objArr) {
        if (Log.isLoggable("PlayCore", 6)) {
            Log.e("PlayCore", z((String) this.f526b, str, objArr), remoteException);
        }
    }

    public void y(String str, Object... objArr) {
        if (Log.isLoggable("PlayCore", 4)) {
            z((String) this.f526b, str, objArr);
        }
    }

    public C0035g2(String str) {
        this.f525a = 2;
        this.f526b = ("UID: [" + Process.myUid() + "]  PID: [" + Process.myPid() + "] ").concat(str);
    }

    public C0035g2(ByteBuffer byteBuffer) {
        this.f525a = 6;
        if (byteBuffer != null) {
            this.f526b = byteBuffer;
            return;
        }
        throw new NullPointerException("buf == null");
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [F0.d0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.text.Editable$Factory, X.a] */
    public C0035g2(EditText editText) {
        this.f525a = 7;
        ?? obj = new Object();
        obj.f479a = editText;
        X.i iVar = new X.i(editText);
        obj.f480b = iVar;
        editText.addTextChangedListener(iVar);
        if (X.a.f2555b == null) {
            synchronized (X.a.f2554a) {
                try {
                    if (X.a.f2555b == null) {
                        ?? factory = new Editable.Factory();
                        try {
                            X.a.f2556c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, X.a.class.getClassLoader());
                        } catch (Throwable unused) {
                        }
                        X.a.f2555b = factory;
                    }
                } finally {
                }
            }
        }
        editText.setEditableFactory(X.a.f2555b);
        this.f526b = obj;
    }

    public C0035g2(Uri uri, ClipDescription clipDescription, Uri uri2) {
        this.f525a = 4;
        if (Build.VERSION.SDK_INT >= 25) {
            this.f526b = new L.g(uri, clipDescription, uri2);
        } else {
            this.f526b = new b3(uri, clipDescription, uri2, 3);
        }
    }

    public C0035g2(ContentInfo contentInfo) {
        this.f525a = 3;
        contentInfo.getClass();
        this.f526b = A.f.p(contentInfo);
    }

    public C0035g2(ArrayList arrayList) {
        this.f525a = 5;
        HashMap hashMap = new HashMap(arrayList.size());
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            Attribute attribute = (Attribute) obj;
            if (hashMap.put(attribute.attrType, attribute.attrValues) != null) {
                throw new Exception("Duplicate signed attribute: " + attribute.attrType);
            }
        }
        this.f526b = hashMap;
    }
}
