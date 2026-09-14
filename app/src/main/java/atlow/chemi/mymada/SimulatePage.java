package atlow.chemi.mymada;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
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

        final android.content.SharedPreferences sp = getSharedPreferences("Settings", 0);
        View cardHatzalah = findViewById(R.id.card_sim_hatzalah);
        if (cardHatzalah != null) {
            cardHatzalah.setOnClickListener(new android.view.View.OnClickListener() {
                @Override
                public void onClick(android.view.View v) {
                    android.content.Intent intent = new android.content.Intent("atlow.chemi.MyMada.MADA_APP");
                    intent.setAction("atlow.chemi.MyMada.MADA_APP");
                    intent.putExtra("callT", 1);
                    intent.putExtra("text", getString(R.string.UHTest));
                    intent.putExtra("address", "ירושלים ירמיהו 78");
                    intent.putExtra("org_title", "איחוד הצלה - קריאת חירום");
                    atlow.chemi.mymada.recieversAndServices.GrobootRec.madasApp(null);
                    androidx.localbroadcastmanager.content.LocalBroadcastManager.getInstance(SimulatePage.this).sendBroadcast(intent);
                    android.widget.Toast.makeText(SimulatePage.this, "דימוי קריאה - איחוד הצלה", android.widget.Toast.LENGTH_SHORT).show();
                }
            });
        }

        View cardMda = findViewById(R.id.card_sim_mda);
        if (cardMda != null) {
            cardMda.setOnClickListener(new android.view.View.OnClickListener() {
                @Override
                public void onClick(android.view.View v) {
                    android.content.Intent intent = new android.content.Intent("atlow.chemi.MyMada.MADA_APP");
                    intent.setAction("atlow.chemi.MyMada.MADA_APP");
                    intent.putExtra("callT", 2);
                    intent.putExtra("text", getString(R.string.CONANTest));
                    intent.putExtra("address", "ירושלים המ\"ג 7");
                    intent.putExtra("org_title", "מד״א - קריאת חירום");
                    atlow.chemi.mymada.recieversAndServices.GrobootRec.madasApp(null);
                    androidx.localbroadcastmanager.content.LocalBroadcastManager.getInstance(SimulatePage.this).sendBroadcast(intent);
                    android.widget.Toast.makeText(SimulatePage.this, "דימוי קריאה - מד״א", android.widget.Toast.LENGTH_SHORT).show();
                }
            });
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
