package com.example.application.kisan;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by HP on 09-03-2018.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsAdapterBindViewHolder> {

    private List<ArticleList> news;
    private Context context;
    public NewsAdapter(List<ArticleList> n, Context con) {
        context = con;
        news = n;
    }

    @Override
    public NewsAdapterBindViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.simple_news_layout,parent,false);
        return new NewsAdapterBindViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsAdapterBindViewHolder holder, int position) {
        if(news.get(position).getUrlToImage()!=null) {
            Picasso picasso = Picasso.with(context);
            picasso.load(news.get(position).getUrlToImage())
                    .centerCrop()
                    .fit()
                    .into(holder.newsImage);
        }

        holder.newsDesc.setText("" + news.get(position).getDescription());
        holder.newsTitle.setText("" + news.get(position).getTitle());
        holder.newsAuthor.setText("" + news.get(position).getAuthor());
        holder.newsTime.setText("" + news.get(position).getPublishedAt());
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    public class NewsAdapterBindViewHolder extends RecyclerView.ViewHolder {
        private ImageView newsImage;
        private TextView newsTime;
        private TextView newsAuthor;
        private TextView newsTitle;
        private TextView newsDesc;
        private TextView newMoreInfo;


        public NewsAdapterBindViewHolder(View itemView) {
            super(itemView);
            newsImage = itemView.findViewById(R.id.newsImage);
            newsTime = itemView.findViewById(R.id.newsTime);
            newsAuthor = itemView.findViewById(R.id.newsAuthor);
            newsTitle = itemView.findViewById(R.id.newsTitle);
            newsDesc = itemView.findViewById(R.id.newsDesc);
            newMoreInfo = itemView.findViewById(R.id.newsMoreInfo);
            newMoreInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // open browser
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(news.get(getAdapterPosition()).getUrl()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
