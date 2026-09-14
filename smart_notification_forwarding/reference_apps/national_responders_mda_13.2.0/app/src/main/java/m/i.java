package m;

import java.util.Arrays;

/* loaded from: classes.dex */
public class i implements Comparable<i> {

    /* renamed from: v, reason: collision with root package name */
    private static int f11962v = 1;

    /* renamed from: f, reason: collision with root package name */
    public boolean f11963f;

    /* renamed from: g, reason: collision with root package name */
    private String f11964g;

    /* renamed from: k, reason: collision with root package name */
    public float f11968k;

    /* renamed from: o, reason: collision with root package name */
    a f11972o;

    /* renamed from: h, reason: collision with root package name */
    public int f11965h = -1;

    /* renamed from: i, reason: collision with root package name */
    int f11966i = -1;

    /* renamed from: j, reason: collision with root package name */
    public int f11967j = 0;

    /* renamed from: l, reason: collision with root package name */
    public boolean f11969l = false;

    /* renamed from: m, reason: collision with root package name */
    float[] f11970m = new float[9];

    /* renamed from: n, reason: collision with root package name */
    float[] f11971n = new float[9];

    /* renamed from: p, reason: collision with root package name */
    b[] f11973p = new b[16];

    /* renamed from: q, reason: collision with root package name */
    int f11974q = 0;

    /* renamed from: r, reason: collision with root package name */
    public int f11975r = 0;

    /* renamed from: s, reason: collision with root package name */
    boolean f11976s = false;

    /* renamed from: t, reason: collision with root package name */
    int f11977t = -1;

    /* renamed from: u, reason: collision with root package name */
    float f11978u = 0.0f;

    /* loaded from: classes.dex */
    public enum a {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public i(a aVar, String str) {
        this.f11972o = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void l() {
        f11962v++;
    }

    public final void j(b bVar) {
        int i10 = 0;
        while (true) {
            int i11 = this.f11974q;
            if (i10 >= i11) {
                b[] bVarArr = this.f11973p;
                if (i11 >= bVarArr.length) {
                    this.f11973p = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
                }
                b[] bVarArr2 = this.f11973p;
                int i12 = this.f11974q;
                bVarArr2[i12] = bVar;
                this.f11974q = i12 + 1;
                return;
            }
            if (this.f11973p[i10] == bVar) {
                return;
            } else {
                i10++;
            }
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public int compareTo(i iVar) {
        return this.f11965h - iVar.f11965h;
    }

    public final void n(b bVar) {
        int i10 = this.f11974q;
        int i11 = 0;
        while (i11 < i10) {
            if (this.f11973p[i11] == bVar) {
                while (i11 < i10 - 1) {
                    b[] bVarArr = this.f11973p;
                    int i12 = i11 + 1;
                    bVarArr[i11] = bVarArr[i12];
                    i11 = i12;
                }
                this.f11974q--;
                return;
            }
            i11++;
        }
    }

    public void o() {
        this.f11964g = null;
        this.f11972o = a.UNKNOWN;
        this.f11967j = 0;
        this.f11965h = -1;
        this.f11966i = -1;
        this.f11968k = 0.0f;
        this.f11969l = false;
        this.f11976s = false;
        this.f11977t = -1;
        this.f11978u = 0.0f;
        int i10 = this.f11974q;
        for (int i11 = 0; i11 < i10; i11++) {
            this.f11973p[i11] = null;
        }
        this.f11974q = 0;
        this.f11975r = 0;
        this.f11963f = false;
        Arrays.fill(this.f11971n, 0.0f);
    }

    public void r(d dVar, float f10) {
        this.f11968k = f10;
        this.f11969l = true;
        this.f11976s = false;
        this.f11977t = -1;
        this.f11978u = 0.0f;
        int i10 = this.f11974q;
        this.f11966i = -1;
        for (int i11 = 0; i11 < i10; i11++) {
            this.f11973p[i11].A(dVar, this, false);
        }
        this.f11974q = 0;
    }

    public void s(a aVar, String str) {
        this.f11972o = aVar;
    }

    public final void t(d dVar, b bVar) {
        int i10 = this.f11974q;
        for (int i11 = 0; i11 < i10; i11++) {
            this.f11973p[i11].B(dVar, bVar, false);
        }
        this.f11974q = 0;
    }

    public String toString() {
        StringBuilder sb2;
        if (this.f11964g != null) {
            sb2 = new StringBuilder();
            sb2.append("");
            sb2.append(this.f11964g);
        } else {
            sb2 = new StringBuilder();
            sb2.append("");
            sb2.append(this.f11965h);
        }
        return sb2.toString();
    }
}
