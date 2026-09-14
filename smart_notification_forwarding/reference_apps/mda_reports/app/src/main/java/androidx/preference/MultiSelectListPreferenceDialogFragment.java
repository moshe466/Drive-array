package androidx.preference;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Deprecated
/* loaded from: classes.dex */
public class MultiSelectListPreferenceDialogFragment extends PreferenceDialogFragment {
    private static final String SAVE_STATE_CHANGED = "MultiSelectListPreferenceDialogFragment.changed";
    private static final String SAVE_STATE_ENTRIES = "MultiSelectListPreferenceDialogFragment.entries";
    private static final String SAVE_STATE_ENTRY_VALUES = "MultiSelectListPreferenceDialogFragment.entryValues";
    private static final String SAVE_STATE_VALUES = "MultiSelectListPreferenceDialogFragment.values";
    Set<String> a = new HashSet();
    boolean b;
    CharSequence[] c;
    CharSequence[] d;

    @Deprecated
    public MultiSelectListPreferenceDialogFragment() {
    }

    private MultiSelectListPreference getListPreference() {
        return (MultiSelectListPreference) getPreference();
    }

    @Deprecated
    public static MultiSelectListPreferenceDialogFragment newInstance(String str) {
        MultiSelectListPreferenceDialogFragment multiSelectListPreferenceDialogFragment = new MultiSelectListPreferenceDialogFragment();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        multiSelectListPreferenceDialogFragment.setArguments(bundle);
        return multiSelectListPreferenceDialogFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.preference.PreferenceDialogFragment
    public void a(AlertDialog.Builder builder) {
        super.a(builder);
        int length = this.d.length;
        boolean[] zArr = new boolean[length];
        for (int i = 0; i < length; i++) {
            zArr[i] = this.a.contains(this.d[i].toString());
        }
        builder.setMultiChoiceItems(this.c, zArr, new DialogInterface.OnMultiChoiceClickListener() { // from class: androidx.preference.MultiSelectListPreferenceDialogFragment.1
            @Override // android.content.DialogInterface.OnMultiChoiceClickListener
            public void onClick(DialogInterface dialogInterface, int i2, boolean z) {
                boolean z2;
                boolean remove;
                MultiSelectListPreferenceDialogFragment multiSelectListPreferenceDialogFragment = MultiSelectListPreferenceDialogFragment.this;
                if (z) {
                    z2 = multiSelectListPreferenceDialogFragment.b;
                    remove = multiSelectListPreferenceDialogFragment.a.add(multiSelectListPreferenceDialogFragment.d[i2].toString());
                } else {
                    z2 = multiSelectListPreferenceDialogFragment.b;
                    remove = multiSelectListPreferenceDialogFragment.a.remove(multiSelectListPreferenceDialogFragment.d[i2].toString());
                }
                multiSelectListPreferenceDialogFragment.b = remove | z2;
            }
        });
    }

    @Override // androidx.preference.PreferenceDialogFragment, android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.a.clear();
            this.a.addAll(bundle.getStringArrayList(SAVE_STATE_VALUES));
            this.b = bundle.getBoolean(SAVE_STATE_CHANGED, false);
            this.c = bundle.getCharSequenceArray(SAVE_STATE_ENTRIES);
            this.d = bundle.getCharSequenceArray(SAVE_STATE_ENTRY_VALUES);
            return;
        }
        MultiSelectListPreference listPreference = getListPreference();
        if (listPreference.getEntries() == null || listPreference.getEntryValues() == null) {
            throw new IllegalStateException("MultiSelectListPreference requires an entries array and an entryValues array.");
        }
        this.a.clear();
        this.a.addAll(listPreference.getValues());
        this.b = false;
        this.c = listPreference.getEntries();
        this.d = listPreference.getEntryValues();
    }

    @Override // androidx.preference.PreferenceDialogFragment
    @Deprecated
    public void onDialogClosed(boolean z) {
        MultiSelectListPreference listPreference = getListPreference();
        if (z && this.b) {
            Set<String> set = this.a;
            if (listPreference.callChangeListener(set)) {
                listPreference.setValues(set);
            }
        }
        this.b = false;
    }

    @Override // androidx.preference.PreferenceDialogFragment, android.app.DialogFragment, android.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList(SAVE_STATE_VALUES, new ArrayList<>(this.a));
        bundle.putBoolean(SAVE_STATE_CHANGED, this.b);
        bundle.putCharSequenceArray(SAVE_STATE_ENTRIES, this.c);
        bundle.putCharSequenceArray(SAVE_STATE_ENTRY_VALUES, this.d);
    }
}
