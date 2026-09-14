package h;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: h.A, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ViewOnClickListenerC0429A implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final View f4715a;

    /* renamed from: b, reason: collision with root package name */
    public final String f4716b;

    /* renamed from: c, reason: collision with root package name */
    public Method f4717c;

    /* renamed from: d, reason: collision with root package name */
    public Context f4718d;

    public ViewOnClickListenerC0429A(View view, String str) {
        this.f4715a = view;
        this.f4716b = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str;
        Method method;
        if (this.f4717c == null) {
            View view2 = this.f4715a;
            Context context = view2.getContext();
            while (true) {
                String str2 = this.f4716b;
                if (context != null) {
                    try {
                        if (!context.isRestricted() && (method = context.getClass().getMethod(str2, View.class)) != null) {
                            this.f4717c = method;
                            this.f4718d = context;
                        }
                    } catch (NoSuchMethodException unused) {
                    }
                    if (context instanceof ContextWrapper) {
                        context = ((ContextWrapper) context).getBaseContext();
                    } else {
                        context = null;
                    }
                } else {
                    int id = view2.getId();
                    if (id == -1) {
                        str = "";
                    } else {
                        str = " with id '" + view2.getContext().getResources().getResourceEntryName(id) + "'";
                    }
                    throw new IllegalStateException("Could not find method " + str2 + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + view2.getClass() + str);
                }
            }
        }
        try {
            this.f4717c.invoke(this.f4718d, view);
        } catch (IllegalAccessException e4) {
            throw new IllegalStateException("Could not execute non-public method for android:onClick", e4);
        } catch (InvocationTargetException e5) {
            throw new IllegalStateException("Could not execute method for android:onClick", e5);
        }
    }
}
