package com.mehedi.pdfmanager.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.mehedi.pdfmanager.R
import com.mehedi.pdfmanager.model.Model

class PdfRecyclerAdapter(private val context: Context, private val itemList: ArrayList<Model>) :
    RecyclerView.Adapter<PdfRecyclerAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val itemPdf: ImageView = itemView.findViewById(R.id.imageView)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.single_page_pdf_view, parent, false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pdf = itemList[position]
        holder.itemPdf.setImageBitmap(pdf.resPdf)
        println("resPdf ->${pdf.resPdf}")

    }

    override fun getItemCount(): Int {
        return itemList.size

    }

}