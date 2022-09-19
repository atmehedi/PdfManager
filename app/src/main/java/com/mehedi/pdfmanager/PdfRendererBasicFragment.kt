package com.mehedi.pdfmanager
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels


class PdfRendererBasicFragment : Fragment(R.layout.fragment_pdf_renderer_basic) {

    private val viewModel: PdfRendererBasicViewModel by viewModels()
    private var UriPdf: String? = "null"

    @SuppressLint("StringFormatInvalid")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // View references.
        val image: ImageView = view.findViewById(R.id.image)
        val buttonPrevious: Button = view.findViewById(R.id.previous)
        val buttonNext: Button = view.findViewById(R.id.next)


        // Bind data.
        viewModel.pageInfo.observe(viewLifecycleOwner) { (index, count) ->
            activity?.title = getString(R.string.name, index + 1, count)
        }

        viewModel.intentHandle(requireActivity().intent)

        viewModel.pageBitmap.observe(viewLifecycleOwner) { image.setImageBitmap(it) }
        viewModel.previousEnabled.observe(viewLifecycleOwner) {
            buttonPrevious.isEnabled = it
        }
        viewModel.nextEnabled.observe(viewLifecycleOwner) {
            buttonNext.isEnabled = it
        }

        // Bind events.
        buttonPrevious.setOnClickListener { viewModel.showPrevious() }
        buttonNext.setOnClickListener { viewModel.showNext() }


       // viewModel.recycle(view,requireContext())


    }

}