package dam.esteban.u3t3menuofactivitis;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import dam.esteban.u3t3menuofactivitis.Model.Item;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private OnItemClickListener listener;
    private ArrayList<Item> myDataSet;
    //Constructor para añadir los datos a la lista

    public MyAdapter(ArrayList<Item> myDataSet , OnItemClickListener listener) { this.myDataSet = myDataSet; this.listener=listener; }

    @Override
    public int getItemCount() {
        return myDataSet.size();
    }

    //Para verificar el tipo de view
    @Override
    public int getItemViewType(int position) {

        if (myDataSet.size()==0){
            return 1;
        }else{
            return 0;
        }

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //Creamos el item View:
        //Verificamos e el tipo de view para mostrar una vista o otra
        View vista;

        switch (viewType){
            case 1:
                vista= (View) LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.sindatos, parent, false);
                return new myEmptyHolder(vista);
            case 0:
            default:
                vista= (View) LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.card_view, parent, false);
                return new MyViewHolder(vista);
        }


    }



    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {


        switch (holder.getItemViewType()){
            case 1:
                myEmptyHolder emptyHolder= (myEmptyHolder) holder;
                emptyHolder.bind();
                break;

            case 0:
            default:
                MyViewHolder myHolder= (MyViewHolder) holder;
                myHolder.bind(myDataSet.get(position), listener);
                break;


        }

    }


    public interface OnItemClickListener{
        void onItemClick(Item item);
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView androidImage;
        TextView textApi;
        TextView textVersion;
        TextView textNombre;


        //Vista del card
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
            this.textVersion.setText(textVersion.getText()+Float.toString(item.getVersion()));
            this.textApi.setText(textApi.getText()+ Integer.toString(item.getNumeroApi()));
            this.textNombre.setText(item.getNombreVersion());

            this.androidImage.setOnClickListener(v -> listener.onItemClick(item));


            //   this.textView.setOnClickListener(v -> listener.onItemClick(textView.getText().toString()));
        }

    }

    static class myEmptyHolder extends  RecyclerView.ViewHolder{

        public myEmptyHolder(@NonNull View itemView) {
            super(itemView);
        }
        public void bind(){

        }
    }



}
