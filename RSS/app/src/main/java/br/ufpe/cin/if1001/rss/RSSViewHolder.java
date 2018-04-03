package br.ufpe.cin.if1001.rss;

import android.view.View;
import android.widget.TextView;

public class RSSViewHolder {
    private TextView title;
    private TextView date;

    public RSSViewHolder(View v) {
        this.title = (TextView) v.findViewById(R.id.item_titulo);
        this.date = (TextView) v.findViewById(R.id.item_data);
    }

    public void bind(ItemRSS item) {
        this.title.setText(item.getTitle());
        this.date.setText(item.getPubDate());
    }
}