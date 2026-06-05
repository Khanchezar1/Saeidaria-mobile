package com.saeidaria.mobile.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.saeidaria.mobile.models.Part;
import java.util.List;

public class PartAdapter extends RecyclerView.Adapter<PartAdapter.PartViewHolder> {
    private List<Part> parts;
    private OnPartClickListener listener;

    public interface OnPartClickListener {
        void onPartClick(Part part);
    }

    public PartAdapter(List<Part> parts, OnPartClickListener listener) {
        this.parts = parts;
        this.listener = listener;
    }

    @NonNull
    @Override
    public PartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_part, parent, false);
        return new PartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PartViewHolder holder, int position) {
        Part part = parts.get(position);
        holder.bind(part, listener);
    }

    @Override
    public int getItemCount() {
        return parts.size();
    }

    public static class PartViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTv, codeTv, quantityTv, priceTv, statusTv;

        public PartViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.name_tv);
            codeTv = itemView.findViewById(R.id.code_tv);
            quantityTv = itemView.findViewById(R.id.quantity_tv);
            priceTv = itemView.findViewById(R.id.price_tv);
            statusTv = itemView.findViewById(R.id.status_tv);
        }

        public void bind(Part part, OnPartClickListener listener) {
            nameTv.setText(part.getName());
            codeTv.setText("کد: " + part.getCode());
            quantityTv.setText("موجودی: " + part.getQuantity());
            priceTv.setText(part.getPrice() + " تومان");
            
            if (part.isOutOfStock()) {
                statusTv.setText("تمام شده");
                statusTv.setTextColor(itemView.getContext().getResources().getColor(R.color.error));
            } else if (part.isLowStock()) {
                statusTv.setText("موجودی کم");
                statusTv.setTextColor(itemView.getContext().getResources().getColor(android.R.color.holo_orange_dark));
            } else {
                statusTv.setText("موجود");
                statusTv.setTextColor(itemView.getContext().getResources().getColor(R.color.success));
            }
            
            itemView.setOnClickListener(v -> listener.onPartClick(part));
        }
    }
}
