import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Jack_Jill {
	public static void main(String[] args) throws IOException {
		int n = 0;
		while (n == (int) n) {
			System.out.println("choose card between 1 to 10");
			Scanner sr = new Scanner(System.in);
			try {
				n = sr.nextInt();
			} catch (Exception ex) {
				System.out
						.println("input exception please enter integer value");
				continue;
			}
			break;
		}
		ArrayList<String> list = new ArrayList<String>();
		String sURL = "http://api.icndb.com/jokes/random/10"; // just a string

		// Connect to the URL using java's native library
		URL url = new URL(sURL);
		HttpURLConnection request = (HttpURLConnection) url.openConnection();
		try
		{
		request.connect();
		}catch(Exception e)
		{
			System.out.println("connection error");
		}

		// Convert to a JSON object to print data
		JsonParser jp = new JsonParser(); // from gson
		JsonElement root = jp.parse(new InputStreamReader((InputStream) request
				.getContent())); // Convert the input stream to a json element
		JsonObject rootobj = root.getAsJsonObject(); // May be an array, may be
														// an object.
		JsonArray urldata = rootobj.get("value").getAsJsonArray();

		for (JsonElement url1 : urldata) {
			JsonObject msg = url1.getAsJsonObject();
			list.add(msg.get("joke").getAsString());
		}
		System.out.println(list.get(n));

	}

}
