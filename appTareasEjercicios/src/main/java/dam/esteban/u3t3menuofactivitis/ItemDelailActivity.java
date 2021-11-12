package dam.esteban.u3t3menuofactivitis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ItemDelailActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_delail);
        //TODO: Boton atras action bar ITEMDETAIL
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setUI();
    }

    public void setUI()
    {
        textView= findViewById(R.id.activityName);

        //TODO: Parametros pasados al ITEMDETAIL
        Bundle parametros = this.getIntent().getExtras();

        if (parametros!=null){
            textView.setText(parametros.getString("name"));
        }
    }



}