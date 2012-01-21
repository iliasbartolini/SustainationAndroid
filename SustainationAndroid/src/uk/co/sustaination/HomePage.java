package uk.co.sustaination;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.net.http.AndroidHttpClient;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.util.Config;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class HomePage extends Activity {
	//private static final String HTTP_URI = "http://app.sustaination.co.uk/test_post";
	private static final String HTTP_URI = "http://posttestserver.com/post.php";


	@Override
    public void onCreate(Bundle savedInstanceState) {
		if (Config.DEBUG && VERSION.SDK_INT >= VERSION_CODES.GINGERBREAD) {
			StrictMode.enableDefaults();
	    }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
	
	public void onSubmitClick(View v) throws Exception{
		EditText name = (EditText)findViewById(R.id.add_business_name);
		EditText type = (EditText)findViewById(R.id.add_business_type);
		EditText location = (EditText)findViewById(R.id.add_business_location);
		
		JSONObject addRequestJson = new JSONObject();
		addRequestJson.put("name", name.getText());
		addRequestJson.put("type", type.getText());
		addRequestJson.put("location", location.getText());

		String jsonMessage = addRequestJson.toString();
		Toast toast = Toast.makeText(getApplicationContext(), "HTTP POST request: " + jsonMessage , 10);
		toast.show();
		
		DefaultHttpClient client = new DefaultHttpClient();//.newInstance("Sustaination Android Application");
		HttpPost request = new HttpPost(HTTP_URI);
		request.setEntity(new StringEntity(jsonMessage));
		HttpResponse response = client.execute(request);
		
		Toast toast2 = Toast.makeText(getApplicationContext(), "HTTP response: "+response.getStatusLine().getStatusCode()+"\n" + response.getEntity().toString() , 10);
		toast2.show();

	}
}