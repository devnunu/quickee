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
     * Show Bottom Sheet
     * */
    fun onChangeBottomSheetState(bottomSheetTag: MainBottomSheetTag?) = intent {
        reduce {
            state.copy(showBottomSheetTag = bottomSheetTag)
        }
    }

    /**
     * Open Animate Visible View
     * */
    fun onClickOpenDoneListView() = intent {
        reduce {
            state.copy(isOpenDoneListView = !state.isOpenDoneListView)
        }
    }

    fun onClickRegisterBtn() = intent {
        val inputValue = state.inputValue
        if (!inputValue.isNullOrBlank()) {
            val isEditMode = state.hasSelectedItem
            if (isEditMode) {
                state.selectedItem?.let { item ->
                    itemRepository.updateQuickeeItemValue(item, inputValue)
                }
            } else {
                itemRepository.addQuickeeItem(QuickeeItem(value = inputValue))
            }
            reduce {
                state.copy(
                    showBottomSheetTag = null,
                    inputValue = null,
                    selectedItem = null
                )
            }
        }
    }

    /**
     * Item Select
     * */
    fun onSelectedItem(item: QuickeeItem) = intent {
        reduce {
            val isClickNotSameArea =
                state.selectedItem != null && state.selectedItem?.isDone != item.isDone
            val isClickSameItem = state.selectedItem == item
            val isResetSelectedItem = isClickSameItem || isClickNotSameArea
            state.copy(
                selectedItem = if (isResetSelectedItem) null else item,
                isOpenInProgressItemSnackBar = if (isResetSelectedItem) false else !item.isDone,
                isOpenDoneItemSnackBar = if (isResetSelectedItem) false else item.isDone
            )

        }
    }

    /**
     * SnackBar Btn
     * */
    fun onClickDoneItem(item: QuickeeItem) = intent {
        itemRepository.updateQuickeeItemDone(item, true)
        reduce {
            state.copy(
                selectedItem = null,
                isOpenDoneItemSnackBar = false
            )
        }
    }

    fun onClickRestoreBtn(item: QuickeeItem) = intent {
        itemRepository.updateQuickeeItemDone(item, false)
        reduce {
            state.copy(
                selectedItem = null,
                isOpenDoneItemSnackBar = false
            )
        }
    }

    fun onClickDeleteItem(item: QuickeeItem) = intent {
        itemRepository.deleteQuickeeItem(item)
        reduce {
            state.copy(selectedItem = null)
        }
    }

    fun onClickEditItem(item: QuickeeItem) = intent {
        reduce {
            state.copy(
                selectedItem = item,
                inputValue = item.value,
                showBottomSheetTag = MainBottomSheetTag.INPUT
            )
        }
    }

    /**
     * empty
     * */
    fun onClickEmptyArea() = intent {
        reduce {
            state.copy(
                showBottomSheetTag = if (state.hasSelectedItem) null else MainBottomSheetTag.INPUT,
                selectedItem = null,
                isOpenInProgressItemSnackBar = false,
                isOpenDoneItemSnackBar = false
            )
        }
    }
}