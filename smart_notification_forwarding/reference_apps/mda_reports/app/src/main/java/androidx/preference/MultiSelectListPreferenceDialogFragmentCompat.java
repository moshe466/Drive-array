package androidx.preference;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class MultiSelectListPreferenceDialogFragmentCompat extends PreferenceDialogFragmentCompat {
    private static final String SAVE_STATE_CHANGED = "MultiSelectListPreferenceDialogFragmentCompat.changed";
    private static final String SAVE_STATE_ENTRIES = "MultiSelectListPreferenceDialogFragmentCompat.entries";
    private static final String SAVE_STATE_ENTRY_VALUES = "MultiSelectListPreferenceDialogFragmentCompat.entryValues";
    private static final String SAVE_STATE_VALUES = "MultiSelectListPreferenceDialogFragmentCompat.values";
    Set<String> g0 = new HashSet();
    boolean h0;
    CharSequence[] i0;
    CharSequence[] j0;

    private MultiSelectListPreference getListPreference() {
        return (MultiSelectListPreference) getPreference();
    }

    public static MultiSelectListPreferenceDialogFragmentCompat newInstance(String str) {
        MultiSelectListPreferenceDialogFragmentCompat multiSelectListPreferenceDialogFragmentCompat = new MultiSelectListPreferenceDialogFragmentCompat();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        multiSelectListPreferenceDialogFragmentCompat.setArguments(bundle);
        return multiSelectListPreferenceDialogFragmentCompat;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.preference.PreferenceDialogFragmentCompat
    public void a(AlertDialog.Builder builder) {
        super.a(builder);
        int length = this.j0.length;
        boolean[] zArr = new boolean[length];
        for (int i = 0; i < length; i++) {
            zArr[i] = this.g0.contains(this.j0[i].toString());
        }
        builder.setMultiChoiceItems(this.i0, zArr, new DialogInterface.OnMultiChoiceClickListener() { // from class: androidx.preference.MultiSelectListPreferenceDialogFragmentCompat.1
            @Override // android.content.DialogInterface.OnMultiChoiceClickListener
            public void onClick(DialogInterface dialogInterface, int i2, boolean z) {
                boolean z2;
                boolean remove;
                MultiSelectListPreferenceDialogFragmentCompat multiSelectListPreferenceDialogFragmentCompat = MultiSelectListPreferenceDialogFragmentCompat.this;
                if (z) {
                    z2 = multiSelectListPreferenceDialogFragmentCompat.h0;
                    remove = multiSelectListPreferenceDialogFragmentCompat.g0.add(multiSelectListPreferenceDialogFragmentCompat.j0[i2].toString());
                } else {
                    z2 = multiSelectListPreferenceDialogFragmentCompat.h0;
                    remove = multiSelectListPreferenceDialogFragmentCompat.g0.remove(multiSelectListPreferenceDialogFragmentCompat.j0[i2].toString());
                }
                multiSelectListPreferenceDialogFragmentCompat.h0 = remove | z2;
            }
        });
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.g0.clear();
            this.g0.addAll(bundle.getStringArrayList(SAVE_STATE_VALUES));
            this.h0 = bundle.getBoolean(SAVE_STATE_CHANGED, false);
            this.i0 = bundle.getCharSequenceArray(SAVE_STATE_ENTRIES);
            this.j0 = bundle.getCharSequenceArray(SAVE_STATE_ENTRY_VALUES);
            return;
        }
        MultiSelectListPreference listPreference = getListPreference();
        if (listPreference.getEntries() == null || listPreference.getEntryValues() == null) {
            throw new IllegalStateException("MultiSelectListPreference requires an entries array and an entryValues array.");
        }
        this.g0.clear();
        this.g0.addAll(listPreference.getValues());
        this.h0 = false;
        this.i0 = listPreference.getEntries();
        this.j0 = listPreference.getEntryValues();
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat
    public void onDialogClosed(boolean z) {
        if (z && this.h0) {
            MultiSelectListPreference listPreference = getListPreference();
            if (listPreference.callChangeListener(this.g0)) {
                listPreference.setValues(this.g0);
            }
        }
        this.h0 = false;
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList(SAVE_STATE_VALUES, new ArrayList<>(this.g0));
        bundle.putBoolean(SAVE_STATE_CHANGED, this.h0);
        bundle.putCharSequenceArray(SAVE_STATE_ENTRIES, this.i0);
        bundle.putCharSequenceArray(SAVE_STATE_ENTRY_VALUES, this.j0);
    }
}
