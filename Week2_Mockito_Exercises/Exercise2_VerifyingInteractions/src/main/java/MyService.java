package Week2_Mockito_Exercises.Exercise2_VerifyingInteractions.src.main.java;

public class MyService {
    private final ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public String fetchData() {
        return api.getData();
    }
}
