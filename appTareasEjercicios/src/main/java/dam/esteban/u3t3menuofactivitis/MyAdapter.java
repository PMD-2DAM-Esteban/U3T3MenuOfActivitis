package dam.esteban.u3t3menuofactivitis;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import dam.esteban.u3t3menuofactivitis.Model.Item;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private OnItemClickListener listener;
    private ArrayList<Item> myDataSet;
    //Constructor para añadir los datos a la lista

    public MyAdapter(ArrayList<Item> myDataSet , OnItemClickListener listener) { this.myDataSet = myDataSet; this.listener=listener; }

    static class MyViewHolder extends RecyclerView.ViewHolder{
            ImageView androidImage;
            TextView textApi;
            TextView textVersion;
            TextView textNombre;

        public MyViewHolder(View view) {
            super(view);

            this.androidImage= view.findViewById(R.id.imageAndroid);
            this.textNombre = view.findViewById(R.id.textNombre);
            this.textApi= view.findViewById(R.id.textApi);
            this.textVersion = view.findViewById(R.id.textVersion);
        }
        //añade al viewHolder con datos
        public void bind(Item item, OnItemClickListener listener){
            this.androidImage.setImageResource(item.getImagen());
            this.textVersion.setText("Version: " + String.valueOf(item.getVersion()));
            this.textApi.setText("Api: " + String.valueOf(item.getNumeroApi()));
            this.textNombre.setText(item.getNombreVersion());

            this.androidImage.setOnClickListener(v -> listener.onItemClick(item));


         //   this.textView.setOnClickListener(v -> listener.onItemClick(textView.getText().toString()));
        }

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //Creamos el item View:

        View vista= (View) LayoutInflater.from(parent.getContext())
            .inflate(R.layout.card_view, parent, false);

        return new MyViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.bind(myDataSet.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return myDataSet.size();
    }

    public interface OnItemClickListener{
        void onItemClick(Item item);
    }





}
