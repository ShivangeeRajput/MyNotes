package Database

import Model.Note
import androidx.lifecycle.LiveData

class NotesRepository(private val NoteDao:NoteDao) {

    val allNotes : LiveData<List<Note>> = NoteDao.getAllNotes()

    suspend fun insert(note: Note){
        NoteDao.insert(note)
    }

   suspend fun delete(note: Note){
       NoteDao.delete(note)
   }

    suspend fun update(note: Note){
        NoteDao.update(note.id,note.title,note.note)
    }

}