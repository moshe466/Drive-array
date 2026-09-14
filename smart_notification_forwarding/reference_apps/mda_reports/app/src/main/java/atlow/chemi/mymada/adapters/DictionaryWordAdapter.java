package atlow.chemi.mymada.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import atlow.chemi.mymada.R;
import atlow.chemi.mymada.classes.DictionaryWord;
import com.crashlytics.android.Crashlytics;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public class DictionaryWordAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private List<DictionaryWord> DictionaryWordList;
    private Context context;
    private ArrayList<DictionaryWord> filteredList = new ArrayList<>();
    private Typeface myTypeface;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ConstraintLayout listElement;
        private TextView wordDefinition;
        private TextView wordKey;
        private TextView wordName;

        private MyViewHolder(DictionaryWordAdapter dictionaryWordAdapter, View view) {
            super(view);
            this.wordKey = (TextView) view.findViewById(R.id.wordID);
            this.wordName = (TextView) view.findViewById(R.id.wordName);
            this.wordDefinition = (TextView) view.findViewById(R.id.wordDefinition);
            this.listElement = (ConstraintLayout) view.findViewById(R.id.word_list_element);
        }
    }

    public DictionaryWordAdapter(List<DictionaryWord> list, Context context) {
        this.DictionaryWordList = list;
        this.filteredList.addAll(list);
        this.context = context;
        this.myTypeface = Typeface.createFromAsset(context.getAssets(), "fonts/opensanshebrew.ttf");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(Button button, Exception exc) {
        Crashlytics.logException(exc);
        button.setEnabled(true);
    }

    private void wordAdder(final String str, final String str2, final String str3) {
        LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService("layout_inflater");
        if (layoutInflater != null) {
            View inflate = layoutInflater.inflate(R.layout.new_word_dialog, (ViewGroup) null);
            final EditText editText = (EditText) inflate.findViewById(R.id.wordName);
            final EditText editText2 = (EditText) inflate.findViewById(R.id.wordDefinition);
            final TextInputLayout textInputLayout = (TextInputLayout) inflate.findViewById(R.id.nameTil);
            final TextInputLayout textInputLayout2 = (TextInputLayout) inflate.findViewById(R.id.definitionTil);
            editText.setText(str2);
            editText2.setText(str3);
            AlertDialog.Builder builder = new AlertDialog.Builder(this.context, R.style.AlertDialogStyle);
            builder.setTitle("עריכת מילה").setCancelable(true).setView(inflate).setNegativeButton("ביטול", new DialogInterface.OnClickListener() { // from class: atlow.chemi.mymada.adapters.h
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            }).setPositiveButton("שמור", (DialogInterface.OnClickListener) null);
            final AlertDialog create = builder.create();
            create.setOnShowListener(new DialogInterface.OnShowListener() { // from class: atlow.chemi.mymada.adapters.j
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    DictionaryWordAdapter.this.a(create, editText, editText2, textInputLayout, textInputLayout2, str2, str3, str, dialogInterface);
                }
            });
            create.show();
        }
    }

    public /* synthetic */ void a(DialogInterface dialogInterface, Void r3) {
        dialogInterface.dismiss();
        Snackbar make = Snackbar.make(((Activity) this.context).getWindow().getDecorView().findViewById(android.R.id.content), R.string.successEditWord, 0);
        ((TextView) make.getView().findViewById(R.id.snackbar_text)).setTextColor(-1);
        make.show();
    }

    public /* synthetic */ void a(EditText editText, EditText editText2, TextInputLayout textInputLayout, TextInputLayout textInputLayout2, String str, String str2, final Button button, String str3, final DialogInterface dialogInterface, View view) {
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
        if (editText.getText().toString().trim().equals(str) && editText2.getText().toString().trim().equals(str2)) {
            textInputLayout.setError("לא שינית את שם המונח");
            textInputLayout2.setError("לא שינית את ההגדרה למונח!");
            return;
        }
        button.setEnabled(false);
        String trim = editText.getText().toString().trim();
        String trim2 = editText2.getText().toString().trim();
        textInputLayout2.setErrorEnabled(false);
        textInputLayout.setErrorEnabled(false);
        DocumentReference document = FirebaseFirestore.getInstance().collection("dictionary").document(str3);
        HashMap hashMap = new HashMap();
        if (!str.equals(trim)) {
            hashMap.put("newName", trim);
        }
        if (!str2.equals(trim2)) {
            hashMap.put("newDefinition", trim2);
        }
        document.update(hashMap).addOnSuccessListener(new OnSuccessListener() { // from class: atlow.chemi.mymada.adapters.k
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                DictionaryWordAdapter.this.a(dialogInterface, (Void) obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: atlow.chemi.mymada.adapters.i
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                DictionaryWordAdapter.a(button, exc);
            }
        });
    }

    public /* synthetic */ void a(AlertDialog alertDialog, DialogInterface dialogInterface) {
        TextView textView = (TextView) alertDialog.findViewById(android.R.id.message);
        if (textView != null) {
            textView.setTypeface(this.myTypeface);
        }
        TextView textView2 = (TextView) alertDialog.findViewById(android.R.id.title);
        if (textView2 != null) {
            textView2.setTypeface(this.myTypeface);
        }
    }

    public /* synthetic */ void a(AlertDialog alertDialog, final EditText editText, final EditText editText2, final TextInputLayout textInputLayout, final TextInputLayout textInputLayout2, final String str, final String str2, final String str3, final DialogInterface dialogInterface) {
        final Button button = alertDialog.getButton(-1);
        button.setOnClickListener(new View.OnClickListener() { // from class: atlow.chemi.mymada.adapters.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DictionaryWordAdapter.this.a(editText, editText2, textInputLayout, textInputLayout2, str, str2, button, str3, dialogInterface, view);
            }
        });
    }

    public /* synthetic */ void a(String str, String str2, String str3, DialogInterface dialogInterface, int i) {
        wordAdder(str, str2, str3);
    }

    public /* synthetic */ void a(final String str, final String str2, final String str3, View view) {
        final AlertDialog create = new AlertDialog.Builder(this.context, R.style.AlertDialogStyle).setTitle(str).setMessage(str2).setPositiveButton(R.string.editDictionary, new DialogInterface.OnClickListener() { // from class: atlow.chemi.mymada.adapters.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                DictionaryWordAdapter.this.a(str3, str, str2, dialogInterface, i);
            }
        }).setNeutralButton("סגור", new DialogInterface.OnClickListener() { // from class: atlow.chemi.mymada.adapters.f
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).create();
        create.setOnShowListener(new DialogInterface.OnShowListener() { // from class: atlow.chemi.mymada.adapters.e
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                DictionaryWordAdapter.this.a(create, dialogInterface);
            }
        });
        create.show();
    }

    public void filter(String str) {
        String lowerCase = str.toLowerCase();
        this.filteredList.clear();
        if (lowerCase.isEmpty()) {
            this.filteredList.addAll(this.DictionaryWordList);
        } else {
            for (DictionaryWord dictionaryWord : this.DictionaryWordList) {
                String lowerCase2 = dictionaryWord.getName().toLowerCase();
                String lowerCase3 = dictionaryWord.getDefinition().toLowerCase();
                if (lowerCase2.contains(lowerCase) || lowerCase3.contains(lowerCase)) {
                    this.filteredList.add(dictionaryWord);
                }
            }
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.filteredList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        DictionaryWord dictionaryWord = this.filteredList.get(i);
        final String name = dictionaryWord.getName();
        final String definition = dictionaryWord.getDefinition();
        final String key = dictionaryWord.getKey();
        myViewHolder.wordName.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        myViewHolder.wordName.setTypeface(Typeface.DEFAULT_BOLD);
        myViewHolder.wordName.setText(name);
        myViewHolder.wordKey.setText(key);
        myViewHolder.wordDefinition.setText(definition);
        myViewHolder.listElement.setOnClickListener(new View.OnClickListener() { // from class: atlow.chemi.mymada.adapters.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DictionaryWordAdapter.this.a(name, definition, key, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.word_list_element, viewGroup, false));
    }
}
