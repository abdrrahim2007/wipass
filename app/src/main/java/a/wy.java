package a;

import android.view.View;
import com.root4arab.wipass.WifiDetailsActivity;

public final class wy implements View.OnClickListener {
    public final int f359a;
    public final WifiDetailsActivity b;

    public wy(WifiDetailsActivity wifiDetailsActivity, int i) {
        this.f359a = i;
        this.b = wifiDetailsActivity;
    }

    @Override
    public final void onClick(View view) {
        if (this.b == null) return;
        switch (this.f359a) {
            case 1:
                if (this.b.q != null) {
                    this.b.i("BSSID", this.b.q);
                }
                break;
            case 2:
                if (this.b.e != null) {
                    this.b.i("Device IP", this.b.e.getText().toString());
                }
                break;
            case 3:
                if (this.b.f != null) {
                    this.b.i("Router IP", this.b.f.getText().toString());
                }
                break;
            case 4:
                this.b.startWifiTest();
                break;
        }
    }
}
