package br.ufpe.cin.if1001.rss;

import android.view.View;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

public class RSSViewHolder implements View.OnClickListener {
    private TextView title;
    private TextView date;

    private String url;

    public RSSViewHolder(View v, Activity activity) {
        this.title = (TextView) v.findViewById(R.id.item_titulo);
        this.date = (TextView) v.findViewById(R.id.item_data);
        this.activity = activity;
        v.setOnClickListener(this);
    }

    public void bind(ItemRSS item) {
        this.title.setText(item.getTitle());
        this.date.setText(item.getPubDate());
        this.url = item.getLink();
    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(this.url));
        activity.startActivity(i);
    }
}