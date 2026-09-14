package com.google.firebase.inappmessaging.display.internal.layout.util;

import android.view.View;
import com.google.firebase.inappmessaging.display.internal.Logging;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class VerticalViewGroupMeasure {
    private int h;
    private List<ViewMeasure> vms;
    private int w;

    public VerticalViewGroupMeasure() {
        this.vms = new ArrayList();
        this.w = 0;
        this.h = 0;
    }

    public VerticalViewGroupMeasure(int i, int i2) {
        this.vms = new ArrayList();
        this.w = i;
        this.h = i2;
    }

    public void add(View view, boolean z) {
        ViewMeasure viewMeasure = new ViewMeasure(view, z);
        viewMeasure.setMaxDimens(this.w, this.h);
        this.vms.add(viewMeasure);
    }

    public void allocateSpace(int i) {
        float f;
        ArrayList<ViewMeasure> arrayList = new ArrayList();
        for (ViewMeasure viewMeasure : this.vms) {
            if (viewMeasure.isFlex()) {
                arrayList.add(viewMeasure);
            }
        }
        Collections.sort(arrayList, new Comparator<ViewMeasure>(this) { // from class: com.google.firebase.inappmessaging.display.internal.layout.util.VerticalViewGroupMeasure.1
            @Override // java.util.Comparator
            public int compare(ViewMeasure viewMeasure2, ViewMeasure viewMeasure3) {
                if (viewMeasure2.getDesiredHeight() > viewMeasure3.getDesiredHeight()) {
                    return -1;
                }
                return viewMeasure2.getDesiredHeight() < viewMeasure3.getDesiredHeight() ? 1 : 0;
            }
        });
        int i2 = 0;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            i2 += ((ViewMeasure) it.next()).getDesiredHeight();
        }
        if (arrayList.size() >= 6) {
            throw new IllegalStateException("VerticalViewGroupMeasure only supports up to 5 children");
        }
        float f2 = 1.0f - ((r2 - 1) * 0.2f);
        Logging.logdPair("VVGM (minFrac, maxFrac)", 0.2f, f2);
        float f3 = 0.0f;
        for (ViewMeasure viewMeasure2 : arrayList) {
            float desiredHeight = viewMeasure2.getDesiredHeight() / i2;
            if (desiredHeight > f2) {
                f3 += desiredHeight - f2;
                f = f2;
            } else {
                f = desiredHeight;
            }
            if (desiredHeight < 0.2f) {
                float min = Math.min(0.2f - desiredHeight, f3);
                f3 -= min;
                f = desiredHeight + min;
            }
            Logging.logdPair("\t(desired, granted)", desiredHeight, f);
            viewMeasure2.setMaxDimens(this.w, (int) (f * i));
        }
    }

    public int getTotalFixedHeight() {
        int i = 0;
        for (ViewMeasure viewMeasure : this.vms) {
            if (!viewMeasure.isFlex()) {
                i += viewMeasure.getDesiredHeight();
            }
        }
        return i;
    }

    public int getTotalHeight() {
        Iterator<ViewMeasure> it = this.vms.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += it.next().getDesiredHeight();
        }
        return i;
    }

    public List<ViewMeasure> getViews() {
        return this.vms;
    }

    public void reset(int i, int i2) {
        this.w = i;
        this.h = i2;
        this.vms = new ArrayList();
    }
}
