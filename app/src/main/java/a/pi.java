package a;

import android.view.View;
import com.google.android.material.datepicker.MaterialDatePicker;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class pi implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f233a;
    public final /* synthetic */ MaterialDatePicker b;

    public /* synthetic */ pi(MaterialDatePicker materialDatePicker, int i) {
        this.f233a = i;
        this.b = materialDatePicker;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f233a) {
            case 0:
                this.b.lambda$initHeaderToggle$0(view);
                break;
            case 1:
                this.b.onPositiveButtonClick(view);
                break;
            default:
                this.b.onNegativeButtonClick(view);
                break;
        }
    }
}
