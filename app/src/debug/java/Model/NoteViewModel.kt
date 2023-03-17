package Model

import Database.NoteDatabase
import Database.NotesRepository
import android.app.Application
import android.provider.ContactsContract
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application ) : AndroidViewModel(application){
    private  val repository : NotesRepository
    val allNotes : LiveData<List<Note>>

    init {
        val Dao=NoteDatabase.getDatabase(application).getNoteDao()
        repository= NotesRepository(Dao)
        allNotes=repository.allNotes
    }
    fun deleteNote(note:Note)=viewModelScope.launch(Dispatchers.IO){
        repository.delete(note)
    }

    fun insertNote(note: Note)=viewModelScope.launch(Dispatchers.IO){
        repository.insert(note)
    }

    fun updateNote(note: Note)=viewModelScope.launch(Dispatchers.IO) {
       repository.update(note)
    }

}
