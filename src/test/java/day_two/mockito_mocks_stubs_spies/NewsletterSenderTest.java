package day_two.mockito_mocks_stubs_spies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

class NewsletterSenderTest {

    @Test
    public void testConstructorAssignsDatabase() {
        MessagingEngine messagingEngineMock = mock(MessagingEngine.class);
        SubscribersDatabase subscribersDatabase = new SubscribersDatabase();
        NewsletterSender newsletterSender = new NewsletterSender(subscribersDatabase, messagingEngineMock);
        // 'mock' -> a mock is a 'nullable' object of given type
        Assertions.assertEquals(subscribersDatabase, newsletterSender.getSubscribersDatabase());
    }

    @Test
    public void numberOfSubscribers() {
        SubscribersDatabase subscribersDatabaseMock = mock(SubscribersDatabase.class);
        MessagingEngine messagingEngineMock = mock(MessagingEngine.class);

        NewsletterSender sender = new NewsletterSender(subscribersDatabaseMock, messagingEngineMock);

        List<String> subscribersList = Arrays.asList("email1", "email2", "email3");
        when(subscribersDatabaseMock.getSubscribers()).thenReturn(subscribersList); // 'stub' -> Giving a predefined return differentiates a STUB from a MOCK

        Assertions.assertEquals(3, sender.numberOfSubscribers(), "Number of subscribers should be: " + 3);
    }

    @Test
    public void zeroSubscribersThrown() {
        NewsletterSender newsletterSender = new NewsletterSender(new SubscribersDatabase(), new MessagingEngine());
        NewsletterSender newsletterSenderSpy = spy(newsletterSender);

        when(newsletterSenderSpy.numberOfSubscribers()).thenReturn(0); // 'spy' -> Giving predefined returns for some of the class methods

        Assertions.assertThrows(ZeroSubscribersException.class, () -> {
            newsletterSenderSpy.sendNewsletter("SUBJECT");
        });
    }

}