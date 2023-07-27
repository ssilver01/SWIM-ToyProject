package com.example.demo.controller;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.domain.Member;
import com.example.demo.service.MemberService;

@RestController
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	//회원가입
    @ResponseBody
    @RequestMapping(value="/member/register", method=RequestMethod.POST) 
      public Member initNewItem(HttpServletRequest request,
            @RequestBody Map<String, Object> paramMap
            )  {
       String[] memberInfo = new String[5];
       int i = 0;
       for (Map.Entry<String, Object> pair : paramMap.entrySet()) {
    	   memberInfo[i] = pair.getValue().toString();
          System.out.println(memberInfo[i]);
            i++;
         }
       Member member = new Member();
       member.setUser_name(memberInfo[0]);
       member.setPassword(memberInfo[1]);
       member.setUser_name(memberInfo[2]);
       member.setPhone(memberInfo[3]);    
       member.setProfile(memberInfo[4]);
      
       memberService.registerMember(member);
       return member;
      }
}