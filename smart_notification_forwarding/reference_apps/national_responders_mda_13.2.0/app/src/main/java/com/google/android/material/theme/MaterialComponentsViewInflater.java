package com.google.android.material.theme;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Keep;
import androidx.appcompat.app.i;
import androidx.appcompat.widget.f;
import com.google.android.material.button.a;

@Keep
/* loaded from: classes.dex */
public class MaterialComponentsViewInflater extends i {
    @Override // androidx.appcompat.app.i
    protected f createButton(Context context, AttributeSet attributeSet) {
        return new a(context, attributeSet);
    }
}
