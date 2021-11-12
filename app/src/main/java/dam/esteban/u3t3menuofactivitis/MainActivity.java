package dam.esteban.u3t3menuofactivitis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements  MyAdapter.OnItemClickListener {
//Esteban
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private String [] myDataSet= {"Activity1", "Activity2", "Activity3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUI();
    }

    private void setUI(){
        recyclerView = findViewById(R.id.recyclerViewActivitis);
        //Bloqueamos el tamaño
        recyclerView.setHasFixedSize(true);

        //Añadimos al recycler un layout

        layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        //Añadimos el adapatador al recycler

        mAdapter = new MyAdapter(myDataSet, this);
        recyclerView.setAdapter(mAdapter);

    }

    @Override
    public void onItemClick(String activityName) {
        Toast.makeText(this, activityName, Toast.LENGTH_SHORT).show();
        try {
            startActivity(new Intent(this, Class.forName(getPackageName()+ "."+activityName)));
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

    }
}