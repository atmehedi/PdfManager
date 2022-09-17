package com.mehedi.pdfmanager

import android.app.Dialog
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.commitNow

class PdfActivity :  AppCompatActivity() {
    companion object {
        const val FRAGMENT_INFO = "info"
    }
//    private val job = Job()
//    private val executor = Executors.newSingleThreadExecutor()
//    private val scope = CoroutineScope(executor.asCoroutineDispatcher() + job)
//
//    private var fileDescriptor: ParcelFileDescriptor? = null
//    private var pdfRenderer: PdfRenderer? = null
//    private var currentPage: PdfRenderer.Page? = null
//    private var cleared = false
//    private lateinit var image:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf)

       // image=findViewById(R.id.image)

        if (savedInstanceState == null) {
            supportFragmentManager.commitNow {
                replace(R.id.container, PdfRendererBasicFragment())
            }


        }

      //  //private val scope = CoroutineScope(executor.asCoroutineDispatcher() + job)
//        scope.launch {
//            openPdfRenderer()
//            showPage(0)
//
//        }


    }

//    private fun showPage(index: Int) {
//        currentPage?.let { page ->
//            currentPage = null
//            page.close()
//        }
//        pdfRenderer?.let { renderer ->
//            val page = renderer.openPage(index).also {
//                currentPage = it
//            }
//             val bitmap = Bitmap.createBitmap(page.width, page.height, Bitmap.Config.ARGB_8888)
//            page.render(bitmap, null, null, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY)
////            _pageBitmap.postValue(bitmap)
////            val count = renderer.pageCount
////            _pageInfo.postValue(index to count)
////            _previousEnabled.postValue(index > 0)
////            _nextEnabled.postValue(index + 1 < count)
//            runOnUiThread(Runnable {
//                image.setImageBitmap(bitmap)
//            })
//
//        }
//
//    }

//    private fun openPdfRenderer() {
//        fileDescriptor = ParcelFileDescriptor
//            .open(
//                File("/storage/emulated/0/Download/wpiea2021278-print-pdf.pdf")
//                , ParcelFileDescriptor.MODE_READ_ONLY).also {
//                pdfRenderer = PdfRenderer(it)
//            }
//    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_info -> {
                InfoFragment().show(supportFragmentManager, FRAGMENT_INFO)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    class InfoFragment : DialogFragment() {
        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
            return AlertDialog.Builder(requireContext())
                .setMessage(R.string.intro_message)
                .setPositiveButton(android.R.string.ok, null)
                .show()
        }


    }
}