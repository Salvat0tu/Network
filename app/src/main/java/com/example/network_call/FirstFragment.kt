package com.example.network_call

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.example.network_call.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private val dogViewModel: DogViewModel by activityViewModels()

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

        binding.getDog.setOnClickListener {
            dogViewModel.getImage()
        }
        dogViewModel.result.observe(viewLifecycleOwner) {
            getDogImg(it)

        }


    }

    private fun getDogImg(dog: DogImg) {
        binding.textviewSecond.text = dog.message

        context?.let { ctx ->
            Glide.with(ctx)
                .load(dog.message)
                .into(binding.img)
        }
    }

}