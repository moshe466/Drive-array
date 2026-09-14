package com.groboot.mdaemergency.ptt;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import il.org.mda.health.R;

/* loaded from: classes.dex */
public class TabbedActivity extends Activity {

    /* renamed from: f, reason: collision with root package name */
    private b f7785f;

    /* renamed from: g, reason: collision with root package name */
    private ViewPager f7786g;

    /* loaded from: classes.dex */
    public static class a extends Fragment {
        public static a a(int i10) {
            a aVar = new a();
            Bundle bundle = new Bundle();
            bundle.putInt("section_number", i10);
            aVar.setArguments(bundle);
            return aVar;
        }

        @Override // android.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View inflate = layoutInflater.inflate(R.layout.fragment_tabbed, viewGroup, false);
            ((TextView) inflate.findViewById(R.id.section_label)).setText(getString(R.string.section_format, Integer.valueOf(getArguments().getInt("section_number"))));
            return inflate;
        }
    }

    /* loaded from: classes.dex */
    public class b extends g0.b {
        public b(TabbedActivity tabbedActivity, FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // androidx.viewpager.widget.a
        public int c() {
            return 3;
        }

        @Override // g0.b
        public Fragment m(int i10) {
            return a.a(i10 + 1);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_tabbed);
        this.f7785f = new b(this, getFragmentManager());
        ViewPager viewPager = (ViewPager) findViewById(R.id.container);
        this.f7786g = viewPager;
        viewPager.setAdapter(this.f7785f);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tabbed, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
