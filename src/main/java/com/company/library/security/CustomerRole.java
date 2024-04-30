package com.company.library.security;

import com.company.library.entity.Book;
import com.company.library.entity.BookHistory;
import com.company.library.entity.UserBook;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.security.role.annotation.SpecificPolicy;
import io.jmix.securityflowui.role.annotation.MenuPolicy;
import io.jmix.securityflowui.role.annotation.ViewPolicy;

@ResourceRole(name = "Customer", code = CustomerRole.CODE)
public interface CustomerRole {
    String CODE = "customer";

    @EntityAttributePolicy(entityClass = BookHistory.class, attributes = "*", action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = BookHistory.class, actions = {EntityPolicyAction.CREATE, EntityPolicyAction.READ})
    void bookHistory();

    @EntityAttributePolicy(entityClass = UserBook.class, attributes = "*", action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = UserBook.class, actions = EntityPolicyAction.READ)
    void userBook();

    @EntityAttributePolicy(entityClass = Book.class, attributes = "*", action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = Book.class, actions = EntityPolicyAction.READ)
    void book();

    @MenuPolicy(menuIds = {"BookHistory.list", "Book.list", "UserBook.list"})
    @ViewPolicy(viewIds = {"BookHistory.list", "Book.list", "LoginView", "MainView", "BookHistory.detail", "entityInfoView", "flowui_AddConditionView", "flowui_GroupFilterCondition.detail", "flowui_JpqlFilterCondition.detail", "flowui_PropertyFilterCondition.detail", "changePasswordView", "datatl_entityInspectorListView", "datatl_entityInspectorDetailView", "inputDialog", "UserBook.list"})
    void screens();

    @SpecificPolicy(resources = {"ui.genericfilter.modifyConfiguration", "ui.genericfilter.modifyJpqlCondition", "datatools.showEntityInfo", "ui.genericfilter.modifyGlobalConfiguration"})
    void specific();
}