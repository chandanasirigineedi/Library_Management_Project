package Entity;

public class Member {
    private Long memberId;
    private String name;
    private String memberType;
    private  Long PhoneNumber;

    public Member(Long memberId, String name, String memberType, Long phoneNumber) {
        this.memberId = memberId;
        this.name = name;
        this.memberType = memberType;
        PhoneNumber = phoneNumber;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public Long getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        PhoneNumber = phoneNumber;
    }
}
