package net.ddns.axlrock.bands.Introduction.B.Gravity;

import android.content.Context;
import android.widget.RelativeLayout;


public abstract class PageView extends RelativeLayout {
    public PageView(Context context) {
        super(context);
    }
    public abstract void refresh();
}
