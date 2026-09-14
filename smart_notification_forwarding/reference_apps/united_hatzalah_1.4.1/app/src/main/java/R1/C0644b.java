package r1;

import A.n;
import android.content.Context;
import android.net.ConnectivityManager;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.net.MalformedURLException;
import java.net.URL;
import s1.C0672l;
import u1.g;

/* renamed from: r1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0644b implements g {

    /* renamed from: b, reason: collision with root package name */
    public final ConnectivityManager f6211b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f6212c;

    /* renamed from: e, reason: collision with root package name */
    public final n f6214e;

    /* renamed from: f, reason: collision with root package name */
    public final n f6215f;

    /* renamed from: a, reason: collision with root package name */
    public final DataEncoder f6210a = new JsonDataEncoderBuilder().configureWith(C0672l.f6292a).ignoreNullValues(true).build();

    /* renamed from: d, reason: collision with root package name */
    public final URL f6213d = b(C0643a.f6204c);

    /* renamed from: g, reason: collision with root package name */
    public final int f6216g = 130000;

    public C0644b(Context context, n nVar, n nVar2) {
        this.f6212c = context;
        this.f6211b = (ConnectivityManager) context.getSystemService("connectivity");
        this.f6214e = nVar2;
        this.f6215f = nVar;
    }

    public static URL b(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e4) {
            throw new IllegalArgumentException(e0.a.d("Invalid url: ", str), e4);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a1, code lost:
    
        if (((s1.EnumC0657H) s1.EnumC0657H.f6239a.get(r0)) != null) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0107  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final t1.j a(t1.j r7) {
        /*
            Method dump skipped, instructions count: 287
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r1.C0644b.a(t1.j):t1.j");
    }
}
