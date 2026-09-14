package androidx.fragment.app;

import android.R;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public class ListFragment extends Fragment {
    ListAdapter X;
    ListView Y;
    View Z;
    TextView a0;
    View b0;
    View c0;
    CharSequence d0;
    boolean e0;
    private final Handler mHandler = new Handler();
    private final Runnable mRequestFocus = new Runnable() { // from class: androidx.fragment.app.ListFragment.1
        @Override // java.lang.Runnable
        public void run() {
            ListView listView = ListFragment.this.Y;
            listView.focusableViewAvailable(listView);
        }
    };
    private final AdapterView.OnItemClickListener mOnClickListener = new AdapterView.OnItemClickListener() { // from class: androidx.fragment.app.ListFragment.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ListFragment.this.onListItemClick((ListView) adapterView, view, i, j);
        }
    };

    private void ensureList() {
        if (this.Y != null) {
            return;
        }
        View view = getView();
        if (view == null) {
            throw new IllegalStateException("Content view not yet created");
        }
        if (view instanceof ListView) {
            this.Y = (ListView) view;
        } else {
            this.a0 = (TextView) view.findViewById(16711681);
            TextView textView = this.a0;
            if (textView == null) {
                this.Z = view.findViewById(R.id.empty);
            } else {
                textView.setVisibility(8);
            }
            this.b0 = view.findViewById(16711682);
            this.c0 = view.findViewById(16711683);
            View findViewById = view.findViewById(R.id.list);
            if (!(findViewById instanceof ListView)) {
                if (findViewById != null) {
                    throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
                }
                throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
            }
            this.Y = (ListView) findViewById;
            View view2 = this.Z;
            if (view2 != null) {
                this.Y.setEmptyView(view2);
            } else {
                CharSequence charSequence = this.d0;
                if (charSequence != null) {
                    this.a0.setText(charSequence);
                    this.Y.setEmptyView(this.a0);
                }
            }
        }
        this.e0 = true;
        this.Y.setOnItemClickListener(this.mOnClickListener);
        ListAdapter listAdapter = this.X;
        if (listAdapter != null) {
            this.X = null;
            setListAdapter(listAdapter);
        } else if (this.b0 != null) {
            setListShown(false, false);
        }
        this.mHandler.post(this.mRequestFocus);
    }

    private void setListShown(boolean z, boolean z2) {
        ensureList();
        View view = this.b0;
        if (view == null) {
            throw new IllegalStateException("Can't be used with a custom content view");
        }
        if (this.e0 == z) {
            return;
        }
        this.e0 = z;
        if (z) {
            if (z2) {
                view.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_out));
                this.c0.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_in));
            } else {
                view.clearAnimation();
                this.c0.clearAnimation();
            }
            this.b0.setVisibility(8);
            this.c0.setVisibility(0);
            return;
        }
        if (z2) {
            view.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_in));
            this.c0.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_out));
        } else {
            view.clearAnimation();
            this.c0.clearAnimation();
        }
        this.b0.setVisibility(0);
        this.c0.setVisibility(8);
    }

    @Nullable
    public ListAdapter getListAdapter() {
        return this.X;
    }

    @NonNull
    public ListView getListView() {
        ensureList();
        return this.Y;
    }

    public long getSelectedItemId() {
        ensureList();
        return this.Y.getSelectedItemId();
    }

    public int getSelectedItemPosition() {
        ensureList();
        return this.Y.getSelectedItemPosition();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Context requireContext = requireContext();
        FrameLayout frameLayout = new FrameLayout(requireContext);
        LinearLayout linearLayout = new LinearLayout(requireContext);
        linearLayout.setId(16711682);
        linearLayout.setOrientation(1);
        linearLayout.setVisibility(8);
        linearLayout.setGravity(17);
        linearLayout.addView(new ProgressBar(requireContext, null, R.attr.progressBarStyleLarge), new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout2 = new FrameLayout(requireContext);
        frameLayout2.setId(16711683);
        TextView textView = new TextView(requireContext);
        textView.setId(16711681);
        textView.setGravity(17);
        frameLayout2.addView(textView, new FrameLayout.LayoutParams(-1, -1));
        ListView listView = new ListView(requireContext);
        listView.setId(R.id.list);
        listView.setDrawSelectorOnTop(false);
        frameLayout2.addView(listView, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.mHandler.removeCallbacks(this.mRequestFocus);
        this.Y = null;
        this.e0 = false;
        this.c0 = null;
        this.b0 = null;
        this.Z = null;
        this.a0 = null;
        super.onDestroyView();
    }

    public void onListItemClick(@NonNull ListView listView, @NonNull View view, int i, long j) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        ensureList();
    }

    @NonNull
    public final ListAdapter requireListAdapter() {
        ListAdapter listAdapter = getListAdapter();
        if (listAdapter != null) {
            return listAdapter;
        }
        throw new IllegalStateException("ListFragment " + this + " does not have a ListAdapter.");
    }

    public void setEmptyText(@Nullable CharSequence charSequence) {
        ensureList();
        TextView textView = this.a0;
        if (textView == null) {
            throw new IllegalStateException("Can't be used with a custom content view");
        }
        textView.setText(charSequence);
        if (this.d0 == null) {
            this.Y.setEmptyView(this.a0);
        }
        this.d0 = charSequence;
    }

    public void setListAdapter(@Nullable ListAdapter listAdapter) {
        boolean z = this.X != null;
        this.X = listAdapter;
        ListView listView = this.Y;
        if (listView != null) {
            listView.setAdapter(listAdapter);
            if (this.e0 || z) {
                return;
            }
            setListShown(true, requireView().getWindowToken() != null);
        }
    }

    public void setListShown(boolean z) {
        setListShown(z, true);
    }

    public void setListShownNoAnimation(boolean z) {
        setListShown(z, false);
    }

    public void setSelection(int i) {
        ensureList();
        this.Y.setSelection(i);
    }
}
