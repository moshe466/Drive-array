package m;

import android.R;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* loaded from: classes.dex */
public final class e1 {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f5643a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f5644b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f5645c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageView f5646d;

    /* renamed from: e, reason: collision with root package name */
    public final ImageView f5647e;

    public e1(View view) {
        this.f5643a = (TextView) view.findViewById(R.id.text1);
        this.f5644b = (TextView) view.findViewById(R.id.text2);
        this.f5645c = (ImageView) view.findViewById(R.id.icon1);
        this.f5646d = (ImageView) view.findViewById(R.id.icon2);
        this.f5647e = (ImageView) view.findViewById(com.uh.sf.R.id.edit_query);
    }
}
