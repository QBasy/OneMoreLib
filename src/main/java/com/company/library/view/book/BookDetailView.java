package com.company.library.view.book;

import com.company.library.entity.Book;

import com.company.library.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "books/:id", layout = MainView.class)
@ViewController("Book.detail")
@ViewDescriptor("book-detail-view.xml")
@EditedEntityContainer("bookDc")
public class BookDetailView extends StandardDetailView<Book> {
}