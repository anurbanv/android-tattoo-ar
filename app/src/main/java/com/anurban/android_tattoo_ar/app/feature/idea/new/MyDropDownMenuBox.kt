@file:OptIn(ExperimentalMaterial3Api::class)

package com.anurban.android_tattoo_ar.app.feature.idea.new

import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MyDropDownMenuBox(
    options: List<DropDownMenuOption> = listOf(),
    selectedOption: DropDownMenuOption? = null,
    isExpanded: Boolean = false,
    onExpandChange: (Boolean) -> Unit = {},
    onDismissRequest: () -> Unit = {},
    onOptionSelected: (Int) -> Unit = {},
) {
    ExposedDropdownMenuBox(
        expanded = isExpanded,
        onExpandedChange = onExpandChange,
    ) {
        TextField(
            modifier = Modifier.menuAnchor(),
            readOnly = true,
            value = selectedOption?.text ?: "N/A",
            onValueChange = { },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded) },
        )
        ExposedDropdownMenu(
            expanded = isExpanded,
            onDismissRequest = onDismissRequest,
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = {
                        Text(text = option.text)
                    },
                    onClick = { onOptionSelected(option.id) },
                )
            }
        }
    }
}

data class DropDownMenuOption(
    val id: Int = 0,
    val text: String = "",
)
