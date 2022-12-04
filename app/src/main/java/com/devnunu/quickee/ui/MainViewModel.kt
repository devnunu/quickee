package com.devnunu.quickee.ui

import androidx.lifecycle.ViewModel
import com.devnunu.quickee.data.model.QuickeeItem
import com.devnunu.quickee.data.repository.ItemRepository
import com.devnunu.quickee.ui.components.bottomSheet.MainBottomSheetTag
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.syntax.simple.repeatOnSubscription
import org.orbitmvi.orbit.viewmodel.container

class MainViewModel(
    private val itemRepository: ItemRepository
) : ContainerHost<MainState, MainSideEffect>, ViewModel() {

    override val container = container<MainState, MainSideEffect>(MainState())

    init {
        collectDataFlow()
    }

    private fun collectDataFlow() = intent {
        repeatOnSubscription {
            itemRepository.getQuickeeItemList().collect { itemList ->
                reduce {
                    state.copy(
                        inProgressItemList = itemList.filter { !it.isDone },
                        doneItemList = itemList.filter { it.isDone },
                    )
                }
            }
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
    fun onChangeBottomSheetState(bottomSheetTag: MainBottomSheetTag?) = intent {
        reduce {
            state.copy(showBottomSheetTag = bottomSheetTag)
        }
    }

    fun onClickRegisterBtn() = intent {
        val inputValue = state.inputValue
        if (!inputValue.isNullOrBlank()) {
            val item = QuickeeItem(value = inputValue)
            itemRepository.addQuickeeItem(item)
            reduce {
                state.copy(
                    showBottomSheetTag = null,
                    inputValue = null
                )
            }
        } else {
            // TODO : error
        }
    }

    fun onClickDeleteItem(item: QuickeeItem) = intent {
        itemRepository.deleteQuickeeItem(item)
        reduce {
            state.copy(selectedItem = null)
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