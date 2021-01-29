package kz.course.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    Button btnOshiru, btnPlusMinus, btnPlus, btnMinus, btnX, btnBolu, btnTen;
    TextView tvSan, tvZapis;

    String birinshiSan, ekisnshiSan, znak, zapisText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        sandarMethods();
        oshiruPlusMinusMethod();
        functionMethod();

    }

    public void initViews(){

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btnOshiru = findViewById(R.id.btnOshiru);
        btnPlusMinus = findViewById(R.id.btnPlusMinus);

        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);

        btnX = findViewById(R.id.btnX);
        btnBolu = findViewById(R.id.btnBolu);
        btnTen = findViewById(R.id.btnTen);

        tvSan = findViewById(R.id.tv_san);
        tvZapis = findViewById(R.id.tv_zapis);
    }
    public void sandarMethods(){

        View.OnClickListener buttonSandar = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String aldingiSan = tvSan.getText().toString();
                String basilganSan = "";
                String songiResult = "";

                switch (view.getId()){
                    case R.id.btn0:
                        basilganSan =  "0";
                        break;
                    case R.id.btn1:
                        basilganSan =  "1";
                        break;
                    case R.id.btn2:
                        basilganSan =  "2";
                        break;
                    case R.id.btn3:
                        basilganSan =  "3";
                        break;
                    case R.id.btn4:
                        basilganSan =  "4";
                        break;
                    case R.id.btn5:
                        basilganSan =  "5";
                        break;
                    case R.id.btn6:
                        basilganSan =  "6";
                        break;
                    case R.id.btn7:
                        basilganSan =  "7";
                        break;
                    case R.id.btn8:
                        basilganSan =  "8";
                        break;
                    case R.id.btn9:
                        basilganSan =  "9";
                        break;
                }

                if(!aldingiSan.equals("0")) songiResult = aldingiSan + basilganSan;
                else songiResult = basilganSan;

                tvSan.setText(songiResult);
            }
        };

        btn0.setOnClickListener(buttonSandar);
        btn1.setOnClickListener(buttonSandar);
        btn2.setOnClickListener(buttonSandar);
        btn3.setOnClickListener(buttonSandar);
        btn4.setOnClickListener(buttonSandar);
        btn5.setOnClickListener(buttonSandar);
        btn6.setOnClickListener(buttonSandar);
        btn7.setOnClickListener(buttonSandar);
        btn8.setOnClickListener(buttonSandar);
        btn9.setOnClickListener(buttonSandar);
    }
    public void oshiruPlusMinusMethod(){

        View.OnClickListener buttonOwiruPlusMinus = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.btnOshiru:

                        tvSan.setText("0");
                        tvZapis.setText("");
                        break;

                    case R.id.btnPlusMinus:

                        String sanText = tvSan.getText().toString();
                        int san = Integer.parseInt(sanText);

                        if(san > 0) tvSan.setText("-"+sanText);

                        else{
                            san = san * (-1);
                            tvSan.setText(""+san);
                        }

                        break;

                }
            }
        };

        btnOshiru.setOnClickListener(buttonOwiruPlusMinus);
        btnPlusMinus.setOnClickListener(buttonOwiruPlusMinus);

    }
    public void functionMethod(){
        View.OnClickListener btnFunctions = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                birinshiSan = tvSan.getText().toString();

                switch (view.getId()){

                    case R.id.btnPlus:
                        znak = "+";
                        break;

                    case R.id.btnMinus:
                        znak = "-";
                        break;
                    case R.id.btnX:
                        znak = "*";
                        break;

                    case R.id.btnBolu:
                        znak = "/";
                        break;
                }

                zapisText = birinshiSan + znak;
                tvZapis.setText(zapisText);
                tvSan.setText("0");
            }
        };

        btnPlus.setOnClickListener(btnFunctions);
        btnMinus.setOnClickListener(btnFunctions);
        btnX.setOnClickListener(btnFunctions);
        btnBolu.setOnClickListener(btnFunctions);


        btnTen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ekisnshiSan = tvSan.getText().toString();
                int san1 = Integer.parseInt(birinshiSan);
                int san2 = Integer.parseInt(ekisnshiSan);
                int res = 0;

                if(znak.equals("+")){
                    res = san1 + san2;
                }else if(znak.equals("-")){
                    res = san1 - san2;
                }else if(znak.equals("*")){
                    res = san1 * san2;
                }else if(znak.equals("/")){
                    res = san1 / san2;
                }

                zapisText = birinshiSan + znak + ekisnshiSan + " = "+res;

                tvZapis.setText(zapisText);
                tvSan.setText(""+res);
            }
        });
    }
}