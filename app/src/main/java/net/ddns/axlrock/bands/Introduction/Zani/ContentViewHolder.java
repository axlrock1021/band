package net.ddns.axlrock.bands.Introduction.Zani;

import android.view.View;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

import net.ddns.axlrock.bands.R;

public class ContentViewHolder extends ChildViewHolder {
    private TextView mTextView;

    public ContentViewHolder(View itemView) {
        super(itemView);
        mTextView = itemView.findViewById(R.id.textView);
    }

    public void bind(Content content) {
        mTextView.setText(content.name);
    }
}
