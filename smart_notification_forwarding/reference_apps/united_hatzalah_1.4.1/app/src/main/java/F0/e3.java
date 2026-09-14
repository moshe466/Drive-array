package F0;

import a.AbstractC0228a;
import java.util.Comparator;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class e3 implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        Pattern pattern = f3.f513c;
        return AbstractC0228a.d(Double.valueOf(c3.a((W2) obj2)), Double.valueOf(c3.a((W2) obj)));
    }
}
