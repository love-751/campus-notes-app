package com.campusnotes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.campusnotes.databinding.ActivityMainBinding
import com.campusnotes.ui.UnitListAdapter
import com.campusnotes.viewmodel.NotesViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: NotesViewModel
    private lateinit var adapter: UnitListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize ViewModel
        viewModel = ViewModelProvider(this).get(NotesViewModel::class.java)

        // Setup RecyclerView
        adapter = UnitListAdapter()
        binding.unitsRecyclerView.adapter = adapter
        binding.unitsRecyclerView.layoutManager = LinearLayoutManager(this)

        // Observe units
        viewModel.allUnits.observe(this) { units ->
            adapter.submitList(units)
        }

        // Add Unit Button
        binding.addUnitBtn.setOnClickListener {
            showAddUnitDialog()
        }
    }

    private fun showAddUnitDialog() {
        // TODO: Implement dialog to add new unit
    }
}
