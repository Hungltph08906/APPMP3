package vn.edu.poly.appmp3.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import vn.edu.poly.appmp3.Activity.PlaynhacActivity;
import vn.edu.poly.appmp3.Model.Baihat;
import vn.edu.poly.appmp3.R;

public class DanhsachbaihatAdapter extends RecyclerView.Adapter<DanhsachbaihatAdapter.viewHolder>{

    Context context;
    ArrayList<Baihat> mangbaihat;

    public DanhsachbaihatAdapter(Context context, ArrayList<Baihat> mangbaihat) {
        this.context = context;
        this.mangbaihat = mangbaihat;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_danhsachbaihat,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        Baihat baihat =mangbaihat.get(position);
        holder.tvtencasi.setText(baihat.getTenCasi());
        holder.tvtenbaihat.setText(baihat.getTenBaihat());
        holder.tvindex.setText(position + 1 +"");
    }

    @Override
    public int getItemCount() {
        return mangbaihat.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        TextView tvindex,tvtenbaihat,tvtencasi;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            tvtencasi = itemView.findViewById(R.id.tvtencasi);
            tvindex = itemView.findViewById(R.id.tvdanhsachindex);
            tvtenbaihat = itemView.findViewById(R.id.tvtenbaihat);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, PlaynhacActivity.class);
                    intent.putExtra("cakhuc",mangbaihat.get(getPosition()));
                    context.startActivity(intent);

                }
            });
        }
    }

}
