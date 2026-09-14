package u0;

import android.os.Build;
import java.util.HashSet;

/* renamed from: u0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0725c implements n {

    /* renamed from: c, reason: collision with root package name */
    public static final HashSet f6559c = new HashSet();

    /* renamed from: a, reason: collision with root package name */
    public final String f6560a;

    /* renamed from: b, reason: collision with root package name */
    public final String f6561b;

    public AbstractC0725c(String str, String str2) {
        this.f6560a = str;
        this.f6561b = str2;
        f6559c.add(this);
    }

    public abstract boolean a();

    public boolean b() {
        HashSet hashSet = AbstractC0723a.f6557a;
        String str = this.f6561b;
        if (!hashSet.contains(str)) {
            String str2 = Build.TYPE;
            if ((!"eng".equals(str2) && !"userdebug".equals(str2)) || !hashSet.contains(str.concat(":dev"))) {
                return false;
            }
            return true;
        }
        return true;
    }
}
