package atlow.chemi.mymada.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.text.method.ScrollingMovementMethod;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import atlow.chemi.mymada.R;
import atlow.chemi.mymada.classes.Chat;
import atlow.chemi.mymada.helpers.ChatEventCallback;
import atlow.chemi.mymada.helpers.Event;
import com.crashlytics.android.Crashlytics;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes.dex */
public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.MyViewHolder> {
    private List<Chat> albumList;
    private Context context;
    public Event<ChatEventCallback> nameChangeRequestCallback = new Event<>();

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private CardView msgHold;
        private TextView msgSender;
        private TextView msgTime;
        private TextView msgTxt;
        private AppCompatImageView waBtn;

        public MyViewHolder(View view) {
            super(view);
            this.msgSender = (TextView) view.findViewById(R.id.msgSender);
            this.msgTxt = (TextView) view.findViewById(R.id.msgTxt);
            this.msgTime = (TextView) view.findViewById(R.id.msgTime);
            this.msgHold = (CardView) view.findViewById(R.id.chat_card_view);
            this.waBtn = (AppCompatImageView) view.findViewById(R.id.waBtn);
        }
    }

    public ChatAdapter(List<Chat> list, Context context) {
        this.albumList = list;
        this.context = context;
    }

    private int dpToPx(int i) {
        return Math.round(TypedValue.applyDimension(1, i, this.context.getResources().getDisplayMetrics()));
    }

    private String formatDate(String str) {
        if (str == null || str.length() < 1) {
            return "";
        }
        long parseLong = Long.parseLong(str.replaceAll("[\\D]", ""));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy' 'HH:mm:ss", Locale.getDefault());
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(parseLong);
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        return simpleDateFormat.format(calendar.getTime());
    }

    public /* synthetic */ void a(View view) {
        Iterator<ChatEventCallback> it = this.nameChangeRequestCallback.listeners().iterator();
        while (it.hasNext()) {
            it.next().invoke();
        }
    }

    public /* synthetic */ void b(View view) {
        try {
            String str = "שלום, אני " + this.context.getSharedPreferences("Settings", 0).getString("UserName", this.context.getString(R.string.user)) + " ואני פונה לגבי השיחה שלנו באפליקציה";
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("http://api.whatsapp.com/send?phone=+972557249771&text=" + str));
            intent.addFlags(268435456);
            this.context.startActivity(intent);
        } catch (Exception e) {
            Crashlytics.logException(e);
            Toast.makeText(this.context, "וואטסאפ לא מותקן כנראה!", 0).show();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.albumList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        CardView cardView;
        View.OnClickListener onClickListener;
        Chat chat = this.albumList.get(i);
        String sender = chat.getSender();
        String msg = chat.getMsg();
        String time = chat.getTime();
        if (sender.equals("NAME_CHANGE") && msg.equals("NAME_CHANGE") && time.equals("NAME_CHANGE")) {
            myViewHolder.msgSender.setText(this.context.getString(R.string.changeName));
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) myViewHolder.msgSender.getLayoutParams();
            int dpToPx = dpToPx(10);
            marginLayoutParams.setMargins(dpToPx, dpToPx, dpToPx, dpToPx);
            myViewHolder.msgSender.requestLayout();
            myViewHolder.msgTxt.setVisibility(8);
            myViewHolder.msgTime.setVisibility(8);
            myViewHolder.msgHold.setCardBackgroundColor(ContextCompat.getColor(this.context, R.color.White));
            cardView = myViewHolder.msgHold;
            onClickListener = new View.OnClickListener() { // from class: atlow.chemi.mymada.adapters.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ChatAdapter.this.a(view);
                }
            };
        } else {
            if (!chat.isWhatsApp()) {
                String string = sender.equals("admin") ? this.context.getString(R.string.admin) : this.context.getSharedPreferences("Settings", 0).getString("UserName", this.context.getString(R.string.user));
                String formatDate = formatDate(chat.getTime());
                myViewHolder.msgSender.setText(string);
                myViewHolder.msgTxt.setText(msg);
                myViewHolder.msgTime.setText(formatDate);
                myViewHolder.msgTxt.setVisibility(0);
                myViewHolder.msgTime.setVisibility(0);
                myViewHolder.msgSender.setVisibility(0);
                myViewHolder.waBtn.setVisibility(8);
                myViewHolder.msgTxt.setMovementMethod(new ScrollingMovementMethod());
                Typeface createFromAsset = Typeface.createFromAsset(this.context.getAssets(), "fonts/opensanshebrew.ttf");
                myViewHolder.msgTxt.setTypeface(createFromAsset);
                myViewHolder.msgSender.setTypeface(createFromAsset);
                myViewHolder.msgTime.setTypeface(createFromAsset);
                myViewHolder.msgHold.setOnClickListener(null);
                myViewHolder.msgHold.setCardBackgroundColor(chat.getSender().equals("admin") ? ContextCompat.getColor(this.context, R.color.chatAdmin) : ContextCompat.getColor(this.context, R.color.White));
                return;
            }
            myViewHolder.msgTime.setText(formatDate(chat.getTime()));
            myViewHolder.msgSender.setVisibility(8);
            myViewHolder.waBtn.setVisibility(0);
            myViewHolder.msgTxt.setText("לחץ על כפתור הוואטסאפ בכדי לתקשר איתנו בוואטסאפ.");
            myViewHolder.msgHold.setCardBackgroundColor(ContextCompat.getColor(this.context, R.color.chatAdmin));
            cardView = myViewHolder.msgHold;
            onClickListener = new View.OnClickListener() { // from class: atlow.chemi.mymada.adapters.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ChatAdapter.this.b(view);
                }
            };
        }
        cardView.setOnClickListener(onClickListener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_layout, viewGroup, false));
    }
}
