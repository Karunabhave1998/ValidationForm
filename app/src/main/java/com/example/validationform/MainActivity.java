package com.example.validationform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    Button submitbtn;
    EditText username, email, mobno, password;
    String namestr, emailStr, mobstr, passStr;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       submitbtn = findViewById(R.id.submit_btn);
        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        mobno = findViewById(R.id.mobile);
        password = findViewById(R.id.password);

        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                namestr = username.getText().toString().trim();
                emailStr = email.getText().toString().trim();
                mobstr = mobno.getText().toString().trim();
                passStr = password.getText().toString().trim();




                Intent intent = new Intent(MainActivity.this,AActivity.class);
                intent.putExtra("uname",namestr);
                intent.putExtra("emailid",emailStr);
                intent.putExtra("mobnum",mobstr);
                intent.putExtra("password",passStr);
                startActivity(intent);



                if (null == namestr || namestr.length() == 0) {
                    username.setError("Enter Name");
                } else if (null == emailStr || emailStr.length() == 0) {

                    email.setError("Enter Email");
                } else if (!isValidEmailId(emailStr)) {
                    email.setError("Enter valid Email");
                }
                else
                    if (null == mobstr || mobstr.length() == 0) {
                    mobno.setError("Enter Mobile number");
                } else if (!(mobstr.length() == 10)) {
                    mobno.setError("Enter 10 digit mobile number");
                }else if (!isValidateMobileNumber(mobstr))
                    {
                        mobno.setError("Enter Valid Mobile Number");
                    }
                    else if (null == passStr || passStr.length() == 0) {
                    password.setError("Enter Password");
                } else if (passStr.length() < 8) {
                    password.setError("Enter minimum 8 character");
                }else if(!isValidePassword(passStr)){

                        password.setError("Enter Valid Password");
                    }

            }



        }

        );





    }

    public boolean isValidEmailId(String email) {
        return Pattern.compile("^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1,}|"
                + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$").matcher(email).matches();

    }

    public boolean isValidateMobileNumber(String mobno)
    {
           return Pattern.compile("(0/91)?[7-9][0-9]{9}").matcher(mobno).matches();
    }

    public boolean isValidePassword(String password)
    {
       return Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$").matcher(password).matches();

    }






}













