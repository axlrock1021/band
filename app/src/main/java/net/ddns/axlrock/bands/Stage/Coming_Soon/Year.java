package net.ddns.axlrock.bands.Stage.Coming_Soon;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class Year extends ExpandableGroup<Content> {
    public Year(String title, List<Content> items) {
        super(title, items);
    }
}
