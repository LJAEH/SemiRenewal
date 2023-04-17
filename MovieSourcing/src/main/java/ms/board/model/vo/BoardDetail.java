package ms.board.model.vo;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@ToString
@NoArgsConstructor
public class BoardDetail {
	
	private int boardNo;
	private int comNo;
	private int memNo;
	private String memPic;
	private String memNic;
	private String comDate;
	private String comTitle;
	private String comContent;
	private int readCount;
	private int replyCount;
	
	private List<BaordReply> replyList;
}
