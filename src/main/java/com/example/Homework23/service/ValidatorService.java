package com.example.Homework23.service;

import com.example.Homework23.exception.IncorrectNameException;
import com.example.Homework23.exception.IncorrectSurnameException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import static org.apache.commons.lang3.StringUtils.*;

@Service
public class ValidatorService {

    public String validateName(String name) {
        if (!isAlpha(name)) {
            throw new IncorrectNameException();
        }
        return StringUtils.capitalize(name.toLowerCase());
    }

    public String validateSurname(String surname) {
        String[] surnames = surname.split("-");
        for (int i = 0; i < surnames.length; i++) {
            if (!isAlpha(surnames[i])) {
                throw new IncorrectSurnameException();
            }
            surnames[i] = StringUtils.capitalize(surnames[i].toLowerCase());
        }
        return String.join("-", surnames);
    }
}