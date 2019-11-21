package vn.edu.poly.appmp3;

import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class BaihatAdater extends RecyclerView.Adapter<BaihatAdater.RecyclerViewHolder>{

    private ArrayList<Baihatclass> data = new ArrayList<>();

    public BaihatAdater(ArrayList<Baihatclass> data) {
        this.data = data;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_baihat, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.tvTenbaihat.setText(data.get(position).getTenbaihat());
        holder.tvTencasi.setText(data.get(position).getTencasi());
        holder.tvThoigian.setText(data.get(position).getThoigian());
        holder.imgBacham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                android.app.AlertDialog.Builder builder=new AlertDialog.Builder(view.getContext());
                builder.setTitle("Thông Báo");
                builder.setMessage("bạn có muốn xóa?");
                builder.create().show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView tvTenbaihat,tvTencasi,tvThoigian;
        ImageView imgBaihat,imgBacham;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            tvTenbaihat = (TextView) itemView.findViewById(R.id.tvtenbaihat);
            tvTencasi = (TextView) itemView.findViewById(R.id.tvtencasi);
            tvThoigian = (TextView) itemView.findViewById(R.id.tvthoigian);
            imgBaihat = (ImageView) itemView.findViewById(R.id.imgbaihat);
            imgBacham = (ImageView) itemView.findViewById(R.id.imgbacham);
        }
    }
}
