package com.saeidaria.mobile.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.saeidaria.mobile.models.Order;
import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {
    private List<Order> orders;
    private OnOrderClickListener listener;

    public interface OnOrderClickListener {
        void onOrderClick(Order order);
    }

    public OrderAdapter(List<Order> orders, OnOrderClickListener listener) {
        this.orders = orders;
        this.listener = listener;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_order, parent, false);
        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        Order order = orders.get(position);
        holder.bind(order, listener);
    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    public static class OrderViewHolder extends RecyclerView.ViewHolder {
        private TextView orderIdTv, deviceTypeTv, statusTv, costTv;

        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);
            orderIdTv = itemView.findViewById(R.id.order_id_tv);
            deviceTypeTv = itemView.findViewById(R.id.device_type_tv);
            statusTv = itemView.findViewById(R.id.status_tv);
            costTv = itemView.findViewById(R.id.cost_tv);
        }

        public void bind(Order order, OnOrderClickListener listener) {
            orderIdTv.setText("سفارش: " + order.getId());
            deviceTypeTv.setText(order.getDeviceType() + " - " + order.getDeviceModel());
            statusTv.setText(order.getStatus());
            costTv.setText(order.getTotalCost() + " تومان");
            itemView.setOnClickListener(v -> listener.onOrderClick(order));
        }
    }
}
