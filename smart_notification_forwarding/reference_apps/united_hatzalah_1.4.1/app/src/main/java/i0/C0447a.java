package i0;

import android.content.res.AssetManager;
import android.os.Build;
import c.k;
import io.flutter.Build;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.concurrent.Executor;

/* renamed from: i0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0447a {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f4935a;

    /* renamed from: b, reason: collision with root package name */
    public final d f4936b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f4937c;

    /* renamed from: d, reason: collision with root package name */
    public final File f4938d;

    /* renamed from: e, reason: collision with root package name */
    public final String f4939e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f4940f = false;

    /* renamed from: g, reason: collision with root package name */
    public C0448b[] f4941g;

    /* renamed from: h, reason: collision with root package name */
    public byte[] f4942h;

    public C0447a(AssetManager assetManager, Executor executor, d dVar, String str, File file) {
        byte[] bArr;
        this.f4935a = executor;
        this.f4936b = dVar;
        this.f4939e = str;
        this.f4938d = file;
        int i = Build.VERSION.SDK_INT;
        if (i >= 31) {
            bArr = e.f4954d;
        } else {
            switch (i) {
                case 24:
                case Build.API_LEVELS.API_25 /* 25 */:
                    bArr = e.f4958h;
                    break;
                case Build.API_LEVELS.API_26 /* 26 */:
                    bArr = e.f4957g;
                    break;
                case Build.API_LEVELS.API_27 /* 27 */:
                    bArr = e.f4956f;
                    break;
                case Build.API_LEVELS.API_28 /* 28 */:
                case Build.API_LEVELS.API_29 /* 29 */:
                case Build.API_LEVELS.API_30 /* 30 */:
                    bArr = e.f4955e;
                    break;
                default:
                    bArr = null;
                    break;
            }
        }
        this.f4937c = bArr;
    }

    public final FileInputStream a(AssetManager assetManager, String str) {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e4) {
            String message = e4.getMessage();
            if (message != null) {
                message.contains("compressed");
                return null;
            }
            return null;
        }
    }

    public final void b(int i, Serializable serializable) {
        this.f4935a.execute(new k(this, i, 2, serializable));
    }
}
