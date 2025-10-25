package Repository;

import Entity.Member;

import java.util.ArrayList;
import java.util.List;

public class MemberRepository {

        List<Member> memberDB= new ArrayList<>();

    public boolean addMember(Member member) {
        memberDB.add(member);
        return true;
    }
    public boolean updateMember(Integer memberId, String memberType, Integer phoneNumber) {
        Member emember=memberDB.stream().filter(b->b.getMemberId()==memberId).findFirst().orElse(null);
        if(emember!=null)
        {
            emember.setMemberType(memberType);
            emember.setPhoneNumber(phoneNumber);

            return true;
        }else
        {
            return false;
        }
    }
    public boolean deleteMember(Integer memberId) {
        Member emember1 =memberDB.stream().filter(b->b.getMemberId()==memberId).findFirst().orElse(null);
        if (emember1 != null) {
            memberDB.remove(emember1);
            return true;
        } else {
            return false;
        }
    }
    public List<Member> getMember() {
        return memberDB;
    }
    public Integer getMemberId(Integer mid){
        Member emember=memberDB.stream().filter(b->b.getMemberId()==mid).findFirst().orElse(null);
        return emember.getMemberId();
    }
}
