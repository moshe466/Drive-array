package com.groboot.mdaemergency.alwaysOn;

import android.content.Context;
import android.view.KeyEvent;
import android.widget.LinearLayout;
import com.groboot.mdaemergency.ui.LockPatternActivity;
import java.util.LinkedHashMap;
import y8.k;

/* loaded from: classes.dex */
public abstract class b extends LinearLayout {

    /* renamed from: f, reason: collision with root package name */
    private d f7544f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context, int i10, d dVar) {
        super(context);
        k.e(context, "context");
        k.e(dVar, "callback");
        new LinkedHashMap();
        this.f7544f = dVar;
    }

    public final void a() {
        this.f7544f.close();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent == null || keyEvent.getKeyCode() != 4) {
            return super.dispatchKeyEvent(keyEvent);
        }
        this.f7544f.close();
        LockPatternActivity.B();
        return true;
    }

    protected final d getCallback() {
        return this.f7544f;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (i10 != 4) {
            return super.onKeyDown(i10, keyEvent);
        }
        a();
        return false;
    }

    protected final void setCallback(d dVar) {
        k.e(dVar, "<set-?>");
        this.f7544f = dVar;
    }
}
