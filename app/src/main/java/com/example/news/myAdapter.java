package com.example.news;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class myAdapter extends RecyclerView.Adapter<myAdapter.viewHolder> {
    LayoutInflater inflater;
    List<News> news;

    public myAdapter(Context ctx , List<News> news ){
        this.inflater=LayoutInflater.from(ctx);
        this.news=news;


    }

    @NonNull

    @Override
    public myAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.sample_layout , parent , false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myAdapter.viewHolder holder, int position) {
        // final News temp = news.get(position);
        holder.author.setText(news.get(position).getAuthor());
        holder.title.setText(news.get(position).getTitle());
        Picasso.get().load(news.get(position).getImageUrl()).into(holder.image);


    }
    void updatedNews(ArrayList<News> updatedNews){
        news.clear();
        news.addAll(updatedNews);
        notifyDataSetChanged();

    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    public  class viewHolder  extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView author , title;
        ImageView image;

        public viewHolder(@NonNull  View itemView) {
            super(itemView);
            author=itemView.findViewById(R.id.author);
            title=itemView.findViewById(R.id.title);
            image=itemView.findViewById(R.id.imageView2);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
           /* String url = "www.google.com";
            CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
            CustomTabsIntent customTabsIntent = builder.build();
            customTabsIntent.launchUrl(inflater.getContext(), Uri.parse(url));

            */
            //Toast.makeText(view.getContext(),  news.get(getAdapterPosition()).getAuthor() , Toast.LENGTH_SHORT).show();
            String url = news.get(getAdapterPosition()).getUrl().toString();
            CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
            CustomTabsIntent customTabsIntent = builder.build();
            customTabsIntent.launchUrl(inflater.getContext(), Uri.parse(url));

        }
    }

}

