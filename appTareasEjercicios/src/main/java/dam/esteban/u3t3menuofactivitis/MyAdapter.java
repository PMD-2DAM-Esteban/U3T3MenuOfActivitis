package dam.esteban.u3t3menuofactivitis;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private OnItemClickListener listener;
    private  String[] myDataSet;
    //Constructor para añadir los datos a la lista

    public MyAdapter(String[] myDataSet , OnItemClickListener listener) { this.myDataSet = myDataSet; this.listener=listener; }

    static class MyViewHolder extends RecyclerView.ViewHolder{

            TextView textView;

        public MyViewHolder(TextView textView) {
            super(textView);
            this.textView=textView;
        }
        //añade al viewHolder con datos
        public void bind(String activityName, OnItemClickListener listener){
            this.textView.setText(activityName);

            this.textView.setOnClickListener(v -> listener.onItemClick(textView.getText().toString()));
        }

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //Creamos el item View:

        TextView tv = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.simple_list_item_1, parent, false);


        return new MyViewHolder(tv);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.bind(myDataSet[position], listener);
    }

    @Override
    public int getItemCount() {
        return myDataSet.length;
    }

    public interface OnItemClickListener{
        void onItemClick(String activityName);
    }



}
