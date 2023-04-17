package ms.movielist.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MovieListInfo {
	
	private int movieNo;
	private String movieTitle;
	private String moviePoster;
	private String movieOpen;
	private int movieScore;
	
	public MovieListInfo(int movieNo, String movieTitle, String moviePoster, int movieScore) {
		// TODO Auto-generated constructor stub
		
		this.movieNo = movieNo;
		this.movieTitle = movieTitle;
		this.moviePoster = moviePoster;
		this.movieScore = movieScore;
	}
	
	public MovieListInfo(int movieNo, String movieTitle, String movieOpen, String moviePoster, int movieScore) {
		// TODO Auto-generated constructor stub
		
		this.movieNo = movieNo;
		this.movieTitle = movieTitle;
		this.movieOpen = movieOpen;
		this.moviePoster = moviePoster;
		this.movieScore = movieScore;
	}
}
