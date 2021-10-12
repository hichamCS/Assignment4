package com.example.tipc2;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btn1 = (Button)findViewById(R.id.buttonCompute);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText checkAmount=(EditText)findViewById(R.id.checkAmountValue);
                EditText partySize=(EditText)findViewById(R.id.partySizeValue);

                if(TextUtils.isEmpty(checkAmount.getText()) || Long.valueOf(checkAmount.getText().toString())<0)
                {
                    toast("Empty or Incorrect Values For Amount");
                }

                else if(TextUtils.isEmpty(partySize.getText()) || Long.valueOf(partySize.getText().toString())<0)
                {
                    toast("Empty or Incorrect Values For Party Size");
                }
                else {


                    EditText fifteenPercentTip = (EditText) findViewById(R.id.fifteenPercentTipValue);
                    fifteenPercentTip.setText(String.valueOf(calCulateTip(Long.valueOf(partySize.getText().toString()), Long.valueOf(checkAmount.getText().toString()), 15)));

                    EditText twentyPercentTip = (EditText) findViewById(R.id.twentyPercentTipValue);
                    twentyPercentTip.setText(String.valueOf(calCulateTip(Long.valueOf(partySize.getText().toString()), Long.valueOf(checkAmount.getText().toString()), 20)));

                    EditText twentyFivePercentTip = (EditText) findViewById(R.id.twentyFivePercentTipValue);
                    twentyFivePercentTip.setText(String.valueOf(calCulateTip(Long.valueOf(partySize.getText().toString()), Long.valueOf(checkAmount.getText().toString()), 25)));


                    EditText fifteenPercentTotal = (EditText) findViewById(R.id.fifteenPercentTotalValue);
                    fifteenPercentTotal.setText(String.valueOf(calCulateTotal(Long.valueOf(partySize.getText().toString()), Long.valueOf(checkAmount.getText().toString()), 15)));

                    EditText twentyPercentTotal = (EditText) findViewById(R.id.twentyPercentTotalValue);
                    twentyPercentTotal.setText(String.valueOf(calCulateTotal(Long.valueOf(partySize.getText().toString()), Long.valueOf(checkAmount.getText().toString()), 20)));

                    EditText twentyFivePercentTotal = (EditText) findViewById(R.id.twentyFivePercentTotalValue);
                    twentyFivePercentTotal.setText(String.valueOf(calCulateTotal(Long.valueOf(partySize.getText().toString()), Long.valueOf(checkAmount.getText().toString()), 25)));
                }
            }
        });

    }



    private long calCulateTip(double totalPersons,double checkAmount,double percent)
    {

        return (long) Math.ceil(((checkAmount/totalPersons)*percent)/100);
    }

    private long calCulateTotal(double totalPersons,double checkAmount,double percent)
    {

        return (long) (Math.ceil(((checkAmount/totalPersons)*percent)/100)+checkAmount/totalPersons);
    }

    public void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}