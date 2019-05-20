package edu.mum.tm.serviceImpl;

import edu.mum.tm.domain.Professor;
import edu.mum.tm.repository.FacultyRepository;
import edu.mum.tm.repository.StudentRepository;
import edu.mum.tm.service.FacultyService;
import edu.mum.tm.viewmodel.ILookupItem;
import edu.mum.tm.viewmodel.LookupItem;
import edu.mum.tm.viewmodel.StudentsExtraCredit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    @Override
    public List<ILookupItem> getFacultyCourses(Long facultyId) throws Exception {
        throw new Exception("");
        //return facultyRepository.getFacultyCourses(facultyId);
    }

    @Override
    public List<StudentsExtraCredit> getCourseStudentsExtraCredits(Integer courseBlockId) {
        return facultyRepository.getCourseStudentsExtraCredits(courseBlockId);
    }

    @Override
    public Professor getFacultyIdByUserId(int userId) {
        return facultyRepository.getProfessorByUserId(userId);
    }
}
