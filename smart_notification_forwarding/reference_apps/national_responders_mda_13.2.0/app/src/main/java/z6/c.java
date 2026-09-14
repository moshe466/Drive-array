package z6;

import com.opentok.otc.opentokJNI;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: b, reason: collision with root package name */
    public static final c f16243b = new c("OTC_PUBLISHER_VIDEO_TYPE_CAMERA", opentokJNI.OTC_PUBLISHER_VIDEO_TYPE_CAMERA_get());

    /* renamed from: c, reason: collision with root package name */
    public static final c f16244c = new c("OTC_PUBLISHER_VIDEO_TYPE_SCREEN", opentokJNI.OTC_PUBLISHER_VIDEO_TYPE_SCREEN_get());

    /* renamed from: a, reason: collision with root package name */
    private final String f16245a;

    private c(String str, int i10) {
        this.f16245a = str;
    }

    public String toString() {
        return this.f16245a;
    }
}
