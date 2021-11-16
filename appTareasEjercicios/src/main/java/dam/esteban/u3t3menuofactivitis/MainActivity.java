package dam.esteban.u3t3menuofactivitis;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

import dam.esteban.u3t3menuofactivitis.Model.Item;

public class MainActivity extends AppCompatActivity implements  MyAdapter.OnItemClickListener {
    //Esteban
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    // private String [] myDataSet= {"Activity1", "Activity2", "Activity3"};

    ArrayList<Item> datos = new ArrayList<>();
    Button btADD, btDelAll, btRestore;
    ImageView imagenVacio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUI();
    }

    private void setUI() {
        //TODO: Añadiomos los datos
        this.insertarDatos();
        imagenVacio= findViewById(R.id.imagenVacio);

        recyclerView = findViewById(R.id.recyclerViewActivitis);
        //Bloqueamos el tamaño
        recyclerView.setHasFixedSize(true);

        //Añadimos al recycler un layout

        layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        //Añadimos el adapatador al recycler

        mAdapter = new MyAdapter(datos, this);

        //Añadimo el drag al card
        new ItemTouchHelper(itemTouch).attachToRecyclerView(recyclerView);

        recyclerView.setAdapter(mAdapter);

        //TODO: Añadimos funcionalidad a los botones
        btADD = findViewById(R.id.btAdd);
        btDelAll = findViewById(R.id.btDeleteAll);
        btRestore = findViewById(R.id.btRestore);

        btADD.setOnClickListener(v -> addOne());
        btDelAll.setOnClickListener(v -> dellAll());
        btRestore.setOnClickListener(v -> restore());


    }

    @Override
    public void onItemClick(Item item) {
        //  Toast.makeText(this, activityName, Toast.LENGTH_SHORT).show();

        startActivity(new Intent(this, ItemDelailActivity.class).putExtra("item", item));

    }

    public void insertarDatos() {

        datos.add(new Item(R.drawable.android3, 3.1f, "HoneyComb", 2011, 12, "https://es.wikipedia.org/wiki/Android_Honeycomb"));
        datos.add(new Item(R.drawable.android4, 4.0f, "Ice Cream Sandwich", 2011, 15, "https://es.wikipedia.org/wiki/Android_Ice_Cream_Sandwich"));
        datos.add(new Item(R.drawable.android4_1, 4.4f, "KitKat", 2013, 20, "https://es.wikipedia.org/wiki/Android_KitKat"));
        datos.add(new Item(R.drawable.android5, 5.0f, "Lollipop", 2014, 22, "https://es.wikipedia.org/wiki/Android_Lollipop"));
        datos.add(new Item(R.drawable.android6, 6.0f, "Marshmallow", 2015, 23, "https://es.wikipedia.org/wiki/Android_Marshmallow"));
        datos.add(new Item(R.drawable.android7, 7.0f, "Nougat", 2016, 25, "https://es.wikipedia.org/wiki/Android_Nougat"));
        datos.add(new Item(R.drawable.android8, 8.0f, "Oreo", 2017, 27, "https://es.wikipedia.org/wiki/Android_Oreo"));
        datos.add(new Item(R.drawable.android9, 9.0f, "Pie", 2018, 28, "https://es.wikipedia.org/wiki/Android_Pie"));
    }

    public void addOne() {

        datos.add(new Item(R.drawable.android3, 1.0f, "NuevoADD", 2021, 1, "https://es.wikipedia.org/wiki/Android"));
        mAdapter.notifyDataSetChanged();
        recyclerView.smoothScrollToPosition(datos.size());
        imagenVacio.setVisibility(View.INVISIBLE);

    }

    public void dellAll() {
        datos.clear();
        mAdapter.notifyDataSetChanged();
        imagenVacio.setVisibility(View.VISIBLE);
    }

    public void restore() {
        datos.clear();
        insertarDatos();
        mAdapter.notifyDataSetChanged();
        imagenVacio.setVisibility(View.INVISIBLE);
    }

    ItemTouchHelper.SimpleCallback itemTouch = new ItemTouchHelper.SimpleCallback(0,  ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            datos.remove(viewHolder.getAdapterPosition());
            mAdapter.notifyDataSetChanged();

            if (datos.size()==0){
                imagenVacio.setVisibility(View.VISIBLE);
            }else{
                imagenVacio.setVisibility(View.INVISIBLE);
            }
        }
    };


}