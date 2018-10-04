/**
* LonelyTwitterActivity.java
*
* Version: Lab 4
*
* October 3, 2018
*
 */

package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
//import java.util.Date;	Unused import statement

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


/**
 * Represents an instance of the LonelyTwitter program.
 * It displays a list of previous Tweets using an arrayAdapter.
 * There is a text field at the bottom of the screen where
 * users can type in a Tweet. There is a save button below
 * the text field that the user can press to save their currently
 * typed Tweet, which will appear in the previous Tweets list. There
 * is also a clear button that clears the Tweet history.
 * (Clear button is not implemented in this version.)
 *
 * Previous Tweets are saved in a file named "file.sav".
 *
 * @author shida3, chomyc1
 * @see Tweet, Activity, ArrayAdapter, ArrayList
 * @version Lab 4
 */
public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;

	private ArrayList<Tweet> tweetList;
	private ArrayAdapter<Tweet> adapter;

	/**
	 * Called when the activity is first created.
	 * It uses the "main.xml" file to create the display
	 * for the user. It also sets up the save button so
	 * the user can click on it to save their currently
	 * typed text in a Tweet.
	 *
	 * @param savedInstanceState a state used to create
	 * the activity.
	 * @see Tweet, main.xml
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();

				Tweet tweet = new NormalTweet(text);
				tweetList.add(tweet);

				adapter.notifyDataSetChanged();

				saveInFile();

			}
		});
	}

	/**
	 * Called when the activity is started.
	 * It starts the activity. Then it calls loadFromFile()
	 * to load past Tweets. After loadFromFile() is finished,
	 * this method will display the loaded Tweets using an
	 * ArrayAdapter.
	 *
	 * @see Tweet, ArrayAdapter
	 */
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();

		loadFromFile();

		adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweetList);
		oldTweetsList.setAdapter(adapter);
	}

	/**
	 * Called within onCreate()'s onClick() method.
	 * It loads the past Tweets from a file (file.sav).
	 * No return value, but loaded Tweets are stored in tweetList,
	 * which can be accessed by other methods.
	 *
	 * @see ArrayList, FileInputStream, BufferedReader, Gson
	 */
	private void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));

			Gson gson = new Gson();

			/**
			 * Taken from http://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt
			 * 2017-01-24 18:19
			 */
			Type listType = new TypeToken<ArrayList<NormalTweet>>(){}.getType();
			tweetList = gson.fromJson(in, listType);

		} catch (FileNotFoundException e) {
			tweetList = new ArrayList<Tweet>();
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	/**
	 * Called by onCreate()'s onClick() method.
	 * It saves the user's current input into the file (file.sav).
	 *
	 * @see ArrayList, FileOutputStream, BufferedWriter, Gson
	 */
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_PRIVATE);
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

			Gson gson = new Gson();
			gson.toJson(tweetList, out);
			out.flush();

			fos.close();
		} catch (FileNotFoundException e) {
			// TODO: Handle the Exception properly later
			throw new RuntimeException();
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
