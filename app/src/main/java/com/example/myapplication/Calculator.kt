package com.example.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetest.com.example.myapplication.CalculatorAction
import com.example.composetest.com.example.myapplication.CalculatorButton
import com.example.composetest.com.example.myapplication.CalculatorOperation
import com.example.composetest.com.example.myapplication.CalculatorState
import com.example.myapplication.ui.theme.LightGray
import com.example.myapplication.ui.theme.Orange

@Composable
fun Calculator(
    state: CalculatorState,
    buttonSpacing: Dp = 8.dp,
    onAction: (CalculatorAction) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            val uriHandler = LocalUriHandler.current
            Text(
                text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(vertical = 32.dp),
                fontWeight = FontWeight.Light,
                fontSize = 64.sp,
                color = Color.White,
                maxLines = 2
            )

            Text(
                text = "Made By Sonal Chauhan",
                fontFamily = FontFamily.Serif,
                fontSize = 20.sp,
                textDecoration = TextDecoration.Underline,
                color = Color.White,
                modifier = Modifier.clickable {
                    uriHandler.openUri("https://www.linkedin.com/in/sonal-chauhan-bab705284/")
                }
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "AC",
                    modifier = Modifier
                        .background(LightGray)
                        .aspectRatio(2f)
                        .weight(2f),
                    onClick = {
                        onAction(CalculatorAction.Clear)
                    }
                )
                CalculatorButton(
                    symbol = "Del",
                    modifier = Modifier
                        .background(LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Delete)
                    }
                )
                CalculatorButton(
                    symbol = "/",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Operation(CalculatorOperation.Divide))
                    }
                )
            }

            listOf(
                listOf("7", "8", "9", "x"),
                listOf("4", "5", "6", "-"),
                listOf("1", "2", "3", "+")
            ).forEach { row ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                ) {
                    row.forEachIndexed { index, symbol ->
                        CalculatorButton(
                            symbol = symbol,
                            modifier = Modifier
                                .background(if (index == 3) Orange else Color.DarkGray)
                                .aspectRatio(1f)
                                .weight(1f),
                            onClick = {
                                onAction(
                                    when (symbol) {
                                        "x" -> CalculatorAction.Operation(CalculatorOperation.Multiply)
                                        "-" -> CalculatorAction.Operation(CalculatorOperation.Subtract)
                                        "+" -> CalculatorAction.Operation(CalculatorOperation.Add)
                                        else -> CalculatorAction.Number(symbol.toInt())
                                    }
                                )
                            }
                        )
                    }
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "0",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(2f)
                        .weight(2f),
                    onClick = {
                        onAction(CalculatorAction.Number(0))
                    }
                )
                CalculatorButton(
                    symbol = ".",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Decimal)
                    }
                )
                CalculatorButton(
                    symbol = "=",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Calculate)
                    }
                )
            }
        }
    }
}
