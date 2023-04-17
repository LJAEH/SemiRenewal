package ms.movielist.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CommunityListInfo {
	
	
	private int comNo;
	private String comTitle;
	private String comDate;
	private int memberNo;
	private int readCount;
	
	public CommunityListInfo(int comNo, String comTitle, 
			String comDate, int memberNo, int readCount) {
		// TODO Auto-generated constructor stub
		
		this.comNo = comNo;
		this.comTitle = comTitle;
		this.comDate = comDate;
		this.memberNo = memberNo;
		this.readCount = readCount;
	}
}
