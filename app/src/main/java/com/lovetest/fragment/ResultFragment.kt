package com.lovetest.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.lovetest.R
import kotlinx.android.synthetic.main.fragment_result.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ResultFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ResultFragment : Fragment() {

    var option = -1;

    lateinit var navController : NavController


    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        option = arguments?.getInt("index")?:-1 // 앨비스 연산자 사용 ( 현재 option 변수는 Non-null 타입임
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false)

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ResultFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ResultFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        // 애가 하는 역할은 제목과 상세 결과를 세팅하는 것
        setResult(option)

        btn_home.setOnClickListener {
            navController.navigate(R.id.action_resultFragment_to_mainFragment)
        }
    }
    private fun setResult(option : Int) {
        when(option) {
            1 -> {
                tv_main.text = "You are a QUITTER!"
                tv_sub.text = "You cat let the person easily."
                //tv_main.setText() 와 같다
            }
            2 -> {
                tv_main.text = "You should focus on yourself."
                tv_sub.text = "You become really clingy to your ex."
            }
            3 -> {
                tv_main.text = "You should take it easy"
                tv_sub.text = "You can do crazy things no matter what it takes."
            }
            4 -> {
                tv_main.text = "You are pretty mature."
                tv_sub.text = "You can easily accept the break-up."
            }
        }
    }

}