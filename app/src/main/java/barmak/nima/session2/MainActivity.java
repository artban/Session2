package barmak.nima.session2;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnCalc, btnWeb, btnCall, btnLocation;
    TextView tvAnswer;
    EditText etNum1, etNum2;

    int number1 = 0, number2 = 0, answer = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number1 = Integer.parseInt(etNum1.getText().toString());
                number2 = Integer.parseInt(etNum2.getText().toString());
                answer = number1 + number2;
                tvAnswer.setText(answer + "");
            }
        });

        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("http://paniz.net/"));
                startActivity(intentWeb);
            }
        });

        btnLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLocation = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:31.3216767,48.6839702"));
                startActivity(intentLocation);
            }
        });

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+9806132202003"));
                startActivity(intentCall);
            }
        });

    }


    void init() {
        btnCalc = (Button) findViewById(R.id.btn_cal);
        btnCall = (Button) findViewById(R.id.btn_call);
        btnLocation = (Button) findViewById(R.id.btn_location);
        btnWeb = (Button) findViewById(R.id.btn_website);
        tvAnswer = (TextView) findViewById(R.id.tv_ans);
        etNum1 = (EditText) findViewById(R.id.et_num1);
        etNum2 = (EditText) findViewById(R.id.et_num2);
    }
}
