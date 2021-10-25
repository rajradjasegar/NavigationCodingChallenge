package raj.training.navdemocodingchallenge

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import raj.training.navdemocodingchallenge.databinding.FragmentNameBinding

/**
 * A simple [Fragment] subclass.
 * Use the [NameFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NameFragment : Fragment() {
    private lateinit var binding: FragmentNameBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_name, container, false)

        binding.usernameNextButton.setOnClickListener {
            if (!TextUtils.isEmpty(binding.usernameEditText.text.toString())) {
                val bundle = bundleOf("input_username" to binding.usernameEditText.text.toString())
                it.findNavController().navigate(R.id.action_nameFragment_to_emailFragment, bundle)
            } else {
                Toast.makeText(activity, " please put your name", Toast.LENGTH_LONG).show()
            }
        }

        return binding.root
    }

}