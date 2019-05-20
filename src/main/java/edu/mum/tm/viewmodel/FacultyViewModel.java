package edu.mum.tm.viewmodel;

import lombok.Data;

import java.util.List;

@Data
public class FacultyViewModel {
    private Long id;

    private List<ILookupItem> courses;
}
