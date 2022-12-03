package com.devnunu.quickee.ui

import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

class MainViewModel : ContainerHost<MainState, MainSideEffect>, ViewModel() {

    override val container = container<MainState, MainSideEffect>(MainState(""))

}