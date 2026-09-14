package z6;

import com.opentok.otc.opentokJNI;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name */
    public static final b f16237c;

    /* renamed from: d, reason: collision with root package name */
    public static final b f16238d;

    /* renamed from: e, reason: collision with root package name */
    public static final b f16239e;

    /* renamed from: f, reason: collision with root package name */
    private static b[] f16240f;

    /* renamed from: a, reason: collision with root package name */
    private final int f16241a;

    /* renamed from: b, reason: collision with root package name */
    private final String f16242b;

    static {
        b bVar = new b("otc_external_video", opentokJNI.otc_external_video_get());
        f16237c = bVar;
        b bVar2 = new b("otc_external_audio", opentokJNI.otc_external_audio_get());
        f16238d = bVar2;
        b bVar3 = new b("otc_internal_video", opentokJNI.otc_internal_video_get());
        f16239e = bVar3;
        f16240f = new b[]{bVar, bVar2, bVar3, new b("otc_internal_audio", opentokJNI.otc_internal_audio_get())};
    }

    private b(String str, int i10) {
        this.f16242b = str;
        this.f16241a = i10;
    }

    public static b b(int i10) {
        b[] bVarArr = f16240f;
        if (i10 < bVarArr.length && i10 >= 0 && bVarArr[i10].f16241a == i10) {
            return bVarArr[i10];
        }
        int i11 = 0;
        while (true) {
            b[] bVarArr2 = f16240f;
            if (i11 >= bVarArr2.length) {
                throw new IllegalArgumentException("No enum " + b.class + " with value " + i10);
            }
            if (bVarArr2[i11].f16241a == i10) {
                return bVarArr2[i11];
            }
            i11++;
        }
    }

    public final int a() {
        return this.f16241a;
    }

    public String toString() {
        return this.f16242b;
    }
}
