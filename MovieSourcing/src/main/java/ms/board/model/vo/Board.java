package ms.board.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor // 기본 생성자
public class Board {
	
	private int comNo;
	private String memPic; // 이미지
	private String memNic;
	private String comDate;
	private String comTitle;
	private String comContent;
	private String thumbnail;
	private int readCount;
	private int replyCount;
	
}
