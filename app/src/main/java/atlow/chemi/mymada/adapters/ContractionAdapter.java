package atlow.chemi.mymada.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import atlow.chemi.mymada.R;
import atlow.chemi.mymada.classes.Contraction;
import com.google.firebase.firestore.util.ExponentialBackoff;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public class ContractionAdapter extends RecyclerView.Adapter<ContractionAdapter.MyViewHolder> {
    private List<Contraction> albumList;
    private Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView count;
        private TextView number;
        private TextView title;

        public MyViewHolder(View view) {
            super(view);
            view.setRotationY(180.0f);
            this.title = (TextView) view.findViewById(R.id.title);
            this.count = (TextView) view.findViewById(R.id.count);
            this.number = (TextView) view.findViewById(R.id.number);
        }
    }

    public ContractionAdapter(List<Contraction> list, Context context) {
        this.albumList = list;
        this.context = context;
    }

    private String printDifference(Date date, Date date2) {
        long time = date2.getTime() - date.getTime();
        long j = time / ExponentialBackoff.DEFAULT_BACKOFF_MAX_DELAY_MS;
        long j2 = (time % ExponentialBackoff.DEFAULT_BACKOFF_MAX_DELAY_MS) / 1000;
        return j > 0 ? this.context.getResources().getString(R.string.ContracMinutes, Long.valueOf(j), Long.valueOf(j2)) : this.context.getResources().getString(R.string.ContracSecondes, Long.valueOf(j2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.albumList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @SuppressLint({"SetTextI18n"})
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        String str;
        Contraction contraction = this.albumList.get(myViewHolder.getAdapterPosition());
        Date oldEnd = contraction.getOldEnd();
        Date start = contraction.getStart();
        myViewHolder.title.setText(this.context.getResources().getString(R.string.ContracLength, printDifference(start, contraction.getEnd())));
        try {
            str = this.context.getResources().getString(R.string.ContracBetween, printDifference(oldEnd, start));
        } catch (Exception e) {
            e.printStackTrace();
            str = "";
        }
        myViewHolder.count.setText(str);
        myViewHolder.number.setText("" + contraction.getNumber());
        Typeface createFromAsset = Typeface.createFromAsset(this.context.getAssets(), "fonts/opensanshebrew.ttf");
        myViewHolder.count.setTypeface(createFromAsset);
        myViewHolder.number.setTypeface(createFromAsset);
        myViewHolder.title.setTypeface(createFromAsset);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.contraction_layout, viewGroup, false));
    }
}
