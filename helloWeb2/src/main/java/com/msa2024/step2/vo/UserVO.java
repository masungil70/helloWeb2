package com.msa2024.step2.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {
	private String userid;
	private String userpassword;
	private String username;
	private int    userage;
	private String useremail;
}
