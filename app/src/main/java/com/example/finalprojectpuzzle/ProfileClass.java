package com.example.finalprojectpuzzle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.util.Patterns;
import android.app.DialogFragment;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

import java.util.regex.Pattern;

import android.app.DatePickerDialog;

import android.widget.DatePicker;


import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.Toast;

import com.example.finalprojectpuzzle.databinding.ActivityProfileClassBinding;

public class ProfileClass extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private static int date;
    private DatePickerDialog datePickerDialog;
    final int Female = R.id.rb_female;
    final int Male = R.id.rb_male;
    String Gender;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    ActivityProfileClassBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileClassBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        editor = sharedPreferences.edit();
       binding.Wrong.setText("عدد الاجابات الخاطئة "+String.valueOf(sharedPreferences.getInt("WrongAnswer",0)));
        binding.tru.setText("عدد الاجابات الصحيحة "+String.valueOf(sharedPreferences.getInt("CorrectAnswer",0)));
binding.numberlevel.setText("عدد المراحل التي تجاوزتها هي "+String.valueOf(sharedPreferences.getInt("PersonLevel",0)));
binding.numberQustion.setText("عدد الاسئلة التي قمت بحلها "+String.valueOf(sharedPreferences.getInt("PersonQuestion",0)));
        MyViewModel myViewModel = new ViewModelProvider(this).get(MyViewModel.class);
        Person person = new Person("biannassar", "bn3@smail.ucas.edu.ps", "palestine", "10/7/2003", "Female");
        binding.tvUsername.setText(person.getFullName());
        binding.tvBirthdate.setText(person.getDateOfBirth());
        binding.tvEmail.setText(person.getEmail());

        binding.editUsername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.etUname2.setVisibility(View.VISIBLE);

            }
        });
        binding.editEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.etEmail2.setVisibility(View.VISIBLE);
            }
        });
        myViewModel.insertPerson(person);
        binding.btnSave2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (validateEmailAddress(binding.etEmail2) && validateusername(binding.etUname2)) {

                    String Birthdate = binding.tvBirthdate.getText().toString();
                    String UserName = binding.etUname2.getText().toString();
                    String email = binding.etEmail2.getText().toString();
                    String country = String.valueOf(binding.spinner2.getTextAlignment());
                    binding.etUname2.setVisibility(View.GONE);
                    binding.etEmail2.setVisibility(View.GONE);
                    binding.tvEmail.setText(email);
                    binding.tvUsername.setText(UserName);

                    binding.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup radioGroup, int i) {
                            switch (i) {
                                case Female:
                                    String Female = binding.rbFemale.getText().toString();
                                    Gender = Female;
                                    break;
                                case Male:
                                    String Male = binding.rbMale.getText().toString();
                                    Gender = Male;
                                    break;
                            }
                            Person person1 = new Person(UserName, email, country, Birthdate, Gender);
                            Log.d("Gender", Gender);
                            myViewModel.insertPerson(person1);}});
                } else {
                    Toast.makeText(ProfileClass.this, "Please fill the fields.", Toast.LENGTH_SHORT).show();
                }

            }
        }
        );


        initDatePicker();


        binding.rbMale.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                    Toast.makeText(ProfileClass.this, "checked" + binding.rbMale.getText().toString(), Toast.LENGTH_SHORT).show();
                else {
                    Toast.makeText(ProfileClass.this, "un checked" + binding.rbMale.getText().toString(), Toast.LENGTH_SHORT).show();

                }

            }
        });
        binding.rbFemale.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                    Toast.makeText(ProfileClass.this, "checked" + binding.rbFemale.getText().toString(), Toast.LENGTH_SHORT).show();
                else {
                    Toast.makeText(ProfileClass.this, "un checked" + binding.rbFemale.getText().toString(), Toast.LENGTH_SHORT).show();

                }

            }
        });


        binding.tvBirthdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment datePicker = new DatepickerFragment();
                datePicker.show(ProfileClass.this.getFragmentManager(), "date Picker");
            }
        });

    }


    private void initDatePicker() {
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        date = Calendar.getInstance().get(Calendar.YEAR) - year;
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());
        binding.tvBirthdate.setText(currentDateString);
    }


    private boolean validateEmailAddress(EditText etEmail) {
        String emailinput = binding.etEmail2.getText().toString();
        if (!emailinput.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailinput).matches()) {
            Toast.makeText(this, "Email Validated Successfully!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Invalid Email Address", Toast.LENGTH_SHORT).show();
            return false;
        }

    }


    private boolean validateusername(EditText username) {
        String Username = binding.etUname2.getText().toString().trim();

        if (Username.isEmpty()) {
            binding.etUname2.setError("Field can't be empty");
            return false;


        } else {

            binding.etUname2.setError(null);
            return true;
        }


    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        outState.putString("username", binding.etUname2.getText().toString());
        super.onSaveInstanceState(outState, outPersistentState);
    }


    @Override
    public void onRestoreInstanceState(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        String username = savedInstanceState.getString("username");
        binding.etUname2.setText(username);
        super.onRestoreInstanceState(savedInstanceState, persistentState);

    }

    public static int age() {
        return date;
    }


}