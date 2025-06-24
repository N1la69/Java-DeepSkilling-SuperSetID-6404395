package Week2_Mockito_Exercises.Exercise1_MockingAndStubbing.src.main.java;

public class MyService {
    private final ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public String fetchData() {
        return api.getData();
    }
}
