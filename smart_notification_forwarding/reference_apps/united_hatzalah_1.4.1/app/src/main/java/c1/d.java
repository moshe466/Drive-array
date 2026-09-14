package c1;

import android.media.MediaCodecList;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.k;

/* loaded from: classes.dex */
public final class d extends k implements F2.a {

    /* renamed from: b, reason: collision with root package name */
    public static final d f3874b;

    /* renamed from: c, reason: collision with root package name */
    public static final d f3875c;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3876a;

    static {
        int i = 0;
        f3874b = new d(i, 0);
        f3875c = new d(i, 1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(int i, int i3) {
        super(i);
        this.f3876a = i3;
    }

    @Override // F2.a
    public final Object invoke() {
        switch (this.f3876a) {
            case 0:
                return new MediaCodecList(1);
            default:
                File rootDirectory = Environment.getRootDirectory();
                j.b(rootDirectory);
                String absolutePath = rootDirectory.getAbsolutePath();
                j.b(absolutePath);
                return new StatFs(absolutePath);
        }
    }
}
