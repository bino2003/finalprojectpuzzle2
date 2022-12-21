package com.example.finalprojectpuzzle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.example.finalprojectpuzzle.databinding.ActivityRegisterClassBinding;

public class RegisterClass extends AppCompatActivity {
ActivityRegisterClassBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityRegisterClassBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        MyViewModel myViewModel= new ViewModelProvider(this).get(MyViewModel.class);

        binding.btnSave2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.etBirthdate2.getText().toString();
                binding.etEmail2.getText().toString();
                binding.etFirstname2.getText().toString();
                binding.etUname2.getText().toString();
                binding.etPass2.getText().toString();
            }
        });
    }
}