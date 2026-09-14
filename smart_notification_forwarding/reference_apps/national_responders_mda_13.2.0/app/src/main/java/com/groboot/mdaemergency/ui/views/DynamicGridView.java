package com.groboot.mdaemergency.ui.views;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.ClipData;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import c6.v;
import com.groboot.mdaemergency.models.Feature;
import com.groboot.mdaemergency.models.ShortcutButtons;
import com.groboot.mdaemergency.ui.views.DynamicGridView;
import il.org.mda.health.R;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import w6.m;

/* loaded from: classes.dex */
public class DynamicGridView extends GridView {

    /* renamed from: f, reason: collision with root package name */
    boolean f8334f;

    /* renamed from: g, reason: collision with root package name */
    boolean f8335g;

    /* renamed from: h, reason: collision with root package name */
    public c f8336h;

    /* renamed from: i, reason: collision with root package name */
    private List<ObjectAnimator> f8337i;

    /* renamed from: j, reason: collision with root package name */
    View.OnTouchListener f8338j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f8339a;

        a(DynamicGridView dynamicGridView, View view) {
            this.f8339a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f8339a.setLayerType(0, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements View.OnTouchListener {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean b(View view, DragEvent dragEvent) {
            switch (dragEvent.getAction()) {
                case 3:
                    if (dragEvent.getLocalState() == view) {
                        return false;
                    }
                    View view2 = (View) dragEvent.getLocalState();
                    Feature feature = (Feature) view2.getTag();
                    v vVar = (v) ((GridView) view2.getParent()).getAdapter();
                    List<Feature> b10 = vVar.b();
                    Feature feature2 = (Feature) view.getTag();
                    int indexOf = b10.indexOf(feature2);
                    int indexOf2 = b10.indexOf(feature);
                    if (feature2 != null) {
                        b10.set(indexOf, feature);
                        b10.set(indexOf2, feature2);
                    } else {
                        b10.remove(feature);
                        b10.set(indexOf, feature);
                        if (indexOf == 4) {
                            DynamicGridView.this.f8336h.b(indexOf + 1);
                        }
                    }
                    m.C0(ShortcutButtons.saveToLocalData(b10));
                    vVar.notifyDataSetChanged();
                    c cVar = DynamicGridView.this.f8336h;
                    if (cVar != null) {
                        cVar.a(b10);
                    }
                    DynamicGridView.this.l();
                case 1:
                case 2:
                case 4:
                case 5:
                case 6:
                    return true;
                default:
                    return false;
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (!DynamicGridView.this.f8334f) {
                return false;
            }
            if (motionEvent.getAction() == 0 || (motionEvent.getAction() == 2 && !DynamicGridView.this.f8335g)) {
                DynamicGridView.this.f8335g = true;
                GridView gridView = (GridView) view;
                int pointToPosition = gridView.pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
                if (pointToPosition > -1) {
                    int childCount = gridView.getChildCount();
                    for (int i10 = 0; i10 < childCount; i10++) {
                        gridView.getChildAt(i10).setOnDragListener(new View.OnDragListener() { // from class: com.groboot.mdaemergency.ui.views.a
                            @Override // android.view.View.OnDragListener
                            public final boolean onDrag(View view2, DragEvent dragEvent) {
                                boolean b10;
                                b10 = DynamicGridView.b.this.b(view2, dragEvent);
                                return b10;
                            }
                        });
                    }
                    View childAt = gridView.getChildAt(pointToPosition - gridView.getFirstVisiblePosition());
                    Feature feature = (Feature) childAt.getTag();
                    childAt.startDrag(ClipData.newPlainText("DragData", feature != null ? feature.Description : ""), new View.DragShadowBuilder(childAt), childAt, 0);
                }
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(List<Feature> list);

        void b(int i10);
    }

    public DynamicGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8334f = false;
        this.f8335g = false;
        this.f8337i = new LinkedList();
        this.f8338j = new b();
        f();
    }

    private void c(View view) {
        ObjectAnimator e10 = e(view);
        e10.setFloatValues(-2.0f, 2.0f);
        e10.start();
        this.f8337i.add(e10);
    }

    private void d(View view) {
        ObjectAnimator e10 = e(view);
        e10.setFloatValues(2.0f, -2.0f);
        e10.start();
        this.f8337i.add(e10);
    }

    private ObjectAnimator e(View view) {
        if (!g()) {
            view.setLayerType(1, null);
        }
        ObjectAnimator objectAnimator = new ObjectAnimator();
        objectAnimator.setDuration(180L);
        objectAnimator.setRepeatMode(2);
        objectAnimator.setRepeatCount(-1);
        objectAnimator.setPropertyName("rotation");
        objectAnimator.setTarget(view);
        objectAnimator.addListener(new a(this, view));
        return objectAnimator;
    }

    private void f() {
        setOnTouchListener(this.f8338j);
        setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: v6.c
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public final boolean onItemLongClick(AdapterView adapterView, View view, int i10, long j10) {
                boolean h10;
                h10 = DynamicGridView.this.h(adapterView, view, i10, j10);
                return h10;
            }
        });
        setOnLongClickListener(new View.OnLongClickListener() { // from class: v6.b
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean i10;
                i10 = DynamicGridView.this.i(view);
                return i10;
            }
        });
    }

    public static boolean g() {
        return Build.VERSION.SDK_INT < 21;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean h(AdapterView adapterView, View view, int i10, long j10) {
        j();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean i(View view) {
        j();
        return false;
    }

    private void k() {
        Boolean bool;
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (childAt != null && (bool = Boolean.TRUE) != childAt.getTag(R.id.dgv_wobble_tag)) {
                if (i10 % 2 == 0) {
                    c(childAt);
                } else {
                    d(childAt);
                }
                childAt.setTag(R.id.dgv_wobble_tag, bool);
            }
        }
    }

    private void m(boolean z10) {
        Iterator<ObjectAnimator> it = this.f8337i.iterator();
        while (it.hasNext()) {
            it.next().cancel();
        }
        this.f8337i.clear();
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (childAt != null) {
                if (z10) {
                    childAt.setRotation(0.0f);
                }
                childAt.setTag(R.id.dgv_wobble_tag, Boolean.FALSE);
            }
        }
    }

    public void j() {
        this.f8334f = true;
        this.f8335g = false;
        ((v) getAdapter()).c(this.f8334f);
        k();
    }

    public void l() {
        this.f8334f = false;
        ((v) getAdapter()).c(this.f8334f);
        m(true);
    }

    public void setCallback(c cVar) {
        this.f8336h = cVar;
    }
}
