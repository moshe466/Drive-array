package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import androidx.preference.Preference;

/* loaded from: classes.dex */
public abstract class TwoStatePreference extends Preference {
    protected boolean a;
    private boolean mCheckedSet;
    private boolean mDisableDependentsState;
    private CharSequence mSummaryOff;
    private CharSequence mSummaryOn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.preference.TwoStatePreference.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        boolean a;

        SavedState(Parcel parcel) {
            super(parcel);
            this.a = parcel.readInt() == 1;
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a ? 1 : 0);
        }
    }

    public TwoStatePreference(Context context) {
        this(context, null);
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // androidx.preference.Preference
    protected Object a(TypedArray typedArray, int i) {
        return Boolean.valueOf(typedArray.getBoolean(i, false));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.preference.Preference
    public void a(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(SavedState.class)) {
            super.a(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.a(savedState.getSuperState());
        setChecked(savedState.a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(PreferenceViewHolder preferenceViewHolder) {
        b(preferenceViewHolder.findViewById(android.R.id.summary));
    }

    @Override // androidx.preference.Preference
    protected void a(Object obj) {
        if (obj == null) {
            obj = false;
        }
        setChecked(a(((Boolean) obj).booleanValue()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(android.view.View r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof android.widget.TextView
            if (r0 != 0) goto L5
            return
        L5:
            android.widget.TextView r5 = (android.widget.TextView) r5
            r0 = 1
            boolean r1 = r4.a
            r2 = 0
            if (r1 == 0) goto L1c
            java.lang.CharSequence r1 = r4.mSummaryOn
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L1c
            java.lang.CharSequence r0 = r4.mSummaryOn
        L17:
            r5.setText(r0)
            r0 = 0
            goto L2b
        L1c:
            boolean r1 = r4.a
            if (r1 != 0) goto L2b
            java.lang.CharSequence r1 = r4.mSummaryOff
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L2b
            java.lang.CharSequence r0 = r4.mSummaryOff
            goto L17
        L2b:
            if (r0 == 0) goto L3b
            java.lang.CharSequence r1 = r4.getSummary()
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 != 0) goto L3b
            r5.setText(r1)
            r0 = 0
        L3b:
            r1 = 8
            if (r0 != 0) goto L40
            r1 = 0
        L40:
            int r0 = r5.getVisibility()
            if (r1 == r0) goto L49
            r5.setVisibility(r1)
        L49:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.TwoStatePreference.b(android.view.View):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.preference.Preference
    public void f() {
        super.f();
        boolean z = !isChecked();
        if (callChangeListener(Boolean.valueOf(z))) {
            setChecked(z);
        }
    }

    public boolean getDisableDependentsState() {
        return this.mDisableDependentsState;
    }

    public CharSequence getSummaryOff() {
        return this.mSummaryOff;
    }

    public CharSequence getSummaryOn() {
        return this.mSummaryOn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.preference.Preference
    public Parcelable h() {
        Parcelable h = super.h();
        if (isPersistent()) {
            return h;
        }
        SavedState savedState = new SavedState(h);
        savedState.a = isChecked();
        return savedState;
    }

    public boolean isChecked() {
        return this.a;
    }

    public void setChecked(boolean z) {
        boolean z2 = this.a != z;
        if (z2 || !this.mCheckedSet) {
            this.a = z;
            this.mCheckedSet = true;
            b(z);
            if (z2) {
                notifyDependencyChange(shouldDisableDependents());
                d();
            }
        }
    }

    public void setDisableDependentsState(boolean z) {
        this.mDisableDependentsState = z;
    }

    public void setSummaryOff(int i) {
        setSummaryOff(getContext().getString(i));
    }

    public void setSummaryOff(CharSequence charSequence) {
        this.mSummaryOff = charSequence;
        if (isChecked()) {
            return;
        }
        d();
    }

    public void setSummaryOn(int i) {
        setSummaryOn(getContext().getString(i));
    }

    public void setSummaryOn(CharSequence charSequence) {
        this.mSummaryOn = charSequence;
        if (isChecked()) {
            d();
        }
    }

    @Override // androidx.preference.Preference
    public boolean shouldDisableDependents() {
        return (this.mDisableDependentsState ? this.a : !this.a) || super.shouldDisableDependents();
    }
}
