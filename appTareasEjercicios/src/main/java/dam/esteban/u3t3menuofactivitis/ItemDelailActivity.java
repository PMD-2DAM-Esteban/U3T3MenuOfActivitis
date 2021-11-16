package dam.esteban.u3t3menuofactivitis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import dam.esteban.u3t3menuofactivitis.Model.Item;

public class ItemDelailActivity extends AppCompatActivity {
    private ImageView logo;
    private TextView nombre, api, numeroVersion , anyo;

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
        nombre= findViewById(R.id.itemNombre);
        api = findViewById(R.id.itemApi);
        numeroVersion= findViewById(R.id.itemVersionNum);
        anyo=findViewById(R.id.itemAnyo);

        logo=findViewById(R.id.itemImage);


        //TODO: Parametros pasados al ITEMDETAIL
        Item parametros = (Item) this.getIntent().getSerializableExtra("item");

        if (parametros!=null){
            nombre.setText(parametros.getNombreVersion());
            api.setText(api.getText()+ " "+ parametros.getNumeroApi());
            numeroVersion.setText(numeroVersion.getText() + " "+ parametros.getVersion());
            anyo.setText(anyo.getText() + " "+parametros.getAnyoLanzamiento());
            logo.setImageResource(parametros.getImagen());
        }
        //TODO: listener ITEMDetail abrir url
        logo.setOnClickListener(v -> abrirURl(parametros));

    }

    public void abrirURl(Item item){
        Intent intentWeb = new Intent();
        intentWeb.setAction(Intent.ACTION_VIEW);
        intentWeb.setData(Uri.parse(item.getUrl()));
        startActivity(intentWeb);


    }



}