package net.ddns.axlrock.bands.Stage.Apamini;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class Year extends ExpandableGroup<Content> {
    public Year(String title, List<Content> items) {
        super(title, items);
    }
}
