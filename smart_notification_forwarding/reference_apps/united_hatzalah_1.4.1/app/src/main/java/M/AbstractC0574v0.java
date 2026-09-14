package m;

import android.widget.AbsListView;
import java.lang.reflect.Field;

/* renamed from: m.v0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0574v0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Field f5799a;

    static {
        Field field = null;
        try {
            field = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            field.setAccessible(true);
        } catch (NoSuchFieldException e4) {
            e4.printStackTrace();
        }
        f5799a = field;
    }
}
