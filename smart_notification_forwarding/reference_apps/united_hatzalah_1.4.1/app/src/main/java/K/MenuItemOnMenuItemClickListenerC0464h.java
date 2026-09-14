package k;

import android.view.MenuItem;
import java.lang.reflect.Method;

/* renamed from: k.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class MenuItemOnMenuItemClickListenerC0464h implements MenuItem.OnMenuItemClickListener {

    /* renamed from: c, reason: collision with root package name */
    public static final Class[] f5116c = {MenuItem.class};

    /* renamed from: a, reason: collision with root package name */
    public Object f5117a;

    /* renamed from: b, reason: collision with root package name */
    public Method f5118b;

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        Object obj = this.f5117a;
        Method method = this.f5118b;
        try {
            if (method.getReturnType() == Boolean.TYPE) {
                return ((Boolean) method.invoke(obj, menuItem)).booleanValue();
            }
            method.invoke(obj, menuItem);
            return true;
        } catch (Exception e4) {
            throw new RuntimeException(e4);
        }
    }
}
