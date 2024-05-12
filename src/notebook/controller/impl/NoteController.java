package notebook.controller.impl;

import model.Note;
import model.repository.Operational;
import notebook.controller.Controller;

import java.util.Optional;

public class NoteController extends Controller<Note> {
    public NoteController(Operational<Note> repository) {
        this.repository = repository;
    }

    @Override
    public Note get(String id) throws RuntimeException {
        Optional<Note> note = repository.get(Long.parseLong(id));

        if (note.isPresent()) return note.get();

        throw new RuntimeException("Note not found");
    }

    @Override
    public void update(String id, Note update) {
        try {
            repository.update(Long.parseLong(id), update);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
