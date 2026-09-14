package com.groboot.mdaemergency.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.groboot.mdaemergency.ui.QuestionView;
import g5.i;
import il.org.mda.health.R;
import java.util.LinkedHashMap;
import java.util.Objects;
import y8.g;
import y8.k;

/* loaded from: classes.dex */
public final class QuestionView extends LinearLayout {

    /* renamed from: f, reason: collision with root package name */
    private ImageView f8046f;

    /* renamed from: g, reason: collision with root package name */
    private ImageView f8047g;

    /* renamed from: h, reason: collision with root package name */
    private Boolean f8048h;

    /* renamed from: i, reason: collision with root package name */
    private String f8049i;

    /* renamed from: j, reason: collision with root package name */
    private LinearLayout f8050j;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QuestionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        k.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuestionView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        k.e(context, "context");
        new LinkedHashMap();
        View inflate = View.inflate(context, R.layout.ll_review_question, null);
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.widget.LinearLayout");
        this.f8050j = (LinearLayout) inflate;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, i.f9848d, 0, 0);
            k.b(obtainStyledAttributes);
            setText(obtainStyledAttributes.getString(0));
        }
        addView(this.f8050j);
        View findViewById = this.f8050j.findViewById(R.id.tv_text);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById).setText(this.f8049i);
        View findViewById2 = this.f8050j.findViewById(R.id.iv_x);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.ImageView");
        this.f8046f = (ImageView) findViewById2;
        View findViewById3 = this.f8050j.findViewById(R.id.iv_v);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.ImageView");
        this.f8047g = (ImageView) findViewById3;
        this.f8046f.setOnClickListener(new View.OnClickListener() { // from class: a6.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QuestionView.c(QuestionView.this, view);
            }
        });
        this.f8047g.setOnClickListener(new View.OnClickListener() { // from class: a6.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QuestionView.d(QuestionView.this, view);
            }
        });
    }

    public /* synthetic */ QuestionView(Context context, AttributeSet attributeSet, int i10, int i11, g gVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(QuestionView questionView, View view) {
        k.e(questionView, "this$0");
        questionView.setValue(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(QuestionView questionView, View view) {
        k.e(questionView, "this$0");
        questionView.setValue(true);
    }

    public final boolean e() {
        return this.f8048h != null;
    }

    public final String getText() {
        return this.f8049i;
    }

    public final boolean getValue() {
        Boolean bool = this.f8048h;
        k.b(bool);
        return bool.booleanValue();
    }

    public final void setText(String str) {
        this.f8049i = str;
    }

    public final void setValue(boolean z10) {
        ImageView imageView;
        int i10;
        ImageView imageView2 = this.f8047g;
        if (z10) {
            imageView2.setImageResource(R.drawable.check_box_checked_30);
            imageView = this.f8046f;
            i10 = R.drawable.check_box_x_none_30;
        } else {
            imageView2.setImageResource(R.drawable.check_box_none_30);
            imageView = this.f8046f;
            i10 = R.drawable.check_box_x_checked_30;
        }
        imageView.setImageResource(i10);
        this.f8048h = Boolean.valueOf(z10);
    }
}
