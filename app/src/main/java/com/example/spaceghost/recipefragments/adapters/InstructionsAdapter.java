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
import com.example.spaceghost.recipefragments.data.InstructionsData;
import com.example.spaceghost.recipefragments.models.Instruction;

import java.util.List;

/**
 * Created by adacher on 31-05-17.
 */

public class InstructionsAdapter extends RecyclerView.Adapter<InstructionsAdapter.ViewHolder> {

    private List<Instruction> instructions;

    public InstructionsAdapter(int position) {
        instructions = new InstructionsData().byPosition(position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_instruction, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Instruction instruction = instructions.get(position);
        holder.textView.setText(instruction.getName());
        CheckBox checkBox = holder.status;
        checkBox.setChecked(instruction.isStatus());
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                int auxPosition = holder.getAdapterPosition();
                Instruction auxInstruction = instructions.get(holder.getAdapterPosition());
                auxInstruction.setStatus(isChecked);
                auxInstruction.save();
                instructions.set(auxPosition, auxInstruction);
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
        return instructions.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        CheckBox status;
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);

            status = (CheckBox) itemView.findViewById(R.id.instructionCb);
            textView = (TextView) itemView.findViewById(R.id.instructionTv);


        }


    }
}
