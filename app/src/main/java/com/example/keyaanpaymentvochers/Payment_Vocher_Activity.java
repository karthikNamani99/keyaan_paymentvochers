package com.example.keyaanpaymentvochers;



import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import com.google.android.material.textfield.TextInputEditText;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;


public class Payment_Vocher_Activity extends AppCompatActivity implements View.OnClickListener {


    static EditText editdate, edittime;
    TextInputEditText editamount, editamount_inwords, editpaid_name, editonAccount_name, edituploader_name, editreciever_name;
     Context context;
    Button btn_save;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_vochers_main);


        btn_save = (Button) findViewById(R.id.btn_save);
        final Calendar myCalendar = Calendar.getInstance();

        editdate = (EditText) findViewById(R.id.date);
        edittime = (EditText) findViewById(R.id.time);
        editamount = (TextInputEditText) findViewById(R.id.sumofrupees);
        editamount_inwords = (TextInputEditText) findViewById(R.id.rupees_inwords);
        editpaid_name = (TextInputEditText) findViewById(R.id.paid_name);
        editonAccount_name = (TextInputEditText) findViewById(R.id.onAccount_name);
        edituploader_name = (TextInputEditText) findViewById(R.id.uploader_name);
        editreciever_name = (TextInputEditText) findViewById(R.id.reciever_name);

        editdate.setFocusable(false);
        editdate.setKeyListener(null);

        edittime.setFocusable(false);
        edittime.setKeyListener(null);

        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        editdate.setText(sdf.format(myCalendar.getTime()));

        int hourOfDay = myCalendar.get(Calendar.HOUR_OF_DAY);
        int minute = myCalendar.get(Calendar.MINUTE);
        edittime.setText( hourOfDay + ":" + minute);

        editdate.setOnClickListener(this);
        edittime.setOnClickListener(this);

        btn_save.setOnClickListener(this);
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.btn_save:


                if (view == btn_save) {


                    if(editamount.getText().toString().isEmpty())
                    {
                        editamount.setError("Please Enter Amount");
                    }
                    else if(editpaid_name.getText().toString().isEmpty())
                    {
                        editpaid_name.setError("Enter Paid Name");
                    }
                    else if(editonAccount_name.getText().toString().isEmpty())
                    {
                        editonAccount_name.setError("Enter OnAccount Name ");
                    }
                    else if(edituploader_name.getText().toString().isEmpty())
                    {
                        edituploader_name.setError("Enter Uploader Name");
                    }
                    else if(editreciever_name.getText().toString().isEmpty())
                    {
                        editreciever_name.setError("Enter Reciever Name");
                    }
                    else
                    {

                        Intent nextpageintent = new Intent(Payment_Vocher_Activity.this, Paymentslist_Activty.class);
                        startActivity(nextpageintent);
                    }

                }

                break;

            case R.id.date:


                showTruitonDatePickerDialog(view);
                break;

            case R.id.time:
                Time currentTime = new Time(System.currentTimeMillis());


                showTruitonTimePickerDialog(view);

                break;
        }
    }

    private void showTruitonTimePickerDialog(View view) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

    private void showTruitonDatePickerDialog(View view) {

        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");

    }


}
