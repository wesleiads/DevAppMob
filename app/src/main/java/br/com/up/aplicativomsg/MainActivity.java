package br.com.up.aplicativomsg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout inputLayoutNumber;
    private TextInputLayout inputLayoutMsg;
    private TextInputEditText inputEditTextNumber;
    private TextInputEditText inputEditTextMsg;
    private Button buttonSend;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        inputLayoutNumber = findViewById(R.id.input_layout_Number);
        inputLayoutMsg = findViewById(R.id.input_layout_Msg);
        inputEditTextNumber = findViewById(R.id.input_text_Number);
        inputEditTextMsg = findViewById(R.id.input_text_Msg);

        buttonSend = findViewById(R.id.button_action);
        buttonSend.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {openLink();
            }
        });
    }

    private void openLink()
    {

        String msg = inputEditTextMsg.getText().toString();
        String number = inputEditTextNumber.getText().toString();

        Uri webpage = Uri.parse("https://api.whatsapp.com/send/?phone="+ number+"&text="+msg);
        Intent webIntent = new Intent(Intent.ACTION_VIEW,webpage);

        startActivity(webIntent);
    }

}