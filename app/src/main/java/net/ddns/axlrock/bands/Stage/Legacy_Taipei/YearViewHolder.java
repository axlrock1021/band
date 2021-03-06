package net.ddns.axlrock.bands.Stage.Legacy_Taipei;

import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import net.ddns.axlrock.bands.R;

import static android.view.animation.Animation.RELATIVE_TO_SELF;

public class YearViewHolder extends GroupViewHolder {
    private TextView mTextView;
    private ImageView arrow;

    public YearViewHolder(View itemView) {
        super(itemView);

        mTextView = itemView.findViewById(R.id.andy);
        arrow = itemView.findViewById(R.id.arrow);
    }

    public void bind(Year year) {
        mTextView.setText(year.getTitle());
    }

    @Override
    public void expand() {
        animateExpand();
    }

    @Override
    public void collapse() {
        animateCollapse();
    }

    private void animateExpand() {
        RotateAnimation rotate =
                new RotateAnimation(360, 180, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(300);
        rotate.setFillAfter(true);
        arrow.setAnimation(rotate);
    }

    private void animateCollapse() {
        RotateAnimation rotate =
                new RotateAnimation(180, 360, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(300);
        rotate.setFillAfter(true);
        arrow.setAnimation(rotate);
    }
}
