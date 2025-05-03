package com.ojijo.ojijolawmate.data

import android.app.Application
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.room.*
import kotlinx.coroutines.launch

// --- Data Models ---

@Entity(tableName = "laws")
data class Law(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val section: String,
    val title: String,
    val description: String
)

@Entity(tableName = "lawyers")
data class Lawyer(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val specialization: String,
    val phone: String
)

@Entity(tableName = "case_registrations")
data class CaseRegistration(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val email: String,
    val phone: String,
    val description: String
)

// --- DAOs ---

@Dao
interface LawDao {
    @Insert
    suspend fun insertLaw(law: Law)

    @Query("SELECT * FROM laws")
    suspend fun getAllLaws(): List<Law>

    @Query("SELECT * FROM laws WHERE section LIKE :searchQuery OR title LIKE :searchQuery OR description LIKE :searchQuery")
    suspend fun searchLaws(searchQuery: String): List<Law>
}

@Dao
interface LawyerDao {
    @Insert
    suspend fun insertLawyer(lawyer: Lawyer)

    @Query("SELECT * FROM lawyers")
    suspend fun getAllLawyers(): List<Lawyer>

    @Query("SELECT * FROM lawyers WHERE name LIKE :searchQuery OR specialization LIKE :searchQuery")
    suspend fun searchLawyers(searchQuery: String): List<Lawyer>
}

// --- Database Setup ---

@Database(entities = [Law::class, Lawyer::class, CaseRegistration::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun lawDao(): LawDao
    abstract fun lawyerDao(): LawyerDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Application): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "lawmate_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}

// --- ViewModels ---

class LawViewModel(application: Application) : AndroidViewModel(application) {
    private val lawDao = AppDatabase.getDatabase(application).lawDao()

    fun getAllLaws(): LiveData<List<Law>> = liveData {
        emit(lawDao.getAllLaws())
    }

    fun searchLaws(query: String): LiveData<List<Law>> = liveData {
        emit(lawDao.searchLaws("%$query%"))
    }

    fun insertLaw(law: Law) {
        viewModelScope.launch {
            lawDao.insertLaw(law)
        }
    }
}

class LawyerViewModel(application: Application) : AndroidViewModel(application) {
    private val lawyerDao = AppDatabase.getDatabase(application).lawyerDao()

    fun getAllLawyers(): LiveData<List<Lawyer>> = liveData {
        emit(lawyerDao.getAllLawyers())
    }

    fun searchLawyers(query: String): LiveData<List<Lawyer>> = liveData {
        emit(lawyerDao.searchLawyers("%$query%"))
    }

    fun insertLawyer(lawyer: Lawyer) {
        viewModelScope.launch {
            lawyerDao.insertLawyer(lawyer)
        }
    }
}

class CaseRegistrationViewModel(application: Application) : AndroidViewModel(application) {



// --- UI Composables ---

@Composable
fun ViewLawsScreen(lawViewModel: LawViewModel = viewModel()) {
    val laws by lawViewModel.getAllLaws().observeAsState(emptyList())

    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        items(laws) { law ->
            LawCard(law)
        }
    }
}

@Composable
fun LawCard(law: Law) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 4.dp), elevation = CardDefaults.cardElevation(4.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = law.section, style = MaterialTheme.typography.titleMedium)
            Text(text = law.title, style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = law.description, style = MaterialTheme.typography.bodySmall)
        }
    }
}

@Composable
fun SearchLawsScreen(lawViewModel: LawViewModel = viewModel()) {
    var query by remember { mutableStateOf(TextFieldValue("")) }
    val filteredLaws by lawViewModel.searchLaws(query.text).observeAsState(emptyList())

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        OutlinedTextField(
            value = query,
            onValueChange = { query = it },
            label = { Text("Search IPC Law") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            items(filteredLaws) { law ->
                LawCard(law)
            }
        }
    }
}

@Composable
fun LawyerScreen(lawyerViewModel: LawyerViewModel = viewModel()) {
    var searchQuery by remember { mutableStateOf("") }
    val filteredLawyers by lawyerViewModel.searchLawyers(searchQuery).observeAsState(emptyList())

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Text("Find a Lawyer", style = MaterialTheme.typography.titleLarge)

        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Search by Name or Specialization") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            items(filteredLawyers) { lawyer ->
                LawyerCard(lawyer)
            }
        }
    }
}

@Composable
fun LawyerCard(lawyer: Lawyer) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 4.dp), elevation = CardDefaults.cardElevation(4.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = lawyer.name, style = MaterialTheme.typography.titleMedium)
            Text(text = "Specialization: ${lawyer.specialization}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Contact: ${lawyer.phone}", style = MaterialTheme.typography.bodySmall)
        }
    }
}

@Composable
fun RegisterCaseScreen(caseRegistrationViewModel: CaseRegistrationViewModel = viewModel()) {
    val context = LocalContext.current
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Register a Case", style = MaterialTheme.typography.titleLarge)

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Full Name") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = phone,
            onValueChange = { phone = it },
            label = { Text("Phone Number") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Case Description") },
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
        )
    }
}
}



