package com.example.spaceghost.recipefragments.adapters;

import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.spaceghost.recipefragments.R;
import com.example.spaceghost.recipefragments.data.IngredientsData;
import com.example.spaceghost.recipefragments.models.Ingredient;

import java.util.List;

/**
 * Created by adacher on 31-05-17.
 */

public class IngredientAdapter extends RecyclerView.Adapter<IngredientAdapter.ViewHolder> {

    private List<Ingredient> ingredients;


    public IngredientAdapter(int position) {

        ingredients = new IngredientsData().byPosition(position);

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_ingredient, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Ingredient ingredient = ingredients.get(position);
        holder.textView.setText(ingredient.getName());
        CheckBox checkBox = holder.status;
        checkBox.setChecked(ingredient.isStatus());

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                int auxPosition = holder.getAdapterPosition();
                Ingredient auxIngredient = ingredients.get(holder.getAdapterPosition());
                auxIngredient.setStatus(isChecked);
                auxIngredient.save();
                ingredients.set(auxPosition, auxIngredient);
                new Handler().post(new Runnable() {
                    @Override
                    public void run() {
                        notifyItemChanged(holder.getAdapterPosition());
                    }
                });


            }
        });


    }

    @Override
    public int getItemCount() {
        return ingredients.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        CheckBox status;
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);

            status = (CheckBox) itemView.findViewById(R.id.ingredientCb);
            textView = (TextView) itemView.findViewById(R.id.ingredientTv);


        }

    }

}
