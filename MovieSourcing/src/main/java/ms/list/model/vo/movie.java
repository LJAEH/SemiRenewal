package ms.list.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor // 기본 생성자

public class movie {

	private int movieNo;
	private String movieTitle;
	private String movieGrade;
	private String national;
	private String moviePoster;
	private String movieJanr;
	
	
	
	
	public movie(int movieNo, String movieTitle, String movieGrade, String national, String moviePoster,
			String movieJanr) {
		super();
		this.movieNo = movieNo;
		this.movieTitle = movieTitle;
		this.movieGrade = movieGrade;
		this.national = national;
		this.moviePoster = moviePoster;
		this.movieJanr = movieJanr;
	}

	
}