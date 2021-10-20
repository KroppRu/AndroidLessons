package ru.startandroid.lesson019simplecalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etNum1;
    EditText etNum2;

    Button btnAdd;
    Button btnSub;
    Button btnMult;
    Button btnDiv;
    Button btnPow;
    Button btnSqrt;

    TextView tvResult;

    final int MENU_RESET_ID = 1;
    final int MENU_QUIT_ID = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //назначаем кнопки
        etNum1 = (EditText) findViewById(R.id.etNum1);
        etNum2 = (EditText) findViewById(R.id.etNum2);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMult = (Button) findViewById(R.id.btnMult);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnPow = (Button) findViewById(R.id.btnPow);
        btnSqrt = (Button) findViewById(R.id.btnSqrt);

        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnPow.setOnClickListener(this);
        btnSqrt.setOnClickListener(this);

        tvResult = (TextView) findViewById(R.id.tvResult);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,MENU_RESET_ID,1,"Reset");
        menu.add(0,MENU_QUIT_ID,2,"Quit");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case MENU_QUIT_ID:
                finish();
                break;
            case MENU_RESET_ID:
                etNum1.setText("");
                etNum2.setText("");
                tvResult.setText("");
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

        float num1 = 0;
        float num2 = 0;
        float result = 0;
        String operator = "";

        if (TextUtils.isEmpty(etNum1.getText().toString())){
            etNum1.setText("0");
        }
        if (TextUtils.isEmpty(etNum2.getText().toString())){
            etNum2.setText("0");
        }

        num1 = Float.parseFloat(etNum1.getText().toString());
        num2 = Float.parseFloat(etNum2.getText().toString());

        switch (view.getId()){
            case R.id.btnAdd:
                result = num1 + num2;
                operator = "+";
                break;
            case R.id.btnSub:
                result = num1 - num2;
                operator = "-";
                break;
            case R.id.btnMult:
                result = num1 * num2;
                operator = "*";
                break;
            case R.id.btnDiv:
                if (num2 == 0){
                    Toast.makeText(this,"Division by zero",Toast.LENGTH_LONG).show();
                    return;
                }
                result = num1 / num2;
                operator = "/";
                break;
            case R.id.btnPow:
                result = (float) Math.pow(num1,num2);
                operator = "pow";
                break;
            case R.id.btnSqrt:
                result = (float) Math.sqrt(num1);
                num2 = 2;
                operator = "SQRT";
                break;
        }
        tvResult.setText("" + num1 + " " + operator + " " + num2 + " = " + result);
        etNum1.setText(Float.toString(result));
        etNum2.setText("0");
    }
}