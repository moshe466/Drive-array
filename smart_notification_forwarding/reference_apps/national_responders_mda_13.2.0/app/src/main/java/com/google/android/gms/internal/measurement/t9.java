package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [FieldDescriptorType] */
/* loaded from: classes.dex */
public final class t9<FieldDescriptorType> extends q9<FieldDescriptorType, Object> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public t9(int i10) {
        super(i10, null);
    }

    @Override // com.google.android.gms.internal.measurement.q9
    public final void e() {
        if (!i()) {
            for (int i10 = 0; i10 < j(); i10++) {
                Map.Entry<FieldDescriptorType, Object> h10 = h(i10);
                if (((g7) h10.getKey()).c()) {
                    h10.setValue(Collections.unmodifiableList((List) h10.getValue()));
                }
            }
            for (Map.Entry<FieldDescriptorType, Object> entry : n()) {
                if (((g7) entry.getKey()).c()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.e();
    }
}
