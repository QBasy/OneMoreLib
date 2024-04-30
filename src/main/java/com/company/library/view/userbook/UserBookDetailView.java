package com.company.library.view.userbook;

import com.company.library.entity.UserBook;

import com.company.library.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "userBooks/:id", layout = MainView.class)
@ViewController("UserBook.detail")
@ViewDescriptor("user-book-detail-view.xml")
@EditedEntityContainer("userBookDc")
public class UserBookDetailView extends StandardDetailView<UserBook> {
}