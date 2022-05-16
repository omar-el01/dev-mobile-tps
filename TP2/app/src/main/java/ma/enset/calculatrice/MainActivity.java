package ma.enset.calculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.google.android.material.textfield.TextInputLayout;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import net.objecthunter.exp4j.ValidationResult;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    private  Button divbt, multbt, susbt, plusbt, equalbt,delbt,floatbt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.et_calc);


        btn0 = (Button) findViewById( R.id.bt_0 );
        btn1 = (Button) findViewById( R.id.bt_1 );
        btn2 = (Button) findViewById( R.id.bt_2);
        btn3 = (Button) findViewById( R.id.bt_3 );
        btn4 = (Button) findViewById( R.id.bt_4 );
        btn5 = (Button) findViewById( R.id.bt_5 );
        btn6 = (Button) findViewById( R.id.bt_6 );
        btn7 = (Button) findViewById( R.id.bt_7 );
        btn8 = (Button) findViewById( R.id.bt_8 );
        btn9 = (Button) findViewById( R.id.bt_9 );


        divbt = (Button) findViewById( R.id.bt_div);
        multbt = (Button) findViewById( R.id.bt_man);
        susbt = (Button) findViewById( R.id.bt_min );
        plusbt = (Button) findViewById( R.id.bt_pls );
        equalbt= (Button) findViewById( R.id.bt_result );
        delbt = (Button) findViewById( R.id.bt_clear);
        floatbt =(Button) findViewById(R.id.bt_dot);



        View.OnClickListener basicClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button b = (Button) view;
                editText.setText( editText.getText().toString()+ b.getText().toString() );
            }
        };
        btn0.setOnClickListener( basicClickListener );
        btn1.setOnClickListener( basicClickListener );
        btn2.setOnClickListener( basicClickListener );
        btn3.setOnClickListener( basicClickListener );
        btn4.setOnClickListener( basicClickListener );
        btn5.setOnClickListener( basicClickListener );
        btn6.setOnClickListener( basicClickListener );
        btn7.setOnClickListener( basicClickListener );
        btn8.setOnClickListener( basicClickListener );
        btn9.setOnClickListener( basicClickListener );
        divbt.setOnClickListener( basicClickListener );
        multbt.setOnClickListener( basicClickListener );
        susbt.setOnClickListener( basicClickListener );
        plusbt.setOnClickListener( basicClickListener );
        floatbt.setOnClickListener(basicClickListener);

delbt.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Button b = (Button) view;
        editText.setText("");
        editText.setVisibility(View.GONE);
        editText.setVisibility(View.GONE);
    }
});
        equalbt.setOnClickListener( view -> {
            try{
                Expression e = new ExpressionBuilder( editText.getText().toString() ).build();
                ValidationResult res = e.validate();
                if( res.isValid() ){
                    editText.setVisibility(View.GONE);
                    editText.setText( e.evaluate()+"" );
                    editText.setVisibility(View.VISIBLE);
                }else{
                    editText.setVisibility(View.GONE);
                    editText.setText( "" );
                    editText.setVisibility(View.VISIBLE);
                }
            }catch(Exception exc){
                editText.setVisibility(View.GONE);
                editText.setText( "" );
                editText.setVisibility(View.VISIBLE);
            }
        } );

    }
}