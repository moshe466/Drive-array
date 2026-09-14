package atlow.chemi.mymada;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import atlow.chemi.mymada.helpers.LocalHelper;

public class MokedPage extends AppCompatActivity {

    private static final String PHONE_HATZALAH = "026261221";
    private static final String PHONE_MDA = "037344017";

    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(LocalHelper.onAttach(context));
    }

    @Override
    protected void onCreate(Bundle bundle) {
        LocalHelper.applyLocale(this);
        super.onCreate(bundle);
        setContentView(R.layout.activity_moked_page);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(R.string.button_j);
        }

        try {
            Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/opensanshebrew.ttf");
            TextView tvSubtitle = findViewById(R.id.tv_moked_subtitle);
            TextView tvHatzalah = findViewById(R.id.tv_title_hatzalah);
            TextView tvMda = findViewById(R.id.tv_title_mda);
            if (tvSubtitle != null) tvSubtitle.setTypeface(tf);
            if (tvHatzalah != null) tvHatzalah.setTypeface(tf);
            if (tvMda != null) tvMda.setTypeface(tf);
        } catch (Exception ignored) {
        }

        CardView cardHatzalah = findViewById(R.id.card_hatzalah);
        if (cardHatzalah != null) {
            cardHatzalah.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialNumber(PHONE_HATZALAH);
                }
            });
        }

        CardView cardMda = findViewById(R.id.card_mda);
        if (cardMda != null) {
            cardMda.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialNumber(PHONE_MDA);
                }
            });
        }
    }

    private void dialNumber(String phoneNumber) {
        try {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + phoneNumber));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
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
