package vn.edu.poly.appmp3.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import vn.edu.poly.appmp3.Activity.DanhsachcacbaihatActivity;
import vn.edu.poly.appmp3.Model.Playlist;
import vn.edu.poly.appmp3.R;

public class PlaylistAdapter extends RecyclerView.Adapter<PlaylistAdapter.ViewHolder> {

    Context context;
    ArrayList<Playlist> mangplaylist;

    public PlaylistAdapter(Context context, ArrayList<Playlist> mangplaylist) {
        this.context = context;
        this.mangplaylist = mangplaylist;
    }

    @NonNull
    @Override
    public PlaylistAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_playlist,parent,false);

        return new PlaylistAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaylistAdapter.ViewHolder holder, int position) {

        Playlist playlist = mangplaylist.get(position);
        Picasso.with(context).load(playlist.getNenPlaylist()).into(holder.imgnenPlaylist);
        Picasso.with(context).load(playlist.getIconplaylist()).into(holder.imgiconplaylist);
        holder.tvitemplaylist.setText(playlist.getTenplaylist());
    }

    @Override
    public int getItemCount() {
        return mangplaylist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgiconplaylist;
        TextView tvitemplaylist;
        ImageView imgnenPlaylist;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgnenPlaylist = itemView.findViewById(R.id.imgnenplaylist);
            imgiconplaylist = itemView.findViewById(R.id.imgitemplaylist);
            tvitemplaylist = itemView.findViewById(R.id.tvitemplaylist);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DanhsachcacbaihatActivity.class);
                    intent.putExtra("playlist",mangplaylist.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
