package y0;

import com.andrognito.patternlockview.PatternLockView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    protected List<PatternLockView.f> f15831a;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(List<PatternLockView.f> list) {
        this.f15831a = list;
    }

    public List<PatternLockView.f> a() {
        return this.f15831a == null ? new ArrayList() : new ArrayList(this.f15831a);
    }
}
