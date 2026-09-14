package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [FieldDescriptorType] */
/* loaded from: classes.dex */
public final class zzdue<FieldDescriptorType> extends zzdub<FieldDescriptorType, Object> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdue(int i) {
        super(i, null);
    }

    @Override // com.google.android.gms.internal.ads.zzdub
    public final void zzaxq() {
        if (!isImmutable()) {
            for (int i = 0; i < zzbbs(); i++) {
                Map.Entry<FieldDescriptorType, Object> zzgw = zzgw(i);
                if (((zzdro) zzgw.getKey()).zzazq()) {
                    zzgw.setValue(Collections.unmodifiableList((List) zzgw.getValue()));
                }
            }
            for (Map.Entry<FieldDescriptorType, Object> entry : zzbbt()) {
                if (((zzdro) entry.getKey()).zzazq()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zzaxq();
    }
}
