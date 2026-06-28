package com.root4arab.wipass;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.card.MaterialCardView;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class a extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MaterialCardView f435a;
    public final ImageView b;
    public final TextView c;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    public final List g;

    public a(View view) {
        super(view);
        try {
            this.f435a = (MaterialCardView) view.findViewById(R.id.cardView);
            view.findViewById(R.id.lockIconContainer);
            this.b = (ImageView) view.findViewById(R.id.networkIcon);
            this.c = (TextView) view.findViewById(R.id.ssidText);
            this.e = (TextView) view.findViewById(R.id.signalStrengthText);
            this.f = (TextView) view.findViewById(R.id.channelText);
            this.d = (TextView) view.findViewById(R.id.frequencyText);
            this.g = Arrays.asList(view.findViewById(R.id.bar3), view.findViewById(R.id.bar2), view.findViewById(R.id.bar1));
        } catch (Exception unused) {
        }
    }
}
