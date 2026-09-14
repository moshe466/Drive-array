package com.groboot.mdaemergency.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import g5.i;
import il.org.mda.health.R;

/* loaded from: classes.dex */
public class VolumeView extends LinearLayout {

    /* renamed from: f, reason: collision with root package name */
    Context f8089f;

    /* renamed from: g, reason: collision with root package name */
    View f8090g;

    /* renamed from: h, reason: collision with root package name */
    c f8091h;

    /* renamed from: i, reason: collision with root package name */
    ImageView f8092i;

    /* renamed from: j, reason: collision with root package name */
    ImageView f8093j;

    /* renamed from: k, reason: collision with root package name */
    ImageView f8094k;

    /* renamed from: l, reason: collision with root package name */
    View.OnClickListener f8095l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VolumeView volumeView = VolumeView.this;
            View.OnClickListener onClickListener = volumeView.f8095l;
            if (onClickListener != null) {
                onClickListener.onClick(volumeView);
            }
        }
    }

    /* loaded from: classes.dex */
    public enum b {
        red,
        white
    }

    /* loaded from: classes.dex */
    public enum c {
        none,
        on,
        off,
        on_up,
        temporery
    }

    public VolumeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8091h = c.none;
        this.f8089f = context;
        a(attributeSet);
    }

    private void a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.f8089f.getTheme().obtainStyledAttributes(attributeSet, i.f9851g, 0, 0);
        try {
            int integer = obtainStyledAttributes.getInteger(1, 0);
            int integer2 = obtainStyledAttributes.getInteger(0, 0);
            obtainStyledAttributes.recycle();
            View inflate = LinearLayout.inflate(this.f8089f, R.layout.volume, null);
            this.f8090g = inflate;
            inflate.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            this.f8092i = (ImageView) this.f8090g.findViewById(R.id.iv_volume_on);
            this.f8093j = (ImageView) this.f8090g.findViewById(R.id.iv_volume_off);
            this.f8094k = (ImageView) this.f8090g.findViewById(R.id.iv_volume_on_up);
            addView(this.f8090g);
            setMode(c.values()[integer]);
            setColor(b.values()[integer2]);
            this.f8090g.setOnClickListener(new a());
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    private void setColor(b bVar) {
        if (bVar == b.red) {
            this.f8092i.setImageDrawable(getResources().getDrawable(R.drawable.ic_volume_on_red));
            this.f8093j.setImageDrawable(getResources().getDrawable(R.drawable.ic_volume_off_red));
            this.f8094k.setImageDrawable(getResources().getDrawable(R.drawable.ic_volume_on_up_red));
        } else {
            this.f8092i.setImageDrawable(getResources().getDrawable(R.drawable.ic_volume_on));
            this.f8093j.setImageDrawable(getResources().getDrawable(R.drawable.ic_volume_off));
            this.f8094k.setImageDrawable(getResources().getDrawable(R.drawable.ic_volume_on_up));
            this.f8092i.setColorFilter(androidx.core.content.a.d(this.f8089f, R.color.title_text_color), PorterDuff.Mode.SRC_IN);
            this.f8093j.setColorFilter(androidx.core.content.a.d(this.f8089f, R.color.title_text_color), PorterDuff.Mode.SRC_IN);
            this.f8094k.setColorFilter(androidx.core.content.a.d(this.f8089f, R.color.title_text_color), PorterDuff.Mode.SRC_IN);
        }
    }

    public c getMode() {
        return this.f8091h;
    }

    public void setMode(c cVar) {
        this.f8091h = cVar;
        this.f8092i.setVisibility(cVar == c.on ? 0 : 8);
        this.f8093j.setVisibility(this.f8091h == c.off ? 0 : 8);
        this.f8094k.setVisibility(this.f8091h != c.on_up ? 8 : 0);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f8095l = onClickListener;
    }
}
