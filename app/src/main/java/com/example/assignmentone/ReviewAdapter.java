package com.example.assignmentone;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.assignmentone.Model.Operation;

import java.util.List;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ViewHolder> {

    private List<Operation> operations;

    public ReviewAdapter(List<Operation> operations) {
        this.operations = operations;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_review,
                parent,
                false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Operation operation = operations.get(position);
        holder.bind(operation);
    }

    @Override
    public int getItemCount() {
        return operations.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView equationTextView;
        private TextView userAnswerTextView;
        private TextView correctAnswerTextView;

        public ViewHolder(@NonNull CardView itemView) {
            super(itemView);
            equationTextView = itemView.findViewById(R.id.equationTextView);
            userAnswerTextView = itemView.findViewById(R.id.userAnswerTextView);
            correctAnswerTextView = itemView.findViewById(R.id.correctAnswerTextView);
        }

        public void bind(Operation operation) {
            equationTextView.setText(operation.getEquation()); //user choice
            correctAnswerTextView.setText("Correct answer: " + operation.getCorrectChoice());
        }
    }
}