package nl.hu.bep.battlesnake.model;

public class SnakeApi {
    private static SnakeApi apiService = new SnakeApi();

    public static SnakeApi getApiService() {
        return apiService;
    }

    private GameInfo information = new GameInfo();

    private GameStatics statics = new GameStatics();

    public GameInfo getInformation() {
        return information;
    }

    public GameStatics getStatics(String id) {
        return statics;
    }
}
