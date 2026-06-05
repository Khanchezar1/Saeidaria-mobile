package com.saeidaria.mobile.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.saeidaria.mobile.models.Customer;
import java.util.List;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.CustomerViewHolder> {
    private List<Customer> customers;
    private OnCustomerClickListener listener;

    public interface OnCustomerClickListener {
        void onCustomerClick(Customer customer);
    }

    public CustomerAdapter(List<Customer> customers, OnCustomerClickListener listener) {
        this.customers = customers;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CustomerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_customer, parent, false);
        return new CustomerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerViewHolder holder, int position) {
        Customer customer = customers.get(position);
        holder.bind(customer, listener);
    }

    @Override
    public int getItemCount() {
        return customers.size();
    }

    public static class CustomerViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTv, phoneTv, totalOrdersTv, totalSpentTv;

        public CustomerViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.name_tv);
            phoneTv = itemView.findViewById(R.id.phone_tv);
            totalOrdersTv = itemView.findViewById(R.id.total_orders_tv);
            totalSpentTv = itemView.findViewById(R.id.total_spent_tv);
        }

        public void bind(Customer customer, OnCustomerClickListener listener) {
            nameTv.setText(customer.getName());
            phoneTv.setText(customer.getPhone());
            totalOrdersTv.setText("سفارشات: " + customer.getTotalOrders());
            totalSpentTv.setText("کل هزینه: " + customer.getTotalSpent() + " تومان");
            itemView.setOnClickListener(v -> listener.onCustomerClick(customer));
        }
    }
}
