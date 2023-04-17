package ms.board.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BaordReply {
	
	private int replyNo;
	private String replyContent;
	private String memNic; 
	private String replyDate;
}
