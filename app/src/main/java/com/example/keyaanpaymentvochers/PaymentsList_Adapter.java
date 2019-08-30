package com.example.keyaanpaymentvochers;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.mikhaellopez.circularimageview.CircularImageView;


import java.util.ArrayList;
import java.util.List;


public class PaymentsList_Adapter extends RecyclerView.Adapter<PaymentsList_Adapter.MyViewHolder> implements Filterable {


    Context context;
    List<PaymentList> paymentlist = new ArrayList<>();
    List<PaymentList> paymentlist1 = new ArrayList<>();

    public PaymentsList_Adapter(Context context, List<PaymentList> paymentlist) {
        this.context = context;
        this.paymentlist = paymentlist;
        this.paymentlist1 = paymentlist;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView vocherno, date, time, amount, recieved_person;
        public CircularImageView recived_person_image;

        public MyViewHolder(View view) {
            super(view);
            vocherno = (TextView) view.findViewById(R.id.vocher_number);
            date = (TextView) view.findViewById(R.id.textView_date);
            time = (TextView) view.findViewById(R.id.textView_time);
            amount = (TextView) view.findViewById(R.id.textView_amount);
            recieved_person = (TextView) view.findViewById(R.id.textView_recieved_person);
            recived_person_image = (CircularImageView) view.findViewById(R.id.recieved_person_image);

        }
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pamentitem_list_main, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        PaymentList event = paymentlist.get(position);
        holder.vocherno.setText(event.getVocherNo());
        holder.date.setText(event.getDate());
        holder.time.setText(event.getTime());
        holder.amount.setText(event.getAmount());
        holder.recieved_person.setText(event.getRecieved_Person());
        holder.recived_person_image.setImageResource(event.getRecived_Person_Image());


    }

    @Override
    public int getItemCount() {
        return paymentlist.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                String charString = constraint.toString();

                if (charString.isEmpty()) {
                    paymentlist = paymentlist1;
                } else {

                    List<PaymentList> filterList = new ArrayList<>();

                    for (PaymentList data : paymentlist1) {

                        if (data.getRecieved_Person().toLowerCase().contains(charString)) {
                            filterList.add(data);
                        }
                        if (data.getVocherNo().toLowerCase().contains(charString)) {
                            filterList.add(data);
                        }
                        if (data.getDate().toLowerCase().contains(charString)) {
                            filterList.add(data);
                        }
                        else{

                        }
                    }

                    paymentlist = filterList;

                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = paymentlist;

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                paymentlist = (List<PaymentList>) results.values;
                notifyDataSetChanged();
            }
        };
    }
}
