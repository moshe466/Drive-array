package n7;

import java.util.HashMap;
import java.util.Map;
import t7.b;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<t7.a, Class<? extends p7.a>> f12239a = new HashMap();

    static {
        for (t7.a aVar : t7.a.values()) {
            try {
                f12239a.put(aVar, ((b) aVar.getClass().getField(aVar.name()).getAnnotation(b.class)).type());
            } catch (NoSuchFieldException e10) {
                e10.printStackTrace();
            } catch (SecurityException e11) {
                e11.printStackTrace();
            }
        }
    }

    public static p7.a a(t7.a aVar) {
        return f12239a.get(aVar).newInstance();
    }
}
