package com.example.numbershapes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    class Number{
        int number;

        public boolean isSquare(){
            double squareRoot=Math.sqrt(number);
            if(squareRoot==Math.floor(squareRoot))
            {
                return true;
            }
            else
            {
                return false;
            }
        }


        public boolean isTriangular(){

            int i=1;
            int triangularNumber=1;

            while(triangularNumber < number)
            {
                i++;
                triangularNumber+=i;
            }
            if(triangularNumber==number)
            {
                return true;
            }
            else
            {
                return false;
            }


        }

    }

    public void makeToast(String s){
        Toast.makeText(MainActivity.this,s,Toast.LENGTH_LONG).show();
    }


    public void testNumber(View view){

        EditText inputno=(EditText)findViewById(R.id.inputText);


        Log.i("userNumber",inputno.getText().toString());

        Number obj=new Number();
        obj.number= Integer.parseInt(inputno.getText().toString());

        String message="";
        if(obj.isSquare())
        {
            if(obj.isTriangular())
            {
                message=obj.number + "is both triangular and square";
                makeToast(message);
            }
            else
            {
                message=obj.number + "is square but not triangular";
                makeToast(message);
            }

        }
        else{
            if(obj.isTriangular())
            {
                message=obj.number + "is triangular but not square";
                makeToast(message);
            }
            else
            {
                message=obj.number + "is neither triangular nor square";
                makeToast(message);
            }
        }



    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
