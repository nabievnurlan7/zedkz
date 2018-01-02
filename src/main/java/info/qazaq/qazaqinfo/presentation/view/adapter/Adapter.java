package info.qazaq.qazaqinfo.presentation.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import info.qazaq.qazaqinfo.R;
import info.qazaq.qazaqinfo.presentation.model.PresentationModel;
import info.qazaq.qazaqinfo.presentation.view.activity.DetailActivity;

import static android.content.ContentValues.TAG;

/**
 * Created by Nurlan. Email: nabievnurlan7@gmail.com on 19.11.2017.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.NewsViewHolder>
{
    List<PresentationModel> mNewsList;
    Context mContext;

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position)
    {
        holder.bind(mNewsList.get(position), position);
    }

    @Override
    public int getItemCount()
    {
        return mNewsList != null ? mNewsList.size() : 0;
    }

    public void setNews(List<PresentationModel> newsList, Context context)
    {
        mContext = context;
        if (newsList == null)
        {
            throw new IllegalArgumentException("List can't be null");
        }

        mNewsList = newsList;
        notifyDataSetChanged();
    }

    class NewsViewHolder extends RecyclerView.ViewHolder
    {
        @BindView(R.id.txtName)
        TextView txtName;
        @BindView(R.id.txtLastName)
        TextView txtLastName;
        @BindView(R.id.txtEmail)
        TextView txtEmail;
        @BindView(R.id.imgPic)
        ImageView imgPic;

        NewsViewHolder(View itemView)
        {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(final PresentationModel news, int position)
        {
            txtName.setText(news.getFirst_name());
            txtLastName.setText(news.getLast_name());
            txtEmail.setText(news.getEmail());
            Log.i(TAG, "bind:" + news.getPhoto());

            Picasso.with(mContext)
                    .load("https://dummyimage.com/196x219.png")
                    .into(imgPic);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    openDetail(news);
                }
            });
        }

        private void openDetail(PresentationModel news)
        {
            Intent intent = new Intent(mContext, DetailActivity.class);
            intent.putExtra("news", news);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            mContext.startActivity(intent);
        }
    }
}