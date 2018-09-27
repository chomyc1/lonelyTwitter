package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.renderscript.Type;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
	private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
	private ArrayAdapter<Tweet> adapter;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				String text = bodyText.getText().toString();
				ImportantTweet newTweet = new ImportantTweet();
				try {
					newTweet.setMessage(text);
					tweets.add(newTweet);
				}catch(TweetTooLongException e) {

				}

				adapter.notifyDataSetChanged();
				saveInFile();
				//saveInFile(text, new Date(System.currentTimeMillis()));
			}
		});
	}

	@Override
	protected void onStart() {
		super.onStart();
		loadFromFile();
		adapter = new ArrayAdapter<Tweet>(this, R.layout.list_item, tweets);
		oldTweetsList.setAdapter(adapter);
	}

	private void loadFromFile() {
		ArrayList<String> tweets = new ArrayList<String>();
		try {
			FileInputStream fis = openFileInput(FILENAME);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader reader = new BufferedReader(isr);

			Gson gson = new Gson();
			java.lang.reflect.Type typeListTweet = new TypeToken<ArrayList<ImportantTweet>>(){}.getType();
			tweets=gson.fromJson(reader, typeListTweet);
			reader.close();
			isr.close();
			fis.close();

			/*FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			String line = in.readLine();
			while (line != null) {
				tweets.add(line);
				line = in.readLine();
			}*/

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void saveInFile() {
		try {
			//Log.d("abc","I am inside saveInFile");

			FileOutputStream fos = openFileOutput(FILENAME, 0);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			BufferedWriter writer = new BufferedWriter(osw);
			Gson gson = new Gson();
			gson.toJson(tweets,osw);
			osw.flush();
			fos.close();
			writer.flush();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//catch (TweetTooLongException e) {
		//	e.printStackTrace();
		//}
	}

/*	private void clearFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_PRIVATE);
			fos.write(new String("").getBytes());
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}*/


}



/* NOTE: All code from this point is old; comes from the earlier lab assignment.




package ca.ualberta.cs.lonelytwitter;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
	
	/** Called when the activity is first created. */
/*	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button clearButton = (Button) findViewById(R.id.clear);
		Button saveButton = (Button) findViewById(R.id.save);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		// Mood related code
		final Happiness happyMood = new Happiness(new Date(System.currentTimeMillis()));
		final Sadness sadMood = new Sadness(new Date(System.currentTimeMillis()));
		final CheckBox happyCheck = (CheckBox) findViewById(R.id.checkBox1);
		final CheckBox sadCheck = (CheckBox) findViewById(R.id.checkBox2);

		// When clear button is clicked:
		clearButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				setResult(RESULT_OK);
				clearFile();
				onStart();
			}
		});

		// When save button is clicked:
		saveButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				if (happyCheck.isChecked()) {
					happyMood.setDate(new Date(System.currentTimeMillis()));
				}
				if (sadCheck.isChecked()) {
					sadMood.setDate(new Date(System.currentTimeMillis()));
				}

				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				saveInFile(text, new Date(System.currentTimeMillis()), happyCheck, sadCheck, happyMood, sadMood);
				onStart();
			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		String[] tweets = loadFromFile();
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				R.layout.list_item, tweets);
		oldTweetsList.setAdapter(adapter);
	}

	private String[] loadFromFile() {
		ArrayList<String> tweets = new ArrayList<String>();
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			String line = in.readLine();
			while (line != null) {
				tweets.add(line);
				line = in.readLine();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tweets.toArray(new String[tweets.size()]);
	}

	private void clearFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_PRIVATE);
			fos.write(new String("").getBytes());
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}

	private void saveInFile(String text, Date date, CheckBox happyCheck, CheckBox sadCheck, Happiness happy, Sadness sad) {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_APPEND);
			String saveString = new String(date.toString() + " | " + text);
			if (happyCheck.isChecked()) {
				String happyMessage = happy.happyMoodFormat();
				Date happyDate = happy.getDate();
				saveString += " | " + happyMessage + " " + happyDate.toString();
			}
			if (sadCheck.isChecked()) {
				String sadMessage = sad.sadMoodFormat();
				Date sadDate = sad.getDate();
				saveString += " | " + sadMessage + " " + sadDate.toString();
			}
			saveString += "\n";
			fos.write(saveString.getBytes());
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}



/*
Some code from the lab session:

	finish() makes the app window go away, was removed from the code above.


	import android.util.Log;

	Student st1=new Student();
	st1.name="Student";
	st1.age = 80;
	Log.d("logstring", st1.name);
	Log.d("logstring2", Integer.toString(st1.age));

	Cat cat = new Cat();
	cat.setType("it's a cat");
	cat.setFood("cat loves fish");



	public abstract class Tweet {
		protected String message;
		protected Date date;

		public void setMessage(String message) {
			if (message.length() > 140) {
				throw new TooLongTweetException();
			}
			this.message = message;
			this.date = new Date();
		}

		public void setDate() {
			this.date = date;
		}

		public String getMessage() {
			return this.message;
		}

		public Date getDate() {
			return this.date;
		}

		public abstract Boolean isImportant;
	}

	public class TooLongTweetException extends Exception {

	}

	public class ImportantTweet extends Tweet {
		public ImportantTweet(String message) {
			super(message);
		}

		@Override
		public Boolean isImportant() {
			return true;
		}
	}

	public class NormalTweet extends Tweet {
		public NormalTweet(String message) {
			super(message);
		}

		@Override
		public Boolean isImportant() {
			return false;
		}
	}


 */
