package ms.board.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Reply {
	
	private int replyNo;
	private String memNic;
	private String replyContent;
	private String replyDate;
	
	private int comNo;
	private int memNo;

}
