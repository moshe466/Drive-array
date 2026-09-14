package m;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import com.uh.sf.R;

/* loaded from: classes.dex */
public final class w1 {

    /* renamed from: a, reason: collision with root package name */
    public final Context f5827a;

    /* renamed from: b, reason: collision with root package name */
    public final View f5828b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f5829c;

    /* renamed from: d, reason: collision with root package name */
    public final WindowManager.LayoutParams f5830d;

    /* renamed from: e, reason: collision with root package name */
    public final Rect f5831e;

    /* renamed from: f, reason: collision with root package name */
    public final int[] f5832f;

    /* renamed from: g, reason: collision with root package name */
    public final int[] f5833g;

    public w1(Context context) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f5830d = layoutParams;
        this.f5831e = new Rect();
        this.f5832f = new int[2];
        this.f5833g = new int[2];
        this.f5827a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.abc_tooltip, (ViewGroup) null);
        this.f5828b = inflate;
        this.f5829c = (TextView) inflate.findViewById(R.id.message);
        layoutParams.setTitle(w1.class.getSimpleName());
        layoutParams.packageName = context.getPackageName();
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = R.style.Animation_AppCompat_Tooltip;
        layoutParams.flags = 24;
    }
}
