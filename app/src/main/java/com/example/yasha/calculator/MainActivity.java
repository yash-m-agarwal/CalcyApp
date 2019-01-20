package com.example.yasha.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Button one, two, three, four, five, six, seven, eight, nine, zero;
    private Button decimal, add, sub, multiply, divide, equal, clear;

    private ImageButton backspace;

    private TextView result, info;

    private int val1=0;
    private int val2=0;
    private int answer=0;

    private char operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeUIViews();

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString() + "0");
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString() + "1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString() + "2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString() + "3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString() + "4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString() + "5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString() + "6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString() + "7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString() + "8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString() + "9");
            }
        });

        decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString() + ".");
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //compute();
                //ACTION = ADDITION;
                info.setText(info.getText() + "+");
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //compute();
                //ACTION = SUBTRACTION;
                info.setText(info.getText() + "-");
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //compute();
                //ACTION = MULTIPLICATION;
                info.setText(info.getText() + "*");
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //compute();
                //ACTION = DIVISION;
                info.setText(info.getText() + "/");
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ACTION = EQU;
                compute();
                result.setText("=" + String.valueOf(answer));
                //info.setText(null);
            }
        });

        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(info.getText().length() > 0)
                {
                    CharSequence name = info.getText().toString();
                    info.setText(name.subSequence(0, name.length()-1));
                }
                else
                {
                    val1 = 0;
                    val2 = 0;
                    info.setText(null);
                    result.setText(null);
                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                val1 = 0;
                val2 = 0;
                info.setText(null);
                result.setText(null);
            }
        });

    }

    private void initializeUIViews()
    {
        zero = (Button)findViewById(R.id.btn0);
        one = (Button)findViewById(R.id.btn1);
        two = (Button)findViewById(R.id.btn2);
        three = (Button)findViewById(R.id.btn3);
        four = (Button)findViewById(R.id.btn4);
        five = (Button)findViewById(R.id.btn5);
        six = (Button)findViewById(R.id.btn6);
        seven = (Button)findViewById(R.id.btn7);
        eight = (Button)findViewById(R.id.btn8);
        nine = (Button)findViewById(R.id.btn9);

        add = (Button)findViewById(R.id.btnadd);
        sub = (Button)findViewById(R.id.btnsub);
        multiply = (Button)findViewById(R.id.btnmul);
        divide = (Button)findViewById(R.id.btndivide);

        decimal = (Button)findViewById(R.id.btndecimal);
        equal = (Button)findViewById(R.id.btnequal);

        clear = (Button)findViewById(R.id.btnclear);

        backspace = (ImageButton)findViewById(R.id.btnbackspace);

        result = (TextView)findViewById(R.id.answer);
        info = (TextView)findViewById(R.id.operation);
    }

    private void compute()
    {
        String str = info.getText().toString();
        char[] charArray = str.toCharArray();
        String v1 = "", v2 = "";
        int i, j;

        for(i=0; i<charArray.length; i++)
        {
            if(charArray[i]=='+' || charArray[i]=='-' || charArray[i]=='*' || charArray[i]=='/')
            {
                operator = charArray[i];
                i++;
                break;
            }
            v1 = v1 + String.valueOf(charArray[i]);
        }
        for(j=i; j<charArray.length; j++)
        {
            v2 = v2 + String.valueOf(charArray[i]);
        }

        val1 = Integer.parseInt(v1);
        val2 = Integer.parseInt(v2);

        if(operator=='+')
            answer = val1 + val2;
        if(operator=='-')
            answer = val1 - val2;
        if(operator=='*')
            answer = val1 * val2;
        if(operator=='/')
            answer = val1/val2;
    }

}