package ms.movie.model.vo;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MovieInfo {
	
	private int movieNo;
	private String movieTitle;
	private String movieEngTitle;
	private int movieTime;
	private String movieOpenDate;
	private int movieScore;
	private String movieNational;
	private String movieGrade;
	private String moviePoster;
	private String moviePreview;
	
	private List<String> movieGenre;
	
}
