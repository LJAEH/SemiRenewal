package ms.movielist.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ReviewListInfo {
	
	
	private int memberNo;
	private int movieNo;
	private String moviePoster;
	private String movieTitle;
	private String reviewContent;
	private String reviewScore;
	private String reviewDate;
	
	public ReviewListInfo(int memberNo, int movieNo, String moviePoster , String movieTitle, 
			String reviewContent, String reviewScore, String reviewDate) {
		// TODO Auto-generated constructor stub
		
		this.memberNo = memberNo;
		this.movieNo = movieNo;
		this.moviePoster = moviePoster;
		this.movieTitle = movieTitle;
		this.reviewContent = reviewContent;
		this.reviewScore = reviewScore;
		this.reviewDate = reviewDate;
	}
}
