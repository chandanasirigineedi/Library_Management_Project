package Service.Implementation;

import Entity.Member;
import Repository.MemberRepository;

import java.util.List;

public class MemberServiceImpl  implements MemberService{
    MemberRepository memberrepository;
    @Override
    public boolean addMember(Member member) {

        return memberrepository.addMember(member);
    }

    @Override
    public boolean updateMember(Integer memberId, String memberType, Integer phoneNumber) {

        return memberrepository.updateMember(memberId,  memberType, phoneNumber);
    }

    @Override
    public boolean deleteMember(Integer memberId) {
        return memberrepository.deleteMember(memberId);
    }

    @Override
    public List<Member> getMember() {
        return memberrepository.getMember();
    }
}
