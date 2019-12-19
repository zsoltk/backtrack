package com.example.lifelike.composable.loggedout

import androidx.compose.Composable
import androidx.compose.state
import androidx.compose.unaryPlus
import androidx.ui.core.Text
import androidx.ui.core.TextField
import androidx.ui.layout.Column
import androidx.ui.material.Button
import com.example.lifelike.entity.User


interface RegConfirmSmsCode {
    companion object {

        @Composable
        fun Content(user: User, onNext: () -> Unit) {
            Column {
                var code by +state { "0000" }

                Text(text = "Confirm SMS code:")
                TextField(
                    value = code,
                    onValueChange = {
                        val digits = it.filter { it.isDigit() }
                        code = if (digits.length < 4) digits else digits.substring(0, 4) }
                )
                Button(
                    text = "Next",
                    onClick = { if (code.length == 4) onNext() }
                )
            }
        }
    }
}