package qb;

import android.hardware.Camera;
import java.util.Objects;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public final Camera f13619a;

    /* renamed from: b, reason: collision with root package name */
    public final int f13620b;

    private e(Camera camera, int i10) {
        Objects.requireNonNull(camera, "Camera cannot be null");
        this.f13619a = camera;
        this.f13620b = i10;
    }

    public static e a(Camera camera, int i10) {
        if (camera == null) {
            return null;
        }
        return new e(camera, i10);
    }
}
