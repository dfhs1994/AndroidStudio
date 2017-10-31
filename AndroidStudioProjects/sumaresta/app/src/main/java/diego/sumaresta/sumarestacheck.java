package diego.sumaresta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class sumarestacheck extends AppCompatActivity {
    private EditText n1,n2;
    private TextView res;
    private CheckBox sumar,restar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sumarestacheck);
    }

}
