package A;

import F0.C0018c1;
import F0.G1;
import F0.RunnableC0064o;
import F0.RunnableC0091v;
import a.AbstractC0228a;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.text.PositionedGlyphs;
import android.graphics.text.TextRunShaper;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Trace;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.apache.tika.utils.StringUtils;
import r.RunnableC0628c;
import t.C0693i;
import t.C0694j;

/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static final E1.b f7a;

    /* renamed from: b, reason: collision with root package name */
    public static final C0693i f8b;

    /* renamed from: c, reason: collision with root package name */
    public static Paint f9c;

    static {
        Trace.beginSection(AbstractC0228a.D("TypefaceCompat static init"));
        int i = Build.VERSION.SDK_INT;
        if (i >= 31) {
            f7a = new E1.b();
        } else if (i >= 29) {
            f7a = new E1.b();
        } else if (i >= 28) {
            f7a = new j();
        } else if (i >= 26) {
            f7a = new j();
        } else if (i.f17d != null) {
            f7a = new E1.b();
        } else {
            f7a = new E1.b();
        }
        f8b = new C0693i(16);
        f9c = null;
        Trace.endSection();
    }

    public static Typeface a(Context context, z.d dVar, Resources resources, int i, String str, int i3, int i4, T0.a aVar) {
        Typeface e4;
        Typeface build;
        Font.Builder fontVariationSettings;
        Font build2;
        FontFamily build3;
        boolean z3;
        Typeface typeface;
        Handler handler;
        int i5 = 20;
        if (dVar instanceof z.g) {
            z.g gVar = (z.g) dVar;
            String str2 = gVar.f6789d;
            e4 = null;
            int i6 = 1;
            int i7 = 0;
            if (TextUtils.isEmpty(str2) || (build = c(str2)) == null) {
                ArrayList arrayList = gVar.f6786a;
                if (arrayList.size() == 1) {
                    build = c(((G.d) arrayList.get(0)).f775e);
                } else {
                    if (Build.VERSION.SDK_INT >= 31) {
                        int i8 = 0;
                        while (true) {
                            if (i8 < arrayList.size()) {
                                if (c(((G.d) arrayList.get(i8)).f775e) == null) {
                                    break;
                                }
                                i8++;
                            } else {
                                int i9 = 0;
                                Typeface.CustomFallbackBuilder customFallbackBuilder = null;
                                while (true) {
                                    if (i9 >= arrayList.size()) {
                                        break;
                                    }
                                    G.d dVar2 = (G.d) arrayList.get(i9);
                                    if (i9 == arrayList.size() - 1 && TextUtils.isEmpty(dVar2.f776f)) {
                                        customFallbackBuilder.setSystemFallback(dVar2.f775e);
                                        break;
                                    }
                                    String str3 = dVar2.f775e;
                                    String str4 = dVar2.f776f;
                                    Font d2 = d(c(str3));
                                    if (d2 == null) {
                                        break;
                                    }
                                    if (!TextUtils.isEmpty(str4)) {
                                        build3 = e.g(d2).build();
                                    } else {
                                        try {
                                            e.o();
                                            e.y();
                                            fontVariationSettings = f.g(d2).setFontVariationSettings(str4);
                                            build2 = fontVariationSettings.build();
                                            build3 = e.g(build2).build();
                                        } catch (IOException unused) {
                                            Log.e("TypefaceCompat", "Failed to clone Font instance. Fall back to provider font.");
                                        }
                                    }
                                    if (customFallbackBuilder != null) {
                                        customFallbackBuilder.addCustomFallback(build3);
                                    } else {
                                        customFallbackBuilder = e.c(build3);
                                    }
                                    i9++;
                                }
                                build = customFallbackBuilder.build();
                            }
                        }
                    }
                    build = null;
                }
            }
            if (build != null) {
                new Handler(Looper.getMainLooper()).post(new RunnableC0064o(i5, aVar, build));
                f8b.put(b(resources, i, str, i3, i4), build);
                return build;
            }
            if (gVar.f6788c == 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            int i10 = gVar.f6787b;
            Handler handler2 = new Handler(Looper.getMainLooper());
            G1 g12 = new G1(i6);
            g12.f218b = aVar;
            ArrayList arrayList2 = gVar.f6786a;
            F.d dVar3 = new F.d(handler2, 1);
            C0018c1 c0018c1 = new C0018c1(g12, dVar3);
            if (z3) {
                if (arrayList2.size() <= 1) {
                    G.d dVar4 = (G.d) arrayList2.get(0);
                    C0693i c0693i = G.h.f787a;
                    ArrayList arrayList3 = new ArrayList(1);
                    Object obj = new Object[]{dVar4}[0];
                    Objects.requireNonNull(obj);
                    arrayList3.add(obj);
                    String a2 = G.h.a(i4, Collections.unmodifiableList(arrayList3));
                    typeface = (Typeface) G.h.f787a.get(a2);
                    if (typeface != null) {
                        dVar3.execute(new RunnableC0091v(i6, g12, typeface));
                    } else if (i10 == -1) {
                        ArrayList arrayList4 = new ArrayList(1);
                        Object obj2 = new Object[]{dVar4}[0];
                        Objects.requireNonNull(obj2);
                        arrayList4.add(obj2);
                        G.g b4 = G.h.b(a2, context, Collections.unmodifiableList(arrayList4), i4);
                        c0018c1.i(b4);
                        e4 = b4.f785a;
                    } else {
                        try {
                            try {
                                try {
                                    try {
                                        G.g gVar2 = (G.g) G.h.f788b.submit(new G.e(a2, context, dVar4, i4, 0)).get(i10, TimeUnit.MILLISECONDS);
                                        c0018c1.i(gVar2);
                                        e4 = gVar2.f785a;
                                    } catch (TimeoutException unused2) {
                                        throw new InterruptedException("timeout");
                                    }
                                } catch (ExecutionException e5) {
                                    throw new RuntimeException(e5);
                                }
                            } catch (InterruptedException e6) {
                                throw e6;
                            }
                        } catch (InterruptedException unused3) {
                            ((F.d) c0018c1.f477b).execute(new G.a((G1) c0018c1.f476a, -3));
                        }
                    }
                } else {
                    throw new IllegalArgumentException("Fallbacks with blocking fetches are not supported for performance reasons");
                }
            } else {
                String a4 = G.h.a(i4, arrayList2);
                typeface = (Typeface) G.h.f787a.get(a4);
                if (typeface != null) {
                    dVar3.execute(new RunnableC0091v(i6, g12, typeface));
                } else {
                    G.f fVar = new G.f(c0018c1, i7);
                    synchronized (G.h.f789c) {
                        try {
                            C0694j c0694j = G.h.f790d;
                            ArrayList arrayList5 = (ArrayList) c0694j.get(a4);
                            if (arrayList5 != null) {
                                arrayList5.add(fVar);
                            } else {
                                ArrayList arrayList6 = new ArrayList();
                                arrayList6.add(fVar);
                                c0694j.put(a4, arrayList6);
                                G.e eVar = new G.e(a4, context, arrayList2, i4, 1);
                                ThreadPoolExecutor threadPoolExecutor = G.h.f788b;
                                G.f fVar2 = new G.f(a4, i6);
                                if (Looper.myLooper() == null) {
                                    handler = new Handler(Looper.getMainLooper());
                                } else {
                                    handler = new Handler();
                                }
                                RunnableC0628c runnableC0628c = new RunnableC0628c();
                                runnableC0628c.f6162b = eVar;
                                runnableC0628c.f6163c = fVar2;
                                runnableC0628c.f6164d = handler;
                                threadPoolExecutor.execute(runnableC0628c);
                            }
                        } finally {
                        }
                    }
                }
            }
            e4 = typeface;
        } else {
            e4 = f7a.e(context, (z.e) dVar, resources, i4);
            if (e4 != null) {
                new Handler(Looper.getMainLooper()).post(new RunnableC0064o(i5, aVar, e4));
            } else {
                aVar.a();
            }
        }
        if (e4 != null) {
            f8b.put(b(resources, i, str, i3, i4), e4);
        }
        return e4;
    }

    public static String b(Resources resources, int i, String str, int i3, int i4) {
        return resources.getResourcePackageName(i) + '-' + str + '-' + i3 + '-' + i + '-' + i4;
    }

    public static Typeface c(String str) {
        if (str != null && !str.isEmpty()) {
            Typeface create = Typeface.create(str, 0);
            Typeface create2 = Typeface.create(Typeface.DEFAULT, 0);
            if (create != null && !create.equals(create2)) {
                return create;
            }
        }
        return null;
    }

    public static Font d(Typeface typeface) {
        PositionedGlyphs shapeTextRun;
        int glyphCount;
        Font font;
        if (f9c == null) {
            f9c = new Paint();
        }
        f9c.setTextSize(10.0f);
        f9c.setTypeface(typeface);
        shapeTextRun = TextRunShaper.shapeTextRun((CharSequence) StringUtils.SPACE, 0, 1, 0, 1, 0.0f, 0.0f, false, f9c);
        glyphCount = shapeTextRun.glyphCount();
        if (glyphCount != 0) {
            font = shapeTextRun.getFont(0);
            return font;
        }
        return null;
    }
}
