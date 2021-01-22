package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StepByStepRecyclerViewAdapter (private val stepList: List<StepByStep>) :
    RecyclerView.Adapter<StepByStepRecyclerViewAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titel: TextView

        val stepOneTitel: TextView
        val stepTwoTitel: TextView
        val stepThreeTitel: TextView
        val stepFourTitel: TextView

        val stepOneInstruction: TextView
        val stepTwoInstruction: TextView
        val stepThreeInstruction: TextView
        val stepFourInstruction: TextView

        val stepOneImage: ImageView
        val stepTwoImage: ImageView
        val stepThreeImage: ImageView
        val stepFourImage: ImageView



        init {
            // Define click listener for the ViewHolder's View.
            titel = view.findViewById(R.id.stepbysteptitel)

            stepOneTitel = view.findViewById(R.id.steponetitel)
            stepTwoTitel = view.findViewById(R.id.steptwotitel)
            stepThreeTitel = view.findViewById(R.id.stepthreetitel)
            stepFourTitel = view.findViewById(R.id.stepfourtitel)

            stepOneInstruction = view.findViewById(R.id.steponetext)
            stepTwoInstruction = view.findViewById(R.id.steptwotext)
            stepThreeInstruction = view.findViewById(R.id.stepthreetext)
            stepFourInstruction = view.findViewById(R.id.stepfourtext)

            stepOneImage = view.findViewById(R.id.steponeimage)
            stepTwoImage = view.findViewById(R.id.steptwoimage)
            stepThreeImage = view.findViewById(R.id.stepthreeimage)
            stepFourImage = view.findViewById(R.id.stepfourimage)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.stepbystep_list_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val currentItem = stepList[position]
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.titel.text = currentItem.titel

        viewHolder.stepOneTitel.text = currentItem.stepOneTitel
        viewHolder.stepTwoTitel.text = currentItem.stepTwoTitel
        viewHolder.stepThreeTitel.text = currentItem.stepThreeTitel
        viewHolder.stepFourTitel.text = currentItem.stepFourTitel

        viewHolder.stepOneInstruction.text = currentItem.stepOneText
        viewHolder.stepTwoInstruction.text = currentItem.stepTwoText
        viewHolder.stepThreeInstruction.text = currentItem.stepThreeText
        viewHolder.stepFourInstruction.text = currentItem.stepFourText

        viewHolder.stepOneImage.setImageResource(currentItem.stepOneImgRes)
        viewHolder.stepTwoImage.setImageResource(currentItem.stepTwoImgRes)
        viewHolder.stepThreeImage.setImageResource(currentItem.stepThreeImgRes)
        viewHolder.stepFourImage.setImageResource(currentItem.stepFourImgRes)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = stepList.size

}
