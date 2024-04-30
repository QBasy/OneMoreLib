package com.company.library.view.bookhistory;

import com.company.library.entity.BookHistory;

import com.company.library.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.core.DataManager;
import io.jmix.core.security.CurrentAuthentication;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Route(value = "bookHistories", layout = MainView.class)
@ViewController("BookHistory.list")
@ViewDescriptor("book-history-list-view.xml")
@LookupComponent("bookHistoriesDataGrid")
@DialogMode(width = "64em")
public class BookHistoryListView extends StandardListView<BookHistory> {
    @Autowired
    private DataManager dataManager;
    @Autowired
    private CurrentAuthentication currentAuthentication;

    private List<BookHistory> getUser(final StandardDetailView.InitEntityEvent<BookHistory> event) {
        return dataManager.load(BookHistory.class)
                .query("select b from BookHistory b where b.user = :user")
                .parameter("user", currentAuthentication.getUser())
                .list();
    }
}