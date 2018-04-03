package br.ufpe.cin.if1001.rss;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public class TitleDateArrayAdapter extends BaseAdapter {
    private Activity activity;
    private List<ItemRSS> items;

    public TitleDateArrayAdapter(Activity activity, List<ItemRSS> items) {
        this.activity = activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return this.items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v;
        RSSViewHolder holder;

        if (view == null) {
            v = activity.getLayoutInflater().inflate(R.layout.itemlista, viewGroup, false);
            holder = new RSSViewHolder(v, activity);
            v.setTag(holder);
        } else {
            v = view;
            holder = (RSSViewHolder) v.getTag();
        }

        holder.bind((ItemRSS) this.getItem(i));
        return v;
    }
}