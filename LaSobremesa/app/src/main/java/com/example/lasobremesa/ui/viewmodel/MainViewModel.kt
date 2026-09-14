// LaSobremesa
// estado de la pantalla principal de navegacion
//
package com.example.lasobremesa.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.lasobremesa.ui.components.BottomNavItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel : ViewModel() {
    private val _selectedTab = MutableStateFlow<BottomNavItem>(BottomNavItem.Home)
    val selectedTab: StateFlow<BottomNavItem> = _selectedTab

    fun selectTab(item: BottomNavItem) {
        _selectedTab.value = item
    }
}