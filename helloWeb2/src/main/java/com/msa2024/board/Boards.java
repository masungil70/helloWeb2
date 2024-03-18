package com.msa2024.board;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Boards {
	
	public Boards(String bno, String btitle, String bcontent) {
		this(bno, btitle, bcontent, "", "");
	}
	
	private String bno;
	private String btitle;
	private String bcontent;
	private String bwriter;
	private String bdate;
}
