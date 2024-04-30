package com.company.library.view.userbook;

import com.company.library.entity.UserBook;

import com.company.library.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "userBooks", layout = MainView.class)
@ViewController("UserBook.list")
@ViewDescriptor("user-book-list-view.xml")
@LookupComponent("userBooksDataGrid")
@DialogMode(width = "64em")
public class UserBookListView extends StandardListView<UserBook> {
}