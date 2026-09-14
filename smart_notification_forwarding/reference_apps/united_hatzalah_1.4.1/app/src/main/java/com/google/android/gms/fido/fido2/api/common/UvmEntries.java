package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes.dex */
public class UvmEntries extends AbstractSafeParcelable {
    public static final Parcelable.Creator<UvmEntries> CREATOR = new zzaz();
    private final List zza;

    /* loaded from: classes.dex */
    public static final class Builder {
        private final List zza = new ArrayList();

        public Builder addAll(List<UvmEntry> list) {
            boolean z3;
            if (list.size() + this.zza.size() <= 3) {
                z3 = true;
            } else {
                z3 = false;
            }
            com.google.android.gms.internal.fido.zzap.zzc(z3);
            this.zza.addAll(list);
            return this;
        }

        public Builder addUvmEntry(UvmEntry uvmEntry) {
            if (this.zza.size() < 3) {
                this.zza.add(uvmEntry);
                return this;
            }
            throw new IllegalStateException();
        }

        public UvmEntries build() {
            return new UvmEntries(this.zza);
        }
    }

    public UvmEntries(List list) {
        this.zza = list;
    }

    public boolean equals(Object obj) {
        List list;
        if (!(obj instanceof UvmEntries)) {
            return false;
        }
        UvmEntries uvmEntries = (UvmEntries) obj;
        List list2 = this.zza;
        if (list2 == null && uvmEntries.zza == null) {
            return true;
        }
        if (list2 == null || (list = uvmEntries.zza) == null || !list2.containsAll(list) || !uvmEntries.zza.containsAll(this.zza)) {
            return false;
        }
        return true;
    }

    public List<UvmEntry> getUvmEntryList() {
        return this.zza;
    }

    public int hashCode() {
        return Objects.hashCode(new HashSet(this.zza));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, getUvmEntryList(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final JSONArray zza() {
        try {
            JSONArray jSONArray = new JSONArray();
            if (this.zza != null) {
                for (int i = 0; i < this.zza.size(); i++) {
                    UvmEntry uvmEntry = (UvmEntry) this.zza.get(i);
                    JSONArray jSONArray2 = new JSONArray();
                    jSONArray2.put((int) uvmEntry.getMatcherProtectionType());
                    jSONArray2.put((int) uvmEntry.getKeyProtectionType());
                    jSONArray2.put((int) uvmEntry.getMatcherProtectionType());
                    jSONArray.put(i, jSONArray2);
                }
            }
            return jSONArray;
        } catch (JSONException e4) {
            throw new RuntimeException("Error encoding UvmEntries to JSON object", e4);
        }
    }
}
