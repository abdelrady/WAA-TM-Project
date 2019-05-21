package edu.mum.tm.service;

import edu.mum.tm.viewmodel.ILookupItem;
import edu.mum.tm.viewmodel.LookupItem;
import edu.mum.tm.viewmodel.StudentsExtraCredit;

import java.util.List;

public interface FacultyService {
    List<ILookupItem> getFacultyCourses(Long facultyId);

    List<StudentsExtraCredit> getCourseStudentsExtraCredits(Integer courseBlockId);

}
