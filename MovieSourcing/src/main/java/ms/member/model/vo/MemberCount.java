package ms.member.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MemberCount {
	
	private int count;
	
	public MemberCount(int count) {
		// TODO Auto-generated constructor stub
		this.count = count;
	}
}
