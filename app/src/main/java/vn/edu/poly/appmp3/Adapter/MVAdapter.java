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

import vn.edu.poly.appmp3.Activity.PlayMVActivity;
import vn.edu.poly.appmp3.Model.MV;
import vn.edu.poly.appmp3.R;

public class MVAdapter extends RecyclerView.Adapter<MVAdapter.ViewHolder> {

    Context context;
    ArrayList<MV> mangmv;

    public MVAdapter(Context context, ArrayList<MV> mangmv) {
        this.context = context;
        this.mangmv = mangmv;
    }

    @NonNull
    @Override
    public MVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_mv,parent,false);

        return new MVAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MVAdapter.ViewHolder holder, int position) {

        MV mv = mangmv.get(position);
        Picasso.with(context).load(mv.getHinhnenMV()).into(holder.imgnenmv);
        Picasso.with(context).load(mv.getIconCasiMV()).into(holder.imgtencasimv);
        holder.tvtencasimv.setText(mv.getTenCasiMV());
        holder.tvtenmv.setText(mv.getTenMV());
    }

    @Override
    public int getItemCount() {
        return mangmv.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgnenmv,imgtencasimv;
        TextView tvtenmv,tvtencasimv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgnenmv = itemView.findViewById(R.id.imgnenmv);
            imgtencasimv = itemView.findViewById(R.id.imgiconcasimv);
            tvtenmv = itemView.findViewById(R.id.tvtenmv);
            tvtencasimv = itemView.findViewById(R.id.tvtencasimv);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, PlayMVActivity.class);
                    intent.putExtra("mv",mangmv.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
