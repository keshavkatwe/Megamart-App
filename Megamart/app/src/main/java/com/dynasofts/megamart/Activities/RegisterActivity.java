package com.dynasofts.megamart.Activities;

import android.app.DatePickerDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.dynasofts.megamart.Logging.L;
import com.dynasofts.megamart.R;

import java.util.ArrayList;
import java.util.List;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mRegister;
    private Toolbar mToolbar;
    private EditText mFullname, mEmail, mPassword, mBirthday, mPhone;
    private DatePickerDialog mDatePickerDialog;
    private Spinner mSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mToolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(mToolbar);

        mFullname = (EditText) findViewById(R.id.full_name);
        mEmail = (EditText) findViewById(R.id.email_id);
        mPassword = (EditText) findViewById(R.id.password);
        mBirthday = (EditText) findViewById(R.id.birthday);
        mPhone = (EditText) findViewById(R.id.phone);

        setUpBirthdayPicker();
        setUpGenderPicker();

        mRegister = (Button) findViewById(R.id.register_button);
        mRegister.setOnClickListener(this);
    }


    public void setUpGenderPicker() {
        mSpinner = (Spinner) findViewById(R.id.gender);
        List<String> list = new ArrayList<String>();
        list.add("Gender");
        list.add("Male");
        list.add("Female");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(dataAdapter);
    }

    public void setUpBirthdayPicker() {
        mBirthday.setOnClickListener(this);
        mDatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int date) {
                mBirthday.setText(date + "/" + (month + 1) + "/" + year);
            }
        }, 2000, 01, 01);
    }

    @Override
    public void onClick(View view) {
        int item_id = view.getId();

        switch (item_id) {
            case R.id.birthday:
                mDatePickerDialog.show();
                break;
            case R.id.register_button:
                L.t(this, "Register");
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
