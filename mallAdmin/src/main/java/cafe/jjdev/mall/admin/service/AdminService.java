package cafe.jjdev.mall.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cafe.jjdev.mall.admin.mapper.AdminMapper;
import cafe.jjdev.mall.admin.vo.Member;

@Service
@Transactional
public class AdminService {
	@Autowired
	private AdminMapper adminMapper;
	
	public Member getMember(Member member) {
		return adminMapper.selectMember(member);
	}
}
