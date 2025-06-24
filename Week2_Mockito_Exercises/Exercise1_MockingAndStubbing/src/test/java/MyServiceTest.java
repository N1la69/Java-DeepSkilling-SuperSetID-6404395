package Week2_Mockito_Exercises.Exercise1_MockingAndStubbing.src.test.java;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import Week2_Mockito_Exercises.Exercise1_MockingAndStubbing.src.main.java.ExternalApi;
import Week2_Mockito_Exercises.Exercise1_MockingAndStubbing.src.main.java.MyService;

public class MyServiceTest {

    @Test
    public void testExternalApi() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        when(mockApi.getData()).thenReturn("Mock Data");

        MyService service = new MyService(mockApi);
        String result = service.fetchData();

        // Step 4: Assert
        assertEquals("Mock Data", result);
    }
}
