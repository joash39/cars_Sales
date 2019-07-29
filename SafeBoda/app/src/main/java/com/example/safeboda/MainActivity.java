package com.example.safeboda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText fname,lname;
    Button savebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fname = findViewById(R.id.edfname);
        lname = findViewById(R.id.edlname);
        savebtn = findViewById(R.id.btnsave);

        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstname = fname.getText().toString();
                String lastname = lname.getText().toString();

//                check if the user did not enter data
                if (firstname.isEmpty()){
                    Toast.makeText(MainActivity.this,"Firstname is required", Toast.LENGTH_SHORT).show();
                }else if (lastname.isEmpty()){
                    Toast.makeText(MainActivity.this,"Lastname is required", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this,"You are " + firstname + " " + lastname,Toast.LENGTH_SHORT).show();
                }
            }
        });


        //    grab the text view in the xml file using an id
        TextView endaAct2 = (TextView)findViewById(R.id.textviewhome);
//        Create/set a listener for a click on the view
        endaAct2.setOnClickListener(new View.OnClickListener() {
//            when the view is clicked!!!
            @Override
            public void onClick(View view) {
                Intent twendeSecondActivity = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(twendeSecondActivity);

            }
        });



        Button googlebtn = (Button)findViewById(R.id.btngoogle);
//        set a listener on the button
        googlebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Action to take place after setting up a listener
//                create a string variable to store the URL for google
                String url = "http://www.google.com";
//                validate the url to confirm if its ok
                Uri webaddress = Uri.parse(url);
//                create an Intent
//                ACTION_VIEW: checks if theres an application to open the url
                Intent goToGoogle = new Intent(Intent.ACTION_VIEW,webaddress);

                if (goToGoogle.resolveActivity(getPackageManager())!= null){
                    startActivity(goToGoogle);
                }



            }
        });
    }


}
