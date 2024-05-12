package util.mapper;

import model.Note;

import java.time.DateTimeException;
import java.time.LocalDateTime;

public class NoteMapper implements Mappable<Note, String> {
    private final String sep;

    public NoteMapper(String sep) {
        this.sep = sep;
    }

    public NoteMapper() {
        this(", ");
    }

    @Override
    public Note toInput(String s) {
        String[] attrs = s.split(sep);

        if (!isDigit(attrs[0]))
            throw new NumberFormatException("Id must be a large number");

        if (!isDateTime(attrs[3]) || !isDateTime(attrs[4]))
            throw new DateTimeException("Dates must be in local date & time format");

        return new Note(
                Long.parseLong(attrs[0]),
                attrs[1],
                attrs[2],
                LocalDateTime.parse(attrs[3]),
                LocalDateTime.parse(attrs[4])
        );
    }

    @Override
    public String toOutput(Note note) {
        return String.join(
                sep,
                note.getId().toString(),
                note.getTitle(),
                note.getText(),
                note.getCreationDate().toString(),
                note.getModificationDate().toString()
        );
    }

    private boolean isDigit(String s) {
        try {
            Long.parseLong(s);

            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isDateTime(String s) {
        try {
            LocalDateTime.parse(s);

            return true;
        } catch (DateTimeException e) {
            return false;
        }
    }
}
