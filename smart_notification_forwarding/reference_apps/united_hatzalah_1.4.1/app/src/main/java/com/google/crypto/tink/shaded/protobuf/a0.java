package com.google.crypto.tink.shaded.protobuf;

/* loaded from: classes.dex */
public final class a0 {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC0329a f4081a;

    /* renamed from: b, reason: collision with root package name */
    public final String f4082b;

    /* renamed from: c, reason: collision with root package name */
    public final Object[] f4083c;

    /* renamed from: d, reason: collision with root package name */
    public final int f4084d;

    public a0(AbstractC0329a abstractC0329a, String str, Object[] objArr) {
        this.f4081a = abstractC0329a;
        this.f4082b = str;
        this.f4083c = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.f4084d = charAt;
            return;
        }
        int i = charAt & 8191;
        int i3 = 13;
        int i4 = 1;
        while (true) {
            int i5 = i4 + 1;
            char charAt2 = str.charAt(i4);
            if (charAt2 >= 55296) {
                i |= (charAt2 & 8191) << i3;
                i3 += 13;
                i4 = i5;
            } else {
                this.f4084d = i | (charAt2 << i3);
                return;
            }
        }
    }
}
