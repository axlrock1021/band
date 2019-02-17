package net.ddns.axlrock.bands.Stage.The_Wall_Live_House;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import net.ddns.axlrock.bands.R;

import java.util.List;

public class ContentAdapter extends ExpandableRecyclerViewAdapter<YearViewHolder, ContentViewHolder> {
    public ContentAdapter(List<? extends ExpandableGroup> groups) {
        super(groups);
    }

    @Override
    public YearViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.experience_year, parent, false);
        return new YearViewHolder(v);
    }

    @Override
    public ContentViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.experience_content, parent, false);
        return new ContentViewHolder(v);
    }

    @Override
    public void onBindChildViewHolder(ContentViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
        final Content content = (Content) group.getItems().get(childIndex);
        holder.bind(content);
    }

    @Override
    public void onBindGroupViewHolder(YearViewHolder holder, int flatPosition, ExpandableGroup group) {
        final Year year = (Year) group;
        holder.bind(year);
    }
}

