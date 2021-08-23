package com.mamunsproject.allsocialmediaplatform.Adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mamunsproject.allsocialmediaplatform.Model.SocialModel;
import com.mamunsproject.allsocialmediaplatform.R;
import com.mamunsproject.allsocialmediaplatform.Utils.ItemAnimation;

import java.util.ArrayList;

import soup.neumorphism.NeumorphImageView;
import soup.neumorphism.NeumorphTextView;

public class SocialAdapter extends RecyclerView.Adapter<SocialAdapter.SocialHolder> {

    Context context;
    ArrayList<SocialModel> list;
    private OnItemListener onItemListener;
    private int animation_type = 0;


    public SocialAdapter(Context context, ArrayList<SocialModel> list,OnItemListener onItemListener, int animation_type) {
        this.context = context;
        this.list = list;
        this.onItemListener=onItemListener;
        this.animation_type = animation_type;

    }

    @NonNull
    @Override
    public SocialHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_layout, parent, false);

        return new SocialHolder(view,onItemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull SocialHolder holder, int position) {

        holder.textView.setText(list.get(position).getTextview());
        holder.imageView.setImageResource(list.get(position).getImageView());
        setAnimation(holder.itemView, position);



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class SocialHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageView;
        TextView textView;
        OnItemListener onItemListener;

        public SocialHolder(@NonNull View itemView,OnItemListener onItemListener) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageviewid);
            textView = itemView.findViewById(R.id.textviewid);
            itemView.setOnClickListener(this::onClick);
            this.onItemListener=onItemListener;

        }

        @Override
        public void onClick(View v) {
            onItemListener.onItemClick(getAdapterPosition());

        }
    }

    public interface OnItemListener{
        void onItemClick(int position);

    }



    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                on_attach = false;
                super.onScrollStateChanged(recyclerView, newState);
            }
        });
        super.onAttachedToRecyclerView(recyclerView);
    }

    private int lastPosition = -1;
    private boolean on_attach = true;

    private void setAnimation(View view, int position) {
        if (position > lastPosition) {
            ItemAnimation.animate(view, on_attach ? position : -1, animation_type);
            lastPosition = position;
        }
    }
}
