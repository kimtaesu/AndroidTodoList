package com.hucet.todo.view.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.hucet.todo.model.RedditNewsItem;


/**
 * Created by Miroslaw Stanek on 11.06.2016.
 */

public abstract class AbstractNewsViewHolder extends RecyclerView.ViewHolder {
    public AbstractNewsViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bind(RedditNewsItem news);
}
