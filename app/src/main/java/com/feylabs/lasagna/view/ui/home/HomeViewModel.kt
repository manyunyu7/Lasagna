package com.feylabs.lasagna.view.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.feylabs.lasagna.data.LasagnaRepository

class HomeViewModel(repository: LasagnaRepository) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    val covidSummary = repository.getCovidDetail()
}