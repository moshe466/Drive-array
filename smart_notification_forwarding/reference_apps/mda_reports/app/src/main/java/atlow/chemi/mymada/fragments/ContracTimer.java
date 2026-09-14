package atlow.chemi.mymada.fragments;

import android.R;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import atlow.chemi.mymada.adapters.ContractionAdapter;
import atlow.chemi.mymada.classes.CircularProgressButton;
import atlow.chemi.mymada.classes.Contraction;
import com.crashlytics.android.Crashlytics;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public class ContracTimer extends Fragment {
    private ContractionAdapter adapter;
    private ArrayList<Contraction> albumList;
    private CircularProgressButton contractBtn;
    private Date end;
    private RecyclerView recyclerView;
    private SharedPreferences sp;
    private Date start;
    private int num = 0;
    private boolean running = false;

    /* loaded from: classes.dex */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {
        private boolean includeEdge;
        private int spacing;
        private int spanCount;

        GridSpacingItemDecoration(ContracTimer contracTimer, int i, int i2, boolean z) {
            this.spanCount = i;
            this.spacing = i2;
            this.includeEdge = z;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect rect, @NonNull View view, RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            int i = this.spanCount;
            int i2 = childAdapterPosition % i;
            if (this.includeEdge) {
                int i3 = this.spacing;
                rect.left = i3 - ((i2 * i3) / i);
                rect.right = ((i2 + 1) * i3) / i;
                if (childAdapterPosition < i) {
                    rect.top = i3;
                }
                rect.bottom = this.spacing / 9;
                return;
            }
            int i4 = this.spacing;
            rect.left = (i2 * i4) / i;
            rect.right = i4 - (((i2 + 1) * i4) / i);
            if (childAdapterPosition >= i) {
                rect.top = i4 / 9;
            }
        }
    }

    private int dpToPx(int i) {
        return Math.round(TypedValue.applyDimension(1, i, getResources().getDisplayMetrics()));
    }

    public /* synthetic */ void a(DialogInterface dialogInterface, int i) {
        this.num = this.sp.getInt("contarctNum", 0);
        this.end = new Date(this.sp.getLong("contractLong", 0L));
        Gson gson = new Gson();
        String string = this.sp.getString("contractList", "");
        if (!string.isEmpty()) {
            this.albumList = (ArrayList) gson.fromJson(string, new TypeToken<List<Contraction>>(this) { // from class: atlow.chemi.mymada.fragments.ContracTimer.1
            }.getType());
        }
        this.adapter = new ContractionAdapter(this.albumList, getActivity());
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null) {
            recyclerView.setAdapter(this.adapter);
        }
    }

    public /* synthetic */ void a(AlertDialog alertDialog, DialogInterface dialogInterface) {
        Button button = alertDialog.getButton(-2);
        try {
            Typeface createFromAsset = Typeface.createFromAsset(getActivity().getAssets(), "fonts/opensanshebrew.ttf");
            TextView textView = (TextView) alertDialog.findViewById(R.id.message);
            if (textView != null) {
                textView.setTypeface(createFromAsset);
            }
            button.setTypeface(createFromAsset);
            button.setTextColor(getActivity().getResources().getColor(atlow.chemi.mymada.R.color.OldPrimary));
        } catch (NullPointerException e) {
            Crashlytics.log("Contractions remake defect");
            Crashlytics.logException(e);
        }
    }

    public /* synthetic */ void b(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        SharedPreferences sharedPreferences = this.sp;
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("contractList", "");
            edit.putInt("contarctNum", 0);
            edit.putLong("contractLong", 0L);
            edit.apply();
        }
        this.num = 0;
        this.end = null;
        this.adapter = new ContractionAdapter(this.albumList, getActivity());
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null) {
            recyclerView.setAdapter(this.adapter);
        }
    }

    public /* synthetic */ void b(View view) {
        this.running = !this.running;
        if (this.running) {
            this.start = Calendar.getInstance().getTime();
            this.contractBtn.setText(getActivity().getResources().getString(atlow.chemi.mymada.R.string.endContract));
            this.contractBtn.startAnimation();
            this.contractBtn.setBackgroundColor(Color.argb(255, 218, 218, 218));
            return;
        }
        Date date = this.end;
        Date date2 = date != null ? date : null;
        this.end = Calendar.getInstance().getTime();
        this.contractBtn.setText(getActivity().getResources().getString(atlow.chemi.mymada.R.string.startContract));
        try {
            this.contractBtn.stopAnimation();
        } catch (NullPointerException e) {
            Crashlytics.log("error stopping circular btn");
            Crashlytics.logException(e);
        }
        this.contractBtn.revertAnimation();
        this.contractBtn.setBackgroundColor(Color.rgb(255, 255, 255));
        int i = this.num + 1;
        this.num = i;
        this.albumList.add(new Contraction(i, this.start, this.end, date2));
        this.adapter.notifyDataSetChanged();
        this.recyclerView.smoothScrollToPosition(this.albumList.size());
    }

    public /* synthetic */ void b(AlertDialog alertDialog, DialogInterface dialogInterface) {
        Button button = alertDialog.getButton(-2);
        try {
            Typeface createFromAsset = Typeface.createFromAsset(getActivity().getAssets(), "fonts/opensanshebrew.ttf");
            TextView textView = (TextView) alertDialog.findViewById(R.id.message);
            if (textView != null) {
                textView.setTypeface(createFromAsset);
            }
            button.setTypeface(createFromAsset);
            button.setTextColor(getActivity().getResources().getColor(atlow.chemi.mymada.R.color.OldPrimary));
        } catch (NullPointerException e) {
            Crashlytics.log("Contractions remake defect");
            Crashlytics.logException(e);
        }
    }

    public /* synthetic */ void c(DialogInterface dialogInterface, int i) {
        SharedPreferences sharedPreferences = this.sp;
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("contractList", "");
            edit.putInt("contarctNum", 0);
            edit.putLong("contractLong", 0L);
            edit.apply();
        }
        this.num = 0;
        this.end = null;
        this.albumList.clear();
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null) {
            recyclerView.setAdapter(this.adapter);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(false);
        if (getActivity() != null) {
            getActivity().setTitle(atlow.chemi.mymada.R.string.button_f);
        }
        this.sp = getActivity().getSharedPreferences("Settings", 0);
        ArrayList<Contraction> arrayList = this.albumList;
        if (arrayList != null && !arrayList.isEmpty()) {
            if (this.adapter == null) {
                this.adapter = new ContractionAdapter(this.albumList, getActivity());
                return;
            }
            return;
        }
        this.albumList = new ArrayList<>();
        this.adapter = new ContractionAdapter(this.albumList, getContext());
        boolean z = Calendar.getInstance().getTime().getTime() - this.sp.getLong("contractLong", 0L) <= 1200000;
        if (!this.sp.getString("contractList", "").isEmpty() && z) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), atlow.chemi.mymada.R.style.AlertDialogStyle);
            builder.setMessage(getActivity().getResources().getString(atlow.chemi.mymada.R.string.ContracRecover)).setCancelable(false).setPositiveButton(getActivity().getResources().getString(atlow.chemi.mymada.R.string.ok), new DialogInterface.OnClickListener() { // from class: atlow.chemi.mymada.fragments.e
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    ContracTimer.this.a(dialogInterface, i);
                }
            }).setNegativeButton(getActivity().getResources().getString(atlow.chemi.mymada.R.string.dialog_no), new DialogInterface.OnClickListener() { // from class: atlow.chemi.mymada.fragments.d
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    ContracTimer.this.b(dialogInterface, i);
                }
            });
            final AlertDialog create = builder.create();
            create.setOnShowListener(new DialogInterface.OnShowListener() { // from class: atlow.chemi.mymada.fragments.c
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    ContracTimer.this.a(create, dialogInterface);
                }
            });
            create.show();
            return;
        }
        try {
            if (this.sp != null) {
                SharedPreferences.Editor edit = this.sp.edit();
                edit.putString("contractList", "");
                edit.putInt("contarctNum", 0);
                edit.putLong("contractLong", 0L);
                edit.apply();
            }
            this.num = 0;
            this.end = null;
            this.adapter = new ContractionAdapter(this.albumList, getActivity());
            if (this.recyclerView != null) {
                this.recyclerView.setAdapter(this.adapter);
            }
        } catch (Exception e) {
            e.printStackTrace();
            SharedPreferences sharedPreferences = this.sp;
            if (sharedPreferences != null) {
                SharedPreferences.Editor edit2 = sharedPreferences.edit();
                edit2.putString("contractList", "");
                edit2.putInt("contarctNum", 0);
                edit2.putLong("contractLong", 0L);
                edit2.apply();
            }
            this.num = 0;
            this.end = null;
            this.adapter = new ContractionAdapter(this.albumList, getActivity());
            RecyclerView recyclerView = this.recyclerView;
            if (recyclerView != null) {
                recyclerView.setAdapter(this.adapter);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(@NonNull Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(atlow.chemi.mymada.R.menu.contractions_menu, menu);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        setHasOptionsMenu(true);
        return layoutInflater.inflate(atlow.chemi.mymada.R.layout.activity_contract_calc, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        if (this.albumList.size() > 0) {
            String json = new Gson().toJson(this.albumList);
            try {
                SharedPreferences.Editor edit = this.sp.edit();
                edit.putString("contractList", json);
                edit.putInt("contarctNum", this.num);
                edit.putLong("contractLong", this.end.getTime());
                edit.apply();
            } catch (NullPointerException e) {
                Crashlytics.log(e.getMessage());
            }
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        final AlertDialog create;
        if (menuItem.getItemId() == atlow.chemi.mymada.R.id.action_delete) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), atlow.chemi.mymada.R.style.AlertDialogStyle);
            ArrayList<Contraction> arrayList = this.albumList;
            if (arrayList == null || arrayList.isEmpty()) {
                builder.setMessage(getActivity().getResources().getString(atlow.chemi.mymada.R.string.ContracDeleteEmpty)).setCancelable(false).setPositiveButton(getActivity().getResources().getString(atlow.chemi.mymada.R.string.ok), new DialogInterface.OnClickListener() { // from class: atlow.chemi.mymada.fragments.g
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                create = builder.create();
            } else {
                builder.setMessage(getActivity().getResources().getString(atlow.chemi.mymada.R.string.ContracDelete)).setCancelable(false).setPositiveButton(getActivity().getResources().getString(atlow.chemi.mymada.R.string.ok), new DialogInterface.OnClickListener() { // from class: atlow.chemi.mymada.fragments.a
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        ContracTimer.this.c(dialogInterface, i);
                    }
                }).setNegativeButton(getActivity().getResources().getString(atlow.chemi.mymada.R.string.dialog_no), new DialogInterface.OnClickListener() { // from class: atlow.chemi.mymada.fragments.f
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                create = builder.create();
                create.setOnShowListener(new DialogInterface.OnShowListener() { // from class: atlow.chemi.mymada.fragments.h
                    @Override // android.content.DialogInterface.OnShowListener
                    public final void onShow(DialogInterface dialogInterface) {
                        ContracTimer.this.b(create, dialogInterface);
                    }
                });
            }
            create.show();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        this.recyclerView = (RecyclerView) view.findViewById(atlow.chemi.mymada.R.id.recycler_view);
        this.recyclerView.setLayoutManager(linearLayoutManager);
        this.recyclerView.setRotationY(180.0f);
        this.recyclerView.addItemDecoration(new GridSpacingItemDecoration(this, 1, dpToPx(4), true));
        this.recyclerView.setItemAnimator(new DefaultItemAnimator());
        this.recyclerView.setAdapter(this.adapter);
        this.contractBtn = (CircularProgressButton) view.findViewById(atlow.chemi.mymada.R.id.contra_btn);
        if (getActivity() != null) {
            this.contractBtn.setTypeface(Typeface.createFromAsset(getActivity().getAssets(), "fonts/opensanshebrew.ttf"));
        }
        if (this.running) {
            if (this.start == null) {
                this.start = Calendar.getInstance().getTime();
            }
            this.contractBtn.setText(getActivity().getResources().getString(atlow.chemi.mymada.R.string.endContract));
            this.contractBtn.startAnimation();
            this.contractBtn.setBackgroundColor(Color.argb(255, 218, 218, 218));
        }
        this.contractBtn.setOnClickListener(new View.OnClickListener() { // from class: atlow.chemi.mymada.fragments.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ContracTimer.this.b(view2);
            }
        });
    }
}
