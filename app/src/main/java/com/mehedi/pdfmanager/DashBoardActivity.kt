package com.mehedi.pdfmanager

import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class DashBoardActivity : AppCompatActivity() {
    private lateinit var pdfA:Button
    private var pdfUri:String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)

        pdfA = findViewById(R.id.pdfA)
        pdfA.setOnClickListener {
            val intent = Intent(this,PdfActivity::class.java)
            intent.putExtra("Uri","/storage/emulated/0/Download/_OceanofPDF.com_The_Alchemist.pdf")
            startActivity(intent)
            // /sdcard/Download/_OceanofPDF.com_The_Alchemist.pdf

        }
        val data: Uri? = this.intent?.data
        if (data !=null){
            println("data ->$data")
            pdfUri = getRealPathFromURI(this,data)
            println("pdfUri->$pdfUri")
            val intent = Intent(this,PdfActivity::class.java)
            intent.putExtra("Uri",pdfUri)
            startActivity(intent)

        }

    }
    private fun getRealPathFromURI(context: Context, contentUri: Uri?): String? {
        var cursor: Cursor? = null
        return try {
            val proj = arrayOf(MediaStore.Images.Media.DATA)
            cursor = context.contentResolver.query(contentUri!!, proj, null, null, null)
            val column_index = cursor!!.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
            cursor.moveToFirst()
            cursor.getString(column_index)
        } finally {
            cursor?.close()
        }
    }
}