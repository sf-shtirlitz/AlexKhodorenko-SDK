package aksdk.movieapi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MovieAPI {

    private String baseUrl;

    public MovieAPI(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public List<String> getMovieList() throws Exception {
        String url = baseUrl + "/movie";
        return sendGetRequest(url);
    }

    public String getMovieById(int id) throws Exception {
        String url = baseUrl + "/movie/" + id;
        List<String> response = sendGetRequest(url);
        if(response.size() > 0) {
            return response.get(0);
        }
        return null;
    }

    public List<String> getMovieQuotesById(int id) throws Exception {
        String url = baseUrl + "/movie/" + id + "/quote";
        return sendGetRequest(url);
    }

    private List<String> sendGetRequest(String url) throws Exception {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        List<String> response = new ArrayList<>();
        while ((inputLine = in.readLine()) != null) {
            response.add(inputLine);
        }
        in.close();
        return response;
    }
}
