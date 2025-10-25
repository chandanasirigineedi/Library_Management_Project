package Service.Implementation;

import Entity.Member;

import java.util.List;

public interface MemberService {
        public boolean addMember(Member member);
        public boolean updateMember(Integer memberId, String memberType,Integer phoneNumber);
        public boolean deleteMember(Integer memberId);
        public List<Member> getMember();
        public  Integer getMemberId(Integer memberId);


}
