package com.hucet.todo.view.viewholder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.auto.factory.AutoFactory;
import com.hucet.todo.R;
import com.hucet.todo.model.RedditNewsItem;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by Miroslaw Stanek on 11.06.2016.
 */
@AutoFactory(implementing = NewsListViewHolderFactory.class)
public class NewsViewHolder extends AbstractNewsViewHolder {

    @BindView(R.id.author)
    TextView author;

    public NewsViewHolder(ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_news, parent, false));
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bind(RedditNewsItem news) {
        author.setText(news.getAuthor());
    }

}
