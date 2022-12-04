package com.devnunu.quickee.ui

import androidx.lifecycle.ViewModel
import com.devnunu.quickee.data.model.QuickeeItem
import com.devnunu.quickee.data.repository.ItemRepository
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

class MainViewModel(
    private val itemRepository: ItemRepository
) : ContainerHost<MainState, MainSideEffect>, ViewModel() {

    override val container = container<MainState, MainSideEffect>(MainState())

    init {
        start()
    }

    fun start() = intent {
        reduce {
            state.copy(
                itemList = itemRepository.getQuickeeInProgressItemList()
            )
        }
    }

    fun onChangeInputValue(inputValue: String) = intent {
        reduce {
            state.copy(inputValue = inputValue)
        }
    }

    /**
     * 클릭 이벤트 핸들러
     * */

    fun onClickDoneBtn() = intent {
        val itemList = state.itemList.toMutableList()
        val inputValue = state.inputValue
        if (!inputValue.isNullOrBlank()) {
            itemList.add(0, QuickeeItem(value = inputValue))
        } else {
            // TODO : error
        }

        reduce {
            state.copy(
                inputValue = "",
                itemList = itemList,
                selectedItem = null
            )
        }
    }

    fun onClickDeleteItem(item: QuickeeItem) = intent {
        val itemList = state.itemList.toMutableList()
        itemList.remove(item)
        reduce {
            state.copy(
                itemList = itemList,
                selectedItem = null
            )
        }
    }

    fun onSelectedItem(item: QuickeeItem) = intent {
        reduce {
            state.copy(
                selectedItem = if (state.selectedItem == item) null else item
            )
        }
    }
}