package Week2_Mockito_Exercises.Exercise2_VerifyingInteractions.src.test.java;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import Week2_Mockito_Exercises.Exercise1_MockingAndStubbing.src.main.java.ExternalApi;
import Week2_Mockito_Exercises.Exercise1_MockingAndStubbing.src.main.java.MyService;

import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    public void testVerifyInteraction() {
        // Step 1: Create mock
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        // Step 2: Call the method
        MyService service = new MyService(mockApi);
        service.fetchData();

        // Step 3: Verify interaction
        verify(mockApi).getData();
    }
}