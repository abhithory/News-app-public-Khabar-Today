package com.sanapps.publickhabartoday;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.List;


public class recyclerViewAdapter extends RecyclerView.Adapter<recyclerViewAdapter.PostViewHolder> {

    private Context context;
    private List<Posts> AllPosts;

    public recyclerViewAdapter(Context context, List<Posts> allPosts) {
        this.context = context;
        this.AllPosts = allPosts;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_item_layout, parent, false);
        return new PostViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {

        Posts post = AllPosts.get(position);
        holder.postTitle.setText(post.getTitle());
        Document documents = Jsoup.parse(post.getContent());
        holder.postDes.setText(documents.text());

        try {
            Elements elements = documents.select("a");
            Elements imgElement = elements.select("img");
            Glide.with(context).load(imgElement.get(0).attr("src")).into(holder.postImg);
        } catch (Exception e) {

        }


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, FullNewsActivity.class);
                intent.putExtra("content", post.getContent());
                intent.putExtra("title", post.getTitle());
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return AllPosts.size();
    }



    public class PostViewHolder extends RecyclerView.ViewHolder {
        ImageView postImg;
        TextView postTitle, postDes;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

            postImg = itemView.findViewById(R.id.post_img);
            postTitle = itemView.findViewById(R.id.post_title);
            postDes = itemView.findViewById(R.id.post_des);

        }
    }
}
