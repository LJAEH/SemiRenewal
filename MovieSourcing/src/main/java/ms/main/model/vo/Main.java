package ms.main.model.vo;


public class Main {
	
	private String movieNo;
	private String movieTitle;
	private String movieEngTitle;
	private String movieTime;
	private String movieOpenDate;
	private double movieScore;
	private String movieNational;
	private String movieGrade;
	private String moviePoster;
	private String moviePreview;
	
	public Main() {} 
	
	
	
	public Main(String movieNo, String movieTitle, String movieEngTitle, String movieTime, String movieOpenDate, double movieScore, String movieNational, String movieGrade, String moviePoster, String moviePreview) {
		super();
		this.movieNo = movieNo;
		this.movieTitle = movieTitle;
		this.movieEngTitle = movieEngTitle;
		this.movieTime = movieTime;
		this.movieOpenDate = movieOpenDate;
		this.movieScore = movieScore;
		this.movieNational = movieNational;
		this.movieGrade = movieGrade;
		this.moviePoster = moviePoster;
		this.moviePreview = moviePreview;
	}

	public String getMovieNo() {
		return movieNo;
	}

	public void setMovieNo(String movieNo) {
		this.movieNo = movieNo;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public String getMovieEngTitle() {
		return movieEngTitle;
	}

	public void setMovieEngTitle(String movieEngTitle) {
		this.movieEngTitle = movieEngTitle;
	}

	public String getMovieTime() {
		return movieTime;
	}

	public void setMovieTime(String movieTime) {
		this.movieTime = movieTime;
	}

	public String getMovieOpenDate() {
		return movieOpenDate;
	}

	public void setMovieOpenDate(String movieOpenDate) {
		this.movieOpenDate = movieOpenDate;
	}

	public double getMovieScore() {
		return movieScore;
	}

	public void setMovieScore(double movieScore) {
		this.movieScore = movieScore;
	}

	public String getMovieNational() {
		return movieNational;
	}

	public void setMovieNational(String movieNational) {
		this.movieNational = movieNational;
	}

	public String getMovieGrade() {
		return movieGrade;
	}

	public void setMovieGrade(String movieGrade) {
		this.movieGrade = movieGrade;
	}

	public String getMoviePoster() {
		return moviePoster;
	}

	public void setMoviePoster(String moviePoster) {
		this.moviePoster = moviePoster;
	}

	public String getMoviePreview() {
		return moviePreview;
	}

	public void setMoviePreview(String moviePreview) {
		this.moviePreview = moviePreview;
	}



	@Override
	public String toString() {
		return "Main [movieNo=" + movieNo + ", movieTitle=" + movieTitle + ", movieEngTitle=" + movieEngTitle
				+ ", movieTime=" + movieTime + ", movieOpenDate=" + movieOpenDate + ", movieScore=" + movieScore
				+ ", movieNational=" + movieNational + ", movieGrade=" + movieGrade + ", moviePoster=" + moviePoster
				+ ", moviePreview=" + moviePreview + "]";
	}
	
	
	

}
