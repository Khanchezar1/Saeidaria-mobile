package com.saeidaria.mobile.data;

import android.content.Context;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.saeidaria.mobile.models.Order;
import com.saeidaria.mobile.models.Customer;
import com.saeidaria.mobile.models.Part;
import java.util.ArrayList;
import java.util.List;

public class FirebaseManager {
    private static FirebaseManager instance;
    private FirebaseDatabase database;
    private DatabaseReference ordersRef, customersRef, partsRef;

    private FirebaseManager() {
        database = FirebaseDatabase.getInstance();
        ordersRef = database.getReference("orders");
        customersRef = database.getReference("customers");
        partsRef = database.getReference("parts");
    }

    public static FirebaseManager getInstance() {
        if (instance == null) {
            instance = new FirebaseManager();
        }
        return instance;
    }

    // Order Methods
    public void addOrder(Order order) {
        String key = ordersRef.push().getKey();
        if (key != null) {
            order.setId(key);
            ordersRef.child(key).setValue(order);
        }
    }

    public void updateOrder(Order order) {
        ordersRef.child(order.getId()).setValue(order);
    }

    public void deleteOrder(String orderId) {
        ordersRef.child(orderId).removeValue();
    }

    // Customer Methods
    public void addCustomer(Customer customer) {
        String key = customersRef.push().getKey();
        if (key != null) {
            customer.setId(key);
            customersRef.child(key).setValue(customer);
        }
    }

    public void updateCustomer(Customer customer) {
        customersRef.child(customer.getId()).setValue(customer);
    }

    public void deleteCustomer(String customerId) {
        customersRef.child(customerId).removeValue();
    }

    // Part Methods
    public void addPart(Part part) {
        String key = partsRef.push().getKey();
        if (key != null) {
            part.setId(key);
            partsRef.child(key).setValue(part);
        }
    }

    public void updatePart(Part part) {
        partsRef.child(part.getId()).setValue(part);
    }

    public void deletePart(String partId) {
        partsRef.child(partId).removeValue();
    }
}
