package model;

import java.time.LocalDateTime;

public class Note {
    private Long id;
    private String title;
    private String text;
    private final LocalDateTime creationDate;
    private LocalDateTime modificationDate;

    public Note(Long id, String title, String text, LocalDateTime creationDate, LocalDateTime modificationDate) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;
    }

    public Note(Long id, String title, String text) {
        this(id, title, text, LocalDateTime.now(), LocalDateTime.now() );
    }

    public Note(String title, String text) {
        this(null, title, text);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public LocalDateTime getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(LocalDateTime modificationDate) {
        this.modificationDate = modificationDate;
    }

    @Override
    public String toString() {
        return String.format("Note #%s\nTitle: %s\n\t%s\n\nCreation date: %s\nModification date: %s",
                id, title, text, creationDate, modificationDate);
    }
}