package h;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AlertController$RecycleListView;
import androidx.core.widget.NestedScrollView;
import com.uh.sf.R;
import g.AbstractC0424a;
import g0.HandlerC0425a;
import java.lang.ref.WeakReference;

/* renamed from: h.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0437g {

    /* renamed from: A, reason: collision with root package name */
    public final int f4798A;

    /* renamed from: B, reason: collision with root package name */
    public final int f4799B;

    /* renamed from: C, reason: collision with root package name */
    public final int f4800C;

    /* renamed from: D, reason: collision with root package name */
    public final boolean f4801D;

    /* renamed from: E, reason: collision with root package name */
    public final HandlerC0425a f4802E;

    /* renamed from: a, reason: collision with root package name */
    public final Context f4804a;

    /* renamed from: b, reason: collision with root package name */
    public final DialogInterfaceC0438h f4805b;

    /* renamed from: c, reason: collision with root package name */
    public final Window f4806c;

    /* renamed from: d, reason: collision with root package name */
    public CharSequence f4807d;

    /* renamed from: e, reason: collision with root package name */
    public String f4808e;

    /* renamed from: f, reason: collision with root package name */
    public AlertController$RecycleListView f4809f;

    /* renamed from: g, reason: collision with root package name */
    public View f4810g;
    public Button i;

    /* renamed from: j, reason: collision with root package name */
    public CharSequence f4812j;

    /* renamed from: k, reason: collision with root package name */
    public Message f4813k;

    /* renamed from: l, reason: collision with root package name */
    public Button f4814l;

    /* renamed from: m, reason: collision with root package name */
    public CharSequence f4815m;

    /* renamed from: n, reason: collision with root package name */
    public Message f4816n;

    /* renamed from: o, reason: collision with root package name */
    public Button f4817o;
    public CharSequence p;

    /* renamed from: q, reason: collision with root package name */
    public Message f4818q;

    /* renamed from: r, reason: collision with root package name */
    public NestedScrollView f4819r;

    /* renamed from: s, reason: collision with root package name */
    public Drawable f4820s;

    /* renamed from: t, reason: collision with root package name */
    public ImageView f4821t;

    /* renamed from: u, reason: collision with root package name */
    public TextView f4822u;

    /* renamed from: v, reason: collision with root package name */
    public TextView f4823v;

    /* renamed from: w, reason: collision with root package name */
    public View f4824w;

    /* renamed from: x, reason: collision with root package name */
    public ListAdapter f4825x;

    /* renamed from: z, reason: collision with root package name */
    public final int f4826z;

    /* renamed from: h, reason: collision with root package name */
    public boolean f4811h = false;
    public int y = -1;

    /* renamed from: F, reason: collision with root package name */
    public final ViewOnClickListenerC0433c f4803F = new ViewOnClickListenerC0433c(this, 0);

    public C0437g(Context context, DialogInterfaceC0438h dialogInterfaceC0438h, Window window) {
        this.f4804a = context;
        this.f4805b = dialogInterfaceC0438h;
        this.f4806c = window;
        HandlerC0425a handlerC0425a = new HandlerC0425a();
        handlerC0425a.f4651b = new WeakReference(dialogInterfaceC0438h);
        this.f4802E = handlerC0425a;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, AbstractC0424a.f4631e, R.attr.alertDialogStyle, 0);
        this.f4826z = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.getResourceId(2, 0);
        this.f4798A = obtainStyledAttributes.getResourceId(4, 0);
        obtainStyledAttributes.getResourceId(5, 0);
        this.f4799B = obtainStyledAttributes.getResourceId(7, 0);
        this.f4800C = obtainStyledAttributes.getResourceId(3, 0);
        this.f4801D = obtainStyledAttributes.getBoolean(6, true);
        obtainStyledAttributes.getDimensionPixelSize(1, 0);
        obtainStyledAttributes.recycle();
        dialogInterfaceC0438h.c().g(1);
    }

    public static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public static ViewGroup b(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    public final void c(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        Message message;
        if (onClickListener != null) {
            message = this.f4802E.obtainMessage(i, onClickListener);
        } else {
            message = null;
        }
        if (i != -3) {
            if (i != -2) {
                if (i == -1) {
                    this.f4812j = charSequence;
                    this.f4813k = message;
                    return;
                }
                throw new IllegalArgumentException("Button does not exist");
            }
            this.f4815m = charSequence;
            this.f4816n = message;
            return;
        }
        this.p = charSequence;
        this.f4818q = message;
    }
}
