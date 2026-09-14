package com.shockwave.pdfium;

import android.graphics.RectF;
import android.os.ParcelFileDescriptor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    long f8611a;

    /* renamed from: b, reason: collision with root package name */
    ParcelFileDescriptor f8612b;

    /* renamed from: c, reason: collision with root package name */
    final Map<Integer, Long> f8613c = new l.a();

    /* renamed from: com.shockwave.pdfium.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0138a {

        /* renamed from: a, reason: collision with root package name */
        private List<C0138a> f8614a = new ArrayList();

        public List<C0138a> a() {
            return this.f8614a;
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private RectF f8615a;

        /* renamed from: b, reason: collision with root package name */
        private Integer f8616b;

        /* renamed from: c, reason: collision with root package name */
        private String f8617c;

        public b(RectF rectF, Integer num, String str) {
            this.f8615a = rectF;
            this.f8616b = num;
            this.f8617c = str;
        }

        public RectF a() {
            return this.f8615a;
        }

        public Integer b() {
            return this.f8616b;
        }

        public String c() {
            return this.f8617c;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
    }
}
