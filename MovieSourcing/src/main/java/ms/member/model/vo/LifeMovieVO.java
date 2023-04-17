package ms.member.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class LifeMovieVO {
	
	private int movieNo;
	private String movieTitle;
	private String moviePoster;

	public LifeMovieVO(int movieNo, String movieTitle, String moviePoster) {
			
		this.movieNo = movieNo;
		this.movieTitle = movieTitle;
		this.moviePoster = moviePoster;
	}

}
