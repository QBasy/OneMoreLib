package com.company.library.view.bookhistory;

import com.company.library.entity.BookHistory;

import com.company.library.entity.User;
import com.company.library.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.core.security.CurrentAuthentication;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "bookHistories/:id", layout = MainView.class)
@ViewController("BookHistory.detail")
@ViewDescriptor("book-history-detail-view.xml")
@EditedEntityContainer("bookHistoryDc")
public class BookHistoryDetailView extends StandardDetailView<BookHistory> {
    @Autowired
    private CurrentAuthentication currentAuthentication;

    @Subscribe
    public void onInitEntity(final InitEntityEvent<BookHistory> event) {
        event.getEntity().setUser((User) currentAuthentication.getUser());
    }
}