package dam.esteban.u3t3menuofactivitis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

import dam.esteban.u3t3menuofactivitis.Model.Item;

public class MainActivity extends AppCompatActivity implements  MyAdapter.OnItemClickListener {
//Esteban
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

   // private String [] myDataSet= {"Activity1", "Activity2", "Activity3"};

    ArrayList<Item> datos= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUI();
    }

    private void setUI(){
        //TODO: Añadiomos los datos
        this.insertarDatos();

        recyclerView = findViewById(R.id.recyclerViewActivitis);
        //Bloqueamos el tamaño
        recyclerView.setHasFixedSize(true);

        //Añadimos al recycler un layout

        layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        //Añadimos el adapatador al recycler

        mAdapter = new MyAdapter(datos, this);
        recyclerView.setAdapter(mAdapter);

    }

    @Override
    public void onItemClick(Item item)  {
      //  Toast.makeText(this, activityName, Toast.LENGTH_SHORT).show();

            startActivity(new Intent(this, ItemDelailActivity.class).putExtra("item", item));

    }

    public void insertarDatos(){

        datos.add(new Item(R.drawable.android3, 3.1f, "HoneyComb", 2011, 12, "https://es.wikipedia.org/wiki/Android_Honeycomb"));
        datos.add(new Item(R.drawable.android4, 4.0f, "Ice Cream Sandwich", 2011, 15, "https://es.wikipedia.org/wiki/Android_Ice_Cream_Sandwich"));
        datos.add(new Item(R.drawable.android4_1, 4.4f, "KitKat", 2013, 20, "https://es.wikipedia.org/wiki/Android_KitKat"));
        datos.add(new Item(R.drawable.android5, 5.0f, "Lollipop", 2014, 22, "https://es.wikipedia.org/wiki/Android_Lollipop"));
        datos.add(new Item(R.drawable.android6, 6.0f, "Marshmallow", 2015, 23, "https://es.wikipedia.org/wiki/Android_Marshmallow"));
        datos.add(new Item(R.drawable.android7, 7.0f, "Nougat", 2016, 25, "https://es.wikipedia.org/wiki/Android_Nougat"));
        datos.add(new Item(R.drawable.android8, 8.0f, "Oreo", 2017, 27, "https://es.wikipedia.org/wiki/Android_Oreo"));
        datos.add(new Item(R.drawable.android9, 9.0f, "Pie", 2018, 28, "https://es.wikipedia.org/wiki/Android_Pie"));
    }

}