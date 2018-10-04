package com.example.rafiazahantamanna.expendablelistviewproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class ExLvAdapter extends BaseExpandableListAdapter {

    private Context context;
    List<String> title;
    Map<String, List<String>> child;

    public ExLvAdapter(Context context, List<String> title, Map<String, List<String>> child) {
        this.context = context;
        this.title = title;
        this.child = child;
    }

    @Override
    public int getGroupCount() {
        //how many title/group;
        return title.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        //how many children per group;
        return child.get(title.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return title.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return child.get(title.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        if (convertView == null) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.parent_layout, null);
        }

        TextView textView = convertView.findViewById(R.id.parent_title);
        textView.setText(title.get(groupPosition));

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.child_layout, null);
        }
        TextView textView = convertView.findViewById(R.id.child_title);
        textView.setText(child.get(title.get(groupPosition)).get(childPosition));
        return convertView;
    }


    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
