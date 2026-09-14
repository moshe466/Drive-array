package atlow.chemi.mymada.fragments;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import atlow.chemi.mymada.R;
import atlow.chemi.mymada.adapters.DictionaryWordAdapter;
import atlow.chemi.mymada.classes.DictionaryWord;
import com.crashlytics.android.Crashlytics;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class DictionaryAdmin extends Fragment {
    private DictionaryWordAdapter adapter;
    private FirebaseFirestore db;
    private ArrayList<DictionaryWord> dictionary = new ArrayList<>();
    private SearchView searchView;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(Button button, Exception exc) {
        Crashlytics.logException(exc);
        button.setEnabled(true);
    }

    @SuppressLint({"InflateParams"})
    private void wordAdder() {
        LayoutInflater layoutInflater = (LayoutInflater) getActivity().getSystemService("layout_inflater");
        if (layoutInflater != null) {
            View inflate = layoutInflater.inflate(R.layout.new_word_dialog, (ViewGroup) null);
            final EditText editText = (EditText) inflate.findViewById(R.id.wordName);
            final EditText editText2 = (EditText) inflate.findViewById(R.id.wordDefinition);
            final TextInputLayout textInputLayout = (TextInputLayout) inflate.findViewById(R.id.nameTil);
            final TextInputLayout textInputLayout2 = (TextInputLayout) inflate.findViewById(R.id.definitionTil);
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.AlertDialogStyle);
            builder.setTitle("הוספת מילה").setCancelable(true).setView(inflate).setNegativeButton("ביטול", new DialogInterface.OnClickListener() { // from class: atlow.chemi.mymada.fragments.o
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            }).setPositiveButton("הוסף", (DialogInterface.OnClickListener) null);
            final AlertDialog create = builder.create();
            create.setOnShowListener(new DialogInterface.OnShowListener() { // from class: atlow.chemi.mymada.fragments.m
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    DictionaryAdmin.this.a(create, editText, editText2, textInputLayout, textInputLayout2, dialogInterface);
                }
            });
            create.show();
        }
    }

    public /* synthetic */ void a(DialogInterface dialogInterface, Void r3) {
        dialogInterface.dismiss();
        Snackbar make = Snackbar.make(getActivity().getWindow().getDecorView().findViewById(android.R.id.content), R.string.successAddWord, 0);
        ((TextView) make.getView().findViewById(R.id.snackbar_text)).setTextColor(-1);
        make.show();
    }

    public /* synthetic */ void a(EditText editText, EditText editText2, TextInputLayout textInputLayout, TextInputLayout textInputLayout2, final Button button, final DialogInterface dialogInterface, View view) {
        if (editText.getText().toString().trim().isEmpty() || editText2.getText().toString().trim().isEmpty()) {
            if (editText.getText().toString().trim().isEmpty()) {
                textInputLayout.setError("לא כתבת מונח");
            } else {
                textInputLayout.setErrorEnabled(false);
            }
            if (editText2.getText().toString().trim().isEmpty()) {
                textInputLayout2.setError("לא כתבת הגדרה למונח!");
                return;
            } else {
                textInputLayout2.setErrorEnabled(false);
                return;
            }
        }
        button.setEnabled(false);
        String trim = editText.getText().toString().trim();
        String trim2 = editText2.getText().toString().trim();
        textInputLayout2.setErrorEnabled(false);
        textInputLayout.setErrorEnabled(false);
        DocumentReference document = this.db.collection("dictionary").document();
        document.set(new DictionaryWord(trim, trim2, document.getId(), false)).addOnSuccessListener(new OnSuccessListener() { // from class: atlow.chemi.mymada.fragments.k
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                DictionaryAdmin.this.a(dialogInterface, (Void) obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: atlow.chemi.mymada.fragments.l
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                DictionaryAdmin.a(button, exc);
            }
        });
    }

    public /* synthetic */ void a(AlertDialog alertDialog, final EditText editText, final EditText editText2, final TextInputLayout textInputLayout, final TextInputLayout textInputLayout2, final DialogInterface dialogInterface) {
        final Button button = alertDialog.getButton(-1);
        button.setOnClickListener(new View.OnClickListener() { // from class: atlow.chemi.mymada.fragments.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DictionaryAdmin.this.a(editText, editText2, textInputLayout, textInputLayout2, button, dialogInterface, view);
            }
        });
    }

    public /* synthetic */ void a(QuerySnapshot querySnapshot, FirebaseFirestoreException firebaseFirestoreException) {
        DictionaryWordAdapter dictionaryWordAdapter;
        String str;
        if (firebaseFirestoreException != null) {
            Log.e("words", "error getting words");
            return;
        }
        HashSet hashSet = new HashSet();
        if (querySnapshot != null) {
            Iterator<QueryDocumentSnapshot> it = querySnapshot.iterator();
            while (it.hasNext()) {
                QueryDocumentSnapshot next = it.next();
                if (next.get(AppMeasurementSdk.ConditionalUserProperty.NAME) != null && next.get("approved") != null) {
                    hashSet.add(new DictionaryWord(next.getString(AppMeasurementSdk.ConditionalUserProperty.NAME), next.getString("definition"), next.getId(), next.getBoolean("approved").booleanValue()));
                }
            }
        }
        this.dictionary.clear();
        this.dictionary.addAll(hashSet);
        Collections.sort(this.dictionary, new Comparator() { // from class: atlow.chemi.mymada.fragments.j
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int compareToIgnoreCase;
                compareToIgnoreCase = ((DictionaryWord) obj).getName().compareToIgnoreCase(((DictionaryWord) obj2).getName());
                return compareToIgnoreCase;
            }
        });
        this.adapter.notifyDataSetChanged();
        SearchView searchView = this.searchView;
        if (searchView == null || searchView.getQuery().toString().isEmpty()) {
            dictionaryWordAdapter = this.adapter;
            str = "";
        } else {
            dictionaryWordAdapter = this.adapter;
            str = this.searchView.getQuery().toString();
        }
        dictionaryWordAdapter.filter(str);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        if (getActivity() != null) {
            getActivity().setTitle(R.string.button_dict);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.search_menu, menu);
        this.searchView = (SearchView) menu.findItem(R.id.app_bar_search).getActionView();
        this.searchView.setQueryHint(getString(R.string.searchDictionary));
        this.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() { // from class: atlow.chemi.mymada.fragments.DictionaryAdmin.1
            @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextChange(String str) {
                if (str.isEmpty()) {
                    str = "";
                }
                DictionaryAdmin.this.adapter.filter(str);
                return false;
            }

            @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextSubmit(String str) {
                DictionaryAdmin.this.searchView.clearFocus();
                DictionaryAdmin.this.adapter.filter("");
                return false;
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        setHasOptionsMenu(true);
        return layoutInflater.inflate(R.layout.fragment_dictionary_admin, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.app_bar_word_add) {
            wordAdder();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.adapter = new DictionaryWordAdapter(this.dictionary, getActivity());
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.dictionary_word_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(this.adapter);
        this.db = FirebaseFirestore.getInstance();
        this.db.collection("dictionary").whereEqualTo("approved", (Object) true).addSnapshotListener(new EventListener() { // from class: atlow.chemi.mymada.fragments.n
            @Override // com.google.firebase.firestore.EventListener
            public final void onEvent(Object obj, FirebaseFirestoreException firebaseFirestoreException) {
                DictionaryAdmin.this.a((QuerySnapshot) obj, firebaseFirestoreException);
            }
        });
    }
}
