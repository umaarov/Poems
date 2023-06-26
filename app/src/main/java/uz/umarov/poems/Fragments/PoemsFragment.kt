package uz.umarov.poems.Fragments

import android.Manifest
import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetDialog
import uz.umarov.poems.Adapters.Rv2Adapter
import uz.umarov.poems.Adapters.RvAdapter
import uz.umarov.poems.Models.PoemsData
import uz.umarov.poems.Objects.MyObject
import uz.umarov.poems.Objects.MySharedPreference
import uz.umarov.poems.R
import uz.umarov.poems.databinding.DialogItemBinding
import uz.umarov.poems.databinding.FragmentPoemsBinding

class PoemsFragment : Fragment() {
    private lateinit var binding: FragmentPoemsBinding
    private lateinit var rvAdapter: RvAdapter
    private lateinit var rv2Adapter: Rv2Adapter

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPoemsBinding.inflate(layoutInflater)
        val txt = arguments?.getString("poem")
        MySharedPreference.init(requireContext())

        when (txt) {
            "Yangi She'rlar" -> {
                binding.poemCategory.text = "YANGI\nSHE'RLAR"
                rvAdapter = RvAdapter(MyObject.new_poems, object : RvAdapter.ItemClick {
                    override fun isItemClick(poemsData: PoemsData) {
                        val bottomSheetDialog = BottomSheetDialog(requireContext(), R.style.SheetDialog)
                        val dialogBinding = DialogItemBinding.inflate(layoutInflater)
                        dialogBinding.poemName.text = poemsData.name
                        dialogBinding.poemDesc.text = poemsData.poem
                        bottomSheetDialog.setContentView(dialogBinding.root)
                        bottomSheetDialog.show()

                        dialogBinding.likeCard.setOnClickListener {
                            dialogBinding.favImage.setImageResource(R.drawable.like)
                            MyObject.fav_poems.add(poemsData)
                        }
                        dialogBinding.shareCard.setOnClickListener {
                            val message = poemsData.poem
                            val intent = Intent()
                            intent.action = Intent.ACTION_SEND
                            intent.putExtra(Intent.EXTRA_TEXT, message)
                            startActivity(Intent.createChooser(intent, "SHARE"))
                        }
                        dialogBinding.copyCard.setOnClickListener {
                            val clipboard =
                                requireActivity().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                            val clip = ClipData.newPlainText("TextView", poemsData.poem)
                            clipboard.setPrimaryClip(clip)
                            Toast.makeText(requireContext(), "Copied", Toast.LENGTH_SHORT).show()
                        }
                        dialogBinding.smsCard.setOnClickListener {
                            sendSmsText()
                            val sms = poemsData.poem
                            if (sms.isNotEmpty()) {
                                val smsIntent = Intent(Intent.ACTION_VIEW)
                                smsIntent.data = Uri.parse("sms:$sms")
                                startActivity(smsIntent)
                            }
                        }
                    }
                })
                binding.rv.adapter = rvAdapter
            }
            "Sevgi she'rlari" -> {
                binding.poemCategory.text = "SEVGI\nSHE'RLAR"
                rvAdapter = RvAdapter(MyObject.new_poems, object : RvAdapter.ItemClick {
                    override fun isItemClick(poemsData: PoemsData) {
                        val bottomSheetDialog = BottomSheetDialog(requireContext(), R.style.SheetDialog)
                        val dialogBinding = DialogItemBinding.inflate(layoutInflater)
                        dialogBinding.poemName.text = poemsData.name
                        dialogBinding.poemDesc.text = poemsData.poem
                        bottomSheetDialog.setContentView(dialogBinding.root)
                        bottomSheetDialog.show()

                        dialogBinding.likeCard.setOnClickListener {
                            dialogBinding.favImage.setImageResource(R.drawable.like)
                            MyObject.fav_poems.add(poemsData)
                        }
                        dialogBinding.shareCard.setOnClickListener {
                            val message = poemsData.poem
                            val intent = Intent()
                            intent.action = Intent.ACTION_SEND
                            intent.putExtra(Intent.EXTRA_TEXT, message)
                            startActivity(Intent.createChooser(intent, "SHARE"))
                        }
                        dialogBinding.copyCard.setOnClickListener {
                            val clipboard =
                                requireActivity().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                            val clip = ClipData.newPlainText("TextView", poemsData.poem)
                            clipboard.setPrimaryClip(clip)
                            Toast.makeText(requireContext(), "Copied", Toast.LENGTH_SHORT).show()
                        }
                        dialogBinding.smsCard.setOnClickListener {
                            sendSmsText()
                            val sms = poemsData.poem
                            if (sms.isNotEmpty()) {
                                val smsIntent = Intent(Intent.ACTION_VIEW)
                                smsIntent.data = Uri.parse("sms:$sms")
                                startActivity(smsIntent)
                            }
                        }
                    }
                })
                binding.rv.adapter = rvAdapter
            }
            "Krinj she'rlar" -> {
                binding.poemCategory.text = "SOG'INCH\nSHE'RLAR"
                rvAdapter = RvAdapter(MyObject.new_poems, object : RvAdapter.ItemClick {
                    override fun isItemClick(poemsData: PoemsData) {
                        val bottomSheetDialog = BottomSheetDialog(requireContext(), R.style.SheetDialog)
                        val dialogBinding = DialogItemBinding.inflate(layoutInflater)
                        dialogBinding.poemName.text = poemsData.name
                        dialogBinding.poemDesc.text = poemsData.poem
                        bottomSheetDialog.setContentView(dialogBinding.root)
                        bottomSheetDialog.show()

                        dialogBinding.likeCard.setOnClickListener {
                            dialogBinding.favImage.setImageResource(R.drawable.like)
                            MyObject.fav_poems.add(poemsData)
                        }
                        dialogBinding.shareCard.setOnClickListener {
                            val message = poemsData.poem
                            val intent = Intent()
                            intent.action = Intent.ACTION_SEND
                            intent.putExtra(Intent.EXTRA_TEXT, message)
                            startActivity(Intent.createChooser(intent, "SHARE"))
                        }
                        dialogBinding.copyCard.setOnClickListener {
                            val clipboard =
                                requireActivity().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                            val clip = ClipData.newPlainText("TextView", poemsData.poem)
                            clipboard.setPrimaryClip(clip)
                            Toast.makeText(requireContext(), "Copied", Toast.LENGTH_SHORT).show()
                        }
                        dialogBinding.smsCard.setOnClickListener {
                            sendSmsText()
                            val sms = poemsData.poem
                            if (sms.isNotEmpty()) {
                                val smsIntent = Intent(Intent.ACTION_VIEW)
                                smsIntent.data = Uri.parse("sms:$sms")
                                startActivity(smsIntent)
                            }
                        }
                    }
                })
                binding.rv.adapter = rvAdapter
            }
            "Saqlanganlar" -> {
                binding.poemCategory.text = "SAQLANGANLAR"
                rv2Adapter = Rv2Adapter(MyObject.new_poems, object : Rv2Adapter.ItemClick {
                    override fun isItemClick(poemsData: PoemsData) {
                        val bottomSheetDialog = BottomSheetDialog(requireContext(), R.style.SheetDialog)
                        val dialogBinding = DialogItemBinding.inflate(layoutInflater)
                        dialogBinding.poemName.text = poemsData.name
                        dialogBinding.poemDesc.text = poemsData.poem
                        bottomSheetDialog.setContentView(dialogBinding.root)
                        bottomSheetDialog.show()

                        dialogBinding.likeCard.setOnClickListener {
                            dialogBinding.favImage.setImageResource(R.drawable.like)
                            MyObject.fav_poems.add(poemsData)
                        }
                        dialogBinding.shareCard.setOnClickListener {
                            val message = poemsData.poem
                            val intent = Intent()
                            intent.action = Intent.ACTION_SEND
                            intent.putExtra(Intent.EXTRA_TEXT, message)
                            startActivity(Intent.createChooser(intent, "SHARE"))
                        }
                        dialogBinding.copyCard.setOnClickListener {
                            val clipboard =
                                requireActivity().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                            val clip = ClipData.newPlainText("TextView", poemsData.poem)
                            clipboard.setPrimaryClip(clip)
                            Toast.makeText(requireContext(), "Copied", Toast.LENGTH_SHORT).show()
                        }
                        dialogBinding.smsCard.setOnClickListener {
                            sendSmsText()
                            val sms = poemsData.poem
                            if (sms.isNotEmpty()) {
                                val smsIntent = Intent(Intent.ACTION_VIEW)
                                smsIntent.data = Uri.parse("sms:$sms")
                                startActivity(smsIntent)
                            }
                        }
                    }
                })
                binding.rv.adapter = rv2Adapter
            }
        }
        return binding.root
    }

    private fun sendSmsText() {
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.SEND_SMS
            ) != PackageManager.PERMISSION_DENIED
        ) {
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(Manifest.permission.RECEIVE_SMS),
                101
            )
        }
    }
}