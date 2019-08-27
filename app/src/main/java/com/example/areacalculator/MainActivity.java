package com.example.areacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv_shape;
    private TextView tv_result;
    private Button button_calculate;
    private  Button button_clear;
    private ImageView iv_triangle;
    private ImageView iv_circle;
    private ImageView iv_square;
    private EditText ev_l1;
    private EditText ev_l2;
    private String selectedShape = "";
    Double length1= 0.0, length2 =0.0;
    String tempLength1, tempLength2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Area Calculator");

        ev_l1 = findViewById(R.id.length1);
        ev_l2 = findViewById(R.id.length2);
        tv_result = findViewById(R.id.textViewResult);
        tv_shape = findViewById(R.id.textSelection);
        button_calculate = findViewById(R.id.button_calculare);
        button_clear = findViewById(R.id.button_clear);
        iv_circle = findViewById(R.id.circle);
        iv_square = findViewById(R.id.square);
        iv_triangle = findViewById(R.id.triangle);

        this.clearButton();
        button_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearButton();
            }
        });
        ev_l1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                tempLength1 = ev_l1.getText().toString();
                if(tempLength1 !=null && !tempLength1.equals("")) {
                    length1 = Double.parseDouble(ev_l1.getText().toString());
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        ev_l2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                tempLength2 = ev_l2.getText().toString();
                if(tempLength2 !=null && !tempLength2.equals("")) {
                    length2 = Double.parseDouble(ev_l2.getText().toString());
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        button_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ev_l1.getText().toString().equals("")) {
                    ev_l1.setError("Hey I need a value");
                }

                if(ev_l2.getText().toString().equals("")) {
                    ev_l2.setError("Hey I need a value");
                }
                switch (selectedShape) {
                    case "triangle":
                        double result = 0.5*length1*length2;
                        tv_result.setText(result+"");
                        break;
                    case "square":
                        double resultsquare = length1*length1;
                        tv_result.setText(resultsquare+"");
                        break;
                    case "circle" :
                        double circleresult = 3.14*length1*length1;
                        tv_result.setText(circleresult+"");
                        break;
                }
            }
        });

        iv_triangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedShape = "triangle";
                tv_shape.setText("Triangle");
                ev_l1.setVisibility(View.VISIBLE);
                ev_l2.setVisibility(View.VISIBLE);
            }
        });

        iv_square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedShape = "square";
                tv_shape.setText("Square");
                ev_l1.setVisibility((View.VISIBLE));
                ev_l2.setVisibility(View.GONE);

            }
        });

        iv_circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedShape ="circle";
                tv_shape.setText("Circle");
                ev_l1.setVisibility((View.VISIBLE));
                ev_l2.setVisibility(View.GONE);
            }
        });

    }

    public  void clearButton() {
        ev_l1.setVisibility(View.VISIBLE);
        ev_l2.setVisibility(View.VISIBLE);
        ev_l1.setText("");
        ev_l2.setText("");
        tv_shape.setText("Select a shape");
        selectedShape = "";
        tv_result.setText("");
    }

}
