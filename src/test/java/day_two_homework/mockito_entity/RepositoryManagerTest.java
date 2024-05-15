package day_two_homework.mockito_entity;

import day_two_homework.mockito_entity.RepositoryManager;
import day_two_homework.mockito_entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RepositoryManagerTest {

    @Test
    void getAllStudentsTest() {
        EntityManager emMock = mock();

        RepositoryManager repositoryManager = new RepositoryManager(emMock);

        Student a = new Student(1, "Parker");
        Student b = new Student(2, "Mary");
        Student c = new Student(3, "Ben");
        List<Student> studentList = Arrays.asList(a, b, c);

        Query queryMock = mock(Query.class);
        when(queryMock.getResultList()).thenReturn(studentList);

        when(emMock.createNamedQuery(RepositoryManager.GET_ALL_STUDENTS)).thenReturn(queryMock);

        List<Student> actualStudents = repositoryManager.getAllStudents();

        assertEquals(actualStudents, studentList);

    }
}