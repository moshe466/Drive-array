package atlow.chemi.mymada;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import atlow.chemi.mymada.helpers.LocalHelper;

public class SimulatePage extends AppCompatActivity {

    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(LocalHelper.onAttach(context));
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_simulate_page);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("דמה מקרה");
        }

        try {
            Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/opensanshebrew.ttf");
            TextView tvSubtitle = findViewById(R.id.tv_simulate_subtitle);
            TextView tvHatzalah = findViewById(R.id.tv_sim_hatzalah);
            TextView tvMda = findViewById(R.id.tv_sim_mda);
            if (tvSubtitle != null) tvSubtitle.setTypeface(tf);
            if (tvHatzalah != null) tvHatzalah.setTypeface(tf);
            if (tvMda != null) tvMda.setTypeface(tf);
        } catch (Exception ignored) {
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
