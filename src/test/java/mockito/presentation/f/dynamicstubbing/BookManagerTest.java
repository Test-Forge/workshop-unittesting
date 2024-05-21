package mockito.presentation.f.dynamicstubbing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookManagerTest {

    @Mock
    private BooksRepository booksRepository;

    @InjectMocks
    private BookManager bookManager;

    private Set<String> booksDatabaseSet;

    @BeforeEach
    public void setup() {

        booksDatabaseSet = new HashSet<>();
        booksDatabaseSet.add("Harry Potter");
//        booksDatabaseSet.add("Lord of the rings");
    }

    @Test
    public void testGetBookInventoryCount() {
        BookManager bookManagerSpy = spy(bookManager);
        when(booksRepository.getBooks()).thenReturn(booksDatabaseSet);

        Integer getBooksCount = bookManagerSpy.getBookInventoryCount();
        assertEquals(1, getBooksCount);
    }

    @Test
    public void testGetBookInventoryCountWithAnswer() {
        BookManager bookManagerSpy = spy(bookManager);
        when(booksRepository.getBooks()).thenAnswer(new GetBooks());

        Integer getBooksCount = bookManagerSpy.getBookInventoryCount();
        assertEquals(1, getBooksCount);
    }

    @Test
    public void testGetBookInventoryCountWithAnswers() {
        BookManager bookManagerSpy = spy(bookManager);
        when(booksRepository.getBooks()).thenAnswer(new GetBooks());

        Integer getBooksCount = bookManagerSpy.getBookInventoryCount();
        assertEquals(1, getBooksCount);

        String newBook = "Black box thinking";
        when(booksRepository.addBook(newBook)).thenAnswer(new AddBook());
        bookManagerSpy.addBook(newBook);

        Integer getBooksCountAfterAdd = bookManagerSpy.getBookInventoryCount();
        assertEquals(2, getBooksCountAfterAdd);
    }

    class GetBooks implements Answer<Object> {
        public Object answer(InvocationOnMock invocation) {

            return booksDatabaseSet;
        }
    }

    class AddBook implements Answer<Object> {
        public Object answer(InvocationOnMock invocation) {
            String book = invocation.getArgument(0);
            booksDatabaseSet.add(book);
            return book;
        }
    }

}