package com.solutions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class MovieData {

	class Movie implements Comparable<Movie> {
		private String movieName;
		private LocalDate year;

		public Movie(String movieName, LocalDate year) {
			this.movieName = movieName;
			this.year = year;
		}

		public String getMovieName() {
			return movieName;
		}

		public void setMovieName(String movieName) {
			this.movieName = movieName;
		}

		public LocalDate getYear() {
			return year;
		}

		public void setYear(LocalDate year) {
			this.year = year;
		}

		@Override
		public int compareTo(Movie mv) {
			return getYear().compareTo(mv.getYear());
		}
	}

	private BufferedReader in;
	private URL url;
	private DateTimeFormatter format = new DateTimeFormatterBuilder().appendPattern("yyyy")
			.parseDefaulting(ChronoField.MONTH_OF_YEAR, 1).parseDefaulting(ChronoField.DAY_OF_MONTH, 1).toFormatter();

	private static final String PAGE = "page";

	// build movie date from json
	private Movie getMovie(JSONObject movieJSON) {
		return new Movie(moviteTitleFromJSON(movieJSON), movieDateFromJSON(movieJSON));
	}

	// get date from json <> util
	private LocalDate movieDateFromJSON(JSONObject date) {
		return LocalDate.parse(String.valueOf((long)date.get("Year")), format);
	}

	// get movie title from json <> util
	private String moviteTitleFromJSON(JSONObject movieJSON) {
		return (String)movieJSON.get("Title");
	}

	// build url
	private static URL buildURL(String query, int startPage) throws MalformedURLException {
		return new URL(URL_PRE + query + "&" + PAGE + "=" + startPage);
	}

	public static final String URL_PRE = "https://jsonmock.hackerrank.com/api/movies/search/?Title=";

	// get stream
	private BufferedReader getMovieData(String query, int startPage) throws IOException {
		url = buildURL(query, startPage);

		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");

		return new BufferedReader(new InputStreamReader(con.getInputStream()));
	}

	// get movie list form api
	private List<Movie> getMovieTitles(String query) throws IOException {

		String response;
		int startPage = 1;
		int totalPages = Integer.MAX_VALUE;

		List<Movie> titles = new ArrayList<Movie>();

		JSONObject convertedObject;
		JSONArray data;
		JSONParser parser = new JSONParser();

		while (startPage <= totalPages) {
			try {
				in = getMovieData(query, startPage);
				while ((response = in.readLine()) != null) {
					convertedObject = (JSONObject) parser.parse(response);
					totalPages = (int) (long) convertedObject.get("total_pages");
					data = (JSONArray) convertedObject.get("data");
					for (int i = 0; i < data.size(); i++) {
						titles.add(getMovie((JSONObject)data.get(i)));
					}
				}
				startPage++;
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				in.close();
			}
		}

		Collections.sort(titles);

		return titles;
	}

	public static void main(String[] args) throws IOException {
		List<Movie> list = new MovieData().getMovieTitles("iron");
		for (Movie t : list) {
			System.out.println(t.getMovieName() + " (" + t.getYear().getYear() + ")");
		}
	}
}
