package ms.movie.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MoviePeople {
	
	private String pdName;
	private String pdPicture;
	private String act1;
	private String act2;
	private String act3;
	private String act4;
	private String act1Picture;
	private String act2Picture;
	private String act3Picture;
	private String act4Picture;
	
	private int pdNo;
	private int act1No;
	private int act2No;
	private int act3No;
	private int act4No;
	
}
