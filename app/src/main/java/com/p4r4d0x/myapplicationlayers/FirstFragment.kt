package com.p4r4d0x.myapplicationlayers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.p4r4d0x.myapplicationlayers.databinding.FragmentFirstBinding
import com.p4r4d0x.myapplicationlayers.viewmodel.SomethingViewModel
import org.koin.android.ext.android.inject

class FirstFragment : Fragment() {

    private val viewModel: SomethingViewModel by inject()

    private var _binding: FragmentFirstBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getSomething()
        binding.buttonFirst.setOnClickListener {
            viewModel.getSomething()
        }
        observeViewModel()
    }

    private fun observeViewModel() {
        with(viewModel) {
            viewModel.somethingBoolean.observe(viewLifecycleOwner) {
                Toast.makeText(requireActivity(), "$it received", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}