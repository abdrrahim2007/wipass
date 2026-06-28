package com.root4arab.wipass;

import a.kz;
import a.xc;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.card.MaterialCardView;
import com.root4arab.wipass.MainActivity;
import com.root4arab.wipass.WifiDetailsActivity;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class b extends RecyclerView.Adapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MainActivity f436a;
    public final ArrayList b;
    public boolean c = false;

    public b(MainActivity mainActivity, ArrayList arrayList) {
        this.f436a = mainActivity;
        this.b = arrayList;
    }

    public static String a(String str) {
        if (str.isEmpty()) {
            return "شبكة غير معروفة";
        }
        if (str.length() <= 20 || !str.contains("_")) {
            return str;
        }
        String[] strArrSplit = str.split("_");
        if (strArrSplit.length < 2) {
            return str;
        }
        String str2 = strArrSplit[0] + "_" + strArrSplit[1];
        return (str2.length() <= 20 || strArrSplit.length <= 1) ? str2 : strArrSplit[0];
    }

    public final void b(a aVar, int i) {
        a aVar2;
        int i2;
        int i3;
        if (i >= 4) {
            aVar2 = aVar;
            i2 = 3;
        } else if (i >= 2) {
            aVar2 = aVar;
            i2 = 2;
        } else if (i >= 1) {
            aVar2 = aVar;
            i2 = 1;
        } else {
            aVar2 = aVar;
            i2 = 0;
        }
        try {
            List list = aVar2.g;
            if (list != null && !list.isEmpty()) {
                int size = list.size();
                for (int i4 = 0; i4 < size; i4++) {
                    View view = (View) list.get(i4);
                    if (view != null) {
                        int i5 = (size - 1) - i4;
                        MainActivity mainActivity = this.f436a;
                        if (i5 < i2) {
                            if (i2 == 3) {
                                try {
                                    i3 = R.color.signal_excellent;
                                } catch (Exception unused) {
                                    return;
                                }
                            } else {
                                i3 = i2 == 2 ? R.color.signal_moderate : R.color.signal_weak;
                            }
                            view.setBackgroundResource(R.drawable.signal_bar_gradient);
                            view.setBackgroundTintList(ContextCompat.getColorStateList(mainActivity, i3));
                            try {
                                ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 1.0f);
                                scaleAnimation.setDuration(500L);
                                scaleAnimation.setStartOffset(((long) i4) * 100);
                                scaleAnimation.setFillAfter(true);
                                view.startAnimation(scaleAnimation);
                            } catch (Exception unused2) {
                            }
                        } else {
                            view.setBackgroundResource(R.drawable.signal_bar_gradient);
                            view.setBackgroundTintList(ContextCompat.getColorStateList(mainActivity, R.color.signal_inactive));
                        }
                    }
                }
            }
        } catch (Exception unused3) {
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        ArrayList arrayList;
        if (this.c && (arrayList = this.b) != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        String str;
        final a aVar = (a) viewHolder;
        try {
            final xc xcVar = (xc) this.b.get(i);
            if (xcVar == null) {
                MaterialCardView materialCardView = aVar.f435a;
                if (materialCardView != null) {
                    materialCardView.setVisibility(8);
                    return;
                }
                return;
            }
            int i2 = xcVar.d;
            String str2 = xcVar.f364a;
            if (str2.isEmpty()) {
                str2 = "شبكة مخفية";
            }
            final String str3 = str2;
            if (str3.isEmpty()) {
                MaterialCardView materialCardView2 = aVar.f435a;
                if (materialCardView2 != null) {
                    materialCardView2.setVisibility(8);
                    return;
                }
                return;
            }
            MaterialCardView materialCardView3 = aVar.f435a;
            TextView textView = aVar.c;
            if (materialCardView3 != null) {
                materialCardView3.setVisibility(0);
            }
            final String str4 = (i2 < 2400 || i2 >= 2500) ? (i2 < 5000 || i2 >= 6000) ? "Unknown" : "5 GHz" : "2.4 GHz";
            final int i3 = xcVar.c;
            final boolean z = xcVar.f;
            xcVar.e.contains("OPEN");
            if (textView != null) {
                textView.setText(a(str3));
            }
            TextView textView2 = aVar.f;
            if (textView2 != null) {
                int i4 = (i2 < 2412 || i2 > 2484) ? (i2 < 5000 || i2 > 5825) ? -1 : (i2 - 5000) / 5 : ((i2 - 2412) / 5) + 1;
                if (i4 > 0) {
                    str = "قناة " + i4;
                } else {
                    str = "غير معروف";
                }
                textView2.setText(str);
            }
            TextView textView3 = aVar.d;
            if (textView3 != null) {
                textView3.setText(str4);
            }
            TextView textView4 = aVar.e;
            if (textView4 != null) {
                String str5 = "جيد";
                if (i3 != 2 && i3 != 3) {
                    str5 = i3 != 4 ? "ضعيف" : "ممتاز";
                }
                textView4.setText(str5);
            }
            boolean zD = kz.d(str3);
            MainActivity mainActivity = this.f436a;
            try {
                int color = (z || zD) ? ContextCompat.getColor(mainActivity, R.color.green_connected) : ContextCompat.getColor(mainActivity, R.color.red_disconnected);
                if (textView != null) {
                    textView.setTextColor(color);
                }
            } catch (Exception unused) {
            }
            try {
                ImageView imageView = aVar.b;
                if (imageView != null) {
                    if (zD) {
                        imageView.setImageResource(R.drawable.wifi1);
                    } else {
                        imageView.setImageResource(R.drawable.no);
                    }
                }
            } catch (Exception unused2) {
            }
            b(aVar, i3);
            MaterialCardView materialCardView4 = aVar.f435a;
            if (materialCardView4 != null) {
                materialCardView4.setOnClickListener(new View.OnClickListener() { // from class: a.wt
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        com.root4arab.wipass.a aVar2 = aVar;
                        String str6 = str3;
                        xc xcVar2 = xcVar;
                        String str7 = str4;
                        int i5 = i3;
                        boolean z2 = z;
                        MainActivity mainActivity2 = this.f355a.f436a;
                        try {
                            MaterialCardView materialCardView5 = aVar2.f435a;
                            try {
                                ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.97f, 1.0f, 0.97f, 1, 0.5f, 1, 0.5f);
                                scaleAnimation.setDuration(120L);
                                scaleAnimation.setRepeatCount(1);
                                scaleAnimation.setRepeatMode(2);
                                materialCardView5.startAnimation(scaleAnimation);
                            } catch (Exception unused3) {
                            }
                            Intent intent = new Intent(mainActivity2, (Class<?>) WifiDetailsActivity.class);
                            intent.putExtra("ssid", str6);
                            intent.putExtra("bssid", xcVar2.b);
                            String str8 = "WEP";
                            String str9 = xcVar2.e;
                            if (str9.contains("WPA3")) {
                                str8 = "WPA3";
                            } else if (str9.contains("WPA2")) {
                                str8 = "WPA2";
                            } else if (str9.contains("WPA")) {
                                str8 = "WPA";
                            } else if (!str9.contains("WEP")) {
                                str8 = "مفتوحة";
                            }
                            intent.putExtra("security", str8);
                            intent.putExtra("frequency", str7);
                            int i6 = xcVar2.c;
                            intent.putExtra("signal", i6 != 1 ? i6 != 2 ? i6 != 3 ? i6 != 4 ? "ضعيفة جداً" : "ممتازة" : "جيدة جداً" : "جيدة" : "ضعيفة");
                            intent.putExtra("level", i5);
                            intent.putExtra("isConnected", z2);
                            mainActivity2.startActivity(intent);
                        } catch (Exception unused4) {
                        }
                    }
                });
            }
        } catch (Exception unused3) {
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(this.f436a).inflate(R.layout.item_wifi_network, viewGroup, false));
    }
}
