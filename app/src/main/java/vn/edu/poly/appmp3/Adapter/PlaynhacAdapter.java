package vn.edu.poly.appmp3.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import vn.edu.poly.appmp3.Model.Baihat;
import vn.edu.poly.appmp3.R;

public class PlaynhacAdapter extends RecyclerView.Adapter<PlaynhacAdapter.ViewHolder> {

    Context context;
    ArrayList<Baihat> mangbaihat;

    public PlaynhacAdapter(FragmentActivity activity, ArrayList<Baihat> mangbaihat) {

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_playbaihat,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Baihat baihat = mangbaihat.get(position);
        holder.tvplaycasi.setText(baihat.getTenCasi());
        holder.tvplaytenbaihat.setText(baihat.getTenBaihat());
        holder.tvplayindex.setText(position + 1 +" ");

    }

    @Override
    public int getItemCount() {
        return mangbaihat.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvplaytenbaihat,tvplayindex,tvplaycasi;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvplaycasi = itemView.findViewById(R.id.tvplaycasi);
            tvplayindex = itemView.findViewById(R.id.tvplayindex);
            tvplaytenbaihat = itemView.findViewById(R.id.tvplaytenbaihat);
        }
    }
}
