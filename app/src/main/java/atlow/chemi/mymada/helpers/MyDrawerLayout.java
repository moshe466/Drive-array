package atlow.chemi.mymada.helpers;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;

/* loaded from: classes.dex */
public class MyDrawerLayout extends DrawerLayout {
    private boolean m_disallowIntercept;

    public MyDrawerLayout(Context context) {
        super(context);
    }

    public MyDrawerLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MyDrawerLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return !this.m_disallowIntercept && super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout
    public void setDrawerLockMode(int i) {
        super.setDrawerLockMode(i);
        this.m_disallowIntercept = i == 2;
    }
}
