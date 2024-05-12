package util;

import model.Note;
import model.repository.Operational;
import model.repository.impl.NoteRepository;
import notebook.controller.Controller;
import notebook.controller.impl.NoteController;
import util.connector.Connector;
import util.connector.impl.FileDBConnector;

import javax.swing.text.View;

public class AppManager {
    private Connector connector;
    private Operational<Note> repository;
    private Controller<Note> controller;
    private View<Note> view;

    public AppManager() {
        this.connector = new FileDBConnector();
        this.repository = new NoteRepository(connector);
        this.controller = new NoteController(repository);
        this.view = new ConsoleView (controller);
    }

    public void run() {
        connector.connect();
        view.run();
    }
}
