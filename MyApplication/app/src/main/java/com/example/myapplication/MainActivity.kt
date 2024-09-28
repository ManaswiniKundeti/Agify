package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.viewModel.AgifyViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.Locale

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val agifyViewModel: AgifyViewModel by viewModels<AgifyViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Display(agifyViewModel)
            }
        }
    }
}

@Composable
fun Display(viewModel: AgifyViewModel) {
    val age by viewModel.ageState.observeAsState()
    val name by viewModel.nameState.observeAsState()

    Column {
        Row(modifier = Modifier.padding(10.dp).align(Alignment.CenterHorizontally)) {
            // Button for Michael's age
            OutlinedButton(onClick = { viewModel.getAge("michael") }) {
                Text("Michael")
            }
            Spacer(modifier = Modifier.width(16.dp))

            // Button for Sarah's age
            OutlinedButton(onClick = { viewModel.getAge("sarah") }) {
                Text("Sarah")
            }
            Spacer(modifier = Modifier.width(16.dp))

            // Button for John’s age
            OutlinedButton(onClick = { viewModel.getAge("john") }) {
                Text("John")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            modifier = Modifier.padding(start = 20.dp),
            text = "${name?.capitalize(Locale.ROOT)}'s age is $age",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}