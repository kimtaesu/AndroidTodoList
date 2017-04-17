package com.hucet.todo.view;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hucet.todo.R;
import com.hucet.todo.webapi.NewsParent;
import com.hucet.web.creator.RetrofitCreator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by taesu on 2017-04-17.
 */

public class NewsAdapter<T extends NewsParent.NewsChildren.NewsItem> extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {

    private List<T> dataset = new ArrayList<T>();

    public NewsAdapter(List<T> dataset) {
        this.dataset.addAll(dataset);
    }

    @Override
    public NewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_news, parent, false);
        return new NewsHolder(v);
    }


    @Override
    public void onBindViewHolder(NewsHolder holder, int position) {
        holder.author.setText(dataset.get(position).getAuthor());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public static class NewsHolder extends RecyclerView.ViewHolder {
        private TextView author;

        @RequiresApi(api = Build.VERSION_CODES.N)
        public NewsHolder(View itemView) {

            super(itemView);
            author = (TextView) itemView.findViewById(R.id.author);
        }
    }
}
