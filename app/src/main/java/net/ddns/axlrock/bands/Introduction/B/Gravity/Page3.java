package net.ddns.axlrock.bands.Introduction.B.Gravity;

import android.view.LayoutInflater;
import android.view.View;

import net.ddns.axlrock.bands.R;


public class Page3 extends PageView {
    
    public Page3(MainActivity context) {
        super(context);
        View view = LayoutInflater.from(context).inflate(R.layout.gravity3, null);
        addView(view);

    }
    @Override
    public void refresh() {

    }
}
