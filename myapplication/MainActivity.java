package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText name1,email1,address1,zip1,password1;
    Button submit;
    String name,email,address,zip,password;
    FirebaseAuth Auth;
    TextView login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseApp.initializeApp(this);
        Auth=FirebaseAuth.getInstance();

        name1=(EditText)findViewById(R.id.Name);
        email1=(EditText)findViewById(R.id.email);
        address1=(EditText)findViewById(R.id.address);
        zip1=(EditText)findViewById(R.id.zip);
        password1=(EditText)findViewById(R.id.password);
        submit=(Button) findViewById(R.id.submit);
        login=(TextView)findViewById(R.id.login);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name=String.valueOf(name1.getText());
                address=String.valueOf(address1.getText());
                zip=String.valueOf(zip1.getText());
                email=String.valueOf(email1.getText());
                password=String.valueOf(password1.getText());
                getuser();

            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    public void getuser()
    {
        if(name.isEmpty())
        {
            name1.setError("This field is required");
        }
        else if(email.isEmpty())
        {
            email1.setError("This field is required");
        }
        else if(!isEmailValid(email))
        {
            email1.setError("Incorrect Email");
        }
        else if(address.isEmpty())
        {
            address1.setError("This field is required");
        }
        else if(zip.isEmpty())
        {
            zip1.setError("This field is required");
        }
        else if(password.isEmpty())
        {
            password1.setError("This field is required");
        }
        else if(!isPasswordValid(password))
        {
            password1.setError("password length should be more than 4");
        }
        else
        {
            Auth=FirebaseAuth.getInstance();
            Auth.createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if(task.isSuccessful())
                            {
                                Toast.makeText(getApplicationContext(),"successfull",Toast.LENGTH_SHORT).show();
                            }
                            else
                                Toast.makeText(getApplicationContext(),"not successfull",Toast.LENGTH_SHORT).show();
                        }
                    });
        }


    }

    private boolean isEmailValid(String email) {
        if(email.contains("@gmail.com"))
        {
           return true;
        }
        else
            return false;
    }

    private boolean isPasswordValid(String password) {

        return password.length() > 4;
    }
}
