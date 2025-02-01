package com.doc.genericarchitecturesecurity.validation;

import com.doc.genericarchitecturesecurity.enums.ValidationActionsEnum;
import com.doc.genericarchitecturesecurity.exception.Message;

import java.util.List;

public interface IValidations<MODEL> {
    void validate(MODEL data, ValidationActionsEnum action, List<Message> messagesToThrow);
}